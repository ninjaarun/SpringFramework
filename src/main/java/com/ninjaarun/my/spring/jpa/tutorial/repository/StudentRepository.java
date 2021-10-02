package com.ninjaarun.my.spring.jpa.tutorial.repository;

import com.ninjaarun.my.spring.jpa.tutorial.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    public List<Student> findByFirstNameContaining(String firstName);

    @Query(value = " select * from mycustom_table where student_id= :emailId", nativeQuery = true)
    Student findByIdQueryMethod(@Param("emailId") Long i);


//    boolean findByFirstNameContaining(String arun);
}
