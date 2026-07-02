package com.library.repository;

public class BookRepository {
    public void printRepositoryInfo() {
        System.out.println("BookRepository: Accessing database to load libraries (Ex 8).");
    }
    
    public String getBookData() {
        return "Book: Spring AOP Before & After Advice Guide";
    }
}
