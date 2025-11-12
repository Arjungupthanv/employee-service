package com.mall.employee.repository;

import com.mall.employee.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findByEmail(String email);
    Page<Employee> findByShopId(Long shopId, Pageable pageable);
    Page<Employee> findByDesignationContainingIgnoreCase(String designation, Pageable pageable);
    Page<Employee> findByActive(Boolean active, Pageable pageable);
}
