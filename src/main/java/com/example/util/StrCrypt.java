package com.example.util;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public final class StrCrypt {

    private static final byte[] KEY = {
        0x5A, 0x3C, (byte) 0x91, 0x7E, (byte) 0xB4, 0x22, (byte) 0xC8, 0x0F
    };

    private StrCrypt() {}

    public static String d(String encoded) {
        byte[] data = Base64.getDecoder().decode(encoded);
        byte[] out = new byte[data.length];
        for (int i = 0; i < data.length; i++) {
            out[i] = (byte) (data[i] ^ KEY[i % KEY.length]);
        }
        return new String(out, StandardCharsets.UTF_8);
    }
}
