package com.example.librarymanagement.dto;

import java.sql.Timestamp;

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
public class BookResponseDTO {
  private int id;
  private int quantity;
  private String title;
  @EqualsAndHashCode.Exclude
  private Timestamp createdAt;
  @EqualsAndHashCode.Exclude
  private Timestamp updatedAt;
}
