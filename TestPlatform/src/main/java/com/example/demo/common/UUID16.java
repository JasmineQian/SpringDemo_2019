package com.example.demo.common;

import java.util.Random;
import java.util.UUID;

public class UUID16 {

    public static String uuid() {
        int first = new Random(10).nextInt(8) + 1;
        int hashCodeV = UUID.randomUUID().toString().hashCode();
        if (hashCodeV < 0) {
            hashCodeV = -hashCodeV;
        }
        return first + String.format("%015d", hashCodeV);
    }

}
