package ma.geo.local.school.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "student")
public class StudentEntite extends UserEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate dateOfBirth;
    private String address;
    @OneToMany//cote student : one class to many students //many students to one class
    private List<ClassEntity> classe;
    @OneToMany//cote student : one groupe to many students //many students to one groupe
    private List<GroupeEntity> groupe;

    public StudentEntite(String firstName, String lastName, String email, String password, String sexe, int id, LocalDate dateOfBirth, String address, List<ClassEntity> classe, List<GroupeEntity> groupe) {
        super(firstName, lastName, email, password, sexe);
        this.id = id;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.classe = classe;
        this.groupe = groupe;
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

    public List<ClassEntity> getClasse() {
        return classe;
    }

    public void setClasse(List<ClassEntity> classe) {
        this.classe = classe;
    }

    public List<GroupeEntity> getGroupe() {
        return groupe;
    }

    public void setGroupe(List<GroupeEntity> groupe) {
        this.groupe = groupe;
    }

    @Override
    public String toString() {
        return "StudentEntite{" +
                "id=" + id +
                ", dateOfBirth=" + dateOfBirth +
                ", address='" + address + '\'' +
                ", classe=" + classe +
                ", groupe=" + groupe +
                '}';
    }
}
