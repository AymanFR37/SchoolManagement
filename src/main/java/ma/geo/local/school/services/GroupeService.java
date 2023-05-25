package ma.geo.local.school.services;

import ma.geo.local.school.dtos.GroupeDTO;

import java.util.List;

public interface GroupeService {
    GroupeDTO createGroupe(GroupeDTO groupeDTO);
    GroupeDTO updateGroupe(int id,GroupeDTO groupeDTO);
    void deleteGroupeById(int id);
    List<GroupeDTO> getAllGroupes();
}
