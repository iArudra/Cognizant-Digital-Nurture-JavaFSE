package com.library;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.library.service.BookService;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        // Load the context which uses component scanning
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Retrieve service bean by type or name
        BookService bookService = context.getBean(BookService.class);
        bookService.printServiceInfo();

        System.out.println("Exercise 6: Annotation-based configuration verified successfully!");
    }
}
