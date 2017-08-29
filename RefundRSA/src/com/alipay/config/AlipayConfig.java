package com.alipay.config;
import com.alipay.util.UtilDate;
/* *
 *������AlipayConfig
 *���ܣ�����������
 *��ϸ�������ʻ��й���Ϣ������·��
 *�汾��3.4
 *�޸����ڣ�2016-03-08
 *˵����
 *���´���ֻ��Ϊ�˷����̻����Զ��ṩ���������룬�̻����Ը����Լ���վ����Ҫ�����ռ����ĵ���д,����һ��Ҫʹ�øô��롣
 *�ô������ѧϰ���о�֧�����ӿ�ʹ�ã�ֻ���ṩһ���ο���
 */

public class AlipayConfig {
	
//�����������������������������������Ļ�����Ϣ������������������������������

	// ���������ID��ǩԼ�˺ţ���2088��ͷ��16λ��������ɵ��ַ������鿴��ַ��https://b.alipay.com/order/pidAndKey.htm
	public static String partner = "";
	
	// �տ�֧�����˺ţ���2088��ͷ��16λ��������ɵ��ַ�����һ��������տ��˺ž���ǩԼ�˺�
	public static String seller_user_id = partner;

	// �̻���˽Կ,��ҪPKCS8��ʽ��RSA��˽Կ���ɣ�https://doc.open.alipay.com/doc2/detail.htm?spm=a219a.7629140.0.0.nBDxfy&treeId=58&articleId=103242&docType=1
	public static String private_key = 
"MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBANFILCG9cqnAAGqt97DHzJ+6ETQ8AY/k31hrF9L1wZVr/kpiF2gnP/sOAIZqNioR6sZMh54kdBZB8+jWjOhpMHZfqJ3JI2A+5mCs0tUl4rBpWmww8OjEGRoixamCc6Hsr9/GnUMURtVMEXdHeLNQPr/xNd7dbYKxRYiGoCZAVAgMBAAECgYEArdX6OmhnpxLCBdrNZD0B/icLBU1WqtScpJAIMQZLrzcN+XEzKiN4JKxDyWLN7PIHBoIpIDX9a0OLO3uDfcVqJ1eL1hMPDsvlxV72FWzUlkFZcBdVgm800CjB3F2z414zPNGWbo2/RQOp9JkEnnF0ekdOqdMBufoQk3W9ofv/UMECQQD7KXatki/rB6HxDXY3tjg91zE69hTJKvYLN8Cq/rkrAoT5XU2fcwg2CyRXVGgc+DlS+zKf5Bchcp2i6yQK+A3xAkEA1VAwWCCv6WE+Rrbe4aLkWc6p+57E90LPo3a6u96aCIBeZT0oTp2lXlQ4gmWCH6jFeeQHxOUJ8FvIWL+hLx0QZQI/LSFGMeoSsiis8KN6mogjkvkX34BYO8aIecFx2uKAxL2ILrb7s7vnpCDW8dRhdUNZTtg814Woo9yQh3cYEhAkEAukZyUSMKOtTuWzYqYAOtQTeVfONiwUGYrPhrjM+Q10eyJtpHLo+/7yXAyy31ecwZ1p1oo2oXScv8onOFP+0zeQJBAMGyDyZqBcbzrUVFRbSAMvno8GqEflNuPJv4/uiy5pI0qHn0GA/dmab/lUX7BA4dsXyoBoRHyheeYgo9J0lwUtQ=";
	
	// ֧������Կ,�鿴��ַ��https://b.alipay.com/order/pidAndKey.htm 
	public static String alipay_public_key  = 
"MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDRSCwXKpwABqrfewx8yfuhE0PAGP5N9YaxfS9cGVa/5KYhdoJz/7DgCGajYqEerGTIeeJHQWQfPo1ozoaTB2X6idySNgPuZgrNLVJeKwaVpsMPDoxBkaIsWpgnOh7K/fxp+KTFDFEbVTBF3R3izUD6/8TXe3W2CsUWIhqAmQFQIDAQAB";

	// �������첽֪ͨҳ��·��  ��http://��ʽ������·�������ܼ�?id=123�����Զ����������������������������
	public static String notify_url = "http://����/Refund/jsp/notify_url.jsp";

	// ҳ����תͬ��֪ͨҳ��·�� ��http://��ʽ������·�������ܼ�?id=123�����Զ����������������������������
	public static String return_url = "http://����/Refund/jsp/return_url.jsp";

	// ǩ����ʽ
	public static String sign_type = "RSA";
	
	// �����ã�����TXT��־�ļ���·������AlipayCore.java���е�logResult(String sWord)��ӡ������
	public static String log_path = "C:\\";
		
	// �ַ������ʽ Ŀǰ֧�� gbk �� utf-8
	public static String input_charset = "utf-8";
		
	 //�˿����� ʱ���ʽ yyyy-MM-dd HH:mm:ss
    public static String refund_date = UtilDate.getDateFormatter();
		
	// ���õĽӿ����������޸�
	public static String service = "refund_fastpay_by_platform_pwd";


//�����������������������������������Ļ�����Ϣ������������������������������

}

