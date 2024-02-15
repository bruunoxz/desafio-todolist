package br.com.bruno.desafiotodolist.repository;

import br.com.bruno.desafiotodolist.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TodoRepository extends JpaRepository<String, Todo> {
}
