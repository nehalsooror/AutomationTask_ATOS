package Modules;

import java.util.regex.Pattern;

public class InputDataValidation {


    public boolean validateFirstName(String first){
        return Pattern.matches("^[A-Z].*$", first);
    }
    public boolean validateLastName(String first,String last){
        return Pattern.matches("^[A-Z].*$", last) && (first != last);

    }
    public boolean validateEmail(String email){
        return Pattern.matches("^(.+)@(.+)$", email);
    }
    public boolean validatePassword(String pass){
        return Pattern.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).*$", pass);
    }

}
