package ma.geo.local.school.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "teacher")
public class TeacherEntity extends UserEntity{
    @Id
    private String id;
    @OneToMany
    private List<MatiereEntity> matiere;

    public TeacherEntity(String firstName, String lastName, String email, String password, String sexe, String id, List<MatiereEntity> matiere) {
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
