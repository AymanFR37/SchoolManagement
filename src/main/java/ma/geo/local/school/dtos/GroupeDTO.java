package ma.geo.local.school.dtos;




public class GroupeDTO {
    private int id;
    private String nomGrp;
    private ClassDTO classe;

    public GroupeDTO(int id, String nomGrp, ClassDTO classe) {
        this.id = id;
        this.nomGrp = nomGrp;
        this.classe = classe;
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

    public ClassDTO getClasse() {
        return classe;
    }

    public void setClasse(ClassDTO classe) {
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
