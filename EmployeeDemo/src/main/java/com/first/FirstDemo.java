package com.first;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class FirstDemo {

    public static void main(String[] args) {
        SpringApplication.run(FirstDemo.class);
    }

    @Bean
    public CommandLineRunner run(EmployeeRepository repository) {
        return (args) -> {
            insertFourEmployees(repository);
            System.out.println(repository.findAll());

            System.out.println(repository.findEmployeesByLastNameContaining(" "));
        };
    }

    private void insertFourEmployees(EmployeeRepository repository) {
        repository.save(new Employee("Dalia", "Abo Sheasha"));
        repository.save(new Employee("Trisha", "Gee"));
        repository.save(new Employee("Helen", "Scott"));
        repository.save(new Employee("Mala", "Gupta"));
    }
}
