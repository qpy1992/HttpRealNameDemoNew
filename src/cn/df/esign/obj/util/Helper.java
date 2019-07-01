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
		obj.put("redirectUrl", "https://www.baidu.com/");//ʵ����֤��ɺ�ҳ���ض����ַ
		obj.put("notifyUrl", "");//ʵ����֤��ɺ�ҵ��֪ͨ��ַ
		obj.put("showResultPage", "1");//�Ƿ���ʾeǩ��ʵ�����ҳ�棬Ĭ����ʾ,0:����ʾ   1����ʾ
		return obj.toString();
	}
	public static String setPersonStr(String accounttid){
		JSONObject obj = new JSONObject();
		obj.put("accountId",accounttid);
		obj.put("redirectUrl", "https://www.baidu.com/");//ʵ����֤��ɺ�ҳ���ض����ַ
		obj.put("notifyUrl", "");//ʵ����֤��ɺ�ҵ��֪ͨ��ַ
//		obj.put("showResultPage", "0");//�Ƿ���ʾeǩ��ʵ�����ҳ�棬Ĭ����ʾ,0:����ʾ   1����ʾ
		return obj.toString();
	}
	
	public static String setOrgIdentityStr(){
		JSONObject obj = new JSONObject();
		obj.put("name","���������Ϣ�Ƽ����޹�˾");//��ҵ���ƣ�����
		obj.put("codeORG", "");//��ҵ��֯�������룬��codeUSC��codeREG����һ��
		obj.put("codeUSC", "913301087458306077");//��ҵͳһ���ô��룬��codeORG��codeREG����һ��
		obj.put("codeREG", "");//��ҵ����ע��ţ���codeUSC��codeORG����һ��
		obj.put("legalName", "��һ��");//��ҵ��������������
		return obj.toString();
	}
	/***
	 * POST�����ͷ����Ϣ
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
	 * ��ָ��URL����POST����������
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
			// ��������
			URL url = new URL(apiUrl);
			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
			// ��Ҫ���
			httpURLConnection.setDoOutput(true);
			// ��Ҫ����
			httpURLConnection.setDoInput(true);
			// ��������
			httpURLConnection.setUseCaches(false);

			httpURLConnection.setRequestMethod("POST");
			// ����Headers
			if (null != headers) {
				for (String key : headers.keySet()) {
					httpURLConnection.setRequestProperty(key, headers.get(key));
				}
			}

			// ���ӻỰ
			httpURLConnection.connect();
			// ��������������ָ���URL�������
			DataOutputStream dos = new DataOutputStream(httpURLConnection.getOutputStream());
			// �����������
			dos.write(data.getBytes(encoding));
			dos.flush();
			dos.close();
			// �����Ӧ״̬
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
						MessageFormat.format("����ʧ��,ʧ��ԭ��: Http״̬�� = {0} , {1}", http_StatusCode, http_ResponseMessage));
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return obj;
	}
	/***
	 * ��JSON�ַ���ת��JSON����
	 * 
	 * @param str
	 * @return JSON����
	 */
	public static JSONObject toJSONObject(String str) {
		JSONObject obj = JSONObject.fromObject(str);
		return obj;
	}
}
