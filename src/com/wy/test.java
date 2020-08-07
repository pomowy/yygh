package com.wy;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.junit.Test;
import pnbclient.command.SQLCommandService;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class test {
    public static void main(String[] args) {

        SQLCommandService ser = new SQLCommandService();
        String sql ="select * from productmanager.it_microsthospital_doctor t where t.hospital_id = '7c083f4a-91be-412e-afab-07e3621f07d3' and t.is_delete =0 and t.hisdept_code='0602' and t.input_code='ZB'";

      //  System.out.println(ser.getListBean(sql,Doctors.class));

        String sql1 ="select * from productmanager.it_microsthospital_doctor t where t.hospital_id = '7c083f4a-91be-412e-afab-07e3621f07d3'";
        List<Doctors> lis = new ArrayList<>();
        lis = ser.getListBean(sql1,Doctors.class);

     for(Doctors i:lis){
      // System.out.println(i.getDEPTCODE());
      }

     Set<String> sc = new HashSet<>();
     for (int i=0; i<lis.size();i++){
         sc.add(lis.get(i).getDEPTCODE());
     }
     String arr[] =sc.toArray(new String[sc.size()]);
     for(int i = 0 ;i<sc.size();i++){
         System.out.println(arr[i]);
     }

    }

    public static Map doXMLParse(String strxml)
            throws JDOMException, IOException
    {
        strxml = strxml.replaceFirst("encoding=\".*\"", "encoding=\"UTF-8\"");

        if ((null == strxml) || ("".equals(strxml))) {
            return null;
        }

        Map m = new HashMap();

        InputStream in = new ByteArrayInputStream(strxml.getBytes("UTF-8"));
        SAXBuilder builder = new SAXBuilder();
        Document doc = builder.build(in);
        Element root = doc.getRootElement();
        List list = root.getChildren();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Element e = (Element)it.next();
            String k = e.getName();
            String v = "";
            List children = e.getChildren();
            if (children.isEmpty())
                v = e.getTextNormalize();
            else {
                v = getChildrenText(children);
            }

            m.put(k, v);
        }

        in.close();

        return m;
    }

    public static String getChildrenText(List children)
    {
        StringBuffer sb = new StringBuffer();
        if (!children.isEmpty()) {
            Iterator it = children.iterator();
            while (it.hasNext()) {
                Element e = (Element)it.next();
                String name = e.getName();
                String value = e.getTextNormalize();
                List list = e.getChildren();
                sb.append("<" + name + ">");
                if (!list.isEmpty()) {
                    sb.append(getChildrenText(list));
                }
                sb.append(value);
                sb.append("</" + name + ">");
            }
        }

        return sb.toString();
    }


    @Test
    public void xmltest() throws  Exception{
        String str ="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<response>\n" +
                "\n" +
                "        <data_row>\n" +
                "            <hospitalid>581</hospitalid>\n" +
                "            <hospitalname>嘉峪关市中医院</hospitalname>\n" +
                "            <deptcode>0000000301</deptcode>\n" +
                "            <inputcode>WKMZ</inputcode>\n" +
                "            <deptname>外科门诊</deptname>\n" +
                "            <deptsmallpicurl></deptsmallpicurl>\n" +
                "            <deptmiddlepicurl></deptmiddlepicurl>\n" +
                "            <deptbigpicurl></deptbigpicurl>\n" +
                "            <deptdes>无</deptdes>\n" +
                "            <parentid>0</parentid>\n" +
                "            <deptlevel>1</deptlevel>\n" +
                "            <location>无</location>\n" +
                "            <ordernum>0</ordernum>\n" +
                "            <createtime>2020-07-01 14:31:02</createtime>\n" +
                "            <lastmodify>2020-07-03 04:00:03</lastmodify>\n" +
                "        </data_row>\n" +
                "\n" +
                "</response>\n";
        Map map = doXMLParse(str);
        System.out.println(map);
    }


}
