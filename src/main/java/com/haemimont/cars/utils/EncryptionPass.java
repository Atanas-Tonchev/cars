package com.haemimont.cars.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptionPass {

    public static String MD5(String input) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] md = messageDigest.digest(input.getBytes());
            BigInteger number = new BigInteger(1,md);
            String hashText = number.toString(16);
            return hashText;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
