package com.example.infinityapp.validation;

public class janithValidation {

    public boolean isValidphoneNo(String phone ){
        String regex = "[0-9]{10}";
        return phone.matches(regex);
    }

    public boolean isValidName(String username){
        String regex = "[a-zA-Z]+";
        return username.matches(regex);
    }

    public boolean isValidStaff(String username){
        String regex = "[a-zA-Z]+";
        return username.matches(regex);
    }
}
