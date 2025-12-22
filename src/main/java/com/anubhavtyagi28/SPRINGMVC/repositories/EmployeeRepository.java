package com.anubhavtyagi28.SPRINGMVC.repositories;

import com.anubhavtyagi28.SPRINGMVC.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
}
