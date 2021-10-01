package com.ninjaarun.my.spring.jpa.tutorial.repository;

import com.ninjaarun.my.spring.jpa.tutorial.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
