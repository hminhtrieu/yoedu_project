package com.yo.day1.controllers;

import com.yo.day1.common.ApiResponse;
import com.yo.day1.domain.entity.Course;
import com.yo.day1.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/course")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Course>>> getCourse()
    {
        return ResponseEntity.ok(ApiResponse.success(courseService.findAll()));
    }

    @GetMapping("/course/{id}")
    public ResponseEntity<ApiResponse<Course>> getCourseById(Long id)
    {
//        return courseService.findById(id).map(value -> ResponseEntity.ok(ApiResponse.success(value)))
//                .orElseGet(() -> ResponseEntity.notFound().build());
        Optional<Course> course = courseService.findById(id);
        if(course.isPresent())
        {
            return ResponseEntity.ok(ApiResponse.success(course.get()));
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Course>> createCourse(@RequestBody Course course)
    {
        return ResponseEntity.ok(ApiResponse.success(courseService.save(course)));
    }
}
