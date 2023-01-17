package springBootApplication.practiceAuth.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springBootApplication.practiceAuth.model.Student;
import springBootApplication.practiceAuth.service.StudentServiceImpl;

import java.util.List;
import java.util.Optional;

@RestController
@Validated
public class StudentController {
    @Autowired
    private StudentServiceImpl studentServiceImpl;

    @GetMapping("/students")
    List<Student> findAllStudent(){
        return studentServiceImpl.findAllStudent();
    }
    @GetMapping("/student/{id}")
    Optional<Student> findStudentById(@PathVariable @Min(1) Long id){
        return studentServiceImpl.findStudentById(id);
    }
    @PostMapping("students")
    @ResponseStatus(HttpStatus.CREATED)
    public String newStudent(@Valid  @RequestParam Long id,
                             @RequestParam String studentFirstName,
                             @RequestParam String studentLastName,
                             @RequestParam String studentCourse,
                             @RequestParam String studentEmail,
                             @RequestParam String studentGpa){
       return  studentServiceImpl.newStudent(id,studentFirstName,studentLastName,studentCourse,studentEmail,studentGpa);
    }

    @PutMapping("/students/{id}")
    public Student updateStudent(@RequestBody Student student,@PathVariable Long id){
        return studentServiceImpl.updateStudent(student,id);
    }

    @DeleteMapping("/students/{id}")
    void deleteStudent(@PathVariable long id){
            studentServiceImpl.deleteStudent(id);
    }



}
