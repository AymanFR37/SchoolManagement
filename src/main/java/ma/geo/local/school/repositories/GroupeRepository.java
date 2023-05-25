package ma.geo.local.school.repositories;

import ma.geo.local.school.entities.GroupeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupeRepository extends JpaRepository<GroupeEntity,Integer> {
    GroupeEntity findByNomGrp(String nomGrp);
}
