package com.example.exception;

public interface ExceptionService {

    boolean checkAuthorization(String login, String password, String confirmPassword);
}
