package com.powek.common.utils;

import org.apache.commons.codec.binary.Hex;

import java.io.PipedWriter;
import java.security.MessageDigest;
import java.util.Random;

public class DecodeUtil {

    public static String decodePwd(String password)
    {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(16);
        for (int i = 0; i < 16; i++)
        {
            sb.append(random.nextInt(10));
        }
        String salt = sb.toString();
        String pwdSalt = md5Hex(password + salt);
        char[] rst = new char[48];
        for (int i = 0; i < 48; i++)
        {
            if ((i + 1) % 3 == 0)
            {
                rst[i] = salt.charAt((i + 1) / 3 - 1);
            }
            else
            {
                rst[i] = pwdSalt.charAt(i - (i + 1) / 3);
            }
        }
        return new String(rst);
    }

    private static String md5Hex(String pwdSalt)
    {
        try
        {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bytes = md5.digest(pwdSalt.getBytes());
            return new String(new Hex().encode(bytes));
        }
        catch (Exception e)
        {
            return "";
        }
    }

    public static Boolean verifyPwd(String password, String md5)
    {
        char[] pwd = new char[32];
        char[] salt = new char[16];

        for (int i = 0; i < 48; i++)
        {
            if ((i + 1) % 3 == 0)
            {
                salt[(i + 1) / 3 -1] = md5.charAt(i);
            }
            else
            {
                pwd[i - (i + 1) / 3] = md5.charAt(i);
            }
        }
        if (md5Hex(password + new String(salt)).equals(new String(pwd)))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
