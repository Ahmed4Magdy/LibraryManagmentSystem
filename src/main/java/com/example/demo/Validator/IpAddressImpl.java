package com.example.demo.Validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.hibernate.validator.cfg.context.Constrainable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IpAddressImpl implements ConstraintValidator<IpAddress,String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {

//        if (s == null || s.isEmpty()) {
//            return false; // Null or empty strings are not valid IPs.
//        }

        Pattern pattern = Pattern.compile("^([0-9]{1,3})\\.([0-9]{1,3})\\.([0-9]{1,3})\\.([0-9]{1,3})$");
        Matcher matcher =pattern.matcher(s);

        try{
            if(!matcher.matches()){
                return false;
            }
            else{
                for(int i=1;i<=4;i++){
                    int octet=Integer.valueOf(matcher.group(i));
                    if(octet<0||octet>255){
                        return false;
                    }

                }
                return true;
            }
        }catch (Exception e){
            return false;
        }
    }
}
