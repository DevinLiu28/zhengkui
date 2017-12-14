package com.lanou3g.game;

import java.util.*;
import java.util.regex.Pattern;

public class SpeedGame {

    public static int time = 0;
    public static void main(String[] args) {

       // games();
    }
    public static int games(List list,String difficulty){
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
//        for (int i = 3; i > 0; i--) {
//            System.out.println("倒计时" + i + "秒后开始");
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
            StringBuffer sb = new StringBuffer();
            switch (difficulty){
                case "1":
                    for (int j = 0; j < 10; j++) {
                        sb.append(list.get(r.nextInt(list.size())));
                    }
                    break;
                case "2":
                    for (int j = 0; j < 20; j++) {
                        sb.append(list.get(r.nextInt(list.size())));
                    }
                    break;
                case "3":
                    for (int j = 0; j < 30; j++) {
                        sb.append(list.get(r.nextInt(list.size())));
                    }
                    break;
            }

        System.out.println(sb);

        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                time++;
            }
        };
        timer.schedule(timerTask,0,1);
        String answer = sc.nextLine();
        while (answer.equals(sb)){
            timer.cancel();
        }
        System.out.println("你的成绩为:"+time);
        return time;

    }


//                    String word =("^.*[a-zA-Z]+.*$") ;
//                    String word1 = ("^.*[0-9]+.*$");
//                    String word2 = ("^.{30}");
//                    if (Pattern.matches(word,sb)&&Pattern.matches(word1,sb)&&Pattern.matches(word2,sb)){
//                        break;
//                    }

}
