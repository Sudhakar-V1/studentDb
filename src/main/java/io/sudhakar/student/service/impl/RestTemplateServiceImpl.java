package io.sudhakar.student.service.impl;

import io.sudhakar.student.dto.Employee;
import io.sudhakar.student.dto.EmployeeGetAll;
import io.sudhakar.student.dto.EmployeeResponse;
import io.sudhakar.student.dto.ServiceResponse;
import io.sudhakar.student.urldetails.RestTemplateUtil;
import io.sudhakar.student.service.RestTemplateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RestTemplateServiceImpl implements RestTemplateService {

    private final RestTemplateUtil restTemplateUtil;

    public RestTemplateServiceImpl(RestTemplateUtil restTemplateUtil) {
        this.restTemplateUtil = restTemplateUtil;
    }

    public ServiceResponse<EmployeeGetAll> getAllEmployee(String urlName) {
        ServiceResponse<EmployeeGetAll> serviceResponse = new ServiceResponse<>();
        try {
            log.info("operation = getAllEmployee, status = IN_PROCESS");

            EmployeeGetAll employeeResponse = restTemplateUtil.get(urlName, EmployeeGetAll.class);

            log.info("operation = getAllEmployee, status = SUCCESS");
            serviceResponse.setHttpStatus(HttpStatus.OK);
            serviceResponse.setData(employeeResponse);
            return serviceResponse;
        } catch (Exception e) {
            log.error("operation = getAllEmployee, status = ERROR",e);
            serviceResponse.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return serviceResponse;
    }

    public ServiceResponse<EmployeeResponse> getEmployeeById(String urlName, int id) {
        ServiceResponse<EmployeeResponse> serviceResponse = new ServiceResponse<>();
        try {
            log.info("operation = getEmployeeById, status = IN_PROCESS");

            EmployeeResponse employeeResponse = restTemplateUtil.get(urlName, EmployeeResponse.class, id);

            log.info("operation = getEmployeeById, status = SUCCESS");
            serviceResponse.setHttpStatus(HttpStatus.OK);
            serviceResponse.setData(employeeResponse);
            return serviceResponse;
        } catch (Exception e) {
            log.error("operation = getEmployeeById, status = ERROR",e);
            serviceResponse.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return serviceResponse;
    }

    public ServiceResponse<EmployeeResponse> addEmployee(String urlName, Employee employee) {
        ServiceResponse<EmployeeResponse> serviceResponse = new ServiceResponse<>();
        try {
            log.info("operation = addEmployee, status = IN_PROCESS");

            EmployeeResponse employeeResponse = restTemplateUtil.post(urlName, employee, EmployeeResponse.class);

            log.info("operation = addEmployee, status = SUCCESS");
            serviceResponse.setHttpStatus(HttpStatus.OK);
            serviceResponse.setData(employeeResponse);
            return serviceResponse;
        } catch (Exception e) {
            log.error("operation = addEmployee, status = ERROR",e);
            serviceResponse.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return serviceResponse;
    }

    public ServiceResponse<Void> updateEmployee(String urlName, Employee employee, int id) {
        ServiceResponse<Void> serviceResponse = new ServiceResponse<>();
        try {
            log.info("operation = updateEmployee, status = IN_PROCESS");

            restTemplateUtil.put(urlName, employee, id);

            log.info("operation = updateEmployee, status = SUCCESS");
            serviceResponse.setHttpStatus(HttpStatus.OK);

            return serviceResponse;
        } catch (Exception e) {
            log.error("operation = updateEmployee, status = ERROR",e);
            serviceResponse.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return serviceResponse;
    }

    public ServiceResponse<Void> deleteEmployee(String urlName, int id) {
        ServiceResponse<Void> serviceResponse = new ServiceResponse<>();
        try {
            log.info("operation = deleteEmployee, status = IN_PROCESS");

            restTemplateUtil.delete(urlName, id);

            log.info("operation = deleteEmployee, status = Success");
            serviceResponse.setHttpStatus(HttpStatus.OK);

            return serviceResponse;
        } catch (Exception e) {
            log.error("operation = deleteEmployee, status = ERROR",e);
            serviceResponse.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return serviceResponse;
    }
}