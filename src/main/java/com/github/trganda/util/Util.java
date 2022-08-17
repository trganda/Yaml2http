package com.github.trganda.util;

public class Util {

    public static String hex2Unicode(String expression) {
        int idx = 0;
        while (idx < expression.length()) {
            char cur = expression.charAt(idx);
            if (cur == '\\' && (expression.length() - idx - 1) > 2 && (expression.charAt(idx+1) == 'x' || expression.charAt(idx+1) == 'X')) {
                char a = (char) ((int)Integer.decode("0x" + expression.substring(idx + 2, idx + 4)));
                expression = expression.substring(0, idx) + a + expression.substring(idx+4);
            }
            idx++;
        }

        return expression;
    }

    public static byte[] getBytes(String expression) {
        char[] buffer = expression.toCharArray();
        byte[] bytes = new byte[buffer.length];

        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte)(buffer[i] & 0x00FF);
        }

        return bytes;
    }

}