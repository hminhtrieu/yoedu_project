package com.yo.day1.controllers;


import com.yo.day1.common.ApiResponse;
import com.yo.day1.domain.entity.Teacher;
import com.yo.day1.service.CourseService;
import com.yo.day1.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/teacher")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;
    private final CourseService courseService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Teacher>>> getAllTeacher()
    {
        return ResponseEntity.ok(ApiResponse.success(teacherService.findAll()));
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponse<Teacher>> getTeacherById(Long id)
    {
        Optional<Teacher> teacher = teacherService.findById(id);
        if(teacher.isPresent())
        {
            return ResponseEntity.ok(ApiResponse.success(teacher.get()));
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Teacher>> createTeacher(@RequestBody Teacher teacher)
    {
        return ResponseEntity.ok(ApiResponse.success(teacherService.save(teacher)));
    }

    @PutMapping("{id}")
    public ResponseEntity<ApiResponse<Teacher>> updateTeacher(@RequestBody Teacher teacher, @PathVariable Long id)
    {
        Optional<Teacher> teacherOptional = teacherService.findById(id);
        if (teacherOptional.isPresent())
        {
            Teacher exitTeacher = teacherOptional.get();
            exitTeacher.setTeacherCode(teacher.getTeacherCode());
            exitTeacher.setTeacherRole(teacher.getTeacherRole());
            exitTeacher.setFullname(teacher.getFullname());
            exitTeacher.setEmail(teacher.getEmail());
            exitTeacher.setPhone(teacher.getPhone());
            exitTeacher.setCccdImageUrl(teacher.getCccdImageUrl());

            Teacher teacherUpdate = teacherService.save(exitTeacher);

            return ResponseEntity.ok(ApiResponse.success(teacherUpdate));
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ApiResponse<String>> deleteById(@PathVariable Long id)
    {
        Optional<Teacher> teacher = teacherService.findById(id);
        if(teacher.isPresent())
        {
            teacherService.deleteById(id);
            return ResponseEntity.ok(ApiResponse.success("Xóa Teacher Thành Công"));
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }


}
