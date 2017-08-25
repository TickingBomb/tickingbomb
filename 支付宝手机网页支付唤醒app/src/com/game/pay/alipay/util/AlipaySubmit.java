package com.game.pay.alipay.util;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import com.game.pay.alipay.config.AlipayConfig;
import com.game.pay.alipay.sign.MD5;


/* *
 *������AlipaySubmit
 *���ܣ�֧�������ӿ������ύ��
 *��ϸ������֧�������ӿڱ�HTML�ı�����ȡԶ��HTTP����
 *�汾��3.3
 *���ڣ�2012-08-13
 *˵����
 *���´���ֻ��Ϊ�˷����̻����Զ��ṩ���������룬�̻����Ը����Լ���վ����Ҫ�����ռ����ĵ���д,����һ��Ҫʹ�øô��롣
 *�ô������ѧϰ���о�֧�����ӿ�ʹ�ã�ֻ���ṩһ���ο���
 */

public class AlipaySubmit {
    
    /**
     * ֧�����ṩ���̻��ķ����������URL(��)
     */
    private static final String ALIPAY_GATEWAY_NEW = "https://mapi.alipay.com/gateway.do?";
	
    /**
     * ����ǩ�����
     * @param sPara Ҫǩ��������
     * @return ǩ������ַ���
     */
	public static String buildRequestMysign(Map<String, String> sPara) {
    	System.out.println("����ǩ�����");
		String prestr = AlipayCore.createLinkString(sPara); //����������Ԫ�أ����ա�����=����ֵ����ģʽ�á�&���ַ�ƴ�ӳ��ַ���
        System.out.println(prestr+"--prestr");
		String mysign = "";
        if(AlipayConfig.sign_type.equals("MD5") ) {
        	mysign = MD5.sign(prestr, AlipayConfig.key, AlipayConfig.input_charset);
        	System.out.println(mysign+"--mysign");
        }
        return mysign;
    }
	
    /**
     * ����Ҫ�����֧�����Ĳ�������
     * @param sParaTemp ����ǰ�Ĳ�������
     * @return Ҫ����Ĳ�������
     */
    private static Map<String, String> buildRequestPara(Map<String, String> sParaTemp) {
        System.out.println("����buildRequestPara");
    	//��ȥ�����еĿ�ֵ��ǩ������
        Map<String, String> sPara = AlipayCore.paraFilter(sParaTemp);
        //����ǩ�����
        String mysign = buildRequestMysign(sPara);
        System.out.println(mysign+"--mysign");
        //ǩ�������ǩ����ʽ���������ύ��������
        sPara.put("sign", mysign);
        sPara.put("sign_type", AlipayConfig.sign_type);

        return sPara;
    }

    /**
     * ���������Ա�HTML��ʽ���죨Ĭ�ϣ�
     * @param sParaTemp �����������
     * @param strMethod �ύ��ʽ������ֵ��ѡ��post��get
     * @param strButtonName ȷ�ϰ�ť��ʾ����
     * @return �ύ��HTML�ı�
     */
    public static String buildRequest(Map<String, String> sParaTemp, String strMethod, String strButtonName) {
    	System.out.println("����buildRequest");
    	//�������������
        Map<String, String> sPara = buildRequestPara(sParaTemp);
        List<String> keys = new ArrayList<String>(sPara.keySet());

        StringBuffer sbHtml = new StringBuffer();

        sbHtml.append("<form id=\"alipaysubmit\" name=\"alipaysubmit\" action=\"" + ALIPAY_GATEWAY_NEW
                      + "_input_charset=" + AlipayConfig.input_charset + "\" method=\"" + strMethod
                      + "\">");

        for (int i = 0; i < keys.size(); i++) {
            String name = (String) keys.get(i);
            System.out.println(name+"--name");
            String value = (String) sPara.get(name);
            System.out.println(value+"**value");
            sbHtml.append("<input type=\"hidden\" name=\"" + name + "\" value=\"" + value + "\"/>");
        }

       
        //submit��ť�ؼ��벻Ҫ����name����
        sbHtml.append("<input type=\"submit\" value=\"" + strButtonName + "\" style=\"display:none;\"></form>");
        sbHtml.append("<script>document.forms['alipaysubmit'].submit();</script>");
        System.out.println(sbHtml.toString()+"--sbhtml.toString");
        return sbHtml.toString();
    }
    /*��ӡ����sbHtml.toString();
     * <form id="alipaysubmit" name="alipaysubmit" 
		action="https://mapi.alipay.com/gateway.do?_input_charset=utf-8" method="get">
		<input type="hidden" name="_input_charset" value="utf-8"/>
		<input type="hidden" name="subject" value="test��Ʒ123"/>
		<input type="hidden" name="sign" value="c1e700d04ed5b986db4dd7d86dc5f3b7"/>
		<input type="hidden" name="notify_url" value="http://jbweb.szjbkj88.com:8080/CPay/notify_url.jsp"/>
		<input type="hidden" name="body" value="��ʱ���˲���"/>
		<input type="hidden" name="payment_type" value="1"/>
		<input type="hidden" name="out_trade_no" value="test20170815093624"/>
		<input type="hidden" name="partner" value="2088621768994703"/>
		<input type="hidden" name="service" value="create_direct_pay_by_user"/>
		<input type="hidden" name="total_fee" value="10000"/>
		<input type="hidden" name="app_pay" value="Y"/>
		<input type="hidden" name="return_url" value="http://jbweb.szjbkj88.com:8080/CPay/return_url.jsp"/>
		<input type="hidden" name="sign_type" value="MD5"/>
		<input type="hidden" name="seller_id" value="2088621768994703"/>
		<input type="submit" value="ȷ��" style="display:none;">
	</form>
	<script>document.forms['alipaysubmit'].submit();</script>
 */
    /**
     * ���ڷ����㣬���ýӿ�query_timestamp����ȡʱ����Ĵ�����
     * ע�⣺Զ�̽���XML������������Ƿ�֧��SSL�������й�
     * @return ʱ����ַ���
     * @throws IOException
     * @throws DocumentException
     * @throws MalformedURLException
     */
	public static String query_timestamp() throws MalformedURLException,
                                                        DocumentException, IOException {

        //�������query_timestamp�ӿڵ�URL��
        String strUrl = ALIPAY_GATEWAY_NEW + "service=query_timestamp&partner=" + AlipayConfig.partner + "&_input_charset" +AlipayConfig.input_charset;
        StringBuffer result = new StringBuffer();

        SAXReader reader = new SAXReader();
        Document doc = reader.read(new URL(strUrl).openStream());

        List<Node> nodeList = doc.selectNodes("//alipay/*");

        for (Node node : nodeList) {
            // ��ȡ���ֲ���Ҫ��������Ϣ
            if (node.getName().equals("is_success") && node.getText().equals("T")) {
                // �ж��Ƿ��гɹ���ʾ
                List<Node> nodeList1 = doc.selectNodes("//response/timestamp/*");
                for (Node node1 : nodeList1) {
                    result.append(node1.getText());
                }
            }
        }

        return result.toString();
    }
}
