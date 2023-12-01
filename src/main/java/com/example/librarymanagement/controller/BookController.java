package com.example.librarymanagement.controller;

import com.example.librarymanagement.dto.BookRequestDTO;
import com.example.librarymanagement.dto.BookResponseDTO;
import com.example.librarymanagement.model.Book;
import com.example.librarymanagement.services.BookService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class BookController {
  private final BookService bookService;

  @PostMapping(value = "/books", consumes = { "application/json;charset=utf-8" }, produces = { "application/json;charset=utf-8" })
  public ResponseEntity<BookResponseDTO> add(@Valid @RequestBody BookRequestDTO bookRequestDTO) {
    Book newBook = bookRequestDTO.convertToEntity();

    Book savedBook = this.bookService.create(newBook);

    return ResponseEntity.status(HttpStatus.CREATED).body(savedBook.convertToDTO());
  }
}
