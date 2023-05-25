package ma.geo.local.school.mappers;

import ma.geo.local.school.dtos.GroupeDTO;
import ma.geo.local.school.entities.GroupeEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface GroupeMapper {
    GroupeEntity groupeDtoToGroupe(GroupeDTO groupeDTO);
    GroupeDTO groupeToGroupeDto(GroupeEntity groupeEntity);
    List<GroupeEntity> groupesToGroupeDtos(List<GroupeDTO> groupeDTOS);
}
