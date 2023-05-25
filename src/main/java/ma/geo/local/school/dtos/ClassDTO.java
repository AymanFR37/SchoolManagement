package ma.geo.local.school.dtos;

public class ClassDTO {
    private int id;
    private String nomClass;

    public ClassDTO(int id, String nomClass) {
        this.id = id;
        this.nomClass = nomClass;
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
        return "ClassDTO{" +
                "id=" + id +
                ", nomClass='" + nomClass + '\'' +
                '}';
    }
}
