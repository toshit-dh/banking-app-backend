package tech.toshitworks.banking_app.mapper;

import tech.toshitworks.banking_app.dto.AccountDto;
import tech.toshitworks.banking_app.entity.Account;

public class AccountMapper {

    public static Account toAccount(AccountDto accountDto){
        return new Account(accountDto.getId(),accountDto.getName(),accountDto.getBalance());
    }

    public static AccountDto toAccuntDto(Account account){
        return new AccountDto(account.getId(),account.getName(),account.getBalance());
    }

}
