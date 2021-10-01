package com.ninjaarun.my.spring.jpa.tutorial.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(
        name = "mycustom_table",
        uniqueConstraints = @UniqueConstraint(
                name = "emailid_unique",
                columnNames = "first_name"
        )

)

public class Student {

    @Id
    @SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
    private Long studentId;
    @Column(name = "first_name")
    private String firstName;
    private String lastName;

    @Column(name = "improved_emailId", nullable = false)
    private String emailId;

    @Embedded
    private Guardian guardian;
}
