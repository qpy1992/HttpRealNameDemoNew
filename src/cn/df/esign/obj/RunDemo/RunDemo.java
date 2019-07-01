package cn.df.esign.obj.RunDemo;

import cn.df.esign.obj.impl.HttpRealNameImpl;

public class RunDemo {

	public static void main(String[] args) {
		
		int choose = 1;
		switch (choose) {
		case 0:
			System.out.println("---《获取企业实名认证地址》---");
			String agentAccountId = "c7ff1f4f153a4b9c83f5d77093fac820"; //经办人用户ID
			String orgAccountId = "2e3ce11a018f4d62940dcf1fa7d21093"; //企业用户ID
			HttpRealNameImpl.getOrganizeUrl(agentAccountId,orgAccountId);
			break;
		case 1:
			System.out.println("---《获取个人实名认证地址》---");
			String accountId = "14be9cae49664fa1aabd2d716736b99c"; //经办人用户ID
			HttpRealNameImpl.getPersonUrl(accountId);
			break;
		case 2:
			System.out.println("---《查询企业实名结果》---");
			String orgAccountId2 = "2e3ce11a018f4d62940dcf1fa7d21093"; //经办人用户ID
			HttpRealNameImpl.queryOrgResult(orgAccountId2);
			break;
		case 3:
			System.out.println("---《查询个人实名结果》---");
			String accountId2 = "047B41240E7648FEA147B3A595671CB7"; //经办人用户ID
			HttpRealNameImpl.queryPerResult(accountId2);
			break;
			
		         /**  以下为信息核验接口部分     **/
		case 4:
			System.out.println("---《个人二要素核验》---");
			HttpRealNameImpl.PersonIdentity();
			break;
		case 5:
			System.out.println("---《企业信息核验》---");
			HttpRealNameImpl.OrganizeIdentity();
			break;
		default:
			System.out.println("---《请先选择调试接口》---");
			HttpRealNameImpl.PersonCreate();
			break;
		}
	}
	

}
