package com.example.exception;

import com.example.exceptions.WrongLoginException;
import com.example.exceptions.WrongPasswordException;
import org.springframework.stereotype.Service;

import java.util.regex.*;

@Service
public class ExceptionServiceImpl implements ExceptionService {

    public boolean checkAuthorization(String login, String password, String confirmPassword) {
        boolean a = true;
        if (login.length() > 20 || !checkCharsAtLogin(login)) {
            throw new WrongLoginException();
        } else if (password.length() >= 20 || !checkCharsAtPassword(password)) {
            throw new WrongPasswordException();
        } else if (!(confirmPassword.equals(password))) {
            throw new WrongPasswordException();
        } else {
            return a;
        }

    }

    @Override
    public boolean checkCharsAtLogin(String login) {
            char[] allowedCharacters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
                    'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B',
                    'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
                    'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7',
                    '8', '9', '_'};
            char[] logArr = login.toCharArray();
            int counter = 0;
            for (int i = 0; i < logArr.length; i++) {
                for (int j = 0; j < allowedCharacters.length; j++) {
                    if (logArr[i] == allowedCharacters[j]) {
                        counter++;
                    }
                }
            }
            if (counter != logArr.length) {
                return false;
            }
            return true;
        }


    @Override
    public boolean checkCharsAtPassword(String password) {
        char[] allowedCharacters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
                'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B',
                'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
                'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7',
                '8', '9', '_'};
        char[] passArr = password.toCharArray();
        int counter = 0;
        for (int i = 0; i < passArr.length; i++) {
            for (int j = 0; j < allowedCharacters.length; j++) {
                if (passArr[i] == allowedCharacters[j]) {
                    counter++;
                }
            }
        }
        if (counter != passArr.length) {
            return false;
        }
        return true;

    }

}

