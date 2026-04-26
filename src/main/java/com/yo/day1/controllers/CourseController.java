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

    @GetMapping("{id}")
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

    @PutMapping("{id}")
    public ResponseEntity<ApiResponse<Course>> updateCourse(@PathVariable Long id, @RequestBody Course course)
    {
        Optional<Course> courseOptional = courseService.findById(id);
        if(courseOptional.isPresent())
        {
            Course exitsCourse = courseOptional.get();

            exitsCourse.setCourseCode(course.getCourseCode());
            exitsCourse.setName(course.getCourseCode());
            exitsCourse.setDescription(course.getDescription());
            exitsCourse.setTuitionFee(course.getTuitionFee());
            exitsCourse.setTotalSessions(course.getTotalSessions());

            Course updateCourse = courseService.save(exitsCourse);

            return ResponseEntity.ok(ApiResponse.success(updateCourse));

        }
        else
        {
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("{id}")
    public ResponseEntity<ApiResponse<String>> deleteCourse(@PathVariable Long id)
    {
        Optional<Course> course = courseService.findById(id);

        if(course.isPresent())
        {
            courseService.deleteById(id);
            return ResponseEntity.ok(ApiResponse.success("Xóa Khóa Học Thành Công!"));
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }
}
