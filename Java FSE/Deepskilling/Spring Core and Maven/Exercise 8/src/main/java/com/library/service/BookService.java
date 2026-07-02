package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void printServiceInfo() {
        System.out.println("BookService: Service info printed.");
    }

    public void fetchBookDetails() {
        System.out.println("BookService: Fetching book details...");
        if (bookRepository != null) {
            System.out.println("Book data: " + bookRepository.getBookData());
        }
    }
}
