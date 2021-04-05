package com.example.demo.domains.todo.dto.response;

import com.example.demo.domains.todo.entity.TodoEntity;
import com.example.demo.domains.todo.model.TodoModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class GetTodosResponse {

    private List<TodoModel> todos;
}


