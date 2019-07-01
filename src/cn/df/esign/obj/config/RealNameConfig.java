package cn.df.esign.obj.config;


/***
 * @Description: ʵ����֤_����������Ϣ��
 * @Team: �����Ƽ���֧��С��
 * @Author: DF
 * @Date: 2018��10��08��
 */
public class RealNameConfig {

	// ��ĿID(����Ӧ��ID)-ģ�⻷��,��ʽ�����¹�˾��ӵ�ж�����Ӧ��ID
	public static final String PROJECT_ID = "4438765544"; //ת��ʽ����ʱ����ʽprojectid
	// ��ĿSecret(����Ӧ��Secret)-ģ�⻷��,��ʽ�����¹�˾��ӵ�ж�����Ӧ��Secret
	public static final String PROJECT_SECRET = "659f16d8c1873cdfdbb9bbda1829bc48"; //ת��ʽ����ʱ����ʽprojectSecret
	// �����ʽ
	public static final String ENCODING = "UTF-8";
	// ��ϣ�㷨
	public static final String ALGORITHM = "HmacSHA256";
	//ʵ����֤���Ի�����ַ��ǰ׺��
	public static final String API_HOST = "https://smlo.tsign.cn/openrealname-service";
	public static final String API_HOST1 = "https://smlo.tsign.cn/opentreaty-service";
	//ʵ����֤��ʽ������ַ��ǰ׺��
	//public static final String API_HOST = "https://o.tsign.cn/openrealname-service";

    
	/**����Ϊ����ӿڵ��������õ�ַ**/
	//���������˺�
	public static final String createperson = API_HOST1 + "/account/create/person/v2";
	//��ȡ��ҵʵ����֤��ַ
	public static final String getOrganizeUrl = API_HOST + "/url/org";
	//��ȡ����ʵ����֤��ַ
	public static final String getPersonUrl = API_HOST + "/url/individual";
    //��ѯ��ҵʵ�����
	public static final String queryOrganizeInfoUrl = API_HOST + "/query/org/result";
    //��ѯ����ʵ�����
	public static final String queryPersonInfoUrl = API_HOST + "/query/psn/result";
	//���˶�Ҫ�غ���
	public static final String perInfoGetUrl = API_HOST + "/infoauth/psn/identity";
	//��ҵ��Ϣ����
	public static final String orgInfoGetUrl = API_HOST + "/infoauth/org/identify";
}
