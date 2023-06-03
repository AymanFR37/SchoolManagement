package ma.geo.local.school.services;

import ma.geo.local.school.dtos.MatiereDTO;
import ma.geo.local.school.dtos.SalleDTO;

import java.util.List;

public interface SalleService {
    SalleDTO addSalle(SalleDTO salleDTO);
    SalleDTO updateSalle(int id,SalleDTO salleDTO);
    void deleteSalleById(int id);
    List<SalleDTO> getAllSalles();
}
