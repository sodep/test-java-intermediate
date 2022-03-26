package com.sodep.repositories;

import com.sodep.entities.Assignee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssigneeRepository extends CrudRepository<Assignee, Long> {

    Assignee findById(Long id);

}
