package br.com.bruno.desafiotodolist.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RequestTodo(String id, @NotBlank String name,@NotBlank String description,@NotNull int priority) {
}
