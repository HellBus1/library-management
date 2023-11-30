package com.example.librarymanagement.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.librarymanagement.services.BookService;
import com.example.librarymanagement.dto.BookResponseDTO;
import com.example.librarymanagement.dto.BookRequestDTO;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.librarymanagement.model.Book;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class BookController {
  private final BookService bookService;

  @PostMapping(value = "/books")
  public ResponseEntity<BookResponseDTO> add(@Valid @RequestBody BookRequestDTO bookRequestDTO) {
    Book newBook = bookRequestDTO.convertToEntity();

    Book savedBook = this.bookService.create(newBook);

    return ResponseEntity.status(HttpStatus.CREATED).body(savedBook.convertToDTO());
  }
}
