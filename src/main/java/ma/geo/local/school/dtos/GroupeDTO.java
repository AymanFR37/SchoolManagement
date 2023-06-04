package ma.geo.local.school.dtos;


import java.util.List;

public class GroupeDTO {
    private int id;
    private String nomGrp;
    private List<ClassDTO> classe;

    public GroupeDTO(int id, String nomGrp, List<ClassDTO> classe) {
        this.id = id;
        this.nomGrp = nomGrp;
        this.classe = classe;
    }

    public GroupeDTO() {
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

    public List<ClassDTO> getClasse() {
        return classe;
    }

    public void setClasse(List<ClassDTO> classe) {
        this.classe = classe;
    }

    @Override
    public String toString() {
        return "GroupeDTO{" +
                "id=" + id +
                ", nomGrp='" + nomGrp + '\'' +
                ", classe=" + classe +
                '}';
    }
}
