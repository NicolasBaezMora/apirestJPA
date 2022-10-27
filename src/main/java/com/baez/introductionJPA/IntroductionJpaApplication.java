package com.baez.introductionJPA;

import com.baez.introductionJPA.models.Student;
import com.baez.introductionJPA.models.Subject;
import com.baez.introductionJPA.services.ServiceLayer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class IntroductionJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntroductionJpaApplication.class, args);
	}



	@Bean
	CommandLineRunner run(ServiceLayer sl) {
		return args -> {
			sl.saveStudentRepo(Student.builder().name("Nicolas").lastname("Baez Mora").build());
			sl.saveStudentRepo(Student.builder().name("Daniela").lastname("Perez Lopez").build());
			sl.saveStudentRepo(Student.builder().name("Poncho").lastname("Alvarez Garcia").build());

			sl.saveSubjectRepo(Subject.builder().name("Matematicas").build());
			sl.saveSubjectRepo(Subject.builder().name("Ingles").build());
			sl.saveSubjectRepo(Subject.builder().name("Sociales").build());
		};
	}

}
