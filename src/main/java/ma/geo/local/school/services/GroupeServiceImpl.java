package ma.geo.local.school.services;


import ma.geo.local.school.dtos.GroupeDTO;
import ma.geo.local.school.exceptions.DuplicateRessourceException;
import ma.geo.local.school.exceptions.ResourceNotFoundException;
import ma.geo.local.school.mappers.GroupeMapper;
import ma.geo.local.school.repositories.GroupeRepository;
import org.mapstruct.factory.Mappers;

import java.util.List;

public class GroupeServiceImpl implements GroupeService{
    private GroupeRepository groupeRepository;

    public GroupeServiceImpl(GroupeRepository groupeRepository) {
        this.groupeRepository = groupeRepository;
    }
    private GroupeMapper groupeMapper = Mappers.getMapper(GroupeMapper.class);

    @Override
    public GroupeDTO createGroupe(GroupeDTO groupeDTO) {
        String nomGrp = groupeDTO.getNomGrp();
        if (groupeRepository.existsByNomGrp(nomGrp)) {
            throw new DuplicateRessourceException("Groupe already exists");
        }
        GroupeDTO dto = groupeMapper.groupeToGroupeDto(groupeRepository.save(groupeMapper.groupeDtoToGroupe(groupeDTO)));
        return dto;
    }

    @Override
    public GroupeDTO updateGroupe(int id, GroupeDTO groupeDTO) {
        GroupeDTO dto = groupeMapper.groupeToGroupeDto(groupeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Groupe with this ID doesn't exits : "+id)));
        dto.setNomGrp(groupeDTO.getNomGrp());

        GroupeDTO savedDto = groupeMapper.groupeToGroupeDto(groupeRepository.save(groupeMapper.groupeDtoToGroupe(dto)));
        return savedDto;
    }

    @Override
    public void deleteGroupeById(int id) {
        GroupeDTO dto = groupeMapper.groupeToGroupeDto(groupeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Groupe with this ID doesn't exits : "+id)));
        groupeRepository.deleteById(id);
    }

    @Override
    public List<GroupeDTO> getAllGroupes() {
        return groupeMapper.groupesToGroupeDtos(groupeRepository.findAll());
    }
}
