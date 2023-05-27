package ma.geo.local.school.controllers;

import ma.geo.local.school.dtos.StudentDTO;
import ma.geo.local.school.dtos.TeacherDTO;
import ma.geo.local.school.services.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/teachers")
public class TeacherController {
    private TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    // Méthode pour créer un enseignant
    @PostMapping
    public ResponseEntity<TeacherDTO> addTeacher(@RequestBody TeacherDTO teacherDTO) {
        TeacherDTO teacher = teacherService.addTeacher(teacherDTO);
        return new ResponseEntity<>(teacher, HttpStatus.CREATED);
    }

    // Méthode pour modifier un enseignant
    @PutMapping("/{id}")
    public ResponseEntity<TeacherDTO> updateTeacher(@PathVariable String id, @RequestBody TeacherDTO teacherDTO) {
        TeacherDTO updatedTeacher = teacherService.updateTeacher(id, teacherDTO);
        return ResponseEntity.ok(updatedTeacher);
    }

    // Méthode pour Supprimer un enseignant
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeacher(@PathVariable("id") String id) {
        teacherService.deleteTeacherById(id);
        return ResponseEntity.noContent().build();
    }

    // Méthode pour sélectionner toutes les enseignants
    @GetMapping
    public ResponseEntity<List<TeacherDTO>> getAllTeachers() {
        List<TeacherDTO> teachers = teacherService.getAllTeachers();
        return ResponseEntity.ok(teachers);
    }

    // Sélectionner un enseignant par son ID
    @GetMapping("/{id}")
    public ResponseEntity<TeacherDTO> getTeacherById(@PathVariable String id) {
        TeacherDTO teacher = teacherService.getTeacherById(id);
        return ResponseEntity.ok(teacher);
    }
}
