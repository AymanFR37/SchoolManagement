package ma.geo.local.school.repositories;

import ma.geo.local.school.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity,Long> {
    List<StudentEntity> findByFirstNameContainingOrLastNameContaining(String searchTerm, String searchTerm1);
    Optional<StudentEntity> findById(Long id);


    boolean existsByEmail(String email);
}
