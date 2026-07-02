package com.library;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.library.service.BookService;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        // Load the Spring Context
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Retrieve the proxy-wrapped BookService bean
        BookService bookService = (BookService) context.getBean("bookService");

        // Execute methods to verify before and after advices
        bookService.printServiceInfo();
        System.out.println();
        bookService.fetchBookDetails();

        System.out.println("\nExercise 8: Spring AOP Before and After advices executed successfully!");
    }
}
