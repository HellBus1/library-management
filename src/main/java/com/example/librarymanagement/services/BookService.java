package com.example.librarymanagement.services;

import com.example.librarymanagement.model.Book;
import com.example.librarymanagement.repository.BookRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookService {
  private final BookRepository bookRepository;

  public Book create(Book book) {
    return this.bookRepository.save(book);
  }
}
