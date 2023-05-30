package ma.geo.local.school.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "teacher")
public class TeacherEntity extends UserEntity{
    @Id
    private String id;
    @OneToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST},fetch = FetchType.LAZY)
    //coté teacher : one matiere to many teachers //coté matiere : many teachers to one matiere
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
