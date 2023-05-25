package ma.geo.local.school.services;

import ma.geo.local.school.dtos.StudentDTO;

import java.util.List;

public interface StudentService {
    List<StudentDTO> getAllStudents();
    StudentDTO getStudentById(int id);
    List<StudentDTO> searchStudents(String lastName, String nomClass, String nomGrp);
    StudentDTO createStudent(StudentDTO studentDTO);
    StudentDTO updateStudent(int id, StudentDTO studentDTO);
    void deleteStudentById(int id);
}
