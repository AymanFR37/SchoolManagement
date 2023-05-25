package ma.geo.local.school.repositories;

import ma.geo.local.school.entities.ClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClasseRepository extends JpaRepository<ClassEntity,Integer> {
    ClassEntity findByNomClass(String nomClass);

}
