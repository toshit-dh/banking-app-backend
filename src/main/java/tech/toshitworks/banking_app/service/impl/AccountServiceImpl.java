package tech.toshitworks.banking_app.service.impl;

import org.springframework.stereotype.Service;
import tech.toshitworks.banking_app.dto.AccountDto;
import tech.toshitworks.banking_app.entity.Account;
import tech.toshitworks.banking_app.mapper.AccountMapper;
import tech.toshitworks.banking_app.repository.AccountRepository;
import tech.toshitworks.banking_app.service.AccountService;
import tech.toshitworks.banking_app.utils.exceptions.AccountNotFound;
import tech.toshitworks.banking_app.utils.exceptions.InsufficientBalance;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.toAccount(accountDto);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.toAccuntDto(savedAccount);
    }

    @Override
    public AccountDto getAccount(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new AccountNotFound("Account Not Found"));
        return AccountMapper.toAccuntDto(account);
    }

    @Override
    public AccountDto depositAmount(Long id, double amount) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new AccountNotFound("Account Not Found"));
        double total = account.getBalance() + amount;
        account.setBalance(total);
        return AccountMapper.toAccuntDto(account);
    }

    @Override
    public AccountDto withdrawAmount(Long id, double amount) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new AccountNotFound("Account Not Found"));
        double total = account.getBalance() - amount;
        if (total < 0){
            throw new InsufficientBalance("Not Enough Balance");
        }
        account.setBalance(total);
        return AccountMapper.toAccuntDto(account);
    }
}
