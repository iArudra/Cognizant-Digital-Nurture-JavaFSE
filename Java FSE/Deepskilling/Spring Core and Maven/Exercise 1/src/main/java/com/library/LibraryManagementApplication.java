package com.library;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.library.service.BookService;
import com.library.repository.BookRepository;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        // Load the Spring XML Configuration Context
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Retrieve the BookService bean
        BookService bookService = (BookService) context.getBean("bookService");
        bookService.printServiceInfo();

        // Retrieve the BookRepository bean
        BookRepository bookRepository = (BookRepository) context.getBean("bookRepository");
        bookRepository.printRepositoryInfo();
        System.out.println("Retrieved book data: " + bookRepository.getBookData());
        
        System.out.println("Exercise 1: Basic Spring Application configured successfully!");
    }
}
