package com.mall.employee.dto;

import java.time.LocalDate;

public record EmployeeResponse(
        Long id,
        String name,
        String email,
        String phone,
        String designation,
        Double salary,
        Long shopId,
        LocalDate joinedDate,
        Boolean active
) {}
