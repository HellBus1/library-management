package com.example.librarymanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.modelmapper.ModelMapper;
import com.example.librarymanagement.model.Book;

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
