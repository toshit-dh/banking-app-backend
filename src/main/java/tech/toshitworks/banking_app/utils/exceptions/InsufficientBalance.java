package tech.toshitworks.banking_app.utils.exceptions;

public class InsufficientBalance extends RuntimeException {
    public InsufficientBalance(String message){
        super(message);
    }
}
