package com.wy;


import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import pnbclient.command.SQLCommandService;

import java.io.File;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

public class TestXMLImport {

    public static void main(String[] args) throws SQLException {
        // TODO Auto-generated method stub
//        执行插入的SQL语句，

        try {
            String sql = "insert into productmanager.power_service_msgconfig (REMOTE_ID, REMOTE_METHOD_CODE, VERSION_ID, XML_DEFINITION, CREATER) values (?, ?, ?, ?,?)";


            //            读取xml文件存放的路径
            Document doc = new SAXReader().read(new File("D:\\==Public==\\7777777.xml"));
//            查找对应的信息，从XMl中找对应的层层关系，我的xml文件中，一开始只是Rows，然后每条数据为Row。
            List itemList = doc.selectNodes("/ROWDATA/ROW");
//            遍历
            for (Iterator iter = itemList.iterator(); iter.hasNext(); ) {
                Element el = (Element) iter.next();
//                使用Element的elementText属性取值，将值一一取出来，这个没有取xml文件中TRANS_DM_TONG_INSERTDATE字段，是因为我需要
//　　　　　　　　　系统时间作为时间字段，默认时间为sysdate
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                String REMOTE_ID = el.elementText("REMOTE_ID");
                String REMOTE_METHOD_CODE = el.elementText("REMOTE_METHOD_CODE");
                String VERSION_ID = el.elementText("VERSION_ID");
                String XML_DEFINITION = el.elementText("XML_DEFINITION");
                String CREATER = el.elementText("CREATER");
                SQLCommandService ser = new SQLCommandService();
                ser.addParameter( REMOTE_ID);
                ser.addParameter(REMOTE_METHOD_CODE);
                ser.addParameter( VERSION_ID);
                ser.addParameter(XML_DEFINITION);
              //  ser.addParameter(sdf.format(new Date().getTime()));
                ser.addParameter(CREATER);
                ser.execute(sql);

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }

}