package tech.toshitworks.banking_app.service;

import tech.toshitworks.banking_app.dto.AccountDto;

public interface AccountService {

    AccountDto createAccount(AccountDto accountDto);

    AccountDto getAccount(Long id);

    AccountDto depositAmount(Long id,double amount);

    AccountDto withdrawAmount(Long id,double amount);

}
