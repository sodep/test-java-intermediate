package com.sodep.repositories;

import com.sodep.entities.Assignee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssigneeRepository extends JpaRepository<Assignee, Long> {

    Assignee findById(Long id);

}
