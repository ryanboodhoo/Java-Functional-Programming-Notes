package CombinatorPattern;

import java.time.LocalDate;
import java.time.Period;

public class CustomerValidatorService {

    private boolean isEmailValid(String email){
        return email.contains("@");
    }

    private boolean isPhoneNumber(String phoneNumber){
        return phoneNumber.startsWith("+1");
    }

    private boolean isAdult ( LocalDate dob ) {
        return Period.between( dob, LocalDate.now()).getYears() > 18;
    }


    public boolean isValid(Customer customer){
        return isEmailValid(customer.getEmail()) &&
                isPhoneNumber(customer.getPhoneNumber()) &&
                isAdult(customer.getDob());
    }
}

