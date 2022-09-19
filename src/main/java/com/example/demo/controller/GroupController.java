package com.example.demo.controller;

import com.example.demo.entity.GroupEntity;
import com.example.demo.repo.GroupDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GroupController {
    @Autowired
    private GroupDAO groupDAO;

    @GetMapping(value = "/getAll")
    public ResponseEntity getAllGroup() {
        return ResponseEntity.ok(groupDAO.findAll());
    }

    @GetMapping(value = "/insert")
    public ResponseEntity insertGroup(GroupEntity group) {
        return ResponseEntity.ok(groupDAO.save(group));
    }
}
