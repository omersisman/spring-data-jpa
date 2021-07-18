package com.sisman.springdatajpa.repository;

import com.sisman.springdatajpa.entity.Guardian;
import com.sisman.springdatajpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .emailId("omer@gmail.com")
                .firstName("omer")
                .lastName("sisman")
                //.guardianName("faruk")
                //.guardianEmail("faruk@gmail.com")
                //.guardianMobile("9999999999999")
                .build();

        studentRepository.save(student);

    }

    @Test
    public void saveStudentWithGuardian() {
        Guardian guardian = Guardian.builder()
                .name("leyla")
                .email("leyla@gmail.com")
                .mobile("8888888888888")
                .build();

        Student student = Student.builder()
                .firstName("tugrul")
                .lastName("sisman")
                .emailId("tugrul@gmail.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student);

    }

    @Test
    public void printAllStudents(){

        List<Student> listOfStudents = studentRepository.findAll();
        System.out.println("List of Students: " + listOfStudents);

    }

    @Test
    public void printStudentByFirstName(){

        List<Student> students = studentRepository.findByFirstName("omer");
        System.out.println(students);

    }

    @Test
    public void printStudentByFirstNameContaining(){

        List<Student> students = studentRepository.findByFirstNameContaining("t");
        System.out.println(students);

    }

    @Test
    public void printStudentsLastNameNotNull(){

        List<Student> students = studentRepository.findByLastNameNotNull();
        System.out.println(students);

    }

    @Test
    public void printStudentBasedOnGuardianName(){

        List<Student> students = studentRepository.findByGuardianName("faruk");
        System.out.println(students);

    }

    @Test
    public void printStudentByFirstNameAndLastName(){

        List<Student> students = studentRepository.findByFirstNameAndLastName("omer", "sisman");
        System.out.println(students);

    }

    @Test
    public void printGetStudentByEmailAddress(){

        Student student = studentRepository.getStudentByEmailAddress("tugrul@gmail.com");
        System.out.println(student);

    }

    @Test
    public void printStudentFirstNameByLastName(){

        List<String> listOfNames = studentRepository.getStudentFirstNameByLastName("sisman");
        System.out.println(listOfNames);

    }

    @Test
    public void printGetStudentByEmailAddressNative(){

        Student student = studentRepository.getStudentByEmailAddressNative("tugrul@gmail.com");
        System.out.println(student);

    }

    @Test
    public void printGetStudentByEmailAddressNativeNamedParam(){

        Student student = studentRepository.getStudentByEmailAddressNativeNamedParam("omer@gmail.com");
        System.out.println(student);

    }

    @Test
    public void updateStudentNameByEmailId(){

        studentRepository.updateStudentNameByEmailId("omerfaruk", "omer@gmail.com");

    }

}