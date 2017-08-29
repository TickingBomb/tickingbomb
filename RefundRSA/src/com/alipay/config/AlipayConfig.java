package com.alipay.config;
import com.alipay.util.UtilDate;
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
	public static String partner = "";
	
	// 收款支付宝账号，以2088开头由16位纯数字组成的字符串，一般情况下收款账号就是签约账号
	public static String seller_user_id = partner;

	// 商户的私钥,需要PKCS8格式，RSA公私钥生成：https://doc.open.alipay.com/doc2/detail.htm?spm=a219a.7629140.0.0.nBDxfy&treeId=58&articleId=103242&docType=1
	public static String private_key = 
"MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBANFILCG9cqnAAGqt97DHzJ+6ETQ8AY/k31hrF9L1wZVr/kpiF2gnP/sOAIZqNioR6sZMh54kdBZB8+jWjOhpMHZfqJ3JI2A+5mCs0tUl4rBpWmww8OjEGRoixamCc6Hsr9/GnUMURtVMEXdHeLNQPr/xNd7dbYKxRYiGoCZAVAgMBAAECgYEArdX6OmhnpxLCBdrNZD0B/icLBU1WqtScpJAIMQZLrzcN+XEzKiN4JKxDyWLN7PIHBoIpIDX9a0OLO3uDfcVqJ1eL1hMPDsvlxV72FWzUlkFZcBdVgm800CjB3F2z414zPNGWbo2/RQOp9JkEnnF0ekdOqdMBufoQk3W9ofv/UMECQQD7KXatki/rB6HxDXY3tjg91zE69hTJKvYLN8Cq/rkrAoT5XU2fcwg2CyRXVGgc+DlS+zKf5Bchcp2i6yQK+A3xAkEA1VAwWCCv6WE+Rrbe4aLkWc6p+57E90LPo3a6u96aCIBeZT0oTp2lXlQ4gmWCH6jFeeQHxOUJ8FvIWL+hLx0QZQI/LSFGMeoSsiis8KN6mogjkvkX34BYO8aIecFx2uKAxL2ILrb7s7vnpCDW8dRhdUNZTtg814Woo9yQh3cYEhAkEAukZyUSMKOtTuWzYqYAOtQTeVfONiwUGYrPhrjM+Q10eyJtpHLo+/7yXAyy31ecwZ1p1oo2oXScv8onOFP+0zeQJBAMGyDyZqBcbzrUVFRbSAMvno8GqEflNuPJv4/uiy5pI0qHn0GA/dmab/lUX7BA4dsXyoBoRHyheeYgo9J0lwUtQ=";
	
	// 支付宝公钥,查看地址：https://b.alipay.com/order/pidAndKey.htm 
	public static String alipay_public_key  = 
"MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDRSCwXKpwABqrfewx8yfuhE0PAGP5N9YaxfS9cGVa/5KYhdoJz/7DgCGajYqEerGTIeeJHQWQfPo1ozoaTB2X6idySNgPuZgrNLVJeKwaVpsMPDoxBkaIsWpgnOh7K/fxp+KTFDFEbVTBF3R3izUD6/8TXe3W2CsUWIhqAmQFQIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://域名/Refund/jsp/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://域名/Refund/jsp/return_url.jsp";

	// 签名方式
	public static String sign_type = "RSA";
	
	// 调试用，创建TXT日志文件夹路径，见AlipayCore.java类中的logResult(String sWord)打印方法。
	public static String log_path = "C:\\";
		
	// 字符编码格式 目前支持 gbk 或 utf-8
	public static String input_charset = "utf-8";
		
	 //退款日期 时间格式 yyyy-MM-dd HH:mm:ss
    public static String refund_date = UtilDate.getDateFormatter();
		
	// 调用的接口名，无需修改
	public static String service = "refund_fastpay_by_platform_pwd";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

}

