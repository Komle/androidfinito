package com.example.bandom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    private static final String CREDENTIALS_PATTERN = "^[a-zA-Z]{3,20}$";

    public static boolean isCredentialsValid(String credentials){
        Pattern pattern= Pattern.compile(CREDENTIALS_PATTERN);
        Matcher matcher= pattern.matcher(credentials);
        return matcher.matches();
    }

    private static final String CREDENTIALS_PATTERN2 = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

    public static boolean isEmailValid(String emails){
        Pattern pattern= Pattern.compile(CREDENTIALS_PATTERN2);
        Matcher matcher = pattern.matcher(emails);
        return matcher.matches();
    }
    private static final String CREDENTIALS_PATTERN3 = "[a-zA-Z]{5,20}$";

    public static boolean isPasswordValid(String passwords){
        Pattern pattern= Pattern.compile(CREDENTIALS_PATTERN3);
        Matcher matcher = pattern.matcher(passwords);
        return matcher.matches();
    }
}
