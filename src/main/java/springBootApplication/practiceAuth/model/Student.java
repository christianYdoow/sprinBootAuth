package springBootApplication.practiceAuth.model;

import com.fasterxml.jackson.databind.deser.Deserializers;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String studentFirstName;

    private String studentLastName;

    private String studentCourse;
    private String studentEmail;
    private String studentGpa;

    public Student() {
    }

    public Student(Long id, String studentFirstName, String studentLastName, String studentCourse, String studentEmail, String studentGpa) {
        this.id = id;
        this.studentFirstName = studentFirstName;
        this.studentLastName = studentLastName;
        this.studentCourse = studentCourse;
        this.studentEmail = studentEmail;
        this.studentGpa = studentGpa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentFirstName() {
        return studentFirstName;
    }

    public void setStudentFirstName(String studentFirstName) {
        this.studentFirstName = studentFirstName;
    }

    public String getStudentLastName() {
        return studentLastName;
    }

    public void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
    }

    public String getStudentCourse() {
        return studentCourse;
    }

    public void setStudentCourse(String studentCourse) {
        this.studentCourse = studentCourse;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getStudentGpa() {
        return studentGpa;
    }

    public void setStudentGpa(String studentGpa) {
        this.studentGpa = studentGpa;
    }
}
