package ma.geo.local.school.repositories;

import ma.geo.local.school.entities.GroupeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GroupeRepository extends JpaRepository<GroupeEntity,Integer> {
    GroupeEntity findByNomGrp(String nomGrp);
    boolean existsByNomGrp(String nomGrp);
    Optional<GroupeEntity> findById(int id);
}
