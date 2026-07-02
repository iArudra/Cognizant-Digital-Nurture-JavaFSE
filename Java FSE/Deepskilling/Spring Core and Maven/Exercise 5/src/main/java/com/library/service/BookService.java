package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void printServiceInfo() {
        System.out.println("BookService: Accessing business logic from Spring IoC Container.");
        if (bookRepository != null) {
            bookRepository.printRepositoryInfo();
            System.out.println("Book data retrieved via Service: " + bookRepository.getBookData());
        } else {
            System.out.println("Error: BookRepository dependency has NOT been injected!");
        }
    }
}
