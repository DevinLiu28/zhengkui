package com.lanou3g.users;

import java.util.regex.Pattern;

public class ChickUser {
    public static boolean userNameIsPhoneNum(String userName){
        String name = "[1][34578]\\d{9}";
        return Pattern.matches(name,userName);
    }

    public static boolean userNameIsEmail(String userName){
        String name = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        return Pattern.matches(name,userName);
    }

    public static boolean passWordTooEasy(String passWord){
        String word =("^.*[a-zA-Z]+.*$") ;
        String word1 = ("^.*[0-9]+.*$");
        String word2 = ".{6,14}";
        return Pattern.matches(word,passWord)&Pattern.matches(word1,passWord)
                &Pattern.matches(word2,passWord);

    }


    public static boolean chickName(String name){
        String word = "[a-zA-Z]*";
        return Pattern.matches(word,name);
    }


}
