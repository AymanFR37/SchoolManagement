package ma.geo.local.school.controllers;

import ma.geo.local.school.dtos.GroupeDTO;
import ma.geo.local.school.dtos.MatiereDTO;
import ma.geo.local.school.services.MatiereService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/matieres")
public class MatiereController {
    private MatiereService matiereService;

    public MatiereController(MatiereService matiereService) {
        this.matiereService = matiereService;
    }
    //Méthode pour Sélectionner toutes les matieres disponibles

    @GetMapping
    public ResponseEntity<List<MatiereDTO>> getAll(){
        List<MatiereDTO> allMatiere = matiereService.getAllMatieres();
        return  ResponseEntity.ok(allMatiere);
    }

    //Méthode pour ajouter une matiere

    @PostMapping("/add")
    public ResponseEntity<MatiereDTO> add(@RequestBody MatiereDTO matiereDTO){
        MatiereDTO aMatiere = matiereService.createMatiere(matiereDTO);
        return new ResponseEntity<>(aMatiere, HttpStatus.CREATED);
    }

    //Méthode pour modifier une matiere

    @PutMapping("/update/{id}")
    public ResponseEntity<MatiereDTO> update(@PathVariable int id,@RequestBody MatiereDTO matiereDTO){
        MatiereDTO updateMatiere = matiereService.updateMatiere(id, matiereDTO);
        return ResponseEntity.ok(updateMatiere);
    }

    //Méthode pour supprimer une matiere

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        matiereService.deleteMatiereById(id);
        return ResponseEntity.noContent().build();
    }
}
