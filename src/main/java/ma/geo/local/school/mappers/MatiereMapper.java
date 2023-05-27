package ma.geo.local.school.mappers;

import ma.geo.local.school.dtos.ClassDTO;
import ma.geo.local.school.dtos.MatiereDTO;
import ma.geo.local.school.entities.ClassEntity;
import ma.geo.local.school.entities.MatiereEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface MatiereMapper {
    MatiereEntity matiereDtoToMatiere(MatiereDTO matiereDTO);
    MatiereDTO matiereToMatiereDto(MatiereEntity matiereEntity);
    List<MatiereEntity> matiereDtosToMatieres(List<MatiereDTO> matiereDTOS);
    List<MatiereDTO> matieresToMatieresDtos(List<MatiereEntity> matiereEntities);
}
