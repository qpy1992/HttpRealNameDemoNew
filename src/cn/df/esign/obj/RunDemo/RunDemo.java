package cn.df.esign.obj.RunDemo;

import cn.df.esign.obj.impl.HttpRealNameImpl;

public class RunDemo {

	public static void main(String[] args) {
		
		int choose = 1;
		switch (choose) {
		case 0:
			System.out.println("---����ȡ��ҵʵ����֤��ַ��---");
			String agentAccountId = "c7ff1f4f153a4b9c83f5d77093fac820"; //�������û�ID
			String orgAccountId = "2e3ce11a018f4d62940dcf1fa7d21093"; //��ҵ�û�ID
			HttpRealNameImpl.getOrganizeUrl(agentAccountId,orgAccountId);
			break;
		case 1:
			System.out.println("---����ȡ����ʵ����֤��ַ��---");
			String accountId = "14be9cae49664fa1aabd2d716736b99c"; //�������û�ID
			HttpRealNameImpl.getPersonUrl(accountId);
			break;
		case 2:
			System.out.println("---����ѯ��ҵʵ�������---");
			String orgAccountId2 = "2e3ce11a018f4d62940dcf1fa7d21093"; //�������û�ID
			HttpRealNameImpl.queryOrgResult(orgAccountId2);
			break;
		case 3:
			System.out.println("---����ѯ����ʵ�������---");
			String accountId2 = "047B41240E7648FEA147B3A595671CB7"; //�������û�ID
			HttpRealNameImpl.queryPerResult(accountId2);
			break;
			
		         /**  ����Ϊ��Ϣ����ӿڲ���     **/
		case 4:
			System.out.println("---�����˶�Ҫ�غ��顷---");
			HttpRealNameImpl.PersonIdentity();
			break;
		case 5:
			System.out.println("---����ҵ��Ϣ���顷---");
			HttpRealNameImpl.OrganizeIdentity();
			break;
		default:
			System.out.println("---������ѡ����Խӿڡ�---");
			HttpRealNameImpl.PersonCreate();
			break;
		}
	}
	

}
