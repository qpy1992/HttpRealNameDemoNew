package cn.df.esign.obj.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.MessageFormat;
import java.util.LinkedHashMap;

import net.sf.json.JSONObject;

public class Helper {

	public static String setOrganizeStr(String agentAccountId,String orgAccountId){
		JSONObject obj = new JSONObject();
		obj.put("agentAccountId",agentAccountId);
		obj.put("orgAccountId", orgAccountId);
		obj.put("redirectUrl", "https://www.baidu.com/");//实名认证完成后页面重定向地址
		obj.put("notifyUrl", "");//实名认证完成后业务方通知地址
		obj.put("showResultPage", "1");//是否显示e签宝实名结果页面，默认显示,0:不显示   1：显示
		return obj.toString();
	}
	public static String setPersonStr(String accounttid){
		JSONObject obj = new JSONObject();
		obj.put("accountId",accounttid);
		obj.put("redirectUrl", "https://www.baidu.com/");//实名认证完成后页面重定向地址
		obj.put("notifyUrl", "");//实名认证完成后业务方通知地址
//		obj.put("showResultPage", "0");//是否显示e签宝实名结果页面，默认显示,0:不显示   1：显示
		return obj.toString();
	}
	
	public static String setOrgIdentityStr(){
		JSONObject obj = new JSONObject();
		obj.put("name","杭州天谷信息科技有限公司");//企业名称，必填
		obj.put("codeORG", "");//企业组织机构代码，与codeUSC，codeREG必填一项
		obj.put("codeUSC", "913301087458306077");//企业统一信用代码，与codeORG，codeREG必填一项
		obj.put("codeREG", "");//企业工商注册号，与codeUSC，codeORG必填一项
		obj.put("legalName", "何一兵");//企业法人姓名，必填
		return obj.toString();
	}
	/***
	 * POST请求的头部信息
	 * 
	 * @param projectId
	 * @param projectSecret
	 * @param ContentType
	 * @param encoding
	 * @return
	 */
	public static LinkedHashMap<String, String> getPOSTHeaders(String projectId, String projectSecret,String ContentType,String encoding) {
		LinkedHashMap<String, String> headers = new LinkedHashMap<String, String>();
		headers.put("X-Tsign-Open-App-Id", projectId);
		headers.put("X-Tsign-Open-App-Secret", projectSecret);
		headers.put("X-timevale-mode", "package");
		headers.put("Content-Type", ContentType);
		headers.put("Charset", encoding);
		return headers;
	}
	
	/***
	 * 向指定URL发送POST方法的请求
	 * 
	 * @param apiUrl
	 * @param data
	 * @param headers
	 * @param encoding
	 * @return
	 */
	public static JSONObject sendPOST(String apiUrl, String data, LinkedHashMap<String, String> headers,
			String encoding) {
		StringBuffer strBuffer = null;
		JSONObject obj = null;
		try {
			// 建立连接
			URL url = new URL(apiUrl);
			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
			// 需要输出
			httpURLConnection.setDoOutput(true);
			// 需要输入
			httpURLConnection.setDoInput(true);
			// 不允许缓存
			httpURLConnection.setUseCaches(false);

			httpURLConnection.setRequestMethod("POST");
			// 设置Headers
			if (null != headers) {
				for (String key : headers.keySet()) {
					httpURLConnection.setRequestProperty(key, headers.get(key));
				}
			}

			// 连接会话
			httpURLConnection.connect();
			// 建立输入流，向指向的URL传入参数
			DataOutputStream dos = new DataOutputStream(httpURLConnection.getOutputStream());
			// 设置请求参数
			dos.write(data.getBytes(encoding));
			dos.flush();
			dos.close();
			// 获得响应状态
			int http_StatusCode = httpURLConnection.getResponseCode();
			String http_ResponseMessage = httpURLConnection.getResponseMessage();
			obj = new JSONObject();
			if (HttpURLConnection.HTTP_OK == http_StatusCode) {
				strBuffer = new StringBuffer();
				String readLine = new String();
				BufferedReader responseReader = new BufferedReader(
						new InputStreamReader(httpURLConnection.getInputStream(), "UTF-8"));
				while ((readLine = responseReader.readLine()) != null) {
					strBuffer.append(readLine);
				}
				responseReader.close();
				// System.out.println("http_StatusCode = " + http_StatusCode + "
				// request_Parameter = " + data);
				obj = toJSONObject(strBuffer.toString());
			} else {
				throw new RuntimeException(
						MessageFormat.format("请求失败,失败原因: Http状态码 = {0} , {1}", http_StatusCode, http_ResponseMessage));
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return obj;
	}
	/***
	 * 将JSON字符串转成JSON对象
	 * 
	 * @param str
	 * @return JSON对象
	 */
	public static JSONObject toJSONObject(String str) {
		JSONObject obj = JSONObject.fromObject(str);
		return obj;
	}
}
