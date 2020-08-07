package com.webser;

import org.junit.Test;

import javax.xml.ws.Endpoint;


public class JwsServiceHello implements JwsService {
    /**
     *
     *
     * @param name
     * @return String 返回结果
     *
     */

    public String getvalue(String name) {
        System.out.println("欢迎你！" + name);
        return "欢迎你！" + name;
    }





    @Test
    public  void main() {
     /*参数:1,本地的服务地址;
           2,提供服务的类;
      */
        Endpoint.publish("http://127.0.0.1:7777/helloWorld", new JwsServiceHello());


        System.out.println("发布成功!");

    }


}
