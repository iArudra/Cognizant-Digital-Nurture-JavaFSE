package com.library.repository;

public class BookRepository {
    public void printRepositoryInfo() {
        System.out.println("BookRepository: Interacting with database to manage book files.");
    }
    
    public String getBookData() {
        return "Book: Spring Dependency Injection Guide";
    }
}
