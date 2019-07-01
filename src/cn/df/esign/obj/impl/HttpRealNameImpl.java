package cn.df.esign.obj.impl;

import java.text.MessageFormat;
import java.util.LinkedHashMap;

import cn.df.esign.obj.config.RealNameConfig;
import cn.df.esign.obj.util.Helper;
import net.sf.json.JSONObject;

public class HttpRealNameImpl {

	//��ȡ��ҵʵ����֤��ַ
	public static void getOrganizeUrl(String agentAccountId,String orgAccountId){
		String orgApply = Helper.setOrganizeStr(agentAccountId, orgAccountId);
		System.out.println(orgApply.toString());

		// HTTP������������
		String ContentType = "application/json";
		// ����HTTP����ͷ��Ϣ
		LinkedHashMap<String, String> headers = Helper.getPOSTHeaders(RealNameConfig.PROJECT_ID,RealNameConfig.PROJECT_SECRET, ContentType,RealNameConfig.ENCODING);

		// ��ָ��URL����POST����������
		System.out.println("�������ַ��="+RealNameConfig.getOrganizeUrl);
		JSONObject result = Helper.sendPOST(RealNameConfig.getOrganizeUrl, orgApply.toString(), headers, RealNameConfig.ENCODING);
		//System.out.println("result==="+result);
		int errCode = result.getInt("errCode");
		String orgUrl = "";
		if (0!=errCode) {
			throw new RuntimeException(MessageFormat.format("��ȡ��ҵʵ����֤��ַʧ��,ʧ����Ϣ��errCode = {0}, msg = {1}",
					errCode, result.get("msg")));
		}else{
			String data = result.getString("data");	
			JSONObject obj = JSONObject.fromObject(data);
			orgUrl = obj.getString("url");
			System.out.println("��ȡ��ҵʵ����֤��ַ�ɹ���"+result+";;;��ҵʵ����֤��ַ==>"+orgUrl);
		}
	}
	//��ȡ��ҵʵ����֤��ַ
	public static void getPersonUrl(String accountid){
		String perApply = Helper.setPersonStr(accountid);
		System.out.println(perApply.toString());

		// HTTP������������
		String ContentType = "application/json";
		// ����HTTP����ͷ��Ϣ
		LinkedHashMap<String, String> headers = Helper.getPOSTHeaders(RealNameConfig.PROJECT_ID,RealNameConfig.PROJECT_SECRET, ContentType,RealNameConfig.ENCODING);

		// ��ָ��URL����POST����������
		System.out.println("�������ַ��="+RealNameConfig.getPersonUrl);
		JSONObject result = Helper.sendPOST(RealNameConfig.getPersonUrl, perApply.toString(), headers, RealNameConfig.ENCODING);
		System.out.println("result==="+result);
		int errCode = result.getInt("errCode");
		String perUrl = "";
		if (0!=errCode) {
			throw new RuntimeException(MessageFormat.format("��ȡ����ʵ����֤��ַʧ��,ʧ����Ϣ��errCode = {0}, msg = {1}",
					errCode, result.get("msg")));
		}else{
			String data = result.getString("data");	
			JSONObject obj = JSONObject.fromObject(data);
			perUrl = obj.getString("url");
			System.out.println("��ȡ����ʵ����֤��ַ�ɹ���"+result+";;;����ʵ����֤��ַ==>"+perUrl);
		}
	}
	//��ѯ��ҵʵ�����
	public static void queryOrgResult(String orgAccountId){
		JSONObject obj = new JSONObject();
		obj.put("orgAccountId", orgAccountId);
		String orgQueryApply = obj.toString();

		// HTTP������������
		String ContentType = "application/json";
		// ����HTTP����ͷ��Ϣ
		LinkedHashMap<String, String> headers = Helper.getPOSTHeaders(RealNameConfig.PROJECT_ID,RealNameConfig.PROJECT_SECRET, ContentType,RealNameConfig.ENCODING);

		// ��ָ��URL����POST����������
		System.out.println("�������ַ��="+RealNameConfig.queryOrganizeInfoUrl);
		JSONObject result = Helper.sendPOST(RealNameConfig.queryOrganizeInfoUrl, orgQueryApply.toString(), headers, RealNameConfig.ENCODING);
		//System.out.println("result==="+result);
		int errCode = result.getInt("errCode");
		if (0!=errCode) {
			throw new RuntimeException(MessageFormat.format("��ѯ��ҵʵ�����ʧ��,ʧ����Ϣ��errCode = {0}, msg = {1}",
					errCode, result.get("msg")));
		}else{
			System.out.println("��ѯ��ҵʵ������ɹ���"+result);
		}
	}
	//��ѯ����ʵ�����
	public static void queryPerResult(String accountId){
		JSONObject obj = new JSONObject();
		obj.put("accountId", accountId);
		String PerQueryApply = obj.toString();

		// HTTP������������
		String ContentType = "application/json";
		// ����HTTP����ͷ��Ϣ
		LinkedHashMap<String, String> headers = Helper.getPOSTHeaders(RealNameConfig.PROJECT_ID,RealNameConfig.PROJECT_SECRET, ContentType,RealNameConfig.ENCODING);

		// ��ָ��URL����POST����������
		System.out.println("�������ַ��="+RealNameConfig.queryPersonInfoUrl);
		JSONObject result = Helper.sendPOST(RealNameConfig.queryPersonInfoUrl, PerQueryApply.toString(), headers, RealNameConfig.ENCODING);
		System.out.println("result==="+result);
		int errCode = result.getInt("errCode");
		if (0!=errCode) {
			throw new RuntimeException(MessageFormat.format("��ѯ����ʵ�����ʧ��,ʧ����Ϣ��errCode = {0}, msg = {1}",
					errCode, result.get("msg")));
		}else{
			System.out.println("��ѯ����ʵ������ɹ���"+result);
		}
	}
	//���˶�Ҫ�غ���
	public static void PersonIdentity(){
		JSONObject obj = new JSONObject();
		obj.put("name", "Ǯ��Ԫ");
		obj.put("idno", "320684199211151614");
		String PerIdentityApply = obj.toString();

		// HTTP������������
		String ContentType = "application/json";
		// ����HTTP����ͷ��Ϣ
		LinkedHashMap<String, String> headers = Helper.getPOSTHeaders(RealNameConfig.PROJECT_ID,RealNameConfig.PROJECT_SECRET, ContentType,RealNameConfig.ENCODING);

		// ��ָ��URL����POST����������
		System.out.println("�������ַ��="+RealNameConfig.perInfoGetUrl);
		JSONObject result = Helper.sendPOST(RealNameConfig.perInfoGetUrl, PerIdentityApply.toString(), headers, RealNameConfig.ENCODING);
		System.out.println("result==="+result);
		int errCode = result.getInt("errCode");
		if (0!=errCode) {
			throw new RuntimeException(MessageFormat.format("���˶�Ҫ�غ���ʧ��,ʧ����Ϣ��errCode = {0}, msg = {1}",
					errCode, result.get("msg")));
		}else{
			System.out.println("���˶�Ҫ�غ���ɹ���"+result);
		}
	}
	//���������˺�
	public static void PersonCreate(){
		JSONObject obj = new JSONObject();
		obj.put("thirdId", "123214455");
		obj.put("name", "Ǯ��Ԫ");
		obj.put("idNo", "320684199211151614");
		obj.put("idType", "19");
		obj.put("mobile", "13776931992");
		obj.put("e-mail", "");
		String PerIdentityApply = obj.toString();

		// HTTP������������
		String ContentType = "application/json";
		// ����HTTP����ͷ��Ϣ
		LinkedHashMap<String, String> headers = Helper.getPOSTHeaders(RealNameConfig.PROJECT_ID,RealNameConfig.PROJECT_SECRET, ContentType,RealNameConfig.ENCODING);

		// ��ָ��URL����POST����������
		System.out.println("�������ַ��="+RealNameConfig.createperson);
		JSONObject result = Helper.sendPOST(RealNameConfig.createperson, PerIdentityApply.toString(), headers, RealNameConfig.ENCODING);
		System.out.println("result==="+result);
		int errCode = result.getInt("errCode");
		if (0!=errCode) {
			throw new RuntimeException(MessageFormat.format("���������˺�ʧ��,ʧ����Ϣ��errCode = {0}, msg = {1}",
					errCode, result.get("msg")));
		}else{
			System.out.println("���������˺ųɹ���"+result);
		}
	}
	//��ҵ��Ϣ����
	public static void OrganizeIdentity(){
		String orgIdentityApply = Helper.setOrgIdentityStr();
		System.out.println(orgIdentityApply);
		// HTTP������������
		String ContentType = "application/json";
		// ����HTTP����ͷ��Ϣ
		LinkedHashMap<String, String> headers = Helper.getPOSTHeaders(RealNameConfig.PROJECT_ID,RealNameConfig.PROJECT_SECRET, ContentType,RealNameConfig.ENCODING);

		// ��ָ��URL����POST����������
		System.out.println("�������ַ��="+RealNameConfig.orgInfoGetUrl);
		JSONObject result = Helper.sendPOST(RealNameConfig.orgInfoGetUrl, orgIdentityApply.toString(), headers, RealNameConfig.ENCODING);
		//System.out.println("result==="+result);
		int errCode = result.getInt("errCode");
		if (0!=errCode) {
			throw new RuntimeException(MessageFormat.format("��ҵ��Ϣ����ʧ��,ʧ����Ϣ��errCode = {0}, msg = {1}",
					errCode, result.get("msg")));
		}else{
			System.out.println("��ҵ��Ϣ����ɹ���"+result);
		}
	}
}
