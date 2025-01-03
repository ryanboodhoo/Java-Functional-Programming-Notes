package CombinatorPattern;

import java.util.function.Function;

import java.time.LocalDate;
import java.time.Period;

import static CombinatorPattern.CustomerRegistrationValidator.ValidationResult.IS_NOT_AN_ADULT;
import static CombinatorPattern.CustomerRegistrationValidator.ValidationResult.SUCCESS;

public interface CustomerRegistrationValidator
        extends Function<Customer, CustomerRegistrationValidator.ValidationResult> {

    static CustomerRegistrationValidator isEmailValid() {
        return customer -> {
            System.out.println("running email validation");
            return customer.getEmail().contains("@") ?
                    SUCCESS : ValidationResult.EMAIL_NOT_VALID;
        };
    }

    static CustomerRegistrationValidator isPhoneNumberValid() {
        return customer -> customer.getPhoneNumber().startsWith("+0") ?
                SUCCESS : ValidationResult.PHONE_NUMBER_NOT_VALID;
    }

    static CustomerRegistrationValidator isAnAdult() {
        return customer ->
                Period.between(customer.getDob(), LocalDate.now()).getYears() > 16 ?
                        SUCCESS : IS_NOT_AN_ADULT;
    }

    default CustomerRegistrationValidator and (CustomerRegistrationValidator other) {
        return customer -> {
            ValidationResult result = this.apply(customer);
            return result.equals(SUCCESS) ? other.apply(customer) : result;
        };
    }

    enum ValidationResult {
        SUCCESS,
        PHONE_NUMBER_NOT_VALID,
        EMAIL_NOT_VALID,
        IS_NOT_AN_ADULT
    }
}
