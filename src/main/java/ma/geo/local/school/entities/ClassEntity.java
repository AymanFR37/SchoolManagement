package ma.geo.local.school.entities;

import javax.persistence.*;

@Entity
@Table(name = "classe")
public class ClassEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nomClass;

    public ClassEntity(int id, String nomClass) {
        this.id = id;
        this.nomClass = nomClass;
    }

    public ClassEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomClass() {
        return nomClass;
    }

    public void setNomClass(String nomClass) {
        this.nomClass = nomClass;
    }

    @Override
    public String toString() {
        return "ClassEntity{" +
                "id=" + id +
                ", nomClass='" + nomClass + '\'' +
                '}';
    }
}
