package com.yo.day1.controllers;

import com.yo.day1.common.ApiResponse;
import com.yo.day1.domain.entity.Student;
import com.yo.day1.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/student")
@AllArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Student>>> findAll()
    {
        return ResponseEntity.ok(ApiResponse.success(studentService.findAll()));
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponse<Student>> getStudentById(@PathVariable Long id)
    {
        Optional<Student> student = studentService.findById(id);
        if (student.isPresent())
        {
            return ResponseEntity.ok(ApiResponse.success(student.get()));
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Student>> createStudent(@RequestBody Student student)
    {
        return ResponseEntity.ok(ApiResponse.success(studentService.save(student)));
    }

    @PutMapping("{id}")
    public ResponseEntity<ApiResponse<Student>> updateStudent(@RequestBody Student student, @PathVariable Long id)
    {
        Optional<Student> updateOptional = studentService.findById(id);
        if(updateOptional.isPresent())
        {
            Student exitStudent = updateOptional.get();

            exitStudent.setStudentCode(student.getStudentCode());
            exitStudent.setFullname(student.getFullname());
            exitStudent.setNote(student.getNote());
            exitStudent.setGender(student.getGender());
            exitStudent.setPhone(student.getPhone());
            exitStudent.setStatus(student.getStatus());
            exitStudent.setDateOfBirth(student.getDateOfBirth());
            exitStudent.setGradeLevel(student.getGradeLevel());
            exitStudent.setLastScore(student.getLastScore());
            exitStudent.setParent(student.getParent());
            exitStudent.setSchoolName(student.getSchoolName());

            Student updateStudent = studentService.save(exitStudent);

            return ResponseEntity.ok(ApiResponse.success(updateStudent));

        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ApiResponse<String>> deleteById(@PathVariable Long id)
    {
        Optional<Student> student = studentService.findById(id);
        if(student.isPresent())
        {
            studentService.deleteById(id);
            return ResponseEntity.ok(ApiResponse.success("Xóa Student Thành Công!"));
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }
}
