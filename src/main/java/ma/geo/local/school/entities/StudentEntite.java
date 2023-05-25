package ma.geo.local.school.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "student")
public class StudentEntite extends UserEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate dateOfBirth;
    private String address;
    @ManyToOne
    private ClassEntity classe;
    @ManyToOne
    private GroupeEntity groupeEntity;

    public StudentEntite(String firstName, String lastName, String email, String password, String sexe, int id, LocalDate dateOfBirth, String address, ClassEntity classe, GroupeEntity groupeEntity) {
        super(firstName, lastName, email, password, sexe);
        this.id = id;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.classe = classe;
        this.groupeEntity = groupeEntity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ClassEntity getClasse() {
        return classe;
    }

    public void setClasse(ClassEntity classe) {
        this.classe= classe;
    }

    public GroupeEntity getGroupeEntity() {
        return groupeEntity;
    }

    public void setGroupeEntity(GroupeEntity groupeEntity) {
        this.groupeEntity = groupeEntity;
    }

    @Override
    public String toString() {
        return "StudentEntite{" +
                "id=" + id +
                ", dateOfBirth=" + dateOfBirth +
                ", address='" + address + '\'' +
                ", classe=" + classe +
                ", groupeEntity=" + groupeEntity +
                '}';
    }
}
