package com.example.apiexamproject.controller;

import com.example.apiexamproject.dto.responses.SaveBookRepsonse;
import com.example.apiexamproject.dto.requests.SaveBookRequest;
import com.example.apiexamproject.entity.Book;
import com.example.apiexamproject.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    @PostMapping
    public ResponseEntity<SaveBookRepsonse> SaveBook(@RequestBody SaveBookRequest saveBookRequest){
        return ResponseEntity.ok( bookService.saveBook(saveBookRequest));
    }

    @PutMapping
    public ResponseEntity<SaveBookRepsonse> UpdateBook(@RequestParam int BookId, @RequestBody SaveBookRequest saveBookRequest){
        return ResponseEntity.ok(bookService.updateBook(BookId,saveBookRequest));
    }

    @GetMapping
    public ResponseEntity<List<Book>> ListBooks(){
        return ResponseEntity.ok(bookService.ListBooks());
    }

    @DeleteMapping
    public ResponseEntity<String> DeleteBook(@RequestParam int BookId){
        return ResponseEntity.ok(bookService.DeleteBook(BookId));
    }
}
