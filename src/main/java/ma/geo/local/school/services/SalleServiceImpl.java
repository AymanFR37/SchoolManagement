package ma.geo.local.school.services;

import ma.geo.local.school.dtos.MatiereDTO;
import ma.geo.local.school.dtos.SalleDTO;
import ma.geo.local.school.exceptions.DuplicateRessourceException;
import ma.geo.local.school.exceptions.ResourceNotFoundException;
import ma.geo.local.school.mappers.SalleMapper;
import ma.geo.local.school.repositories.SalleRepository;
import org.mapstruct.factory.Mappers;

import java.util.List;

public class SalleServiceImpl implements SalleService{
    private SalleRepository salleRepository;

    public SalleServiceImpl(SalleRepository salleRepository) {
        this.salleRepository = salleRepository;
    }

    private SalleMapper salleMapper = Mappers.getMapper(SalleMapper.class);

    @Override
    public SalleDTO addSalle(SalleDTO salleDTO) {
        String nomSalle = salleDTO.getNomSalle();
        if (salleRepository.existsByNomSalle(nomSalle)) {
            throw new DuplicateRessourceException("Salle already exists");
        }
        SalleDTO dto = salleMapper.salleToSalleDto(salleRepository.save(salleMapper.salleDtoToSalle(salleDTO)));
        return dto;
    }

    @Override
    public SalleDTO updateSalle(int id, SalleDTO salleDTO) {
        SalleDTO dto = salleMapper.salleToSalleDto(salleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Salle with this ID doesn't exits : "+id)));
        dto.setNomSalle(salleDTO.getNomSalle());

        SalleDTO savedDto = salleMapper.salleToSalleDto(salleRepository.save(salleMapper.salleDtoToSalle(dto)));
        return savedDto;
    }

    @Override
    public void deleteSalleById(int id) {
        SalleDTO dto = salleMapper.salleToSalleDto(salleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Salle with this ID doesn't exits : "+id)));
        salleRepository.deleteById(id);
    }

    @Override
    public List<SalleDTO> getAllSalles() {
        return salleMapper.sallesToSallesDtos(salleRepository.findAll());
    }
}
