package io.sudhakar.student.service;

import io.sudhakar.student.dto.ServiceResponse;
import io.sudhakar.student.dto.Student;

import java.util.List;

public interface GenericService {

    ServiceResponse<List<Student>> getAllStudents(String queryName);

    ServiceResponse<List<Student>> getStudent(int id, String queryName);

    ServiceResponse<?> addStudent(Student student, String queryName);

    ServiceResponse<?> updateStudent(Student student, String queryName);

    ServiceResponse<?> deleteStudent(int id, String queryName);

    ServiceResponse<?> addMany(List<Student> students, String queryName);

    ServiceResponse<?> deleteMany(List<Integer> ids, String queryName);

    ServiceResponse<?> updateMany(List<Integer> ids, String queryName, Student student);

}