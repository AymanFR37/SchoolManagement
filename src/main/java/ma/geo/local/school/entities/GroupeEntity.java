package ma.geo.local.school.entities;

import javax.persistence.*;

@Entity
@Table(name = "groupe")
public class GroupeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nomGrp;
    @ManyToOne
    private ClassEntity classEntity;

    public GroupeEntity(int id, String nomGrp, ClassEntity classEntity) {
        this.id = id;
        this.nomGrp = nomGrp;
        this.classEntity = classEntity;
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

    public ClassEntity getClassEntity() {
        return classEntity;
    }

    public void setClassEntity(ClassEntity classEntity) {
        this.classEntity = classEntity;
    }

    @Override
    public String toString() {
        return "GroupeEntity{" +
                "id=" + id +
                ", nomGrp='" + nomGrp + '\'' +
                ", classEntity=" + classEntity +
                '}';
    }
}
