package com.example.exception;

import com.example.exceptions.WrongLoginException;
import com.example.exceptions.WrongPasswordException;
import org.springframework.stereotype.Service;

@Service
public class ExceptionServiceImpl implements ExceptionService {

    public boolean checkAuthorization(String login,String password,String confirmPassword) {
        boolean a = true;
        if (login.length() > 20) {
            throw new WrongLoginException();
        }else if (password.length()>=20) {
            throw new WrongPasswordException();
        }else if (confirmPassword.length() != password.length()) {
            throw new WrongPasswordException();
        } else {
            return a;
        }

    }

}

