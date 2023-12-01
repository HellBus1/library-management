package com.example.librarymanagement.dto;

import com.example.librarymanagement.model.Book;

import org.modelmapper.ModelMapper;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class BookRequestDTO {
  @NotNull(message = "Quantity is mandatory")
  private Integer quantity;
  @NotBlank(message = "Title is mandatory")
  private String title;

  public Book convertToEntity() {
      ModelMapper modelMapper = new ModelMapper();
      return modelMapper.map(this, Book.class);
  }
}
