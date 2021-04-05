package com.example.demo.domains.todo.controller;

import com.example.demo.domains.todo.dto.request.AddTodoRequest;
import com.example.demo.domains.todo.dto.request.DeleteTodoRequest;
import com.example.demo.domains.todo.dto.request.UpdateTodoRequest;
import com.example.demo.domains.todo.dto.response.AddTodoResponse;
import com.example.demo.domains.todo.dto.response.GetTodosResponse;
import com.example.demo.domains.todo.service.iterface.TodoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/todos")
@Slf4j
public class TodoController {

    @Autowired
    TodoService todoService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<GetTodosResponse> getTodos(){
            return ResponseEntity.ok(todoService.getTodos());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<AddTodoResponse> addTodo(@Valid @RequestBody AddTodoRequest addTodoRequest){
        return ResponseEntity.ok(todoService.addTodo(addTodoRequest));
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public ResponseEntity updateTodo(@Valid @RequestBody UpdateTodoRequest updateTodoRequest){
        todoService.updateTodo(updateTodoRequest);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/delete" , method = RequestMethod.POST)
    public ResponseEntity deleteTodo(@Valid @RequestBody DeleteTodoRequest deleteTodoRequest){
        todoService.deleteTodo(deleteTodoRequest);
        return ResponseEntity.ok().build();
    }


}
