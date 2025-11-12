package com.mall.employee.service;

import com.mall.employee.dto.EmployeeRequest;
import com.mall.employee.dto.EmployeeResponse;
import org.springframework.data.domain.Page;

public interface EmployeeService {
    EmployeeResponse create(EmployeeRequest request);
    EmployeeResponse get(Long id);
    Page<EmployeeResponse> list(int page, int size);
    Page<EmployeeResponse> listByShop(Long shopId, int page, int size);
    Page<EmployeeResponse> searchByDesignation(String q, int page, int size);
    EmployeeResponse update(Long id, EmployeeRequest request);
    void delete(Long id);
}
