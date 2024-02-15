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
import java.util.Optional;

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
    public ResponseEntity registerTodo(@RequestBody @Valid RequestTodo data){
        Todo newTodo = new Todo(data);
        todoRepository.save(newTodo);
        return ResponseEntity.ok(newTodo);
    }

    @PutMapping
    public ResponseEntity updateTodo(@RequestBody @Valid RequestTodo data){
        Optional<Todo> optionalTodo = todoRepository.findById(data.id());
        if(optionalTodo.isPresent()){
            Todo todo = optionalTodo.get();
            todo.setName(data.name());
            todo.setDescription(data.description());
            todo.setPriority(data.priority());
            todoRepository.save(todo);
            return ResponseEntity.ok(todo);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTodo(@PathVariable("id") String id){
        Optional<Todo> optionalTodo = todoRepository.findById(id);
        if(optionalTodo.isPresent()){
            Todo todo = optionalTodo.get();
            todoRepository.delete(todo);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }


}
