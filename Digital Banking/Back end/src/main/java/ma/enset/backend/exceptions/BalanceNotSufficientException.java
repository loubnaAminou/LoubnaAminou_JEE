package ma.enset.backend.exceptions;

public class BalanceNotSufficientException extends Exception {
    public BalanceNotSufficientException(String msg) {
        super(msg);
    }
}
