package com.game.pay.alipay.config;

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
	public static String seller_id = partner;

	// MD5��Կ����ȫ�����룬�����ֺ���ĸ��ɵ�32λ�ַ������鿴��ַ��https://b.alipay.com/order/pidAndKey.htm
    public static String key = "";

	// �������첽֪ͨҳ��·��  ��http://��ʽ������·�������ܼ�?id=123�����Զ����������������������������
	public static String notify_url = "http://yours/CPay/pay/notify_url.jsp";

	// ҳ����תͬ��֪ͨҳ��·�� ��http://��ʽ������·�������ܼ�?id=123�����Զ����������������������������
	public static String return_url = "http://yours/CPay/pay/return_url.jsp";

	// ǩ����ʽ
	public static String sign_type = "MD5";
	
	// �����ã�����TXT��־�ļ���·������AlipayCore.java���е�logResult(String sWord)��ӡ������
	public static String log_path = "D:\\";
		
	// �ַ������ʽ Ŀǰ֧�� gbk �� utf-8
	public static String input_charset = "utf-8";
		
	// ֧������ �������޸�
	public static String payment_type = "1";
		
	// pc�˵��õĽӿ����������޸�shoujiduan
	public static String service = "alipay.wap.create.direct.pay.by.user";
	//----------------�ֻ���֧�������ýӿ�---------------------
//	public static String wap_service = "alipay.wap.create.direct.pay.by.user";

//�����������������������������������Ļ�����Ϣ������������������������������
	
//�������������������� �����������÷�������Ϣ�����û��ͨ�����㹦�ܣ�Ϊ�ռ��� ������������������������������
	
	// ������ʱ���  ��Ҫʹ����������ļ�submit�е�query_timestamp����
	public static String anti_phishing_key = "";
	
	// �ͻ��˵�IP��ַ �Ǿ�����������IP��ַ���磺221.0.0.1
	public static String exter_invoke_ip = "";
		
//�������������������������������÷�������Ϣ�����û��ͨ�����㹦�ܣ�Ϊ�ռ��� ������������������������������
	
}

