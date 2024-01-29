package net.ilyass.customerservice;


import net.ilyass.customerservice.entities.Customer;
import net.ilyass.customerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
        return args -> {

            List<Customer> customerList = List.of(
                    Customer.builder()
                            .firstname("ilyass")
                            .lastname("ln")
                            .email("ilyass@gmail.com")
                            .build(),
                    Customer.builder()
                            .firstname("ilyass2")
                            .lastname("ln2")
                            .email("ilyass2@gmail.com").build()
            );

            customerRepository.saveAll(customerList);
        };
    }

}
