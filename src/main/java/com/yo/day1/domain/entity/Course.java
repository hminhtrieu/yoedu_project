package com.yo.day1.domain.entity;

import com.yo.day1.domain.AuditableEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Course extends AuditableEntity {
    @Column(columnDefinition = "varchar(20)")
    private String courseCode;
    @Column(columnDefinition = "varchar(100)")
    private String name;
    @Column(columnDefinition = "text")
    private String decsciption;
    private double tuitionFee;

    private int totalSessions;
    private byte isActive;
}
