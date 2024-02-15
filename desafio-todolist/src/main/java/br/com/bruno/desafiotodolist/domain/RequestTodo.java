package br.com.bruno.desafiotodolist.domain;

import jakarta.validation.constraints.NotBlank;

public record RequestTodo(String id, @NotBlank String name,@NotBlank String description,@NotBlank String priority) {
}
