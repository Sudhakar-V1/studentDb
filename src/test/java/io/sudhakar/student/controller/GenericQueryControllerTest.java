package io.sudhakar.student.controller;

import io.sudhakar.student.dto.ServiceResponse;
import io.sudhakar.student.dto.Student;
import io.sudhakar.student.dto.StudentResponse;
import io.sudhakar.student.service.GenericService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


class GenericQueryControllerTest {

    GenericQueryController genericQueryController;

    @Mock
    GenericService genericService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        genericQueryController = new GenericQueryController(genericService);
    }


    /*
    Given getAllStudents(queryName)
    Then  ServiceResponse
    Scenario SUCCESS
     */

    @Test
    void getAllStudentsOk() {

        Student student = new Student();
        student.setId(1);
        student.setAge(24);
        student.setName("arr");
        student.setCourse("java Script");
        student.setPlace("pune");

        List<Student> students = new ArrayList<>();
        students.add(student);

        ServiceResponse<List<Student>> serviceResponse = new ServiceResponse<>();
        serviceResponse.setHttpStatus(HttpStatus.OK);
        serviceResponse.setData(students);

        String queryName = "findAll";

        when(genericService.getAllStudents(queryName))
                .thenReturn(serviceResponse);

        ResponseEntity<StudentResponse<List<Student>>> responseEntity = genericQueryController.getAllStudents(queryName);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        assertEquals(1, (responseEntity.getBody()).getData().get(0).getId());
        assertEquals("arr", (responseEntity.getBody()).getData().get(0).getName());
        assertEquals("java Script", (responseEntity.getBody()).getData().get(0).getCourse());
        assertEquals("pune", (responseEntity.getBody()).getData().get(0).getPlace());

    }

    /*
    Given getAllStudents(queryName)
    Then  ServiceResponse
    Scenario INTERNAL_SERVER_ERROR
    */
    @Test
    void getAllStudentsInternalServerError() {

        ServiceResponse<List<Student>> serviceResponse = new ServiceResponse<>();
        serviceResponse.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);

        when(genericService.getAllStudents(Mockito.any()))
                .thenReturn(serviceResponse);

        ResponseEntity<StudentResponse<List<Student>>> responseEntity = genericQueryController.getAllStudents(Mockito.any());

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
    }

    /*
   Given addStudent(student,queryName)
   Then  ServiceResponse
   Scenario SUCCESS
    */
    @Test
    void addStudentOk() {

        Student student = new Student();
        student.setId(1);
        student.setAge(24);
        student.setName("arr");
        student.setCourse("java Script");
        student.setPlace("pune");

        ServiceResponse serviceResponse = new ServiceResponse<>();
        serviceResponse.setHttpStatus(HttpStatus.OK);

        String queryName = "add";

        Mockito.when(genericService.addStudent(student,queryName))
                .thenReturn(serviceResponse);

        ResponseEntity<?> responseEntity = genericQueryController.addStudent(student,queryName);

        assertEquals(200, responseEntity.getStatusCodeValue());

    }

    /*
    Given addStudent(student,queryName)
    Then  ServiceResponse
    Scenario INTERNAL_SERVER_ERROR
    */

    @Test
    void addStudentInternalServerError() {

        ServiceResponse serviceResponse = new ServiceResponse<>();
        serviceResponse.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);

        Mockito.when(genericService.addStudent(Mockito.any(),Mockito.any()))
                .thenReturn(serviceResponse);

        ResponseEntity<?> responseEntity = genericQueryController.addStudent(Mockito.any(),Mockito.any());
        assertEquals(500, responseEntity.getStatusCodeValue());

    }

    /*
    Given updateStudent(student,queryName)
    Then  ServiceResponse
    Scenario SUCCESS
    */
    @Test
    void updateStudentOk() {
        Student student = new Student();
        student.setId(1);
        student.setAge(24);
        student.setName("arr");
        student.setCourse("java Script");
        student.setPlace("pune");

        ServiceResponse serviceResponse = new ServiceResponse<>();
        serviceResponse.setHttpStatus(HttpStatus.OK);
        serviceResponse.setData(student);

        String queryName = "update";

        Mockito.when(genericService.updateStudent(student, queryName))
                .thenReturn(serviceResponse);

        ResponseEntity<?> responseEntity = genericQueryController.updateStudent(student, queryName);

        assertEquals(200, responseEntity.getStatusCodeValue());

    }

    /*
   Given updateStudent(student, queryName)
   Then  ServiceResponse
   Scenario INTERNAL_SERVER_ERROR
   */
    @Test
    void updateStudentInternalServerError() {

        ServiceResponse serviceResponse = new ServiceResponse<>();
        serviceResponse.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);

        Mockito.when(genericService.updateStudent(Mockito.any(), Mockito.any()))
                .thenReturn(serviceResponse);

        ResponseEntity<?> responseEntity = genericQueryController.updateStudent(Mockito.any(), Mockito.any());

        assertEquals(500, responseEntity.getStatusCodeValue());
    }

  /*
  Given deleteStudent(id,queryName)
  Then  ServiceResponse
  Scenario SUCCESS
  */
    @Test
    void deleteStudentOk() {

        Student student = new Student();
        student.setId(1);
        student.setAge(24);
        student.setName("arr");
        student.setCourse("java Script");
        student.setPlace("pune");

        ServiceResponse serviceResponse = new ServiceResponse<>();
        serviceResponse.setHttpStatus(HttpStatus.OK);

        String queryName = "delete";

        when(genericService.deleteStudent(1,queryName))
                .thenReturn(serviceResponse);

        ResponseEntity<?> responseEntity = genericQueryController.deleteStudent(1,queryName);
        assertEquals(200, responseEntity.getStatusCodeValue());

    }

    /*
    Given deleteStudent(id,queryName)
    Then  ServiceResponse
    Scenario INTERNAL_SERVER_ERROR
    */
    @Test
    void deleteStudentInternalServerError() {

        ServiceResponse serviceResponse = new ServiceResponse<>();
        serviceResponse.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);

        String queryName = "delete";

        when(genericService.deleteStudent(1,queryName))
                .thenReturn(serviceResponse);

        ResponseEntity<?> responseEntity = genericQueryController.deleteStudent(1,queryName);
        assertEquals(500, responseEntity.getStatusCodeValue());

    }

    /*
    Given getStudent(id,queryName)
    Then  ServiceResponse
    Scenario SUCCESS
     */

    @Test
    void getStudentOk() {

        Student student = new Student();
        student.setId(1);
        student.setAge(24);
        student.setName("arr");
        student.setCourse("java Script");
        student.setPlace("pune");

        List<Student> students = new ArrayList<>();
        students.add(student);

        ServiceResponse<List<Student>> serviceResponse = new ServiceResponse<>();
        serviceResponse.setHttpStatus(HttpStatus.OK);
        serviceResponse.setData(students);

        String queryName = "findById";

        when(genericService.getStudent (1,queryName))
                .thenReturn(serviceResponse);

        ResponseEntity<StudentResponse<List<Student>>> responseEntity = genericQueryController.getStudent(1,queryName);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        assertEquals(1, (responseEntity.getBody()).getData().get(0).getId());
        assertEquals("arr", (responseEntity.getBody()).getData().get(0).getName());
        assertEquals("java Script", (responseEntity.getBody()).getData().get(0).getCourse());
        assertEquals("pune", (responseEntity.getBody()).getData().get(0).getPlace());

    }

     /*
    Given getStudent(id,queryName)
    Then  ServiceResponse
    Scenario INTERNAL_SERVER_ERROR
     */

    @Test
    void getStudentInternalServerError() {

        ServiceResponse<List<Student>> serviceResponse = new ServiceResponse<>();
        serviceResponse.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);

        String queryName = "findById";

        when(genericService.getStudent (1,queryName))
                .thenReturn(serviceResponse);

        ResponseEntity<StudentResponse<List<Student>>> responseEntity = genericQueryController.getStudent(1,queryName);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());

    }

    /*
    Given deleteMany(ids,queryName)
    Then  ServiceResponse
    Scenario SUCCESS
    */
    @Test
    void deleteManyOk() {

        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);

        ServiceResponse<?> serviceResponse = new ServiceResponse<>();
        serviceResponse.setHttpStatus(HttpStatus.OK);

        String queryName = "deleteMany";

        Mockito.doReturn(serviceResponse).when(genericService).deleteMany(ids, queryName);

        ResponseEntity<?> responseEntity = genericQueryController.deleteMany(ids, queryName);
        assertEquals(200, responseEntity.getStatusCodeValue());
    }

    /*
   Given deleteMany(ids,queryName)
   Then  ServiceResponse
   Scenario INTERNAL_SERVER_ERROR
   */
    @Test
    void deleteManyInternalServerError() {

        ServiceResponse<?> serviceResponse = new ServiceResponse<>();
        serviceResponse.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);

        Mockito.doReturn(serviceResponse).when(genericService).deleteMany(Mockito.any(), Mockito.any());

        ResponseEntity<?> responseEntity = genericQueryController.deleteMany(Mockito.any(), Mockito.any());
        assertEquals(500, responseEntity.getStatusCodeValue());
    }

    /*
   Given updateMany(students,ids,queryName)
   Then  ServiceResponse
   Scenario SUCCESS
   */
    @Test
    void updateManyOk() {

        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);

        Student student = new Student();
        student.setId(1);
        student.setAge(24);
        student.setName("arr");
        student.setCourse("java Script");
        student.setPlace("pune");

        ServiceResponse<?> serviceResponse = new ServiceResponse<>();
        serviceResponse.setHttpStatus(HttpStatus.OK);

        String queryName = "updateMany";

        Mockito.doReturn(serviceResponse).when(genericService).updateMany(ids, queryName,student);

        ResponseEntity<?> responseEntity = genericQueryController.updateMany(ids, queryName,student);
        assertEquals(200, responseEntity.getStatusCodeValue());
    }

    /*
    Given updateMany(students,ids,queryName)
    Then  ServiceResponse
    Scenario INTERNAL_SERVER_ERROR
    */
    @Test
    void updateManyInternalServerError() {

        ServiceResponse<?> serviceResponse = new ServiceResponse<>();
        serviceResponse.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);

        Mockito.doReturn(serviceResponse).when(genericService).updateMany(Mockito.any(), Mockito.any(),Mockito.any());

        ResponseEntity<?> responseEntity = genericQueryController.updateMany(Mockito.any(), Mockito.any(),Mockito.any());
        assertEquals(500, responseEntity.getStatusCodeValue());
    }



    /*
   Given addMany(students,queryName)
   Then  ServiceResponse
   Scenario SUCCESS
   */
    @Test
    void addManyOk() {

        Student student = new Student();
        student.setId(1);
        student.setAge(24);
        student.setName("arr");
        student.setCourse("java Script");
        student.setPlace("pune");

        List<Student> students = new ArrayList<>();
        students.add(student);

        ServiceResponse<?> serviceResponse = new ServiceResponse<>();
        serviceResponse.setHttpStatus(HttpStatus.OK);

        String queryName = "addMany";

        Mockito.doReturn(serviceResponse).when(genericService).addMany(students,queryName);

        ResponseEntity<?> responseEntity = genericQueryController.addMany(students,queryName);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    /*
    Given addMany(students,queryName)
    Then  ServiceResponse
    Scenario INTERNAL_SERVER_ERROR
    */

    @Test
    void addManyInternalServerError() {

        ServiceResponse serviceResponse = new ServiceResponse<>();
        serviceResponse.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);

        Mockito.when(genericService.addMany(Mockito.any(),Mockito.any()))
                .thenReturn(serviceResponse);

        ResponseEntity<?> responseEntity = genericQueryController.addMany(Mockito.any(),Mockito.any());
        assertEquals(500, responseEntity.getStatusCodeValue());

    }



}