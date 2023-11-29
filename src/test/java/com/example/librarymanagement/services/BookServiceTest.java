package com.example.librarymanagement.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.librarymanagement.model.Book;
import com.example.librarymanagement.repository.BookRepository;

@SpringBootTest(classes = BookService.class)
class BookServiceTest {
  @MockBean
  private BookRepository bookRepository;

  @Autowired
  BookService bookService;

  @Test
  void create_shouldAddNewBookTitledNarutoWithQuantityThirty() {
    Book mockData = Book.builder().title("Naruto").quantity(30).build();
    Book expectedResult = Book.builder().id(1).title("Naruto").quantity(30).build();
    Mockito.when(this.bookRepository.save(mockData)).thenReturn(expectedResult);

    Book actualResult = bookService.create(mockData);

    Mockito.verify(bookRepository, Mockito.times(1)).save(mockData);
    assertEquals(actualResult, expectedResult);
  };
}
