package com.example.librarymanagement.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
public class BookServiceTests {
  @Autowired
  BookService bookService;

  @Test
  public void shouldReturnListOfBooks() {
    List expectedResult = new ArrayList();

    List actualResult = bookService.fetchAll();

    assertEquals(actualResult, expectedResult);
  };
}
