package ma.geo.local.school.services;

import ma.geo.local.school.dtos.ClassDTO;
import ma.geo.local.school.dtos.GroupeDTO;
import ma.geo.local.school.dtos.StudentDTO;
import ma.geo.local.school.exceptions.DuplicateRessourceException;
import ma.geo.local.school.exceptions.ResourceNotFoundException;
import ma.geo.local.school.mappers.ClassMapper;
import ma.geo.local.school.mappers.GroupeMapper;
import ma.geo.local.school.mappers.StudentMapper;
import ma.geo.local.school.repositories.ClasseRepository;
import ma.geo.local.school.repositories.GroupeRepository;
import ma.geo.local.school.repositories.StudentRepository;
import org.mapstruct.factory.Mappers;

import java.util.List;

public class StudentServiceImp implements StudentService{

    private StudentRepository studentRepository;
    private GroupeRepository groupeRepository;
    private ClasseRepository classeRepository;


    public StudentServiceImp(StudentRepository studentRepository, GroupeRepository groupeRepository, ClasseRepository classeRepository) {
        this.studentRepository = studentRepository;
        this.groupeRepository = groupeRepository;
        this.classeRepository = classeRepository;
    }

    private StudentMapper studentMapper= Mappers.getMapper(StudentMapper.class);
    private ClassMapper classMapper = Mappers.getMapper(ClassMapper.class);
    private GroupeMapper groupeMapper = Mappers.getMapper(GroupeMapper.class);

    @Override
    public List<StudentDTO> getAllStudents() {
        return studentMapper.studentsToStudentDTOs(studentRepository.findAll());
    }

    @Override
    public StudentDTO getStudentById(int id) {
        return studentMapper.studentToStudentDTO(
                studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not found for this id :: " +id)));
    }

    @Override
    public List<StudentDTO> searchStudents(String lastName, String nomClass, String nomGrp) {
        ClassDTO classe = classMapper.classToClassDto(classeRepository.findByNomClass(nomClass));
        GroupeDTO groupe = groupeMapper.groupeToGroupeDto(groupeRepository.findByNomGrp(nomGrp));


        return studentMapper.studentsToStudentDTOs(studentRepository.findByLastNameAndClasseAndGroupe(lastName,classe.getNomClass(),groupe.getNomGrp()));
    }

    @Override
    public StudentDTO createStudent(StudentDTO studentDTO) {
        String email = studentDTO.getEmail();
        if (studentRepository.existsByEmail(email)){
            throw new DuplicateRessourceException("email already taken");
        }
        StudentDTO dto = studentMapper.studentToStudentDTO(studentRepository.save(studentMapper.studentDTOToStudent(studentDTO)));
        return dto;
    }

    @Override
    public StudentDTO updateStudent(int id, StudentDTO studentDTO) {
        StudentDTO existStudent = studentMapper.studentToStudentDTO(studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student with this id doesn't exist : "+id)));
        existStudent.setFirstName(studentDTO.getFirstName());
        existStudent.setLastName(studentDTO.getLastName());
        existStudent.setEmail(studentDTO.getEmail());
        existStudent.setPassword(studentDTO.getPassword());
        existStudent.setSexe(studentDTO.getSexe());
        existStudent.setAddress(studentDTO.getAddress());
        existStudent.setClasse(studentDTO.getClasse());
        existStudent.setGroupe(studentDTO.getGroupe());
        StudentDTO dto = studentMapper.studentToStudentDTO(studentRepository.save(studentMapper.studentDTOToStudent(studentDTO)));
        return dto;
    }

    @Override
    public void deleteStudentById(int id) {
        studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student with this id doesn't exist : "+id));
        studentRepository.deleteById(id);
    }
}