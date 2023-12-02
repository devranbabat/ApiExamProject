package com.example.apiexamproject.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveBookRequest {

    private String name;

    private int page;

    private String about;

    private String writerName;
}
