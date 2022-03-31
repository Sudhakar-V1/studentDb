package io.sudhakar.student.service;

import io.sudhakar.student.dto.Employee;
import io.sudhakar.student.dto.EmployeeGetAll;
import io.sudhakar.student.dto.EmployeeResponse;
import io.sudhakar.student.dto.ServiceResponse;

public interface RestTemplateService {
    ServiceResponse<EmployeeGetAll> getAllEmployee(String urlName);
    ServiceResponse<EmployeeResponse> getEmployeeById(String urlName, int id);
    ServiceResponse<EmployeeResponse> addEmployee(String urlName, Employee employee);
    ServiceResponse<Void> updateEmployee(String urlName, Employee employee, int id);
    ServiceResponse<Void> deleteEmployee(String urlName, int id);
}
