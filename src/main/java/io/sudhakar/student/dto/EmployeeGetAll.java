package io.sudhakar.student.dto;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class EmployeeGetAll {
    private String status;
    private List<Employee> data;
    private String message;
}
