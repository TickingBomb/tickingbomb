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

	// MD5��Կ����ȫ�����룬�����ֺ���ĸ��ɵ�32λ�ַ������鿴��ַ��https://b.alipay.com/order/pidAndKey.htm
    public static String key = "";
	

	// �������첽֪ͨҳ��·��  ��http://��ʽ������·�������ܼ�?id=123�����Զ����������������������������
	public static String notify_url = "http://����/Refunding/jsp/notify_url.jsp";

	// ҳ����תͬ��֪ͨҳ��·�� ��http://��ʽ������·�������ܼ�?id=123�����Զ����������������������������
	public static String return_url = "http://����/Refunding/jsp/return_url.jsp";

	// ǩ����ʽ
	public static String sign_type = "MD5";
	
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

