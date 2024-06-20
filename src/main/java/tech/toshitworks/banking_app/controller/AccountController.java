package tech.toshitworks.banking_app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.toshitworks.banking_app.dto.AccountDto;
import tech.toshitworks.banking_app.service.AccountService;
import tech.toshitworks.banking_app.utils.exceptions.InsufficientBalance;

import java.util.Map;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto accountDto){
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccount(@PathVariable Long id){
        return new ResponseEntity<>(accountService.getAccount(id),HttpStatus.OK);
    }

    @PutMapping("/deposit/{id}")
    public ResponseEntity<AccountDto> depositAmount(@PathVariable Long id,@RequestBody Map<String,Double> request){
        return new ResponseEntity<>(accountService.depositAmount(id,request.get("amount")),HttpStatus.OK);
    }

    @PutMapping("/withdraw/{id}")
    public ResponseEntity<Object> withdrawAmount(@PathVariable Long id,@RequestBody Map<String,Double> request){
        try {
            return new ResponseEntity<>(accountService.withdrawAmount(id,request.get("amount")),HttpStatus.OK);
        }catch (InsufficientBalance e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

}
