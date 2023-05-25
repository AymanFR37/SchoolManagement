package ma.geo.local.school.mappers;

import ma.geo.local.school.dtos.ClassDTO;
import ma.geo.local.school.entities.ClassEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ClassMapper {
    ClassEntity classDtoToClass(ClassDTO classDTO);
    ClassDTO classToClassDto(ClassEntity classEntity);
    List<ClassEntity> classeDtosToClasses(List<ClassDTO> classDTOS);
    List<ClassDTO> ClassesToClassesDtos(List<ClassEntity> classEntities);
}
