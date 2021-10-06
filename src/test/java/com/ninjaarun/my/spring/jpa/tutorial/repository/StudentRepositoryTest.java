package com.ninjaarun.my.spring.jpa.tutorial.repository;

import com.ninjaarun.my.spring.jpa.tutorial.entity.Guardian;
import com.ninjaarun.my.spring.jpa.tutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
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

        List<Student> results = studentRepository.findByFirstNameContaining("Neetu");
        assertFalse(results.isEmpty());
    }

    @Test
    public void findByFirstName()
    {
        assertTrue(studentRepository.findByFirstNameContaining("arun").isEmpty());
    }

    @Test
    public void findByIdQueryMethod()
    {
        Student result = studentRepository.findByIdQueryMethod(2L);
        assertNull(result);
    }
}