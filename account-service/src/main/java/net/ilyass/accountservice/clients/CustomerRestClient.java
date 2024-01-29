package net.ilyass.accountservice.clients;


import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import net.ilyass.accountservice.models.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClient {
    @GetMapping("/customers/{id}")
    @CircuitBreaker(name = "customerservice", fallbackMethod = "getDefaultCustomer")
    Customer findCustomerById(@PathVariable Long id);

    @CircuitBreaker(name = "customerservice", fallbackMethod = "getDefaultCustomer")
    @GetMapping("/customers")
    List<Customer> allCustomers();

    default Customer getDefaultCustomer(Long id, Exception exception) {
        Customer customer = new Customer();
        customer.setId(id);
        customer.setEmail("not valid");
        customer.setFirstname("not valid");
        customer.setLastname("not valid");

        return customer;
    }
}


