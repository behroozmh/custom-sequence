package ir.behi.seqtest.controller;

import ir.behi.seqtest.entity.GroupEntity;
import ir.behi.seqtest.repo.GroupDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/group")
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
