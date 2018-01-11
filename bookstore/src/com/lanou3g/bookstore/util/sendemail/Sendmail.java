package com.lanou3g.bookstore.util.sendemail;

import com.lanou3g.bookstore.user.domain.User;
import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.GeneralSecurityException;
import java.util.Properties;

public class Sendmail {
    public static void sendmail(User user) {
        String sendAddr = "1135337863@qq.com";//这是发送方的邮箱
        String receiveAddr = user.getEmail();//接收方的邮箱
        //邮箱生成的授权码
        String pass = "aecjdykxxcucifcj";
        //QQ邮件服务器
        String host = "smtp.qq.com";
        Properties prop = new Properties();
        //设置服务器主机名
        prop.setProperty("mail.host",host);
        prop.setProperty("mail.smtp.auth","true");
        try {
            MailSSLSocketFactory sf = new MailSSLSocketFactory();
            sf.setTrustAllHosts(true);
            prop.put("mail.smtp.ssl.enable", "true");
            prop.put("mail.smtp.ssl.socketFactory", sf);
            Authenticator auth = new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(sendAddr,pass);
                }
            };
            Session session = Session.getInstance(prop,auth);
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(sendAddr));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(receiveAddr));
            message.setSubject("这是来自蓝鸥网上书城的激活邮件");
            message.setContent("<a href=\"http://localhost:8080/bookstore/user?method=active&code="+user.getCode()+"\">点击这里完成激活</a>"+"或者复制链接访问   "+"http://localhost:8080/bookstore/user?method=active&code="+user.getCode(),"text/html;charset=utf-8");

            Transport.send(message);
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
