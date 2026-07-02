package com.library;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.library.service.BookService;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        // Load the XML Context
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        System.out.println("--- Verifying Constructor Injection ---");
        BookService serviceConstructor = (BookService) context.getBean("bookServiceConstructor");
        serviceConstructor.printServiceInfo();

        System.out.println("\n--- Verifying Setter Injection ---");
        BookService serviceSetter = (BookService) context.getBean("bookServiceSetter");
        serviceSetter.printServiceInfo();

        System.out.println("\nExercise 7: Constructor and Setter Injection verified successfully!");
    }
}
