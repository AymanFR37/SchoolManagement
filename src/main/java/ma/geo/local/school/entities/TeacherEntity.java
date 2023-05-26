package ma.geo.local.school.entities;

import javax.persistence.OneToMany;
import java.util.List;

public class TeacherEntity extends UserEntity{
    private int id;
    @OneToMany
    private List<MatiereEntity> matiere;

    public TeacherEntity(String firstName, String lastName, String email, String password, String sexe, int id, List<MatiereEntity> matiere) {
        super(firstName, lastName, email, password, sexe);
        this.id = id;
        this.matiere = matiere;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<MatiereEntity> getMatiere() {
        return matiere;
    }

    public void setMatiere(List<MatiereEntity> matiere) {
        this.matiere = matiere;
    }

    @Override
    public String toString() {
        return "TeacherEntity{" +
                "id=" + id +
                ", matiere=" + matiere +
                '}';
    }
}
