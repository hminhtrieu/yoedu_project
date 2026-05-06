package com.yo.day1.controllers;

import com.yo.day1.dto.teacher.TeacherResponse;
import com.yo.day1.dto.teacher.TeacherUpsertRequest;
import com.yo.day1.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/teacher")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;

    @GetMapping
    public ResponseEntity<List<TeacherResponse>> findAll()
    {
        return ResponseEntity.ok(teacherService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<TeacherResponse> findById(@PathVariable Long id)
    {
        return teacherService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TeacherResponse> create(@RequestBody TeacherUpsertRequest request)
    {
        return ResponseEntity.ok(teacherService.create(request));
    }

    @PutMapping("{id}")
    public ResponseEntity<TeacherResponse> update(TeacherUpsertRequest request, @PathVariable Long id)
    {
        return ResponseEntity.ok(teacherService.update(id,request));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id)
    {
        teacherService.deleteById(id);
        return ResponseEntity.ok("Xoa Teacher Thanh Cong");
    }
}

