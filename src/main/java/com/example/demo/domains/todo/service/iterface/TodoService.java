package com.example.demo.domains.todo.service.iterface;

import com.example.demo.common.exception.GlobalException;
import com.example.demo.domains.todo.dto.request.AddTodoRequest;
import com.example.demo.domains.todo.dto.request.DeleteTodoRequest;
import com.example.demo.domains.todo.dto.request.UpdateTodoRequest;
import com.example.demo.domains.todo.dto.response.AddTodoResponse;
import com.example.demo.domains.todo.dto.response.GetTodosResponse;
import org.springframework.stereotype.Service;

@Service
public interface TodoService {
    public GetTodosResponse getTodos();

    public AddTodoResponse addTodo(AddTodoRequest addTodoRequest);

    public void updateTodo(UpdateTodoRequest updateTodoRequest) ;


    void deleteTodo(DeleteTodoRequest deleteTodoRequest);
}
