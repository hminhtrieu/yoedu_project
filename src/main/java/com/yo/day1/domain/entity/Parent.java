package com.yo.day1.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yo.day1.domain.AuditableEntity;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "parents")
public class Parent extends AuditableEntity {
    @Column(name = "full_name", columnDefinition = "varchar(100)")
    private String fullname;

    @Column(columnDefinition = "varchar(20)")
    private String phone;

    @Column(columnDefinition = "varchar(100)")
    private String email;

    @Column(columnDefinition = "varchar(255)")
    private String address;

    @OneToMany(mappedBy = "parent")
    @JsonIgnore
    private Set<Student> students;
}
