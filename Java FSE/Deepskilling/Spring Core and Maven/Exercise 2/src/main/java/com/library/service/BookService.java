package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    // Setter method for Dependency Injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void printServiceInfo() {
        System.out.println("BookService: Delegating requests to BookRepository.");
        if (bookRepository != null) {
            bookRepository.printRepositoryInfo();
            System.out.println("Book data retrieved via Service: " + bookRepository.getBookData());
        } else {
            System.out.println("Error: BookRepository dependency has NOT been injected!");
        }
    }
}
