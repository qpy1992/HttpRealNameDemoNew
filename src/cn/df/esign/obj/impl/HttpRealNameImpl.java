package cn.df.esign.obj.impl;

import java.text.MessageFormat;
import java.util.LinkedHashMap;

import cn.df.esign.obj.config.RealNameConfig;
import cn.df.esign.obj.util.Helper;
import net.sf.json.JSONObject;

public class HttpRealNameImpl {

	//获取企业实名认证地址
	public static void getOrganizeUrl(String agentAccountId,String orgAccountId){
		String orgApply = Helper.setOrganizeStr(agentAccountId, orgAccountId);
		System.out.println(orgApply.toString());

		// HTTP请求内容类型
		String ContentType = "application/json";
		// 设置HTTP请求头信息
		LinkedHashMap<String, String> headers = Helper.getPOSTHeaders(RealNameConfig.PROJECT_ID,RealNameConfig.PROJECT_SECRET, ContentType,RealNameConfig.ENCODING);

		// 向指定URL发送POST方法的请求
		System.out.println("【请求地址】="+RealNameConfig.getOrganizeUrl);
		JSONObject result = Helper.sendPOST(RealNameConfig.getOrganizeUrl, orgApply.toString(), headers, RealNameConfig.ENCODING);
		//System.out.println("result==="+result);
		int errCode = result.getInt("errCode");
		String orgUrl = "";
		if (0!=errCode) {
			throw new RuntimeException(MessageFormat.format("获取企业实名认证地址失败,失败信息：errCode = {0}, msg = {1}",
					errCode, result.get("msg")));
		}else{
			String data = result.getString("data");	
			JSONObject obj = JSONObject.fromObject(data);
			orgUrl = obj.getString("url");
			System.out.println("获取企业实名认证地址成功！"+result+";;;企业实名认证地址==>"+orgUrl);
		}
	}
	//获取企业实名认证地址
	public static void getPersonUrl(String accountid){
		String perApply = Helper.setPersonStr(accountid);
		System.out.println(perApply.toString());

		// HTTP请求内容类型
		String ContentType = "application/json";
		// 设置HTTP请求头信息
		LinkedHashMap<String, String> headers = Helper.getPOSTHeaders(RealNameConfig.PROJECT_ID,RealNameConfig.PROJECT_SECRET, ContentType,RealNameConfig.ENCODING);

		// 向指定URL发送POST方法的请求
		System.out.println("【请求地址】="+RealNameConfig.getPersonUrl);
		JSONObject result = Helper.sendPOST(RealNameConfig.getPersonUrl, perApply.toString(), headers, RealNameConfig.ENCODING);
		System.out.println("result==="+result);
		int errCode = result.getInt("errCode");
		String perUrl = "";
		if (0!=errCode) {
			throw new RuntimeException(MessageFormat.format("获取个人实名认证地址失败,失败信息：errCode = {0}, msg = {1}",
					errCode, result.get("msg")));
		}else{
			String data = result.getString("data");	
			JSONObject obj = JSONObject.fromObject(data);
			perUrl = obj.getString("url");
			System.out.println("获取个人实名认证地址成功！"+result+";;;个人实名认证地址==>"+perUrl);
		}
	}
	//查询企业实名结果
	public static void queryOrgResult(String orgAccountId){
		JSONObject obj = new JSONObject();
		obj.put("orgAccountId", orgAccountId);
		String orgQueryApply = obj.toString();

		// HTTP请求内容类型
		String ContentType = "application/json";
		// 设置HTTP请求头信息
		LinkedHashMap<String, String> headers = Helper.getPOSTHeaders(RealNameConfig.PROJECT_ID,RealNameConfig.PROJECT_SECRET, ContentType,RealNameConfig.ENCODING);

		// 向指定URL发送POST方法的请求
		System.out.println("【请求地址】="+RealNameConfig.queryOrganizeInfoUrl);
		JSONObject result = Helper.sendPOST(RealNameConfig.queryOrganizeInfoUrl, orgQueryApply.toString(), headers, RealNameConfig.ENCODING);
		//System.out.println("result==="+result);
		int errCode = result.getInt("errCode");
		if (0!=errCode) {
			throw new RuntimeException(MessageFormat.format("查询企业实名结果失败,失败信息：errCode = {0}, msg = {1}",
					errCode, result.get("msg")));
		}else{
			System.out.println("查询企业实名结果成功！"+result);
		}
	}
	//查询个人实名结果
	public static void queryPerResult(String accountId){
		JSONObject obj = new JSONObject();
		obj.put("accountId", accountId);
		String PerQueryApply = obj.toString();

		// HTTP请求内容类型
		String ContentType = "application/json";
		// 设置HTTP请求头信息
		LinkedHashMap<String, String> headers = Helper.getPOSTHeaders(RealNameConfig.PROJECT_ID,RealNameConfig.PROJECT_SECRET, ContentType,RealNameConfig.ENCODING);

		// 向指定URL发送POST方法的请求
		System.out.println("【请求地址】="+RealNameConfig.queryPersonInfoUrl);
		JSONObject result = Helper.sendPOST(RealNameConfig.queryPersonInfoUrl, PerQueryApply.toString(), headers, RealNameConfig.ENCODING);
		System.out.println("result==="+result);
		int errCode = result.getInt("errCode");
		if (0!=errCode) {
			throw new RuntimeException(MessageFormat.format("查询个人实名结果失败,失败信息：errCode = {0}, msg = {1}",
					errCode, result.get("msg")));
		}else{
			System.out.println("查询个人实名结果成功！"+result);
		}
	}
	//个人二要素核验
	public static void PersonIdentity(){
		JSONObject obj = new JSONObject();
		obj.put("name", "钱培元");
		obj.put("idno", "320684199211151614");
		String PerIdentityApply = obj.toString();

		// HTTP请求内容类型
		String ContentType = "application/json";
		// 设置HTTP请求头信息
		LinkedHashMap<String, String> headers = Helper.getPOSTHeaders(RealNameConfig.PROJECT_ID,RealNameConfig.PROJECT_SECRET, ContentType,RealNameConfig.ENCODING);

		// 向指定URL发送POST方法的请求
		System.out.println("【请求地址】="+RealNameConfig.perInfoGetUrl);
		JSONObject result = Helper.sendPOST(RealNameConfig.perInfoGetUrl, PerIdentityApply.toString(), headers, RealNameConfig.ENCODING);
		System.out.println("result==="+result);
		int errCode = result.getInt("errCode");
		if (0!=errCode) {
			throw new RuntimeException(MessageFormat.format("个人二要素核验失败,失败信息：errCode = {0}, msg = {1}",
					errCode, result.get("msg")));
		}else{
			System.out.println("个人二要素核验成功！"+result);
		}
	}
	//创建个人账号
	public static void PersonCreate(){
		JSONObject obj = new JSONObject();
		obj.put("thirdId", "123214455");
		obj.put("name", "钱培元");
		obj.put("idNo", "320684199211151614");
		obj.put("idType", "19");
		obj.put("mobile", "13776931992");
		obj.put("e-mail", "");
		String PerIdentityApply = obj.toString();

		// HTTP请求内容类型
		String ContentType = "application/json";
		// 设置HTTP请求头信息
		LinkedHashMap<String, String> headers = Helper.getPOSTHeaders(RealNameConfig.PROJECT_ID,RealNameConfig.PROJECT_SECRET, ContentType,RealNameConfig.ENCODING);

		// 向指定URL发送POST方法的请求
		System.out.println("【请求地址】="+RealNameConfig.createperson);
		JSONObject result = Helper.sendPOST(RealNameConfig.createperson, PerIdentityApply.toString(), headers, RealNameConfig.ENCODING);
		System.out.println("result==="+result);
		int errCode = result.getInt("errCode");
		if (0!=errCode) {
			throw new RuntimeException(MessageFormat.format("创建个人账号失败,失败信息：errCode = {0}, msg = {1}",
					errCode, result.get("msg")));
		}else{
			System.out.println("创建个人账号成功！"+result);
		}
	}
	//企业信息核验
	public static void OrganizeIdentity(){
		String orgIdentityApply = Helper.setOrgIdentityStr();
		System.out.println(orgIdentityApply);
		// HTTP请求内容类型
		String ContentType = "application/json";
		// 设置HTTP请求头信息
		LinkedHashMap<String, String> headers = Helper.getPOSTHeaders(RealNameConfig.PROJECT_ID,RealNameConfig.PROJECT_SECRET, ContentType,RealNameConfig.ENCODING);

		// 向指定URL发送POST方法的请求
		System.out.println("【请求地址】="+RealNameConfig.orgInfoGetUrl);
		JSONObject result = Helper.sendPOST(RealNameConfig.orgInfoGetUrl, orgIdentityApply.toString(), headers, RealNameConfig.ENCODING);
		//System.out.println("result==="+result);
		int errCode = result.getInt("errCode");
		if (0!=errCode) {
			throw new RuntimeException(MessageFormat.format("企业信息核验失败,失败信息：errCode = {0}, msg = {1}",
					errCode, result.get("msg")));
		}else{
			System.out.println("企业信息核验成功！"+result);
		}
	}
}
