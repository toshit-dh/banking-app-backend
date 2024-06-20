package tech.toshitworks.banking_app.utils.exceptions;

public class AccountNotFound extends RuntimeException{
    public AccountNotFound(String message){
        super(message);
    }
}
