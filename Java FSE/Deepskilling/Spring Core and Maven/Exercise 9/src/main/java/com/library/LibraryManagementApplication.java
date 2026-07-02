package com.library;

import com.library.model.Book;
import com.library.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LibraryManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryManagementApplication.class, args);
    }

    @Bean
    public CommandLineRunner initData(BookRepository repository) {
        return args -> {
            System.out.println("Initializing H2 Database with seed book records...");
            repository.save(new Book("Effective Java", "Joshua Bloch", "978-0134685991", 45.00));
            repository.save(new Book("Clean Code", "Robert C. Martin", "978-0132350884", 40.50));
            repository.save(new Book("Spring in Action", "Craig Walls", "978-1617294945", 50.00));
            System.out.println("H2 Database initialized successfully!");
        };
    }
}
