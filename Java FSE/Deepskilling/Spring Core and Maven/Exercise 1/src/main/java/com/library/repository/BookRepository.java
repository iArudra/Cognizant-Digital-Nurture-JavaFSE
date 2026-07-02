package com.library.repository;

public class BookRepository {
    public void printRepositoryInfo() {
        System.out.println("BookRepository: Accessing database layer and performing CRUD operations.");
    }
    
    public String getBookData() {
        return "Book: Spring Core & Maven Handbook";
    }
}
