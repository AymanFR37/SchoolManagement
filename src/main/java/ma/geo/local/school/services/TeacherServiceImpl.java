package ma.geo.local.school.services;


import ma.geo.local.school.dtos.TeacherDTO;
import ma.geo.local.school.exceptions.DuplicateRessourceException;
import ma.geo.local.school.exceptions.ResourceNotFoundException;
import ma.geo.local.school.mappers.TeacherMapper;
import ma.geo.local.school.repositories.TeacherRepository;
import org.mapstruct.factory.Mappers;

import java.util.List;

public class TeacherServiceImpl implements TeacherService{
    private TeacherRepository teacherRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    private TeacherMapper teacherMapper = Mappers.getMapper(TeacherMapper.class);

    @Override
    public List<TeacherDTO> getAllTeachers() {
        return teacherMapper.teachersToTeacherDTOs(teacherRepository.findAll());
    }

    @Override
    public TeacherDTO getTeacherById(String id) {
        return teacherMapper.teacherToTeacherDTO(
                teacherRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Teacher not found for this CIN :: " +id)));
    }

    @Override
    public TeacherDTO addTeacher(TeacherDTO teacherDTO) {
        String email = teacherDTO.getEmail();
        if (teacherRepository.existsByEmail(email)){
            throw new DuplicateRessourceException("email already taken");
        }
        TeacherDTO dto = teacherMapper.teacherToTeacherDTO(teacherRepository.save(teacherMapper.teacherDtoToTeacher(teacherDTO)));
        return dto;
    }

    @Override
    public TeacherDTO updateTeacher(String id, TeacherDTO teacherDTO) {
        TeacherDTO existTeacher = teacherMapper.teacherToTeacherDTO(teacherRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Teacher with this CIN doesn't exist : "+id)));

        existTeacher.setId(teacherDTO.getId());
        existTeacher.setFirstName(teacherDTO.getFirstName());
        existTeacher.setLastName(teacherDTO.getLastName());
        existTeacher.setEmail(teacherDTO.getEmail());
        existTeacher.setPassword(teacherDTO.getPassword());
        existTeacher.setSexe(teacherDTO.getSexe());
        existTeacher.setMatiere(teacherDTO.getMatiere());

        TeacherDTO dto = teacherMapper.teacherToTeacherDTO(teacherRepository.save(teacherMapper.teacherDtoToTeacher(teacherDTO)));
        return dto;
    }

    @Override
    public void deleteTeacherById(String id) {
        teacherRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Teacher with this CIN doesn't exist : "+id));
        teacherRepository.deleteById(id);
    }
}