package com.example.apiexamproject.service.bussiness;

import com.example.apiexamproject.dto.responses.SaveBookRepsonse;
import com.example.apiexamproject.dto.requests.SaveBookRequest;
import com.example.apiexamproject.entity.Book;
import com.example.apiexamproject.entity.Writer;
import com.example.apiexamproject.repository.BookRepository;
import com.example.apiexamproject.repository.WriterRepository;
import com.example.apiexamproject.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final WriterRepository writerRepository;


    @Override
    public SaveBookRepsonse saveBook(SaveBookRequest saveBookRequest) {

        Writer writer = findWriter(saveBookRequest.getWriterName());
        Optional<Book> bookObject=bookRepository.findByName(saveBookRequest.getName());
        Book book=new Book();

        if (bookObject.isEmpty()){
            book.setName(saveBookRequest.getName());
            book.setPage(saveBookRequest.getPage());
            book.setAbout(saveBookRequest.getAbout());
            book.setWriter(writer);

            bookRepository.save(book);
        }

        return new SaveBookRepsonse("Başarıyla Kaydedildi", book);
    }
    public Writer findWriter(String name){

        if (writerRepository.findByWriterName(name).isEmpty()){
            Writer writer= new Writer();
            writer.setWriterName(name);
            writerRepository.save(writer);
        }

      return writerRepository.findByWriterName(name).orElseThrow();

    }
    @Override
    public SaveBookRepsonse updateBook(int bookId, SaveBookRequest saveBookRequest) {
        Writer writer=findWriter(saveBookRequest.getWriterName());
       Book book=new Book(
               bookId,
               saveBookRequest.getName(),
               saveBookRequest.getPage(),
               saveBookRequest.getAbout(),
               writer
       );
       bookRepository.save(book);
       return new SaveBookRepsonse("Başarıyla güncellendi.",book);

    }

    @Override
    public List<Book> ListBooks() {
        return bookRepository.findAll();

    }

    @Override
    public String DeleteBook(int bookId) {

    bookRepository.deleteById(bookId);
    return "Başarıyla silindi.";

    }
}
