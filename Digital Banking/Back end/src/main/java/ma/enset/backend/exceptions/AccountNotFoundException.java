package ma.enset.backend.exceptions;

import java.util.function.Supplier;

public class AccountNotFoundException extends Exception {

    public AccountNotFoundException(String msg){
        super(msg);
    }
}
