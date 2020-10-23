package com.example.codemarktask.model;

import java.util.ArrayList;
import java.util.List;

public class CheckerUser {
    public static SaveUserResponse checkCriteria(User user){
        boolean numberPassword = false;
        boolean success = true;
        List<String> errors = new ArrayList<>();
        SaveUserResponse saveUserResponse;
        if (user.getLogin().equals("")){
            success = false;
            errors.add("Пустой логин");
        }
        if (user.getName().equals("")){
            success = false;
            errors.add("Пустое имя");
        }
        if (user.getPassword().equals("")){
            success = false;
            errors.add("Пустой пароль");
        }
        for (char c: user.getPassword().toCharArray()){
            int i = 0;
            if (Character.isDigit(c)){
                numberPassword = true;
            }

        }

        if (user.getPassword().equals(user.getPassword().toLowerCase()) || !numberPassword){
            System.out.println(user.getPassword().toLowerCase());
            System.out.println(!user.getPassword().equals(user.getPassword().toLowerCase()));
            System.out.println(numberPassword);
            errors.add("Пароль не удовлетворяет требованиям");
            success = false;

        }

        if (errors.size()> 0){
            saveUserResponse = new SaveUserResponse(success,errors);
        }
        else {
            saveUserResponse = new SaveUserResponse(success);
        }

        return saveUserResponse;
    }
}
