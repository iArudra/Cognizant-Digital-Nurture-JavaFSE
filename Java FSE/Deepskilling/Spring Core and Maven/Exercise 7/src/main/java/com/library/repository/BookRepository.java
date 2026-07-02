package com.library.repository;

public class BookRepository {
    public void printRepositoryInfo() {
        System.out.println("BookRepository: Accessing database to load libraries (Ex 7).");
    }
    
    public String getBookData() {
        return "Book: Constructor & Setter Injection Combined Guide";
    }
}
