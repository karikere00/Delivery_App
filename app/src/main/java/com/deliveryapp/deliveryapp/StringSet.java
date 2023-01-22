package com.deliveryapp.deliveryapp;

import java.util.Set;
import java.util.HashSet;

public class StringSet {
    private static final Set<String> strings = new HashSet<>();

    static {
        strings.add("235564");
        strings.add("934790");
        strings.add("984338");
        strings.add("767442");
        strings.add("684389");
    }

    public static boolean isInSet(String s) {
        return strings.contains(s);
    }
}
