package ma.geo.local.school.repositories;

import ma.geo.local.school.entities.ClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClasseRepository extends JpaRepository<ClassEntity,Integer> {
    ClassEntity findByNomClass(String nomClass);
    boolean existsByNomClass(String nomClass);
    Optional<ClassEntity> findById(int id);

}
