package com.example.demo.domains.todo.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
public class DeleteTodoRequest {
    @NotNull
    long id;
}
