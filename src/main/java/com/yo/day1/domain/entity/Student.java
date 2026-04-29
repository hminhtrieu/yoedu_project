package com.yo.day1.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.yo.day1.domain.AuditableEntity;
import com.yo.day1.domain.enums.StudentGender;
import com.yo.day1.domain.enums.StudentStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "students")
public class Student extends AuditableEntity {

    @Column(name = "student_code", columnDefinition = "varchar(20)")
    private String studentCode;

    @Column(name = "full_name", columnDefinition = "varchar(100)")
    private String fullname;

    @Column(name = "date_of_birth",columnDefinition = "date")
    private LocalDate dateOfBirth;

    @Column(name = "grade_level", columnDefinition = "varchar(30)")
    private String gradeLevel;

    @Column(name = "school_name", columnDefinition = "varchar(100)")
    private String schoolName;


    @Column(name = "latest_score", columnDefinition = "decimal(5,2)")
    private String lastScore;

    @Column(columnDefinition = "varchar(255)")
    private String note;

    @Column(columnDefinition = "varchar(20)")
    private String phone;


    @Column(columnDefinition = "enum('MALE', 'FEMALE', 'OTHER')")
    @Enumerated(EnumType.STRING)
    private StudentGender gender;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "enum('ACTIVE', 'PAUSED', 'DROPPED')")
    private StudentStatus status;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Parent parent;

}
