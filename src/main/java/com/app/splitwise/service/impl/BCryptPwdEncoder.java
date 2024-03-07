package com.app.splitwise.service.impl;

import com.app.splitwise.service.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class BCryptPwdEncoder implements PasswordEncoder {
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public String encode(String plainTextPassword) {
        return passwordEncoder.encode(plainTextPassword);
    }

    @Override
    public boolean matches(String plainTextPassword, String encodedPassword) {
        return passwordEncoder.matches(plainTextPassword, encodedPassword);
    }
}
