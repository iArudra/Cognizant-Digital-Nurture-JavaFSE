package com.library.service;

import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private BookRepository bookRepository;

    // Autowired setter injection
    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void printServiceInfo() {
        System.out.println("BookService: Annotations simplification enabled (@Service).");
        if (bookRepository != null) {
            bookRepository.printRepositoryInfo();
            System.out.println("Book data retrieved via Service: " + bookRepository.getBookData());
        } else {
            System.out.println("Error: BookRepository has NOT been autowired!");
        }
    }
}
