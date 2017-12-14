package com.lanou3g.users;

import com.lanou3g.exceptions.LoginName;
import com.lanou3g.exceptions.LoginNoMatching;
import com.lanou3g.exceptions.LoginNoPhoneNum;
import com.lanou3g.exceptions.LoginPassWordTooEasy;
import org.dom4j.DocumentException;

import java.io.IOException;
import java.util.regex.Pattern;

public class UserOperate {
    public static boolean register(Users users) throws LoginNoPhoneNum, LoginPassWordTooEasy, LoginName, IOException, DocumentException {

        if(!ChickUser.userNameIsPhoneNum(users.getUserName())&&!ChickUser.userNameIsEmail(users.getUserName())){
            throw new LoginNoPhoneNum();
        }else if(!ChickUser.passWordTooEasy(users.getPassWord())){
            throw new LoginPassWordTooEasy();
        }else if(!ChickUser.chickName(users.getName())){
            throw new LoginName();
        }else if(!UserData.write(users)){
            return false;
        }else {
            return true;
        }


    }

    public static Users login(String userName,String passWord) throws LoginNoMatching, DocumentException {

        Users user = UserData.read(userName, passWord);

        if (user == null){
            throw new LoginNoMatching();
        }

        return user;
    }


}
