package com.ninjaarun.my.spring.jpa.tutorial.repository;

import com.ninjaarun.my.spring.jpa.tutorial.entity.Guardian;
import com.ninjaarun.my.spring.jpa.tutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    StudentRepository studentRepository;

//    @Test
//    public void saveStudentTest()
//    {
//        Student s = Student.builder()
//                .firstName("Arun")
//                .lastName("Kumar")
//                .emailId("ap@gmail.com")
//                .guardianName("Hritik")
//                .guardianEmail("hrx@gmail.com")
//                .guardianMobile("9898989808")
//                .build();
//
//        studentRepository.save(s);
//    }
//
//    @Test
//    public void printAllStudent(){
//        List<Student> s = studentRepository.findAll();
//        System.out.println(s);
//    }

    @Test
    public void saveStudentWithGuardian()
    {
        Guardian g = Guardian.builder()
                .name("Rohit")
                .email("rohitt@gmail.com")
                .mobile("9898987657")
                .build();

        Student s = Student.builder()
                .firstName("Neetu")
                .lastName("Yadav")
                .emailId("nyc@gmail.com")
                .guardian(g)
                .build();

        studentRepository.save(s);
    }

    @Test
    public void findByFirstName()
    {
        System.out.println(studentRepository.findByFirstNameContaining("arun"));
    }

    @Test
    public void findByIdQueryMethod()
    {
        System.out.println(studentRepository.findByIdQueryMethod(2L));
    }
}