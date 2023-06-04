package ma.geo.local.school.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "groupe")
public class GroupeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nomGrp;
    @OneToMany(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
    private List<ClassEntity> classe;

    public GroupeEntity(int id, String nomGrp, List<ClassEntity> classe) {
        this.id = id;
        this.nomGrp = nomGrp;
        this.classe = classe;
    }

    public GroupeEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomGrp() {
        return nomGrp;
    }

    public void setNomGrp(String nomGrp) {
        this.nomGrp = nomGrp;
    }

    public List<ClassEntity> getClasse() {
        return classe;
    }

    public void setClasse(List<ClassEntity> classe) {
        this.classe = classe;
    }

    @Override
    public String toString() {
        return "GroupeEntity{" +
                "id=" + id +
                ", nomGrp='" + nomGrp + '\'' +
                ", classEntity=" + classe +
                '}';
    }
}
