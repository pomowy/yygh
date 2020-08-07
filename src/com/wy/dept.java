package com.wy;

import com.maptest.HashMap_;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.commons.codec.binary.Base64;
import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.junit.Test;
import pnbclient.command.SQLCommandService;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class dept {
    /*
    同步科室
     */
    public static void main(String[] arges) throws Exception {
        SQLCommandService ser = new SQLCommandService();
        int sun = 0;
        SAXBuilder saxBuilder = new SAXBuilder();
        InputStream is = new FileInputStream(new File("src/dept.xml"));
        Document document = saxBuilder.build(is);
        Element rootElement = document.getRootElement();
        List<Element> children = rootElement.getChildren();
        for (Element child : children) {
            System.out.println("通过rollno获取属性值:" + child.getAttribute("rollno"));
            List<Attribute> attributes = child.getAttributes();
            //打印属性
            for (Attribute attr : attributes) {
                System.out.println(attr.getName() + ":" + attr.getValue());
            }
            List<Element> childrenList = child.getChildren();
            System.out.println("======获取子节点-start======");
//            for (Element o : childrenList) {
//                //System.out.println("节点名:" + o.getName() + "---" + "节点值:" + o.getValue());
//            }
            try {
                String sql = "insert into productmanager.it_microsthospital_dept t(hospital_id,dept_code,dept_name,dept_level,parent_id,is_delete,is_used,hisdept_code,is_assplatdept,dept_type,ordernum) values(?,?,?,?,?,?,?,?,?,?,?)";

                ser.addParameter("8d87a8b0-9605-43fb-ad1a-571da32e320eJYGZY");
                ser.addParameter(childrenList.get(2).getValue());
                ser.addParameter(childrenList.get(4).getValue());
                ser.addParameter("2");
                ser.addParameter("0");
                ser.addParameter("0");
                ser.addParameter("0");
                ser.addParameter(childrenList.get(2).getValue());
                ser.addParameter("0");
                ser.addParameter("1");
                ser.addParameter(childrenList.get(12).getValue());
                sun += ser.execute(sql);


            } catch (Exception e) {
                continue;
            }


            System.out.println("======获取子节点-end======");
        }

        System.out.println("执行了" + sun + "次");

    }

    /*
    同步医生
     */
    @Test
    public void doctor() throws Exception {
        int sun = 0;
        SQLCommandService ser = new SQLCommandService();
        SAXBuilder saxBuilder = new SAXBuilder();
        InputStream is = new FileInputStream(new File("src/doctor.xml"));
        Document document = saxBuilder.build(is);
        Element rootElement = document.getRootElement();
        List<Element> children = rootElement.getChildren();
        for (Element child : children) {
            System.out.println("通过rollno获取属性值:" + child.getChildren("rollno"));
            List<Attribute> attributes = child.getAttributes();
            //打印属性
            for (Attribute attr : attributes) {
                System.out.println(attr.getName() + ":" + attr.getValue());
            }
            Map map = new HashMap();

            List<Element> childrenList = child.getChildren();
            for (int y = 0; y < childrenList.size(); y++) {
                map.put(childrenList.get(y).getName(), childrenList.get(y).getValue());
            }

            System.out.println(map.get("doctorname"));
            System.out.println("======获取子节点-start======");

            try {
                String sql = " insert into productmanager.it_microsthospital_doctor t (hospital_id,dept_code,doctor_no,doctor_name,doctor_title,t.doctor_des,is_used,hisdoctor_no,is_delete,hisdept_code,input_code,specialty) values(?,?,?,?,?,?,?,?,?,?,?,?)";

                ser.addParameter("2a0a5ba8-42d4-42cb-bdb4-ff861cade531");
                ser.addParameter((String) map.get("deptcode"));
                ser.addParameter((String) map.get("doctorno"));
                ser.addParameter((String) map.get("doctorname"));
                ser.addParameter((String) map.get("doctortitle"));
                ser.addParameter((String) map.get("doctordes"));
                ser.addParameter("0");
                ser.addParameter((String) map.get("doctorno"));
                ser.addParameter("0");
                ser.addParameter((String) map.get("deptcode"));
                ser.addParameter((String) map.get("inputcode"));
                ser.addParameter((String) map.get("specialty"));

//                String key = (String) map.get("doctorsmallpicurl");
//                String key_1 =  key.replace("/image/upload/","/images/hospital/whjytyy/");
//                ser.addParameter(key_1);

                sun += ser.execute(sql);
            } catch (Exception e) {
                //e.printStackTrace();
                continue;
            }


        }

        System.out.println("======共执行了" + sun + "次======");
        System.out.println("======获取子节点-end======");
    }


    @Test
    public void checkdoctor() {
        SQLCommandService se = new SQLCommandService();
        String sql = "select t.* from productmanager.mydoctor t";
        //List list = new ArrayList<mydoctor>();
        List<mydoctor> list = se.getListBean(sql, Doctors.class);

        for (int i = 0; i < list.size(); i++) {
            String sql1 = "select count(1) from productmanager.it_microsthospital_doctor t where hospital_id = '4f312cb8-55b9-495c-b7ca-d2f0c7efae5e' and hisdoctor_no='" + list.get(i).getID() + "'and doctor_name='" + list.get(i).getNAME() + "'";


            String y = String.valueOf(se.getSingleObject(sql1));
            int z = Integer.valueOf(y);
            //System.out.println(y);
            sql.split(".");
            if (z < 1) {
                System.out.println("未查询到的医生no=" + list.get(i).getID() + ",医生姓名=" + list.get(i).getNAME());
            }

        }


    }

    @Test
    public void updatedoctor() {
        SQLCommandService ser = new SQLCommandService();
        String sql = " select t.hospital_id,t.dept_code,t.doctor_no,t.input_code,t.doctor_name,t.doctor_title,t.is_used,t.hisdoctor_no,t.is_delete,t.hisdept_code,t.doctor_des,t.ordernum,t.specialty,t.smallphoto_url from productmanager.it_microsthospital_doctor t where t.hospital_id in ( 'CCZYFSDStbys01') ";
        List<Doctors> list = ser.getListBean(sql, Doctors.class);

        String sql1 = "update productmanager.it_microsthospital_doctor t set t.specialty=?, t.doctor_des=?   where t.hospital_id='8d87a8b0-9605-43fb-ad1a-571da32e320eCCZYFSDS' and doctor_name=? ";


        for (Doctors i : list) {
            try {
                ser.addParameter(i.getSPECIALTY());
                ser.addParameter(i.getDOCTORDES());
                ser.addParameter(i.getDOCTORNAME());

                ser.execute(sql1);
            } catch (Exception e) {

                continue;
            }


        }


    }


    @Test
    public void test() {
        String a = "{\"ysgh\":\"系统管理员\",\"je\":\".9\",\"mcyl\":\"1\",\"jg\":\".9\",\"bz\":\"自助结算\",\"xmmc\":\"维生素C片\",\"ypgg\":\"100MG*100#\",\"yyxmbh\":\"A0000234A\",\"xmxh\":\"65604113\",\"tzje\":\"0\",\"ypjx\":\"\",\"jzrq\":\"20200305\"}";
//        JsonParser parser = new JsonParser();
//        JsonElement je = parser.parse(a);
//        JsonObject jobj = je.getAsJsonObject();
//        String name = jobj.get("yyxmbh").getAsString();
//        System.out.print(name);

        String fozuStr = "ICAgICAgICAgICAgICAgICAgIF9vb09vb18KICAgICAgICAgICAgICAgICAgbzg4ODg4ODhvCiAgICAgICAgICAgICAgICAgIDg4IiAuICI4OAogICAgICAgICAgICAgICAgICAofCAtXy0gfCkKICAgICAgICAgICAgICAgICAgT1wgID0gIC9PCiAgICAgICAgICAgICAgIF9fX18vYC0tLSdcX19fXwogICAgICAgICAgICAgLicgIFxcfCAgICAgfC8vICBgLgogICAgICAgICAgICAvICBcXHx8fCAgOiAgfHx8Ly8gIFwKICAgICAgICAgICAvICBffHx8fHwgLTotIHx8fHx8LSAgXAogICAgICAgICAgIHwgICB8IFxcXCAgLSAgLy8vIHwgICB8CiAgICAgICAgICAgfCBcX3wgICcnXC0tLS8nJyAgfCAgIHwKICAgICAgICAgICBcICAuLVxfXyAgYC1gICBfX18vLS4gLwogICAgICAgICBfX19gLiAuJyAgLy0tLi0tXCAgYC4gLiBfXwogICAgICAuIiIgJzwgIGAuX19fXF88fD5fL19fXy4nICA+JyIiLgogICAgIHwgfCA6ICBgLSBcYC47YFwgXyAvYDsuYC8gLSBgIDogfCB8CiAgICAgXCAgXCBgLS4gICBcXyBfX1wgL19fIF8vICAgLi1gIC8gIC8KPT09PT09YC0uX19fX2AtLl9fX1xfX19fXy9fX18uLWBfX19fLi0nPT09PT09CiAgICAgICAgICAgICAgICAgICBgPS0tLT0nCl5eXl5eXl5eXl5eXl5eXl5eXl5eXl5eXl5eXl5eXl5eXl5eXl5eXl5eXl5eXgogICAgICAgICAgICAgICAgIOS9m+elluS/neS9kSAgICAgICDmsLjml6BCVUc=";
        //byte[] decode = Base64.decode(fozuStr.toCharArray());

        String C = "PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiPz4KPHJlcXVlc3Q+CiAgPHJlcXVlc3RpZD4xMjE8L3JlcXVlc3RpZD4KICA8cGFnZWFjdGlvbmluPgogICAgPGN1cnJlbnRwYWdlbnVtPjwvY3VycmVudHBhZ2VudW0+CiAgICA8cm93c3BlcnBhZ2U+PC9yb3dzcGVycGFnZT4KICAgIDxwYWdlYWN0aW9uPjwvcGFnZWFjdGlvbj4KICAgIDx0b3BhZ2VudW0+PC90b3BhZ2VudW0+CiAgPC9wYWdlYWN0aW9uaW4+CiAgPHJldHJpZXZlYXJncz4KICAgIDxob3NwaXRhbGlkPjUzMTwvaG9zcGl0YWxpZD4KICAgIDxkYXRhPgogICAgICA8ZGF0YV9yb3c+CiAgICAgICAgPGhvc3BpdGFsaWQ+NTMxPC9ob3NwaXRhbGlkPgogICAgICAgIDxkb2N0b3Jubz45MDAwMzwvZG9jdG9ybm8+CiAgICAgICAgPHBhcmVudGlkPjwvcGFyZW50aWQ+CiAgICAgICAgPGRlcHRjb2RlPmtzMDI1MDEwMTwvZGVwdGNvZGU+CiAgICAgIDwvZGF0YV9yb3c+CgkgICAgICAgIDxkYXRhX3Jvdz4KICAgICAgICA8aG9zcGl0YWxpZD41MzE8L2hvc3BpdGFsaWQ+CiAgICAgICAgPGRvY3Rvcm5vPjIxMTM8L2RvY3Rvcm5vPgogICAgICAgIDxwYXJlbnRpZD48L3BhcmVudGlkPgogICAgICAgIDxkZXB0Y29kZT5jazAwMTAxPC9kZXB0Y29kZT4KICAgICAgPC9kYXRhX3Jvdz4KCSAgCSAgICAgICAgPGRhdGFfcm93PgogICAgICAgIDxob3NwaXRhbGlkPjUzMTwvaG9zcGl0YWxpZD4KICAgICAgICA8ZG9jdG9ybm8+MTAwNjwvZG9jdG9ybm8+CiAgICAgICAgPHBhcmVudGlkPjwvcGFyZW50aWQ+CiAgICAgICAgPGRlcHRjb2RlPmtzMDAyMDEwMjwvZGVwdGNvZGU+CiAgICAgIDwvZGF0YV9yb3c+CiAgICA8L2RhdGE+CiAgPC9yZXRyaWV2ZWFyZ3M+CjwvcmVxdWVzdD4=";

        //byte[] decode = org.apache.axis.encoding.Base64.decode(fozuStr.toString());
        byte[] decode = org.apache.axis.encoding.Base64.decode(C.toString());
        System.out.println("\n" + new String(decode));


    }


    /*
    调用webservices接口demo

     */
    @Test
    public void remote() {

//入参转成base64码
        String inxml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<request>\n" +
                "  <requestid>121</requestid>\n" +
                "  <pageactionin>\n" +
                "    <currentpagenum>1</currentpagenum>\n" +
                "    <rowsperpage>1000</rowsperpage>\n" +
                "    <pageaction>firstpage</pageaction>\n" +
                "    <topagenum>1</topagenum>\n" +
                "  </pageactionin>\n" +
                "  <retrieveargs>\n" +
                "    <hospitalid>514</hospitalid>\n" +
                "    <departcode></departcode>\n" +
                "    <doctorlike></doctorlike>\n" +
                "    <extInfo></extInfo>\n" +
                "  </retrieveargs>\n" +
                "</request>\n";
        Base64 base64 = new Base64();
        byte[] bytes = inxml.getBytes();
        String encode = Base64Util.encode(bytes);

        try {
           // String endpoint = "http://218.206.235.182:15778/powermopsrv/services/yygh";
            String endpoint =   "http://202.103.61.165:15778/powermopsrv/services/yygh";
            // 直接引用远程的wsdl文件
            // 以下都是套路
            Service service = new Service();
            Call call = (Call) service.createCall();
            call.setTargetEndpointAddress(endpoint);
          //  call.setOperationName("GetEffectiveDoctorList");// WSDL里面描述的接口名称
            call.setOperationName("GetDoctorList");// WSDL里面描述的接口名称
            call.addParameter("userName",
                    org.apache.axis.encoding.XMLType.XSD_DATE,
                    javax.xml.rpc.ParameterMode.IN);// 接口的参数
            call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);// 设置返回类型
            String temp = encode;
            String result = (String) call.invoke(new Object[]{temp});
            // 给方法传递参数，并且调用方法
            System.out.println("result is " + result);
            //解析出参
            byte[] decode = Base64Util.decode(result);
            result = new String(decode);
            System.out.println(result);

        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }



    @Test
    public void testhashmap_(){
        HashMap_<String,String> hashMap_ = new HashMap_<>();

        hashMap_.put("张三","张三_");
        hashMap_.put("六一","六一_");
        hashMap_.put("陈二","陈二_");
        hashMap_.put("李四","李四_");
        hashMap_.put("李四","李四er");
        hashMap_.put("王五","王五_");
        hashMap_.put("monkey","monkey_");
       // System.out.println(hashMap_.get("李四"));
        for(int i=0;i<1000;i++){
            hashMap_.put("测试"+i,"测试"+i);
           // System.out.println(hashMap_.get("测试"+i));
        }

      System.out.println(hashMap_);
    }



}
