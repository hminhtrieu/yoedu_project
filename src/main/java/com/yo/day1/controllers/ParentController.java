package com.yo.day1.controllers;


import com.yo.day1.common.ApiResponse;
import com.yo.day1.domain.entity.Parent;
import com.yo.day1.service.ParentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/parent")
@RequiredArgsConstructor
public class ParentController {
    private final ParentService parentService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Parent>>> getAllParent()
    {
        return ResponseEntity.ok(ApiResponse.success(parentService.findAll()));
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponse<Parent>> getParentById(Long id)
    {
        Optional<Parent> parent = parentService.findById(id);
        if(parent.isPresent())
        {
            return ResponseEntity.ok(ApiResponse.success(parent.get()));
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Parent>> createParent(@RequestBody Parent parent)
    {
        return ResponseEntity.ok(ApiResponse.success(parentService.save(parent)));
    }

    @PutMapping("{id}")
    public ResponseEntity<ApiResponse<Parent>> updateParent(@RequestBody Parent parent, @PathVariable Long id)
    {
        Optional<Parent> parentOptional = parentService.findById(id);
        if(parentOptional.isPresent())
        {
            Parent exitParent = parentOptional.get();

            exitParent.setFullname(parent.getFullname());
            exitParent.setEmail(parent.getEmail());
            exitParent.setPhone(parent.getPhone());
            exitParent.setAddress(parent.getAddress());

            Parent parentUpdate = parentService.save(exitParent);

            return ResponseEntity.ok(ApiResponse.success(parentUpdate));

        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ApiResponse<String>> deleteParent(@PathVariable Long id)
    {
        Optional<Parent> parent = parentService.findById(id);
        if(parent.isPresent())
        {
            parentService.deleteById(id);
            return ResponseEntity.ok(ApiResponse.success("Xóa Parent Thành Công"));
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }


}
