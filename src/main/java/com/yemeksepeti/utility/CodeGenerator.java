package com.yemeksepeti.utility;

import java.util.UUID;
public class CodeGenerator {
    public static String generateCode(){
        String code = UUID.randomUUID().toString();
        String[] data = code.split("-");
        StringBuilder newcode = new StringBuilder();
        String newCode="";
        for (String str: data) {
            newCode += str.charAt(0);
            newcode.append(str.charAt(0));
        }
        return newcode.toString();
    }
}
