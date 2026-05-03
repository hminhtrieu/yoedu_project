package com.yo.day1.dto.student;

import com.yo.day1.domain.entity.Parent;
import com.yo.day1.domain.enums.Gender;
import com.yo.day1.domain.enums.StudentStatus;
import jakarta.validation.constraints.*;
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

    @Size(min = 2, max= 100)
    private String studentCode;

    @Size(min = 2, max= 10)
    private String fullname;


    private LocalDate dateOfBirth;


    @NotNull
    private String gradeLevel;


    private String schoolName;

    @Min(value = 0)
    @Max(value = 10)
    private BigDecimal lastScore = BigDecimal.ZERO;


    private String note;

    @Pattern(regexp = "^(84|0[35789])+([0-9]{8})$")
    @NotBlank
    private String phone;


    private Gender gender = Gender.OTHER;

    @Min(1)
    private Long parentId;


    private StudentStatus status = StudentStatus.ACTIVE;


}
