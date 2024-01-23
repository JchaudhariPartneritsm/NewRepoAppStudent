package com.WebApp.cruddemo;

import com.WebApp.cruddemo.dao.StudentDAO;
import com.WebApp.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLRunner(StudentDAO studentDAO) {//String[] args)

		return runner -> {
            createStudent(studentDAO);
		};
	}

    private void createStudent(StudentDAO studentDAO) {
        // create student object
        System.out.println("Creating new Student here:");
        Student tempStudent=new Student("Jidnyasa","Chauadhri","jc@spring.com");

        // save the student object
        System.out.println("Saving the Student");
        studentDAO.save(tempStudent);

        // display id of saved student
        System.out.println("Saved Student generated Id is: " +tempStudent.getId());
    }
}
