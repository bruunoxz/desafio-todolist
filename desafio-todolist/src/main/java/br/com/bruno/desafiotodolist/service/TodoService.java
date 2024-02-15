package br.com.bruno.desafiotodolist.service;

import br.com.bruno.desafiotodolist.domain.RequestTodo;
import br.com.bruno.desafiotodolist.domain.Todo;
import br.com.bruno.desafiotodolist.repository.TodoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    TodoRepository todoRepository;

    public List<Todo> list(){
        Sort sort = Sort.by("priority").descending().and(Sort.by("name").ascending());
        return todoRepository.findAll(sort);
    }

    public List<Todo> create(RequestTodo todo){
        Todo newTodo = new Todo(todo);
        todoRepository.save(newTodo);
        return list();
    }

    public Todo update(RequestTodo todo){
        Optional<Todo> optionalTodo = todoRepository.findById(todo.id());
        if(optionalTodo.isPresent()){
            Todo newTodo = optionalTodo.get();
            newTodo.setName(todo.name());
            newTodo.setDescription(todo.description());
            newTodo.setPriority(todo.priority());
            todoRepository.save(newTodo);
            return newTodo;
        }else{
            throw new EntityNotFoundException();
        }
    }

    public void delete(String id){
        todoRepository.deleteById(id);
    }

}
