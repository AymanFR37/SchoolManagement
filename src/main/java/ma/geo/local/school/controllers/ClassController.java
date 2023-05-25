package ma.geo.local.school.controllers;

import ma.geo.local.school.dtos.ClassDTO;
import ma.geo.local.school.services.ClassService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classes")
public class ClassController {
    private ClassService classService;

    public ClassController(ClassService classService) {
        this.classService = classService;
    }

    //Méthode pour Sélectionner toutes les classes disponibles
    @GetMapping
    public ResponseEntity<List<ClassDTO>> getAll(){
        List<ClassDTO> allClasses = classService.getAllClasses();
        return  ResponseEntity.ok(allClasses);
    }

    //Méthode pour ajouter une classe
    @PostMapping("/add")
    public ResponseEntity<ClassDTO> add(@RequestBody ClassDTO classDTO){
        ClassDTO aClass = classService.createClass(classDTO);
        return new ResponseEntity<>(aClass, HttpStatus.CREATED);
    }

    //Méthode pour modifier une classe
    @PutMapping("/update/{id}")
    public ResponseEntity<ClassDTO> update(@PathVariable int id,@RequestBody ClassDTO classDTO){
        ClassDTO updateClass = classService.updateClass(id, classDTO);
        return ResponseEntity.ok(updateClass);
    }

    //Méthode pour supprimer une classe
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        classService.deleteClassById(id);
        return ResponseEntity.noContent().build();
    }
}
