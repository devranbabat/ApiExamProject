package com.example.apiexamproject.repository;

import com.example.apiexamproject.entity.Writer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WriterRepository extends JpaRepository<Writer, Integer> {
   Optional<Writer> findByWriterName(String name);
}
