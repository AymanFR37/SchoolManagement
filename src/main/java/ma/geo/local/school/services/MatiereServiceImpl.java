package ma.geo.local.school.services;

import ma.geo.local.school.dtos.MatiereDTO;
import ma.geo.local.school.exceptions.DuplicateRessourceException;
import ma.geo.local.school.exceptions.ResourceNotFoundException;
import ma.geo.local.school.mappers.MatiereMapper;
import ma.geo.local.school.repositories.MatiereRepository;
import org.mapstruct.factory.Mappers;

import java.util.List;

public class MatiereServiceImpl implements MatiereService{
    private MatiereRepository matiereRepository;

    public MatiereServiceImpl(MatiereRepository matiereRepository) {
        this.matiereRepository = matiereRepository;
    }
    private MatiereMapper matiereMapper = Mappers.getMapper(MatiereMapper.class);

    @Override
    public MatiereDTO createMatiere(MatiereDTO matiereDTO) {
        String nomMatiere = matiereDTO.getNomMatiere();
        if (matiereRepository.existsByNomMatiere(nomMatiere)) {
            throw new DuplicateRessourceException("Matiere already exists");
        }
        MatiereDTO dto = matiereMapper.matiereToMatiereDto(matiereRepository.save(matiereMapper.matiereDtoToMatiere(matiereDTO)));
        return dto;
    }

    @Override
    public MatiereDTO updateMatiere(int id, MatiereDTO matiereDTO) {
        MatiereDTO dto = matiereMapper.matiereToMatiereDto(matiereRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Matiere with this ID doesn't exits : "+id)));
        dto.setNomMatiere(matiereDTO.getNomMatiere());

        MatiereDTO savedDto = matiereMapper.matiereToMatiereDto(matiereRepository.save(matiereMapper.matiereDtoToMatiere(dto)));
        return savedDto;
    }

    @Override
    public void deleteMatiereById(int id) {
        MatiereDTO dto = matiereMapper.matiereToMatiereDto(matiereRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Matiere with this ID doesn't exits : "+id)));
        matiereRepository.deleteById(id);
    }

    @Override
    public List<MatiereDTO> getAllMatieres() {
        return matiereMapper.matieresToMatieresDtos(matiereRepository.findAll());
    }
}
