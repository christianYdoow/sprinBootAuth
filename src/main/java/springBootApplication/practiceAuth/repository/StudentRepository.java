package springBootApplication.practiceAuth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springBootApplication.practiceAuth.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
