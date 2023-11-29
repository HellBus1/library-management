package com.example.librarymanagement.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.librarymanagement.model.Book;
import com.example.librarymanagement.dto.BookRequestDTO;

@SpringBootTest(classes = BookRequestDTO.class)
class BookRequestDTOTest {
  @Test
  void convertToEntity_shouldReturnBookEntity_whenGivenBookRequestDTO() {
      BookRequestDTO bookRequest = BookRequestDTO.builder().build();
      Book expectedResult = Book.builder().build();

      Book actualResult = bookRequest.convertToEntity();

      assertEquals(actualResult, expectedResult);
  }
}
