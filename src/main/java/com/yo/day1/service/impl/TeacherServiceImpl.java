package com.yo.day1.service.impl;

import com.yo.day1.common.ApiResponse;
import com.yo.day1.domain.entity.Teacher;
import com.yo.day1.repository.TeacherRepository;
import com.yo.day1.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository teacherRepository;

    public List<Teacher> findAll()
    {
        return teacherRepository.findAll();
    }

    public Optional<Teacher> findById(Long id)
    {
        return teacherRepository.findById(id);
    }

    public Teacher save(Teacher teacher)
    {
        return teacherRepository.save(teacher);
    }

    public void deleteById(Long id)
    {
        teacherRepository.deleteById(id);
    }

}
