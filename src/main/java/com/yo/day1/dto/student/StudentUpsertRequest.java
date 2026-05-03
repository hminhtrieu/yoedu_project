package com.yo.day1.dto.student;

import com.yo.day1.domain.entity.Parent;
import com.yo.day1.domain.enums.Gender;
import com.yo.day1.domain.enums.StudentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentUpsertRequest {

    private String studentCode;


    private String fullname;


    private LocalDate dateOfBirth;

    private String gradeLevel;


    private String schoolName;


    private BigDecimal lastScore = BigDecimal.ZERO;


    private String note;


    private String phone;


    private Gender gender = Gender.OTHER;

    private Long parentId;

    private StudentStatus status = StudentStatus.ACTIVE;


}
