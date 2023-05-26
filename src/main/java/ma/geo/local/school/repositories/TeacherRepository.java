package ma.geo.local.school.repositories;

import ma.geo.local.school.entities.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<TeacherEntity,String>{

    boolean existsByEmail(String email);
}