package io.sudhakar.student.controller;

import io.sudhakar.student.dto.ServiceResponse;
import io.sudhakar.student.dto.Student;
import io.sudhakar.student.dto.StudentResponse;
import io.sudhakar.student.service.GenericService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/genericQuery")
public class GenericQueryController {

    private final GenericService genericService;

    public GenericQueryController(GenericService genericService) {
        this.genericService = genericService;
    }

    @GetMapping
    public ResponseEntity<StudentResponse<List<Student>>> getAllStudents(@RequestParam("queries") String queryName) {
        log.info("api = /genericQuery, method = GET, result = IN_PROGRESS");

        ServiceResponse<List<Student>> serviceResponse = genericService.getAllStudents(queryName);

        log.info("api = /genericQuery, method = GET, result = SUCCESS");
        return ResponseEntity.status(serviceResponse.getHttpStatus()).body(new StudentResponse<>(serviceResponse.getData()));
    }

    @GetMapping("/id")
    public ResponseEntity<StudentResponse<List<Student>>> getStudent(@RequestParam("id") int id, @RequestParam("queries") String queryName) {
        log.info("api = /genericQuery/{id}, method = GET, result = IN_PROGRESS");

        ServiceResponse<List<Student>> serviceResponse = genericService.getStudent(id, queryName);

        log.info("api = /genericQuery/{id}, method = GET, result = SUCCESS");
        return ResponseEntity.status(serviceResponse.getHttpStatus()).body(new StudentResponse<>(serviceResponse.getData()));
    }

    @PostMapping
    public ResponseEntity<Void> addStudent(@RequestBody Student student, @RequestParam("queries") String queryName) {
        log.info("api = /genericQuery, method = POST, result = IN_PROGRESS");

        ServiceResponse<?> serviceResponse = genericService.addStudent(student, queryName);

        log.info("api = /genericQuery, method = POST, result = SUCCESS");
        return ResponseEntity.status(serviceResponse.getHttpStatus()).build();
    }

    @PutMapping
    public ResponseEntity<?> updateStudent(@RequestBody Student student, @RequestParam("queries") String queryName) {
        log.info("api = /genericQuery, method = PUT, result = IN_PROGRESS");

        ServiceResponse<?> serviceResponse = genericService.updateStudent(student, queryName);

        log.info("api = /genericQuery, method = PUT, result = SUCCESS");
        return ResponseEntity.status(serviceResponse.getHttpStatus()).build();
    }

    @DeleteMapping
    public ResponseEntity<?> deleteStudent(@RequestParam("id") int id, @RequestParam("queries") String queryName) {
        log.info("api = /genericQuery, method = DELETE, result = IN_PROGRESS");

        ServiceResponse<?> serviceResponse = genericService.deleteStudent(id, queryName);

        log.info("api = /genericQuery, method = DELETE, result = SUCCESS");
        return ResponseEntity.status(serviceResponse.getHttpStatus()).build();
    }

    @PostMapping("/addMany")
    public ResponseEntity<?> addMany(@RequestBody List<Student> students, @RequestParam("queries") String queryName) {
        log.info("api = /genericQuery/addMany, method = POST, result = IN_PROGRESS");

        ServiceResponse<?> serviceResponse = genericService.addMany(students, queryName);

        log.info("api = /genericQuery/addMany, method = POST, result = SUCCESS");
        return ResponseEntity.status(serviceResponse.getHttpStatus()).build();
    }

    @DeleteMapping("/deleteMany")
    public ResponseEntity<?> deleteMany(@RequestParam("ids") List<Integer> ids, @RequestParam("queries") String queryName) {
        log.info("api = /genericQuery/deleteMany, method = deleteMany, result = IN_PROGRESS");

        ServiceResponse<?> serviceResponse = genericService.deleteMany(ids, queryName);

        log.info("api = /genericQuery/deleteMany, method = deleteMany, result = SUCCESS");
        return ResponseEntity.status(serviceResponse.getHttpStatus()).build();
    }

    @PutMapping("/updateMany")
    public ResponseEntity<?> updateMany(@RequestParam("ids") List<Integer> ids, @RequestParam("queries") String queryName, @RequestBody Student student) {
        log.info("api = /genericQuery/deleteMany, method = deleteMany, result = IN_PROGRESS");

        ServiceResponse<?> serviceResponse = genericService.updateMany(ids, queryName, student);

        log.info("api = /genericQuery/deleteMany, method = deleteMany, result = SUCCESS");
        return ResponseEntity.status(serviceResponse.getHttpStatus()).build();
    }
}