package com.example.librarymanagement.services;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.librarymanagement.model.Book;
import com.example.librarymanagement.repository.BookRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookService {
  private final BookRepository bookRepository;

  public Book create(Book book) {
    return this.bookRepository.save(book);
  }
}
