package com.example.librarymanagement.controller;

import com.example.librarymanagement.dto.BookRequestDTO;
import com.example.librarymanagement.repository.BookRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.http.MediaType;
import com.example.librarymanagement.dto.BookResponseDTO;
import com.example.librarymanagement.services.BookService;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.mockito.Mockito;
import com.example.librarymanagement.model.Book;

@SpringBootTest(classes = { BookController.class, BookService.class, ObjectMapper.class })
@AutoConfigureMockMvc
@EnableWebMvc
class BookControllerTest {
  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @MockBean
  private BookRepository bookRepository;

  @Autowired
  private BookService bookService;

  @Test
  void add_shouldAddBookTitledNarutoAndQuantityThirty() {
    try {
      BookRequestDTO bookRequest = BookRequestDTO.builder().title("Naruto").quantity(30).build();
      Book mockData = Book.builder().title("Naruto").quantity(30).build();
      Book expectedResult = Book.builder().id(1).title("Naruto").quantity(30).build();
      String newBookRequest = this.objectMapper.writeValueAsString(bookRequest);
      RequestBuilder builder = MockMvcRequestBuilders.post("/books")
                      .contentType(MediaType.APPLICATION_JSON)
                      .content(newBookRequest)
                      .characterEncoding("utf-8");
      Mockito.when(this.bookRepository.save(mockData)).thenReturn(expectedResult);

      MvcResult result = this.mockMvc.perform(builder).andExpect(MockMvcResultMatchers.status().isCreated())
                      .andReturn();
      String responseString = result.getResponse().getContentAsString();
      BookResponseDTO actualResult = this.objectMapper.readValue(responseString, BookResponseDTO.class);

      Assertions.assertEquals(actualResult, expectedResult.convertToDTO());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
