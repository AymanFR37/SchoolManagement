package ma.geo.local.school.dtos;

public class SalleDTO {
    private int id;
    private String nomSalle;

    public SalleDTO(int id, String nomSalle) {
        this.id = id;
        this.nomSalle = nomSalle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomSalle() {
        return nomSalle;
    }

    public void setNomSalle(String nomSalle) {
        this.nomSalle = nomSalle;
    }

    @Override
    public String toString() {
        return "SalleDTO{" +
                "id=" + id +
                ", nomSalle='" + nomSalle + '\'' +
                '}';
    }
}
