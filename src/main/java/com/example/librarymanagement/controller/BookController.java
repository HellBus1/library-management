package com.example.librarymanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.librarymanagement.services.BookService;
import com.example.librarymanagement.dto.BookResponseDTO;
import com.example.librarymanagement.dto.BookRequestDTO;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.example.librarymanagement.model.Book;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@CrossOrigin
@RequiredArgsConstructor
public class BookController {
  private final BookService bookService;

  @PostMapping("/books")
  public ResponseEntity<BookResponseDTO> add(@Valid @RequestBody BookRequestDTO bookRequestDTO) {
    Book newBook = bookRequestDTO.convertToEntity();

    Book savedBook = this.bookService.create(newBook);

    return ResponseEntity.status(HttpStatus.CREATED).body(savedBook.convertToDTO());
  }
}
