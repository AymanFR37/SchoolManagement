package ma.geo.local.school.dtos;



import java.time.LocalDate;


public class StudentDTO extends UserDTO {
    private int id;
    private LocalDate dateOfBirth;
    private String address;
    private ClassDTO classe;
    private GroupeDTO groupe;

    public StudentDTO(String firstName, String lastName, String email, String password, String sexe, int id, LocalDate dateOfBirth, String address, ClassDTO classe, GroupeDTO groupe) {
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

    public ClassDTO getClasse() {
        return classe;
    }

    public void setClasse(ClassDTO classe) {
        this.classe = classe;
    }

    public GroupeDTO getGroupe() {
        return groupe;
    }

    public void setGroupe(GroupeDTO groupe) {
        this.groupe = groupe;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "id=" + id +
                ", dateOfBirth=" + dateOfBirth +
                ", address='" + address + '\'' +
                ", classe=" + classe +
                ", groupe=" + groupe +
                '}';
    }
}
