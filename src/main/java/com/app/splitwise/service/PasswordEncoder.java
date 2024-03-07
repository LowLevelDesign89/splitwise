package com.app.splitwise.service;

public interface PasswordEncoder {
    String encode(String plainTextPassword);

    boolean matches(String plainTextPassword, String encodedPassword);
}
