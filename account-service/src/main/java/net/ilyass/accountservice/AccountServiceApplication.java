package net.ilyass.accountservice;

import net.ilyass.accountservice.config.ConfigParams;
import net.ilyass.accountservice.entities.BankAccount;
import net.ilyass.accountservice.enums.AccountType;
import net.ilyass.accountservice.repositories.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootApplication
@EnableConfigurationProperties(ConfigParams.class)
@EnableFeignClients
public class AccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(BankAccountRepository accountRepository){
		return args ->{
			BankAccount bankAccount=BankAccount.builder()
					.accountId(UUID.randomUUID().toString())
					.balance(9000)
					.currency("MAD")
					.createdAt(LocalDate.now())
					.idCustomer(Long.valueOf(2))
					.type(AccountType.SAVING_ACCOUNT)
					.build();
			BankAccount bankAccount1=BankAccount.builder()
					.accountId(UUID.randomUUID().toString())
					.currency("MAD")
					.balance(8000)
					.createdAt(LocalDate.now())
					.idCustomer(Long.valueOf(1))
					.type(AccountType.SAVING_ACCOUNT)
					.build();
			accountRepository.save(bankAccount);
			accountRepository.save(bankAccount1);
		};
	}
}
