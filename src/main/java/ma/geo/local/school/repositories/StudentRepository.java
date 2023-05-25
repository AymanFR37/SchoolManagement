package ma.geo.local.school.repositories;

import ma.geo.local.school.entities.StudentEntite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntite,Integer> {
    List<StudentEntite> findByLastNameAndClasseAndGroupe(String lastName, String classe, String groupe);
    Optional<StudentEntite> findById(int id);
    boolean existsByEmail(String email);
}
