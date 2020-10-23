package com.example.codemarktask.model;

import java.util.List;

public class SaveUserResponse {
    private boolean success;
    private List<String> errors;

    public SaveUserResponse(){

    }
    public SaveUserResponse(boolean success){
        this.success = success;
    }
    public SaveUserResponse(boolean success, List<String> errors){
        this.success = success;
        this.errors = errors;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }





    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
