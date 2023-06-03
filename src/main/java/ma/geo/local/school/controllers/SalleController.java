package ma.geo.local.school.controllers;

import ma.geo.local.school.dtos.SalleDTO;
import ma.geo.local.school.services.SalleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/salles")
public class SalleController {
    private SalleService salleService;

    public SalleController(SalleService salleService) {
        this.salleService = salleService;
    }

    //Méthode pour Sélectionner toutes les salles disponibles
    @GetMapping
    public ResponseEntity<List<SalleDTO>> getAll(){
        List<SalleDTO> allSalles = salleService.getAllSalles();
        return  ResponseEntity.ok(allSalles);
    }

    //Méthode pour ajouter une salle
    @PostMapping("/add")
    public ResponseEntity<SalleDTO> add(@RequestBody SalleDTO salleDTO){
        SalleDTO aSalle = salleService.addSalle(salleDTO);
        return new ResponseEntity<>(aSalle, HttpStatus.CREATED);
    }

    //Méthode pour modifier une salle
    @PutMapping("/update/{id}")
    public ResponseEntity<SalleDTO> update(@PathVariable int id,@RequestBody SalleDTO salleDTO){
        SalleDTO updateSalle = salleService.updateSalle(id, salleDTO);
        return ResponseEntity.ok(updateSalle);
    }

    //Méthode pour supprimer une salle
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        salleService.deleteSalleById(id);
        return ResponseEntity.noContent().build();
    }
}
