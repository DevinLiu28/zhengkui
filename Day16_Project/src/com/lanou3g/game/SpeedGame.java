package com.lanou3g.game;

import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public class SpeedGame {

    public static void main(String[] args) {
        games();
    }
    public static void games(){

        System.out.println("请选择游戏难度:1-简单;2-适中;3-困难");
        Scanner sc = new Scanner(System.in);
        String select = sc.nextLine();
        for (int i = 3; i >0; i--){
            System.out.println("倒计时"+i+"秒后开始");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        switch (select){
            case "1":

                break;




            case "2":
                String b = "QWERTYUIOPASDFGHJKLZXCVBNM1234567890";

                break;




            case "3":
//                for (int i = 3; i >0; i--){
//                    System.out.println("倒计时"+i+"秒后开始");
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//
//                }
                String a = "QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm1234567890/+-*[]{})(_=)(*&^%$#@!~\\";
                Random r = new Random();
                StringBuffer sb = new StringBuffer();
                while (true) {
                    for (int j = 0; j < 30; j++) {
                        sb.append(a.charAt(r.nextInt(a.length())));
                    }
                    String word =("^.*[a-zA-Z]+.*$") ;
                    String word1 = ("^.*[0-9]+.*$");
                    String word2 = ("^.{30}");
                    if (Pattern.matches(word,sb)&&Pattern.matches(word1,sb)&&Pattern.matches(word2,sb)){
                        break;
                    }
                    sb.setLength(0);
                }
                System.out.println(sb);
                break;








            }





        }


    }
}
