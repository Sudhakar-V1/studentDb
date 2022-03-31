package io.sudhakar.student.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Employee {
    private long id;

    @JsonProperty("employee_name")
    private String employeeName;

    @JsonProperty("employee_salary")
    private long employeeSalary;

    @JsonProperty("employee_age")
    private long employeeAge;

    @JsonProperty("profile_image")
    private String profileImage;
}