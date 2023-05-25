package ma.geo.local.school.services;

import ma.geo.local.school.dtos.ClassDTO;
import ma.geo.local.school.exceptions.DuplicateRessourceException;
import ma.geo.local.school.exceptions.ResourceNotFoundException;
import ma.geo.local.school.mappers.ClassMapper;
import ma.geo.local.school.repositories.ClasseRepository;
import org.mapstruct.factory.Mappers;

import java.util.List;

public class ClassServiceImpl implements ClassService {
    private ClasseRepository classeRepository;

    public ClassServiceImpl(ClasseRepository classeRepository) {
        this.classeRepository = classeRepository;
    }

    private ClassMapper classMapper = Mappers.getMapper(ClassMapper.class);

    @Override
    public ClassDTO createClass(ClassDTO classDTO) {
        String nomClass = classDTO.getNomClass();
        if (classeRepository.existsByNomClass(nomClass)) {
            throw new DuplicateRessourceException("Class already exists");
        }
        ClassDTO dto = classMapper.classToClassDto(classeRepository.save(classMapper.classDtoToClass(classDTO)));
        return dto;
    }

    @Override
    public ClassDTO updateClass(int id, ClassDTO classDTO) {
        ClassDTO dto = classMapper.classToClassDto(classeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Class with this ID doesn't exits : "+id)));
        dto.setNomClass(classDTO.getNomClass());

        ClassDTO savedDto = classMapper.classToClassDto(classeRepository.save(classMapper.classDtoToClass(dto)));
        return savedDto;
    }

    @Override
    public void deleteClassById(int id) {
        ClassDTO dto = classMapper.classToClassDto(classeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Class with this ID doesn't exits : "+id)));
        classeRepository.deleteById(id);
    }

    @Override
    public List<ClassDTO> getAllClasses() {
        return classMapper.ClassesToClassesDtos(classeRepository.findAll());
    }
}
