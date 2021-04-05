package com.example.demo.domains.todo.dto.request;

import com.example.demo.common.annotations.date.CheckDateFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.NotNull;


@Getter
@Setter
@NoArgsConstructor
public class AddTodoRequest {
    @NotNull
    private String description;
    @NotNull
    @CheckDateFormat
    private String targetDate;
}
