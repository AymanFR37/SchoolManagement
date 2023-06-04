package ma.geo.local.school.dtos;

import java.util.List;

public class TeacherDTO extends UserDTO{
    private String id;
    private List<MatiereDTO> matiere;

    public TeacherDTO(String firstName, String lastName, String email, String password, String sexe, String id, List<MatiereDTO> matiere) {
        super(firstName, lastName, email, password, sexe);
        this.id = id;
        this.matiere = matiere;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<MatiereDTO> getMatiere() {
        return matiere;
    }

    public void setMatiere(List<MatiereDTO> matiere) {
        this.matiere = matiere;
    }

    @Override
    public String toString() {
        return "TeacherDTO{" +
                "id=" + id +
                ", matiere=" + matiere +
                '}';
    }
}
