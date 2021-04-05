package com.example.demo.domains.todo.service;

import com.example.demo.common.exception.GlobalException;
import com.example.demo.domains.todo.dto.request.AddTodoRequest;
import com.example.demo.domains.todo.dto.request.DeleteTodoRequest;
import com.example.demo.domains.todo.dto.request.UpdateTodoRequest;
import com.example.demo.domains.todo.dto.response.AddTodoResponse;
import com.example.demo.domains.todo.dto.response.GetTodosResponse;
import com.example.demo.domains.todo.entity.TodoEntity;
import com.example.demo.domains.todo.model.TodoModel;
import com.example.demo.domains.todo.repository.TodoRepository;
import com.example.demo.domains.todo.service.iterface.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TodoServiceImp implements TodoService {
    @Autowired
    TodoRepository todoRepository;

    @Override
    public GetTodosResponse getTodos() {
        GetTodosResponse getTodosResponse = new GetTodosResponse();
        getTodosResponse.setTodos(todoRepository.findAll().stream().map(todoEntity -> new TodoModel(todoEntity.getId(),todoEntity.getDescription(),todoEntity.getTargetDate())).collect(Collectors.toList()));
        return getTodosResponse;
    }

    @Override
    public AddTodoResponse addTodo(AddTodoRequest addTodoRequest) {

        TodoEntity todoEntity=new TodoEntity();
        {
            todoEntity.setDescription(addTodoRequest.getDescription());
            todoEntity.setTargetDate(Date.valueOf(addTodoRequest.getTargetDate()));
        }
        todoEntity = todoRepository.save(todoEntity);

        AddTodoResponse addTodoResponse = new AddTodoResponse();
        addTodoResponse.setId(todoEntity.getId());

        return addTodoResponse;
    }

    @Override
    public void updateTodo(UpdateTodoRequest updateTodoRequest)  {
        Optional<TodoEntity> optionalTodoEntity=todoRepository.findById(updateTodoRequest.getId());
        if(!optionalTodoEntity.isPresent())
            throw new GlobalException("Todo not found", HttpStatus.NOT_FOUND);
        TodoEntity todoEntity=optionalTodoEntity.get();
        {
            todoEntity.setDescription(updateTodoRequest.getDescription());
            todoEntity.setTargetDate(Date.valueOf(updateTodoRequest.getTargetDate()));
        }
        todoRepository.save(todoEntity);
    }

    @Override
    public void deleteTodo(DeleteTodoRequest deleteTodoRequest) {
        Optional<TodoEntity> optionalTodoEntity=todoRepository.findById(deleteTodoRequest.getId());
        if(!optionalTodoEntity.isPresent())
            throw new GlobalException("Todo not found", HttpStatus.NOT_FOUND);
        TodoEntity todoEntity=optionalTodoEntity.get();
        todoRepository.delete(todoEntity);
    }


}