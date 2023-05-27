package ma.geo.local.school.repositories;

import ma.geo.local.school.entities.MatiereEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatiereRepository extends JpaRepository<MatiereEntity,Integer> {
    boolean existsByNomMatiere(String nomMatiere);
}
