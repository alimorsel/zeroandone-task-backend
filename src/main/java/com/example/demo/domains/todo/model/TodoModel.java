package com.example.demo.domains.todo.model;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TodoModel {
    private long id;
    private String description;
    private Date targetDate;
}
