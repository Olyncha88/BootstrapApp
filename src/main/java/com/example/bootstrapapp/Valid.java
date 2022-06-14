package com.example.bootstrapapp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Valid {
    private String email;
    private String number;

    private boolean isCorrectEmail = false;
    private boolean isCorrectNumber = false;

    public Valid(){

    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public String getNumber() {
        return number;
    }

    public void validMain(){

        email = email.trim();
        number = number.trim();

        if(email !=null && number !=null){
            if(checkEmail()){
                isCorrectEmail = true;
            }
            if(checkNumber() && (number.length() == 13)){
                isCorrectNumber = true;
            }
        }
    }

    private boolean checkEmail(){

        Pattern pattern = Pattern.compile("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$");
        Matcher matcher = pattern.matcher(email);
        return matcher.find();
    }
    private boolean checkNumber(){

        Pattern pattern = Pattern.compile("^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$");
        Matcher matcher = pattern.matcher(number);
        return matcher.find();
    }
    public void resetData(){
        isCorrectEmail = false;
        isCorrectNumber = false;
    }

    public boolean isCorrectEmail() {
        return isCorrectEmail;
    }

    public boolean isCorrectNumber() {
        return isCorrectNumber;
    }
}
