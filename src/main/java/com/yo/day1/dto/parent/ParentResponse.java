package com.yo.day1.dto.parent;


import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParentResponse {

    private Long id;

    private String fullname;

    private String phone;

    private String email;

    private String address;

    private String relationship;
}
