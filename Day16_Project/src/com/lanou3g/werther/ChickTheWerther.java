package com.lanou3g.werther;

import com.lanou3g.exceptions.LoginNoPhoneNum;
import com.lanou3g.users.ChickUser;
import net.sf.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class ChickTheWerther {
//    public static void main(String[] args) throws IOException {
//        phone("13415879514");
//    }
    public static void werther(String s) throws IOException {
        URL u=new URL("http://api.k780.com/?app=weather.today&weaid="+s+"&appkey=10003&sign=b59bc3ef6191eb9f747dd4e83c99f2a4&format=json");
        InputStream in=u.openStream();
        ByteArrayOutputStream out=new ByteArrayOutputStream();
        try {
            byte buf[]=new byte[1024];
            int read = 0;
            while ((read = in.read(buf)) > 0) {
                out.write(buf, 0, read);
            }
        }  finally {
            if (in != null) {
                in.close();
            }
        }
        byte b[]=out.toByteArray( );
        String str = new String(b,"utf-8");
        //System.out.println(str);
        JSONObject jsonObject = JSONObject.fromObject(str);
        WeatherData weatherData = (WeatherData) JSONObject.toBean(jsonObject,WeatherData.class);
        System.out.println(s+"的天气是"+weatherData.getResult().getWeather());
    }



    public static void phone(String num) throws IOException, LoginNoPhoneNum {
        if(!ChickUser.userNameIsPhoneNum(num)){
            throw new LoginNoPhoneNum();
        }
        URL u=new URL("http://api.k780.com/?app=phone.get&phone="+num+"&appkey=10003&sign=b59bc3ef6191eb9f747dd4e83c99f2a4&format=json");
        InputStream in=u.openStream();
        ByteArrayOutputStream out=new ByteArrayOutputStream();
            byte buf[]=new byte[1024];
            int read = 0;
            while ((read = in.read(buf)) > 0) {
                out.write(buf, 0, read);
        }
            if (in != null) {
                in.close();
            }

        byte b[]=out.toByteArray( );
        String str = new String(b,"utf-8");
        //System.out.println(str);
        JSONObject jsonObject = JSONObject.fromObject(str);
        Phone phone = (Phone) JSONObject.toBean(jsonObject,Phone.class);
        System.out.println("您的手机号码归属地为"+phone.getResult().getStyle_simcall());
    }

}
