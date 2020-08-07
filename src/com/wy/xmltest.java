package com.wy;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.jdom.xpath.XPath;


public class xmltest {

    public static void main(String[] args) throws DocumentException {


        String inputxml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + "<request>\n" + "<requestid>121</requestid>" + "  <retrieveargs>\n" + "    <hospitalid>482</hospitalid>\n" + "    <codeType>1</codeType>\n" + "    <queryCode>1900722</queryCode>\n" + "<patientName></patientName>\n" + "<idCard></idCard>\n" + "  </retrieveargs>\n" + "</request>";
        Document document = DocumentHelper.parseText(inputxml);
        Element root = document.getRootElement();

        String rid = root.element("requestid").getText();
        System.out.println(root.element("requestid"));
    }
}
