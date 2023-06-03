package ma.geo.local.school.repositories;

import ma.geo.local.school.entities.SalleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalleRepository extends JpaRepository<SalleEntity,Integer> {
    boolean existsByNomSalle(String nomSalle);
}
