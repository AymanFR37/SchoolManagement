package ma.geo.local.school.services;

import ma.geo.local.school.dtos.ClassDTO;

import java.util.List;

public interface ClassService {
    ClassDTO createClass(ClassDTO classDTO);
    ClassDTO updateClass(int id,ClassDTO classDTO);
    void deleteClassById(int id);
    List<ClassDTO> getAllClasses();


}
