package br.com.bruno.desafiotodolist.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;


@Getter
@Setter
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "todos")
@Table(name="todos")
public class Todo {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String description;
    private TodoPriority priority;
}
