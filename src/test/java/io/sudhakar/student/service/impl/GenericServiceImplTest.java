package io.sudhakar.student.service.impl;

import io.sudhakar.student.dto.ServiceResponse;
import io.sudhakar.student.dto.Student;
import io.sudhakar.student.repository.JdbcRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class GenericServiceImplTest {

    GenericServiceImpl genericService;

    @Mock
    JdbcRepository jdbcRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        genericService = new GenericServiceImpl(jdbcRepository);
    }

    /*
    Given executeQuery(null, queryName, new StudentMapper()),getAllStudents(queryName)
    Then Students ,ServiceResponse
    Scenario SUCCESS
    */

    @Test
    void getAllStudentOk() {

        Student student = new Student();
        student.setId(1);
        student.setAge(24);
        student.setName("arr");
        student.setCourse("java Script");
        student.setPlace("pune");

        List<Student> students = new ArrayList<>();
        students.add(student);

        String queryName = "findAll";

        Mockito.when(jdbcRepository.executeQuery(queryName))
                .thenReturn(students);

        ServiceResponse<List<Student>> serviceResponse = genericService.getAllStudents(queryName);

        serviceResponse.setHttpStatus(HttpStatus.OK);
        serviceResponse.setData(students);

        assertEquals(HttpStatus.OK, serviceResponse.getHttpStatus());

        assertEquals(1, serviceResponse.getData().get(0).getId());
        assertEquals(24, serviceResponse.getData().get(0).getAge());
        assertEquals("pune", serviceResponse.getData().get(0).getPlace());
        assertEquals("arr", serviceResponse.getData().get(0).getName());
        assertEquals("java Script", serviceResponse.getData().get(0).getCourse());
    }


     /*
     Given executeQuery(null, queryName, new StudentMapper()),getAllStudents(queryName)
     Then Students ,ServiceResponse
     Scenario INTERNAL_SERVER_ERROR
     */

    @Test
    void getAllStudentsInternalServerError() {

        String queryName = "findAll";

        Mockito.when(jdbcRepository.executeQuery(queryName))
                .thenThrow(new NullPointerException(""));

        ServiceResponse<List<Student>> serviceResponse = genericService.getAllStudents(queryName);

        serviceResponse.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, serviceResponse.getHttpStatus());
    }

    /*
    Given executeAddQuery(student,queryName), addStudent(student,queryName)
    Then ServiceResponse
    Scenario SUCCESS
    */
    @Test
    void addStudentOK() {

        Student student = new Student();
        student.setId(1);
        student.setAge(24);
        student.setName("arr");
        student.setCourse("java Script");
        student.setPlace("pune");

        String queryName = "add";

        Mockito.doNothing().when(jdbcRepository).executeAddQuery(student, queryName);

        ServiceResponse<?> serviceResponse = genericService.addStudent(student, queryName);
        serviceResponse.setHttpStatus(HttpStatus.OK);

        assertEquals(HttpStatus.OK, serviceResponse.getHttpStatus());

    }

    /*
    Given executeAddQuery(student,queryName), addStudent(student,queryName)
    Then ServiceResponse
    Scenario INTERNAL_SERVER_ERROR
    */
    @Test
    void addStudentInternalServerError() {

        Mockito.doThrow(new NullPointerException(""))
                .when(jdbcRepository).executeAddQuery(Mockito.any(), Mockito.any());

        ServiceResponse<?> serviceResponse = genericService.addStudent(Mockito.any(), Mockito.any());
        serviceResponse.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, serviceResponse.getHttpStatus());

    }

    /*
    Given executeUpdateQuery(student, queryName), updateStudent(student, queryName)
    Then ServiceResponse
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

        String queryName = "update";

        Mockito.doNothing().when(jdbcRepository).executeUpdateQuery(student, queryName);

        ServiceResponse<?> serviceResponse = genericService.updateStudent(student, queryName);
        serviceResponse.setHttpStatus(HttpStatus.OK);

        assertEquals(HttpStatus.OK, serviceResponse.getHttpStatus());

    }

    /*
    Given executeUpdateQuery(student, queryName), updateStudent(student, queryName)
    Then ServiceResponse
    Scenario INTERNAL_SERVER_ERROR
    */
    @Test
    void updateStudentInternalServerError() {

        Mockito.doThrow(new NullPointerException(""))
                .when(jdbcRepository).executeUpdateQuery(Mockito.any(), Mockito.any());

        ServiceResponse<?> serviceResponse = genericService.updateStudent(Mockito.any(), Mockito.any());
        serviceResponse.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, serviceResponse.getHttpStatus());

    }

    /*
    Given executeDeleteQuery(id,queryName), deleteStudent(id,queryName)
    Then ServiceResponse
    Scenario SUCCESS
    */
    @Test
    void deleteStudentOK() {

//        Student student = new Student();
//        student.setId(1);
//        student.setAge(24);
//        student.setName("arr");
//        student.setCourse("java Script");
//        student.setPlace("pune");

        String queryName = "delete";

        Mockito.doNothing().when(jdbcRepository).executeDeleteQuery(1, queryName);

        ServiceResponse<?> serviceResponse = genericService.deleteStudent(1, queryName);
        serviceResponse.setHttpStatus(HttpStatus.OK);

        assertEquals(HttpStatus.OK, serviceResponse.getHttpStatus());

    }

    /*
    Given executeDeleteQuery(id,queryName), deleteStudent(id,queryName)
    Then ServiceResponse
    Scenario INTERNAL_SERVER_ERROR
    */
    @Test
    void deleteStudentInternalServerError() {

        String queryName = "delete";

        Mockito.doThrow(new NullPointerException(""))
                .when(jdbcRepository).executeDeleteQuery(1, queryName);

        ServiceResponse<?> serviceResponse = genericService.deleteStudent(1, queryName);
        serviceResponse.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, serviceResponse.getHttpStatus());

    }

     /*
    Given getStudent(id,queryName),executeByIdQuery(null, queryName, new StudentMapper(),id)
    Then  ServiceResponse, student
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

        String queryName = "findById";

        Mockito.when(jdbcRepository.executeByIdQuery(1, queryName))
                .thenReturn(students);

        ServiceResponse<List<Student>> serviceResponse = genericService.getStudent(1, queryName);

        serviceResponse.setHttpStatus(HttpStatus.OK);
        serviceResponse.setData(students);

        assertEquals(HttpStatus.OK, serviceResponse.getHttpStatus());

        assertEquals(1, serviceResponse.getData().get(0).getId());
        assertEquals(24, serviceResponse.getData().get(0).getAge());
        assertEquals("pune", serviceResponse.getData().get(0).getPlace());
        assertEquals("arr", serviceResponse.getData().get(0).getName());
        assertEquals("java Script", serviceResponse.getData().get(0).getCourse());
    }


    /*
    Given getStudent(id,queryName),executeByIdQuery(null, queryName, new StudentMapper(),id)
    Then  ServiceResponse, student
    Scenario ERROR (INTERNAL_SERVER_ERROR)
    */
    @Test
    void getStudentInternalServerError() {

        String queryName = "findById";

        when(jdbcRepository.executeByIdQuery(1, queryName))
                .thenThrow(new NullPointerException(""));

        ServiceResponse<List<Student>> serviceResponse = genericService.getStudent(1, queryName);
        serviceResponse.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, serviceResponse.getHttpStatus());

    }

    /*
     Given executeDeleteManyQuery(ids,queryName), deleteMany(ids,queryName)
     Then  ServiceResponse
     Scenario SUCCESS
     */
    @Test
    void deleteManyOk() {

        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);

        String queryName = "deleteMany";

        Mockito.doNothing().when(jdbcRepository).executeDeleteManyQuery(ids, queryName);

        ServiceResponse<?> serviceResponse = genericService.deleteMany(ids, queryName);
        serviceResponse.setHttpStatus(HttpStatus.OK);

        assertEquals(HttpStatus.OK, serviceResponse.getHttpStatus());
    }

    /*
    Given executeDeleteManyQuery(ids,queryName), deleteMany(ids,queryName)
    Then ServiceResponse
    Scenario INTERNAL_SERVER_ERROR
    */
    @Test
    void deleteManyInternalServerError() {

        Mockito.doThrow(new NullPointerException(""))
                .when(jdbcRepository).executeDeleteManyQuery(Mockito.any(), Mockito.any());

        ServiceResponse<?> serviceResponse = genericService.deleteMany(Mockito.any(), Mockito.any());
        serviceResponse.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, serviceResponse.getHttpStatus());

    }


    /*
  Given updateMany(students,ids,queryName),executeUpdateManyQuery(students,ids,queryName)
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

        String queryName = "updateMany";

        Mockito.doNothing().when(jdbcRepository).executeUpdateManyQuery(ids, queryName, student);

        ServiceResponse<?> serviceResponse = genericService.updateMany(ids, queryName, student);
        serviceResponse.setHttpStatus(HttpStatus.OK);

        assertEquals(HttpStatus.OK, serviceResponse.getHttpStatus());

    }

    /*
    Given updateMany(students,ids,queryName),executeUpdateManyQuery(students,ids,queryName)
    Then  ServiceResponse
    Scenario INTERNAL_SERVER_ERROR
    */
    @Test
    void updateManyInternalServerError() {

        Mockito.doThrow(new NullPointerException(""))
                .when(jdbcRepository).executeUpdateManyQuery(Mockito.any(), Mockito.any(), Mockito.any());

        ServiceResponse<?> serviceResponse = genericService.updateMany(Mockito.any(), Mockito.any(), Mockito.any());
        serviceResponse.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, serviceResponse.getHttpStatus());
    }

   /*
   Given executeAddManyQuery(students,queryName), addMany(students,queryName)
   Then ServiceResponse
   Scenario SUCCESS
   */
    @Test
    void addManyOK() {

        Student student = new Student();
        student.setId(1);
        student.setAge(24);
        student.setName("arr");
        student.setCourse("java Script");
        student.setPlace("pune");

        List<Student> students = new ArrayList<>();
        students.add(student);

        String queryName = "addMany";

        Mockito.doNothing().when(jdbcRepository).executeAddManyQuery(students,queryName);

        ServiceResponse<?> serviceResponse = genericService.addMany(students,queryName);
        serviceResponse.setHttpStatus(HttpStatus.OK);

        assertEquals(HttpStatus.OK, serviceResponse.getHttpStatus());

    }

    /*
    Given executeAddManyQuery(students,queryName), addMany(students,queryName)
    Then ServiceResponse
    Scenario INTERNAL_SERVER_ERROR
    */
    @Test
    void addManyInternalServerError() {

        Mockito.doThrow(new NullPointerException(""))
                .when(jdbcRepository).executeAddQuery(Mockito.any(),Mockito.any());

        ServiceResponse<?> serviceResponse = genericService.addMany(Mockito.any(),Mockito.any());
        serviceResponse.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, serviceResponse.getHttpStatus());
    }

}