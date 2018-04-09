package com.alipay.config;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *版本：3.4
 *修改日期：2016-03-08
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 合作身份者ID，签约账号，以2088开头由16位纯数字组成的字符串，查看地址：https://b.alipay.com/order/pidAndKey.htm
	public static String partner = "2088421489924270";
	
	// 收款支付宝账号，以2088开头由16位纯数字组成的字符串，一般情况下收款账号就是签约账号
	public static String seller_id = "2088421489924270";

	//商户的私钥,需要PKCS8格式，RSA公私钥生成：https://doc.open.alipay.com/doc2/detail.htm?spm=a219a.7629140.0.0.nBDxfy&treeId=58&articleId=103242&docType=1
	public static String private_key = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAKxB5hRPfOwkskLtEoNJjvPpa850jl9KwenvRHzJL9BNCR06+ZYndIbE6sIHT84YJ6duBn5FK6tRjcZXNPbylUscwDIstAf83DSMkZYwebZOBGv34Xa1krWJ36rBZqNClVy4P6cSFDahzmlIcLWHr9SbKy6xccFQHfrWtbZ5lCgDAgMBAAECgYAcEDxgsLaEblIQbzkl5HUCrdOfdgO/6JkA+LcqsUg14mcKuRHycYkdb7VjWPeadvr23wj1x2Ue6xFy78A0Pz8tEgk2q4++SzMrqIcmC8TKLSh1OJkdp7v5Z2x6AH9D0BvoOISrt75hw0QyEuiMDGB7L294P1I8LOrTHJ8IWWnB+QJBANwVf9ePr/887T+X0njgutX8+GqxMs2z1kYKLSjYTiK4OEO2JQsDntokE1HSwzoFWZuJjIW+AnlHGYubdJ/yGMUCQQDIXlZvXNYiRYNMPKuAq7WgMu+naTpd2F8A8Q2+slaT/XSHBpzxjiWosDnWCqiBNAuzTDAYICHuewAXw8w1mvonAkATrOxf9h2S4PyI2ebcHaM2bEY9K5hSIYi/fDtrUmMx4WxOSWNoZ6t07xK3FvOTJVVMfXCNqF4KP5v+CijT/83NAkBFwlpzgS3oVq1EwKaxMJcWhEVd0swIWkmRSVuQtgRgl9CXJh1EGEpSNbCdLa7G9PjR3serzpwhrF825utVCnTnAkEAxW7tfxFWqWqGdO/TAG3r673G2icmOI2u3wbi8f23kQRdf0CEbMeB9lMMUeguAPJ87Q2uLRsjo+S4Q8nhbEbLEQ==";
	// 支付宝的公钥,查看地址：https://b.alipay.com/order/pidAndKey.htm
	public static String alipay_public_key  = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDIgHnOn7LLILlKETd6BFRJ0GqgS2Y3mn1wMQmyh9zEyWlz5p1zrahRahbXAfCfSqshSNfqOmAQzSHRVjCqjsAw1jyqrXaPdKBmr90DIpIxmIyKXv4GGAkPyJ/6FTFY99uhpiq0qadD/uSzQsefWo0aTvP/65zi3eof7TcZ32oWpwIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://wuyafang.oicp.net/asynAlipayNotify";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://wuyafang.oicp.net/synAlipayReturn";

	// 签名方式
	public static String sign_type = "RSA";
	
	// 调试用，创建TXT日志文件夹路径，见AlipayCore.java类中的logResult(String sWord)打印方法。
	public static String log_path = "D:\\";
		
	// 字符编码格式 目前支持 gbk 或 utf-8
	public static String input_charset = "utf-8";
		
	// 支付类型 ，无需修改
	public static String payment_type = "1";
		
	// 调用的接口名，无需修改
	public static String service = "create_direct_pay_by_user";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
	
//↓↓↓↓↓↓↓↓↓↓ 请在这里配置防钓鱼信息，如果没开通防钓鱼功能，为空即可 ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
	
	// 防钓鱼时间戳  若要使用请调用类文件submit中的query_timestamp函数
	public static String anti_phishing_key = "";
	
	// 客户端的IP地址 非局域网的外网IP地址，如：221.0.0.1
	public static String exter_invoke_ip = "";
		
//↑↑↑↑↑↑↑↑↑↑请在这里配置防钓鱼信息，如果没开通防钓鱼功能，为空即可 ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
	
}

