package springBootApplication.practiceAuth;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import springBootApplication.practiceAuth.model.Student;
import springBootApplication.practiceAuth.repository.StudentRepository;

@SpringBootApplication
public class PracticeAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticeAuthApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(StudentRepository studentRepository) {
		return args -> {
			studentRepository.save(new Student(1L,"Chris", "Sandoval","BSBA","chris@gmail.com","1.50"));
			studentRepository.save(new Student(2L,"yd", "Smith","BSBA","yd@gmail.com","1.75"));
			studentRepository.save(new Student(3L,"kd", "Durant","BSBA","kd@gmail.com","2.50"));
		};
	}
}
