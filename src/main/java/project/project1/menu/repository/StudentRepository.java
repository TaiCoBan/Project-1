package project.project1.menu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.project1.menu.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    Student findById(int id);
}
