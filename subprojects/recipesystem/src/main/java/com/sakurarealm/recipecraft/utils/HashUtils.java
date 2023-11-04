package com.sakurarealm.recipecraft.utils;

import java.util.List;
import java.util.zip.CRC32;

public class HashUtils {

    private static final int prime = 1000000007;

    static public int commutativeHash(Object[] objects) {
        int hash = 0;
        for (Object object : objects) {
            hash += object.hashCode();
        }
        return hash % prime;
    }

    static public int nonCommutativeHash(Object[] objects) {
        int hash = 0;
        for (int i = 0; i < objects.length; i++) {
            hash += objects[i].hashCode() * (i + 1);
        }
        return hash % prime;
    }

    static public String crc32(List<String> string) {
        CRC32 crc32 = new CRC32();
        for (String s : string) {
            byte[] b = s.getBytes();
            crc32.update(b, 0, b.length);
        }
        return Long.toHexString(crc32.getValue());
    }
}
