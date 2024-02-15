package br.com.bruno.desafiotodolist.controller;

import br.com.bruno.desafiotodolist.domain.RequestTodo;
import br.com.bruno.desafiotodolist.domain.Todo;
import br.com.bruno.desafiotodolist.repository.TodoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {
    @Autowired
    private TodoRepository todoRepository;

    @GetMapping
    public ResponseEntity getAllTodos(){
        var allTodos = todoRepository.findAll();
        return ResponseEntity.ok(allTodos);
    }

    @PostMapping
    public ResponseEntity registerTodo(@RequestBody @Valid RequestTodo requestTodo){
        Todo newTodo = new Todo(requestTodo);
        todoRepository.save(newTodo);
        return ResponseEntity.ok(newTodo);
    }


}
