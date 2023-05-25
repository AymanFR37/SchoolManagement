package ma.geo.local.school.mappers;

import ma.geo.local.school.dtos.StudentDTO;
import ma.geo.local.school.entities.StudentEntite;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {
    StudentDTO studentToStudentDTO(StudentEntite student);
    StudentEntite studentDTOToStudent(StudentDTO studentDTO);

    List<StudentDTO> studentsToStudentDTOs(List<StudentEntite> all);
}
