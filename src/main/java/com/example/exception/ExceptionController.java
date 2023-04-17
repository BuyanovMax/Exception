package com.example.exception;

import com.example.exceptions.WrongLoginException;
import com.example.exceptions.WrongPasswordException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionController {
    private static ExceptionService exceptionService;

    public ExceptionController(ExceptionService exceptionService) {
        this.exceptionService = exceptionService;
    }

    @GetMapping(path = "/check")
    public static boolean checkAuthorization(@RequestParam String login, @RequestParam String password,@RequestParam String confirmPassword) {
        try {
            return exceptionService.checkAuthorization(login, password, confirmPassword);
        } catch (WrongLoginException e) {
            return false;
        } catch (WrongPasswordException e) {
            return false;
        }

    }

}
