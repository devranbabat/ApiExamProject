package com.example.apiexamproject.dto.responses;

import com.example.apiexamproject.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveBookRepsonse {

    private String information;
    private Book book;
}
