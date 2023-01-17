package springBootApplication.practiceAuth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springBootApplication.practiceAuth.model.Student;
import springBootApplication.practiceAuth.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;



    @Override
    public String newStudent(Long id, String studentFirstName, String studentLastName, String studentCourse, String studentEmail, String studentGpa) {
        Student newStudent=new Student();
        newStudent.setId(id);
        newStudent.setStudentFirstName(studentFirstName);
        newStudent.setStudentLastName(studentLastName);
        newStudent.setStudentCourse(studentCourse);
        newStudent.setStudentEmail(studentEmail);
        newStudent.setStudentGpa(studentGpa);
        studentRepository.save(newStudent);

        return "data saved";
    }

    @Override
    public Optional<Student> findStudentById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public List<Student> findAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Student updateStudent(Student student, Long id) {
        return studentRepository.findById(id).map(x->{
            x.setStudentFirstName(student.getStudentFirstName());
            x.setStudentLastName(student.getStudentLastName());
            x.setStudentCourse(student.getStudentCourse());
            x.setStudentEmail(student.getStudentEmail());
            x.setStudentGpa(student.getStudentGpa());
            return studentRepository.save(x);
        }) .orElseGet(()->{
            student.setId(id);
            return studentRepository.save(student);
        });
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
