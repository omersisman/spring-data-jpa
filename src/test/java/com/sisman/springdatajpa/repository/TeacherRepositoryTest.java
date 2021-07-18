package com.sisman.springdatajpa.repository;

import com.sisman.springdatajpa.entity.Course;
import com.sisman.springdatajpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){

        Course course1 = Course.builder()
                .title("PHYS202")
                .credit(4)
                .build();

        Course course2 = Course.builder()
                .title("CMPE240")
                .credit(4)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("ibrahim")
                .lastName("kabasakal")
                .courseList(List.of(course1,course2))
                .build();

        teacherRepository.save(teacher);

    }

}