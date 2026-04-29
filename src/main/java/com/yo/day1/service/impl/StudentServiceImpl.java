package com.yo.day1.service.impl;

import com.yo.day1.domain.entity.Student;
import com.yo.day1.repository.StudentRepository;
import com.yo.day1.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;


    public List<Student> findAll()
    {
        return studentRepository.findAll();
    }

    public Optional<Student> findById(Long id)
    {
        return studentRepository.findById(id);
    }

    public Student save(Student student)
    {
        return studentRepository.save(student);
    }

    public void deleteById(Long id)
    {
        studentRepository.deleteById(id);
    }
}
