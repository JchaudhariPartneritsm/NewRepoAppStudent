package com.WebApp.cruddemo;

import com.WebApp.cruddemo.dao.StudentDAO;
import com.WebApp.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLRunner(StudentDAO studentDAO) {//String[] args)

		return runner -> {
            //createStudent(studentDAO);

            //createMultipleStudents(studentDAO);

            //readStudent(studentDAO);

            queryForStudents(studentDAO);
		};
	}

    private void queryForStudents(StudentDAO studentDAO) {
        // get a list of students
        List<Student> theStudent = studentDAO.findAll();

        // display the list of students
        for (Student tempStudent: theStudent) {
            System.out.println(tempStudent);
        }

    }

    private void readStudent(StudentDAO studentDAO) {
        // create a student object
        System.out.println("Creating new student object: ");
        Student tempStudent = new Student("Kushmati","Chaudhari","kc@spring.com");

        // save the student
        System.out.println("Save the Student object: ");
        studentDAO.save(tempStudent);

        // display id of the saved student
        int theId = tempStudent.getId();
        System.out.println("The Saved Student is:" + theId);

        // retrive student based on the id: primary key
        System.out.println("Retriving the Saved Student with id: " + theId);
        Student myStudent = studentDAO.findByID(theId);

        // display the student
        System.out.println("Found the Student: " + myStudent);

    }

    private void createMultipleStudents(StudentDAO studentDAO) {
        // create multiple students
        System.out.println("Creating multiple students: ");
        Student tempStudent1 = new Student("Suchak","Chaudhari","sc@spring.com");
        Student tempStudent2 = new Student("Vasant","Chaudhari","vc@spring.com");
        Student tempStudent3 = new Student("Jyoti","Chaudhari","jcp@spring.com");

        //save the student objects
        System.out.println("Saving Multiple Students");
        studentDAO.save(tempStudent1);
        studentDAO.save(tempStudent2);
        studentDAO.save(tempStudent3);

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
