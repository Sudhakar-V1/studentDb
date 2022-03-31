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
            log.error("method = getAll, status = IN_PROCESS");

            EmployeeGetAll employeeResponse = restTemplateUtil.getAll(urlName, EmployeeGetAll.class);

            log.error("method = getAll, status = Success");
            serviceResponse.setHttpStatus(HttpStatus.OK);
            serviceResponse.setData(employeeResponse);
            return serviceResponse;
        } catch (Exception e) {
            log.error("method = getAll, status = ERROR");
            serviceResponse.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return serviceResponse;
    }

    public ServiceResponse<EmployeeResponse> getEmployeeById(String urlName, int id) {
        ServiceResponse<EmployeeResponse> serviceResponse = new ServiceResponse<>();
        try {
            log.error("method = get, status = IN_PROCESS");

            EmployeeResponse employeeResponse = restTemplateUtil.getById(urlName, EmployeeResponse.class, id);

            log.error("method = getAll, status = Success");
            serviceResponse.setHttpStatus(HttpStatus.OK);
            serviceResponse.setData(employeeResponse);

            return serviceResponse;
        } catch (Exception e) {
            log.error("method = get, status = ERROR");
            serviceResponse.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return serviceResponse;
    }

    public ServiceResponse<EmployeeResponse> addEmployee(String urlName, Employee employee) {
        ServiceResponse<EmployeeResponse> serviceResponse = new ServiceResponse<>();

        try {
            log.error("method = add, status = IN_PROCESS");

            EmployeeResponse employeeResponse = restTemplateUtil.add(urlName, employee, EmployeeResponse.class);

            log.error("method = add, status = Success");
            serviceResponse.setHttpStatus(HttpStatus.OK);
            serviceResponse.setData(employeeResponse);
            return serviceResponse;
        } catch (Exception e) {
            log.error("method = add, status = ERROR");
            serviceResponse.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return serviceResponse;
    }

    public ServiceResponse<Void> updateEmployee(String urlName, Employee employee, int id) {
        ServiceResponse<Void> serviceResponse = new ServiceResponse<>();

        try {
            log.error("method = add, status = IN_PROCESS");

            restTemplateUtil.update(urlName, employee, id);

            log.error("method = add, status = Success");
            serviceResponse.setHttpStatus(HttpStatus.OK);

            return serviceResponse;
        } catch (Exception e) {
            log.error("method = add, status = ERROR");
            serviceResponse.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return serviceResponse;
    }

    public ServiceResponse<Void> deleteEmployee(String urlName, int id) {
        ServiceResponse<Void> serviceResponse = new ServiceResponse<>();

        try {
            log.error("method = delete, status = IN_PROCESS");

            restTemplateUtil.delete(urlName, id);

            log.error("method = delete, status = Success");
            serviceResponse.setHttpStatus(HttpStatus.OK);

            return serviceResponse;
        } catch (Exception e) {
            log.error("method = delete, status = ERROR");
            serviceResponse.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return serviceResponse;
    }

}
