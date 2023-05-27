package ma.geo.local.school.services;

import ma.geo.local.school.dtos.MatiereDTO;

import java.util.List;

public interface MatiereService {
    MatiereDTO createMatiere(MatiereDTO matiereDTO);
    MatiereDTO updateMatiere(int id,MatiereDTO matiereDTO);
    void deleteMatiereById(int id);
    List<MatiereDTO> getAllMatieres();
}
