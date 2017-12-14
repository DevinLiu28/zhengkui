package com.lanou3g;

import com.lanou3g.exceptions.LoginName;
import com.lanou3g.exceptions.LoginNoMatching;
import com.lanou3g.exceptions.LoginNoPhoneNum;
import com.lanou3g.exceptions.LoginPassWordTooEasy;
import com.lanou3g.users.ChickUser;
import com.lanou3g.users.UserOperate;
import com.lanou3g.users.Users;
import com.lanou3g.werther.ChickTheWerther;
import org.dom4j.DocumentException;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Loading{
    private static final String SING_IN = "1";
    private static final String LOG_IN = "2";

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("欢迎来到本系统;请根据提示输入相应信息");
        Users user = null;
        a: while (true) {
            System.out.println("1-注册;2-登录;3-退出");
            String s = sc.nextLine();
            switch (s) {
                case SING_IN:


                    b:
                    while (true) {
                        System.out.println("请输入你的用户名----用户名必须为电话号码或邮箱");
                        String userName = sc.nextLine();
                        System.out.println("请输入你的密码-----密码必须包含大小写字母和数字");
                        String passWord = sc.nextLine();
                        System.out.println("请输入你的姓名-----姓名必须为全英文");
                        String name = sc.nextLine();
                        user = new Users(userName, passWord, name);

                        try {
                            if (!UserOperate.register(user)) {
                                System.out.println("输入用户名重复;请重新输入");
                                continue b;
                            }
                        } catch (LoginNoPhoneNum loginNoPhoneNum) {
                            System.out.println(loginNoPhoneNum.getMessage());
                            continue b;
                        } catch (LoginPassWordTooEasy loginPassWordTooEasy) {
                            System.out.println(loginPassWordTooEasy.getMessage());
                            continue b;
                        } catch (LoginName loginName) {
                            System.out.println(loginName.getMessage());
                            continue b;
                        } catch (DocumentException e) {
                            e.printStackTrace();
                        }

                        break;
                    }
                     break;


                case LOG_IN:

                    c:
                    while (true) {
                        System.out.println("请输入登录用户名");
                        String userName = sc.nextLine();
                        System.out.println("请输入登录密码");
                        String passWord = sc.nextLine();

                        try {
                            user = UserOperate.login(userName, passWord);
                        } catch (LoginNoMatching loginNoMatching) {
                            System.out.println(loginNoMatching.getMessage());
                            continue c;
                        } catch (DocumentException e) {
                            e.printStackTrace();
                        }

                        System.out.println(user);

                        System.out.println("登录成功");
                        break a;
                    }

            }
        }

        System.out.println("欢迎"+user.getName()+"进入xx系统");
        c: while (true) {
            System.out.println("1-查询天气" + "\n" + "2-查询手机号码归属地" + "\n" + "3-手速游戏" + "\n" + "4-查询手速游戏前十用户");
            switch (sc.nextLine()){
                case "1":
                    System.out.println("请输入你要查询的城市");
                    ChickTheWerther.werther(sc.nextLine());
                    continue c;

                case "2":
                    System.out.println("请输入你要查询的手机号码");
                    try {
                        ChickTheWerther.phone(sc.nextLine());
                    } catch (LoginNoPhoneNum loginNoPhoneNum) {
                        System.out.println("请输入正确的电话号码");
                    }
                    continue c;
                case "3":

                    break;
                case "4":
                    break;
            }


        }

    }
}
