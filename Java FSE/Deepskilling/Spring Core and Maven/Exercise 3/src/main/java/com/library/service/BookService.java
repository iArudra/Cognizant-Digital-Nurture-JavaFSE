package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void printServiceInfo() {
        System.out.println("BookService: In printServiceInfo method...");
        try {
            Thread.sleep(50); // Simulate execution time
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void fetchBookDetails() {
        System.out.println("BookService: In fetchBookDetails method...");
        if (bookRepository != null) {
            System.out.println("Retrieved via service: " + bookRepository.getBookData());
        }
        try {
            Thread.sleep(120); // Simulate execution time
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
