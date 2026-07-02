package com.library.repository;

public class BookRepository {
    public void printRepositoryInfo() {
        System.out.println("BookRepository: Checking repository connections.");
    }
    
    public String getBookData() {
        return "Book: Spring AOP in Action";
    }
}
