package ma.geo.local.school.services;

import ma.geo.local.school.dtos.TeacherDTO;

import java.util.List;

public interface TeacherService {
    List<TeacherDTO> getAllTeachers();
    TeacherDTO getTeacherById(String id);
    TeacherDTO addTeacher(TeacherDTO teacherDTO);
    TeacherDTO updateTeacher(String id,TeacherDTO teacherDTO);
    void deleteTeacherById(String id);
}
