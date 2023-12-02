package com.example.apiexamproject.service;

import com.example.apiexamproject.dto.responses.SaveBookRepsonse;
import com.example.apiexamproject.dto.requests.SaveBookRequest;
import com.example.apiexamproject.entity.Book;

import java.util.List;

public interface BookService {
    SaveBookRepsonse saveBook(SaveBookRequest saveBookRequest);

    SaveBookRepsonse updateBook(int bookId, SaveBookRequest saveBookRequest);

    List<Book> ListBooks();

    String DeleteBook(int bookId);
}
