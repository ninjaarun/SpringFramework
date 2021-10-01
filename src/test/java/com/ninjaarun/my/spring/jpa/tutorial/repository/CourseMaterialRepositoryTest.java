package com.ninjaarun.my.spring.jpa.tutorial.repository;

import com.ninjaarun.my.spring.jpa.tutorial.entity.Course;
import com.ninjaarun.my.spring.jpa.tutorial.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository repository;

    @Test
    public void SaveCourseMaterial() {
        Course course =
                Course.builder()
                        .title(".net")
                        .credit(6)
                        .build();

        CourseMaterial courseMaterial =
                CourseMaterial.builder()
                        .url("www.dailycodebuffer.com")
                        .course(course)
                        .build();

        repository.save(courseMaterial);
    }

}