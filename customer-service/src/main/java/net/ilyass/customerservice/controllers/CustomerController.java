package net.ilyass.customerservice.controllers;

import lombok.AllArgsConstructor;
import net.ilyass.customerservice.entities.Customer;
import net.ilyass.customerservice.repositories.CustomerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class CustomerController {
    private final CustomerRepository customerRepository;

    @GetMapping("/customers")
    public List<Customer> customerList() {
        return customerRepository.findAll();
    }

    @GetMapping("/customers/{id}")
    public Customer customerByID(@PathVariable Long id) {
        return customerRepository.findById(id).orElse(null);
    }
}
