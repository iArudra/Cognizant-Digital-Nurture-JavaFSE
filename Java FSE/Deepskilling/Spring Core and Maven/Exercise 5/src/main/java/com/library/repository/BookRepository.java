package com.library.repository;

public class BookRepository {
    public void printRepositoryInfo() {
        System.out.println("BookRepository: Accessing database to load libraries.");
    }
    
    public String getBookData() {
        return "Book: Spring IoC Container Deep Dive";
    }
}
