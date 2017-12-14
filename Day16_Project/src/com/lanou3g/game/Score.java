package com.lanou3g.game;

import com.lanou3g.users.Users;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.print.DocFlavor;
import javax.xml.bind.Element;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class Score {

//    public static void main(String[] args) throws IOException {
//        showTen();
//        //showFirst();
//    }
    public static String pushScore(String url) throws IOException {
        URL u=new URL(url);
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

        byte b[]=out.toByteArray();
        String str = new String(b,"utf-8");
       // System.out.println(str);
        return str;

    }


    public static void showFirst() throws IOException {

        URL u = new URL("http://192.168.20.194:8080/day16/first");
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
        byte b[]=out.toByteArray();
        String str = new String(b);
        //System.out.println(str);
        XStream xStream = new XStream(new DomDriver());
        xStream.alias("User", Rank.class);
        Rank rank = (Rank) xStream.fromXML(str);
        System.out.println("第一名为:"+rank.getUser()+"成绩为:"+rank.getScore());


    }


    public static void showTen() throws IOException {
        URL u = new URL("http://192.168.20.194:8080/day16/ten");
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

        byte b[]=out.toByteArray();
        String str = new String(b,"utf-8");
        System.out.println(str);
        JSONArray jsonArray = JSONArray.fromObject(str);

        for(int i = 0; i < jsonArray.size(); i++){
            JSONObject jsonObject = jsonArray.getJSONObject(i);



            System.out.println("第"+(i+1)+"名"+jsonObject.get("nickname")+"的分数为:"+jsonObject.get("score"));
        }

//        for (Rank rank : list) {
//            System.out.println(rank.getUser()+"的分数为:"+rank.getScore());
//        }



    }

}
