package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;
    private String injectionType;

    // No-arg constructor (required for setter injection)
    public BookService() {
        this.injectionType = "Setter Injection (No-arg constructor invoked)";
    }

    // Constructor for Constructor Injection
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        this.injectionType = "Constructor Injection";
    }

    // Setter for Setter Injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void setInjectionType(String injectionType) {
        this.injectionType = injectionType;
    }

    public void printServiceInfo() {
        System.out.println("BookService instance info:");
        System.out.println("  Injection Method: " + injectionType);
        if (bookRepository != null) {
            bookRepository.printRepositoryInfo();
            System.out.println("  Book data retrieved: " + bookRepository.getBookData());
        } else {
            System.out.println("  Error: BookRepository dependency is null!");
        }
    }
}
