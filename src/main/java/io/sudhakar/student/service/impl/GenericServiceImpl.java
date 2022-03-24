package io.sudhakar.student.service.impl;

import io.sudhakar.student.dto.ServiceResponse;
import io.sudhakar.student.dto.Student;
import io.sudhakar.student.repository.JdbcRepository;
import io.sudhakar.student.service.GenericService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class GenericServiceImpl implements GenericService {

    @Autowired
    private final JdbcRepository jdbcRepository;

    public GenericServiceImpl(JdbcRepository jdbcRepository) {
        this.jdbcRepository = jdbcRepository;
    }

    public ServiceResponse<List<Student>> getAllStudents(String queryName) {
        ServiceResponse<List<Student>> serviceResponse = new ServiceResponse<>();

        try {
            log.info("operation = getAllStudents, status = IN_PROGRESS");

            List<Student> students = jdbcRepository.executeQuery(queryName);

            log.info("operation = getAllStudents, status = SUCCESS");
            serviceResponse.setHttpStatus(HttpStatus.OK);
            serviceResponse.setData(students);

            return serviceResponse;

        } catch (Exception e) {
            log.error("operation = getAllStudents, status = ERROR", e);
            serviceResponse.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return serviceResponse;
    }

    public ServiceResponse<List<Student>> getStudent(int id, String queryName) {
        ServiceResponse<List<Student>> serviceResponse = new ServiceResponse<>();

        try {
            log.info("operation = getStudent, status = IN_PROGRESS");

            List<Student> students = jdbcRepository.executeByIdQuery(id, queryName);

            log.info("operation = getStudent, status = SUCCESS");
            serviceResponse.setHttpStatus(HttpStatus.OK);
            serviceResponse.setData(students);

            return serviceResponse;

        } catch (Exception e) {
            log.error("operation = getStudent, status = ERROR", e);
            serviceResponse.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return serviceResponse;
    }

    @Override
    public ServiceResponse<?> addStudent(Student student, String queryName) {

        ServiceResponse<?> serviceResponse = new ServiceResponse<>();

        try {
            log.info("operation = addStudent, status = IN_PROGRESS");

            jdbcRepository.executeAddQuery(student, queryName);

            serviceResponse.setHttpStatus(HttpStatus.OK);
            log.info("operation = addStudent, status = SUCCESS");

            return serviceResponse;
        } catch (Exception e) {
            log.error("operation = addStudent, status = ERROR", e);
            serviceResponse.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return serviceResponse;

    }

    @Override
    public ServiceResponse<?> updateStudent(Student student, String queryName) {

        ServiceResponse<?> serviceResponse = new ServiceResponse<>();

        try {
            log.info("operation = updateStudent, status = IN_PROGRESS");

            jdbcRepository.executeUpdateQuery(student, queryName);
            serviceResponse.setHttpStatus(HttpStatus.OK);

            log.info("operation = updateStudent,  status = SUCCESS");

            return serviceResponse;
        } catch (Exception e) {
            log.error("operation = updateStudent, status = ERROR", e);
            serviceResponse.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return serviceResponse;

    }

    @Override
    public ServiceResponse<?> deleteStudent(int id, String queryName) {

        ServiceResponse<?> serviceResponse = new ServiceResponse<>();

        try {
            log.info("operation = deleteStudent, status = IN_PROGRESS");

            jdbcRepository.executeDeleteQuery(id, queryName);
            serviceResponse.setHttpStatus(HttpStatus.OK);

            log.info("operation = deleteStudent, status = done service");

            return serviceResponse;
        } catch (Exception e) {
            log.error("operation = deleteStudent, status = ERROR", e);
            serviceResponse.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return serviceResponse;

    }

    @Override
    public ServiceResponse<?> addMany(List<Student> students, String queryName) {

        ServiceResponse<?> serviceResponse = new ServiceResponse<>();
        try {

            log.info("operation = addMany, status = IN_PROGRESS");

            jdbcRepository.executeAddManyQuery(students, queryName);
            serviceResponse.setHttpStatus(HttpStatus.OK);

            log.info("operation = addMany, status = SUCCESS");

            return serviceResponse;
        } catch (Exception e) {
            log.error("operation = addMany, status = ERROR", e);
            serviceResponse.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return serviceResponse;

    }

    @Override
    public ServiceResponse<?> updateMany(List<Integer> ids, String queryName, Student student) {

        ServiceResponse<?> serviceResponse = new ServiceResponse<>();
        try {

            log.info("operation = updateMany, status = IN_PROGRESS");

            jdbcRepository.executeUpdateManyQuery(ids, queryName, student);
            serviceResponse.setHttpStatus(HttpStatus.OK);

            log.info("operation = updateMany, status = SUCCESS");

            return serviceResponse;
        } catch (Exception e) {
            log.error("operation = updateMany, status = ERROR", e);
            serviceResponse.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return serviceResponse;

    }

    @Override
    public ServiceResponse<?> deleteMany(List<Integer> ids, String queryName) {

        ServiceResponse<?> serviceResponse = new ServiceResponse<>();
        try {

            log.info("operation = deleteMany, status = IN_PROGRESS");

            jdbcRepository.executeDeleteManyQuery(ids, queryName);
            serviceResponse.setHttpStatus(HttpStatus.OK);

            log.info("operation = deleteMany, status = SUCCESS");

            return serviceResponse;
        } catch (Exception e) {
            log.error("operation = deleteMany, status = ERROR", e);
            serviceResponse.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return serviceResponse;
    }

}
