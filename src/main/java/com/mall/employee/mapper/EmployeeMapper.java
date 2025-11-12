package com.mall.employee.mapper;

import com.mall.employee.dto.*;
import com.mall.employee.entity.Employee;

public class EmployeeMapper {

    public static Employee toEntity(EmployeeRequest r) {
        if (r == null) return null;
        Employee e = new Employee();
        e.setName(r.name());
        e.setEmail(r.email());
        e.setPhone(r.phone());
        e.setDesignation(r.designation());
        e.setSalary(r.salary());
        e.setShopId(r.shopId());
        e.setJoinedDate(r.joinedDate());
        e.setActive(r.active() == null ? true : r.active());
        return e;
    }

    public static EmployeeResponse toResponse(Employee e) {
        if (e == null) return null;
        return new EmployeeResponse(
                e.getId(),
                e.getName(),
                e.getEmail(),
                e.getPhone(),
                e.getDesignation(),
                e.getSalary(),
                e.getShopId(),
                e.getJoinedDate(),
                e.getActive()
        );
    }

    public static void updateEntity(Employee e, EmployeeRequest r) {
        if (r == null) return;
        if (r.name() != null) e.setName(r.name());
        if (r.email() != null) e.setEmail(r.email());
        if (r.phone() != null) e.setPhone(r.phone());
        if (r.designation() != null) e.setDesignation(r.designation());
        if (r.salary() != null) e.setSalary(r.salary());
        if (r.shopId() != null) e.setShopId(r.shopId());
        if (r.joinedDate() != null) e.setJoinedDate(r.joinedDate());
        if (r.active() != null) e.setActive(r.active());
    }
}
