package ma.geo.local.school.mappers;

import ma.geo.local.school.dtos.TeacherDTO;
import ma.geo.local.school.entities.TeacherEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface TeacherMapper {
    TeacherDTO teacherToTeacherDTO(TeacherEntity teacherEntity);
    TeacherEntity teacherDtoToTeacher(TeacherDTO teacherDTO);
    List<TeacherDTO> teachersToTeacherDTOs(List<TeacherEntity> teacherEntities);
    List<TeacherEntity> teacherDTOsToteachers(List<TeacherDTO> teacherDTOS);
}
