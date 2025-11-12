package com.mall.employee.dto;

import java.time.LocalDate;

public record EmployeeRequest(
        String name,
        String email,
        String phone,
        String designation,
        Double salary,
        Long shopId,
        LocalDate joinedDate,
        Boolean active
) {}
