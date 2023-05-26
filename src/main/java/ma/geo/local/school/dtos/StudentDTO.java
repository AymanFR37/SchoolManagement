package ma.geo.local.school.dtos;



import java.time.LocalDate;
import java.util.List;


public class StudentDTO extends UserDTO {
    private int id;
    private LocalDate dateOfBirth;
    private String address;
    private List<ClassDTO> classe;
    private List<GroupeDTO> groupe;

    public StudentDTO(String firstName, String lastName, String email, String password, String sexe, int id, LocalDate dateOfBirth, String address, List<ClassDTO> classe, List<GroupeDTO> groupe) {
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

    public List<ClassDTO> getClasse() {
        return classe;
    }

    public void setClasse(List<ClassDTO> classe) {
        this.classe = classe;
    }

    public List<GroupeDTO> getGroupe() {
        return groupe;
    }

    public void setGroupe(List<GroupeDTO> groupe) {
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
