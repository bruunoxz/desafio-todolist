package br.com.bruno.desafiotodolist.domain;

import jakarta.validation.constraints.NotBlank;

public record RequestTodo(@NotBlank String name,@NotBlank String description,@NotBlank String priority) {
}
