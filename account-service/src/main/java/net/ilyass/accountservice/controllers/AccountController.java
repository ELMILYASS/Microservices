package net.ilyass.accountservice.controllers;

import lombok.AllArgsConstructor;
import net.ilyass.accountservice.clients.CustomerRestClient;
import net.ilyass.accountservice.entities.BankAccount;
import net.ilyass.accountservice.models.Customer;
import net.ilyass.accountservice.repositories.BankAccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor

@RestController

public class AccountController {
    private final BankAccountRepository bankAccountRepository;

    private final CustomerRestClient customerRestClient;

    @GetMapping("/accounts")
    public List<BankAccount> accountList() {
        List<BankAccount> bankAccounts = bankAccountRepository.findAll();

        bankAccounts.forEach(bankAccount -> bankAccount.setCustomer(customerRestClient.findCustomerById(bankAccount.getIdCustomer())));
        return bankAccounts;
    }

    @GetMapping("/accounts/{id}")
    public BankAccount bankAccountFindById(@PathVariable String id) {
        BankAccount bankaccount = bankAccountRepository.findById(id).get();
        Customer customer = customerRestClient.findCustomerById(bankaccount.getIdCustomer());
        bankaccount.setCustomer(customer);
        return bankaccount;
    }


}
