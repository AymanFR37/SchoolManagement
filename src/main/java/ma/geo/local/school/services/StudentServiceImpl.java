package ma.geo.local.school.services;

import ma.geo.local.school.dtos.StudentDTO;
import ma.geo.local.school.entities.StudentEntity;
import ma.geo.local.school.exceptions.DuplicateRessourceException;
import ma.geo.local.school.exceptions.ResourceNotFoundException;
import ma.geo.local.school.mappers.StudentMapper;
import ma.geo.local.school.repositories.StudentRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    private StudentMapper studentMapper= Mappers.getMapper(StudentMapper.class);



    @Override
    public List<StudentDTO> getAllStudents() {
        return studentMapper.studentsToStudentDTOs(studentRepository.findAll());
    }

    @Override
    public StudentDTO getStudentById(Long id){
        return studentMapper.studentToStudentDTO(studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found for this id :: " + id)));
    }

    @Override
    public List<StudentDTO> searchStudents(String searchTerm) {
        return studentMapper.studentsToStudentDTOs(studentRepository.findByFirstNameContainingOrLastNameContaining(searchTerm, searchTerm));
    }

    @Override
    public StudentDTO createStudent(StudentDTO studentDTO) {
        String email = studentDTO.getEmail();
        if (studentRepository.existsByEmail(email)){
            throw new DuplicateRessourceException("email already taken");
        }
        return studentMapper.studentToStudentDTO(
                studentRepository.save(studentMapper.studentDTOToStudent(studentDTO))
        );
    }

    @Override
    public StudentDTO updateStudent(Long id, StudentDTO studentDTO) {
        StudentEntity student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found for this id :: " + id));
// à verifier 
        String newEmail = studentDTO.getEmail();
        if (!student.getEmail().equals(newEmail) && studentRepository.existsByEmail(newEmail)) {
            throw new DuplicateRessourceException("Email already exists in the database");
        }

        student.setFirstName(studentDTO.getFirstName());
        student.setLastName(studentDTO.getLastName());
        student.setDateOfBirth(studentDTO.getDateOfBirth());
        student.setAddress(studentDTO.getAddress());
        student.setPhoneNumber(studentDTO.getPhoneNumber());
        student.setEmail(newEmail);
        student = studentRepository.save(student);
        return studentMapper.studentToStudentDTO(student);
    }

    @Override
    public void deleteStudent(Long id) {
        StudentEntity student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found for this id :: " + id));
        studentRepository.delete(student);

    }
}
