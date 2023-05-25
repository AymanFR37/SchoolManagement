package ma.geo.local.school.controllers;

import ma.geo.local.school.dtos.GroupeDTO;
import ma.geo.local.school.services.GroupeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groupes")
public class GroupeController {
    private GroupeService groupeService;

    public GroupeController(GroupeService groupeService) {
        this.groupeService = groupeService;
    }

    //Méthode pour Sélectionner toutes les groupes disponibles

    @GetMapping
    public ResponseEntity<List<GroupeDTO>> getAll(){
        List<GroupeDTO> allGroupes = groupeService.getAllGroupes();
        return  ResponseEntity.ok(allGroupes);
    }

    //Méthode pour ajouter un groupe

    @PostMapping("/add")
    public ResponseEntity<GroupeDTO> add(@RequestBody GroupeDTO groupeDTO){
        GroupeDTO aGroupe = groupeService.createGroupe(groupeDTO);
        return new ResponseEntity<>(aGroupe, HttpStatus.CREATED);
    }

    //Méthode pour modifier un groupe

    @PutMapping("/update/{id}")
    public ResponseEntity<GroupeDTO> update(@PathVariable int id,@RequestBody GroupeDTO groupeDTO){
        GroupeDTO updateGroupe = groupeService.updateGroupe(id, groupeDTO);
        return ResponseEntity.ok(updateGroupe);
    }

    //Méthode pour supprimer un groupe

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        groupeService.deleteGroupeById(id);
        return ResponseEntity.noContent().build();
    }
}
