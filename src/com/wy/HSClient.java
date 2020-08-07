package com.wy;

import com.caucho.hessian.client.HessianProxyFactory;
import com.yuanqi.hc.info.virtualcard.SignVirtualCardInInfo;
import com.yuanqi.hc.info.virtualcard.SignVirtualCardOutInfo;
import com.yuanqi.hc.wsdl.iface.HealthCardService;
import org.junit.Test;

/**
 * @author wy
 * @create 2020-06-15 14:55
 */

public class HSClient {

    @Test
    public void test() throws Exception {
        try {
            String url = "http://111.59.90.19:15778/HealthCard/hc";
            HessianProxyFactory a = new HessianProxyFactory();
            HealthCardService HealthCardService = (HealthCardService) a.create(HealthCardService.class, url);
            SignVirtualCardInInfo in = new SignVirtualCardInInfo();
            in.setCardNo("110101199003077897");
            in.setCardType("2");
            in.setName("123");
            in.setNation("乌孜别克族");
            in.setAddress("山西省运城市新绛县泽掌镇小聂村");
            in.setBirthday("11111111");
            in.setSex("1");
            in.setMobile("12345678901");
            in.setNation("汉族");
            in.setSignMode("1");

            SignVirtualCardOutInfo out = HealthCardService.SignVirtualCard(in);
            System.out.println(out.getRc());
            System.out.println(out.getErrorMsg());
            System.out.println(out.toString());
        } catch (Exception e) {
           e.printStackTrace();
        }


    }

//        URL url_ = new URL(url);
//        HttpURLConnection connection = (HttpURLConnection) url_.openConnection();
//        connection.setDoOutput(true);
//        connection.setDoInput(true);
//        connection.setRequestMethod("POST");
//        connection.setUseCaches(false);
//        connection.setInstanceFollowRedirects(true);
//        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
//        connection.connect();
//        //POST请求
//        DataOutputStream out = new DataOutputStream(connection.getOutputStream());
//
//        SignVirtualCardInInfo in = new SignVirtualCardInInfo();
//        in.setCardNo("110101199003077897");
//        in.setCardType("2");
//        in.setName("123");
//        in.setNation("乌孜别克族");
//        in.setAddress("山西省运城市新绛县泽掌镇小聂村");
//        in.setBirthday("11111111");
//        in.setSex("1");
//        in.setMobile("12345678901");
//        in.setNation("汉族");
//        in.setSignMode("1");
//       String inc =  in.toString().replace("QueryVirtualCardInInfo","");
//        out.write(inc.getBytes("UTF-8"));
//        out.flush();
//        out.close();
//
//        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//        String lines;
//        StringBuffer sb = new StringBuffer("");
//        while ((lines = reader.readLine()) != null) {
//            lines = new String(lines.getBytes(), "utf-8");
//            sb.append(lines);
//        }
//        System.out.println(sb);
//        reader.close();
//        // 断开连接
//        connection.disconnect();
//
//


}
