package com.design.lld.git;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;

public class HashUtils {
    /**
     * Generates a SHA-1 hash for the given content.
     *
     * @param content The content to hash.
     * @return The SHA-1 hash as a string.
     */
    public static String generateHash(String content) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] digest = md.digest(content.getBytes());
            try (Formatter formatter = new Formatter()) {
                for (byte b : digest) {
                    formatter.format("%02x", b);
                }
                return formatter.toString();
            }
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-1 algorithm not found.");
        }
    }
}
