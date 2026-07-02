package com.library.repository;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
    public void printRepositoryInfo() {
        System.out.println("BookRepository: Component scanning detected this repository bean.");
    }
    
    public String getBookData() {
        return "Book: Annotation-Configured Spring Guide";
    }
}
