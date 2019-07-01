package cn.df.esign.obj.config;


/***
 * @Description: 实名认证_常用配置信息类
 * @Team: 公有云技术支持小组
 * @Author: DF
 * @Date: 2018年10月08日
 */
public class RealNameConfig {

	// 项目ID(公共应用ID)-模拟环境,正式环境下贵司将拥有独立的应用ID
	public static final String PROJECT_ID = "4438765544"; //转正式环境时填正式projectid
	// 项目Secret(公共应用Secret)-模拟环境,正式环境下贵司将拥有独立的应用Secret
	public static final String PROJECT_SECRET = "659f16d8c1873cdfdbb9bbda1829bc48"; //转正式环境时填正式projectSecret
	// 编码格式
	public static final String ENCODING = "UTF-8";
	// 哈希算法
	public static final String ALGORITHM = "HmacSHA256";
	//实名认证测试环境地址（前缀）
	public static final String API_HOST = "https://smlo.tsign.cn/openrealname-service";
	public static final String API_HOST1 = "https://smlo.tsign.cn/opentreaty-service";
	//实名认证正式环境地址（前缀）
	//public static final String API_HOST = "https://o.tsign.cn/openrealname-service";

    
	/**以下为具体接口的完整调用地址**/
	//创建个人账号
	public static final String createperson = API_HOST1 + "/account/create/person/v2";
	//获取企业实名认证地址
	public static final String getOrganizeUrl = API_HOST + "/url/org";
	//获取个人实名认证地址
	public static final String getPersonUrl = API_HOST + "/url/individual";
    //查询企业实名结果
	public static final String queryOrganizeInfoUrl = API_HOST + "/query/org/result";
    //查询个人实名结果
	public static final String queryPersonInfoUrl = API_HOST + "/query/psn/result";
	//个人二要素核验
	public static final String perInfoGetUrl = API_HOST + "/infoauth/psn/identity";
	//企业信息核验
	public static final String orgInfoGetUrl = API_HOST + "/infoauth/org/identify";
}
