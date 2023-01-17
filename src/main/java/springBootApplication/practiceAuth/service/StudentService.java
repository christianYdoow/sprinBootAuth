package springBootApplication.practiceAuth.service;

import springBootApplication.practiceAuth.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    String newStudent(Long id,String studentFirstName,
                    String studentLastName,
                    String studentCourse,
                    String studentEmail,
                    String studentGpa);

    Optional<Student> findStudentById(Long id);

    List<Student> findAllStudent();

    Student updateStudent(Student student,Long id);

    void deleteStudent(Long id);



}
