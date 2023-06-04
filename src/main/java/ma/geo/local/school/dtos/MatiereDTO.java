package ma.geo.local.school.dtos;

public class MatiereDTO {
    private int id;
    private String nomMatiere;

    public MatiereDTO(int id, String nomMatiere) {
        this.id = id;
        this.nomMatiere = nomMatiere;
    }

    public MatiereDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomMatiere() {
        return nomMatiere;
    }

    public void setNomMatiere(String nomMatiere) {
        this.nomMatiere = nomMatiere;
    }

    @Override
    public String toString() {
        return "MatiereDTO{" +
                "id=" + id +
                ", nomMatiere='" + nomMatiere + '\'' +
                '}';
    }
}
