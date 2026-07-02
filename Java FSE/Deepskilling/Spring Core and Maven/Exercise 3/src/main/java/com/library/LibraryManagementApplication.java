package com.library;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.library.service.BookService;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        // Load the Spring XML Configuration Context with AOP enabled
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Retrieve the BookService bean (which is proxy-enabled under Spring AOP)
        BookService bookService = (BookService) context.getBean("bookService");

        // Execute methods to verify logging aspect prints their execution time
        bookService.printServiceInfo();
        bookService.fetchBookDetails();

        System.out.println("Exercise 3: Spring AOP Logging Aspect executed successfully!");
    }
}
