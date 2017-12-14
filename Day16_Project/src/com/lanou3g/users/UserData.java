package com.lanou3g.users;

import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserData {

    protected static SAXReader saxReader = new SAXReader();
    protected static Document read;
    public static Users read(String userName,String passWord) throws DocumentException {
        read = saxReader.read("src/user.xml");
        Element rootElement = read.getRootElement();
        Users users = null;

        List<Element> elements = rootElement.elements();
        for (Element element : elements) {
            String userName1 = element.attribute("userName").getValue();

            String passWord1 = element.attribute("passWord").getValue();

            String name = element.getText();
            if(userName.equals(userName1)&passWord.equals(passWord1)){
                users = new Users(userName1,passWord1,name);
            }

        }

        return users;

    }




    public static boolean write(Users u) throws IOException, DocumentException {
        read = saxReader.read("src/user.xml");
        Element users = read.getRootElement();
        List<Element> elements = users.elements();
        for (Element element : elements) {
            if (u.getUserName().equals(element.attribute("userName").getValue())) {
                return false;
            }
        }


        Element user = users.addElement("user");
        user.addAttribute("userName", u.getUserName());
        user.addAttribute("passWord", u.getPassWord());
        user.addText(u.getName());


        OutputFormat outputFormat = OutputFormat.createPrettyPrint();
        outputFormat.setEncoding("utf-8");

        XMLWriter xmlWriter = new XMLWriter(new FileWriter("src/user.xml"), outputFormat);
        xmlWriter.write(read);
        xmlWriter.close();
        return true;

    }




}
