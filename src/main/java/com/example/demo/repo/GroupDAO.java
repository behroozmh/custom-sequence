package com.example.demo.repo;

import com.example.demo.entity.GroupEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface GroupDAO extends CrudRepository<GroupEntity,Integer> {
}
