package ma.geo.local.school.mappers;

import ma.geo.local.school.dtos.MatiereDTO;
import ma.geo.local.school.dtos.SalleDTO;
import ma.geo.local.school.entities.MatiereEntity;
import ma.geo.local.school.entities.SalleEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface SalleMapper {
    SalleEntity salleDtoToSalle(SalleDTO salleDTO);
    SalleDTO salleToSalleDto(SalleEntity salleEntity);
    List<SalleEntity> salleDtosToSalles(List<SalleDTO> salleDTOS);
    List<SalleDTO> sallesToSallesDtos(List<SalleEntity> salleEntities);
}
