package com.lanou3g.bookstore.util;

import java.util.Random;

public class RandomId {

    public static String randomId()  {
        try {
            StringBuffer result = new StringBuffer();
            for(int i=0;i<6;i++) {
                result.append(Integer.toHexString(new Random().nextInt(16)));
            }
            return result.toString().toUpperCase();

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();

        }
        return null;

    }
}
