package br.com.bruno.desafiotodolist.controller;

import br.com.bruno.desafiotodolist.domain.RequestTodo;
import br.com.bruno.desafiotodolist.domain.Todo;
import br.com.bruno.desafiotodolist.infra.RequestsExceptionHandler;
import br.com.bruno.desafiotodolist.repository.TodoRepository;
import br.com.bruno.desafiotodolist.service.TodoService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/todos")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @GetMapping
    public ResponseEntity getAllTodos(){
        return ResponseEntity.ok(todoService.list());
    }

    @PostMapping
    public ResponseEntity registerTodo(@RequestBody @Valid RequestTodo data){
        return ResponseEntity.ok(todoService.create(data));
    }

    @PutMapping
    public ResponseEntity updateTodo(@RequestBody @Valid RequestTodo data){
        return ResponseEntity.ok(todoService.update(data));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTodo(@PathVariable("id") String id){
        todoService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
