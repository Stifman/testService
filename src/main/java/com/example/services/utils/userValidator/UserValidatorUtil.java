package com.example.services.utils.userValidator;

import java.io.UnsupportedEncodingException;

public class UserValidatorUtil {
    public static Boolean validateUserString(String field, int byteSize) {
        try {
            byte[] masReturnByte = field.getBytes("UTF-8");
            if (masReturnByte.length > byteSize) return true;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return false;
    }
}
