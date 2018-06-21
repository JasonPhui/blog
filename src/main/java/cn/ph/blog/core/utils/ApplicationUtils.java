package cn.ph.blog.core.utils;

import java.util.Random;
import java.util.UUID;

public class ApplicationUtils {

    public static String getUUID(){
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        String temp = str.substring(0, 8) + str.substring(9, 13) + str.substring(14, 18) + str.substring(19, 23) + str.substring(24);
        return temp;
    }

    /**
     * 生成六位数字字符串
     * @return 返回六位数字字符串
     */
    public static String getNumStringRandom(int length){
        String sources = "0123456789"; // 加上一些字母，就可以生成pc站的验证码了
        Random rand = new Random();
        StringBuffer flag = new StringBuffer();
        for (int j = 0; j < length; j++)
        {
            flag.append(sources.charAt(rand.nextInt(9)) + "");
        }
        return flag.toString();
    }
}
