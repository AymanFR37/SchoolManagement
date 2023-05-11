package ma.geo.local.school.mappers;

import ma.geo.local.school.dtos.StudentDTO;
import ma.geo.local.school.entities.StudentEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {
    StudentDTO studentToStudentDTO(StudentEntity student);
    StudentEntity studentDTOToStudent(StudentDTO studentDTO);

    List<StudentDTO> studentsToStudentDTOs(List<StudentEntity> all);
}
