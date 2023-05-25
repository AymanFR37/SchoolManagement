package ma.geo.local.school.controllers;


import ma.geo.local.school.dtos.StudentDTO;
import ma.geo.local.school.services.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Méthode pour créer un étudiant
    @PostMapping
    public ResponseEntity<StudentDTO> createStudent(@RequestBody StudentDTO studentDTO) {
        StudentDTO student = studentService.createStudent(studentDTO);
        return new ResponseEntity<>(student,HttpStatus.CREATED);
    }

    // Méthode pour modifier un étudiant
    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO> updateStudent(@PathVariable int id, @RequestBody StudentDTO studentDto) {
        StudentDTO updatedStudent = studentService.updateStudent(id, studentDto);
        return ResponseEntity.ok(updatedStudent);
    }

    // Méthode pour Supprimer un étudiant
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable("id") int id) {
        studentService.deleteStudentById(id);
        return ResponseEntity.noContent().build();
    }

    // Méthode pour sélectionner toutes les étudiants
    @GetMapping
    public ResponseEntity<List<StudentDTO>> getAllStudents() {
        List<StudentDTO> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    // Sélectionner un étudiant par son ID
    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable int id) {
        StudentDTO student = studentService.getStudentById(id);
        return ResponseEntity.ok(student);
    }

    //Sélectionner un étudiant par son lastName et nomClass et nomGrp
    @GetMapping("search/{lastName}/{nomClass}/{nomGrp}")
    public ResponseEntity<List<StudentDTO>> searchStudents(@RequestParam String lastName,
                                                           @RequestParam String nomClass,
                                                           @RequestParam String nomGrp) {
        List<StudentDTO> students = studentService.searchStudents(lastName,nomClass,nomGrp);
        return ResponseEntity.ok(students);
    }
}
