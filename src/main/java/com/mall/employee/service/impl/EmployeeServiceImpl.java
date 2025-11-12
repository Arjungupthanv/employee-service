package com.mall.employee.service.impl;

import com.mall.employee.dto.*;
import com.mall.employee.entity.Employee;
import com.mall.employee.exception.NotFoundException;
import com.mall.employee.mapper.EmployeeMapper;
import com.mall.employee.repository.EmployeeRepository;
import com.mall.employee.service.EmployeeService;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public  class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repo;

    public EmployeeServiceImpl(EmployeeRepository repo) {
        this.repo = repo;
    }

    @Override
    public EmployeeResponse create(EmployeeRequest request) {
        Employee saved = repo.save(EmployeeMapper.toEntity(request));
        return EmployeeMapper.toResponse(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public EmployeeResponse get(Long id) {
        Employee e = repo.findById(id).orElseThrow(() -> new NotFoundException("Employee " + id + " not found"));
        return EmployeeMapper.toResponse(e);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<EmployeeResponse> list(int page, int size) {
        return repo.findAll(PageRequest.of(page, size, Sort.by("id").descending()))
                .map(EmployeeMapper::toResponse);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<EmployeeResponse> listByShop(Long shopId, int page, int size) {
        return repo.findByShopId(shopId, PageRequest.of(page, size)).map(EmployeeMapper::toResponse);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<EmployeeResponse> searchByDesignation(String q, int page, int size) {
        return repo.findByDesignationContainingIgnoreCase(q, PageRequest.of(page, size)).map(EmployeeMapper::toResponse);
    }

    @Override
    public EmployeeResponse update(Long id, EmployeeRequest request) {
        Employee e = repo.findById(id).orElseThrow(() -> new NotFoundException("Employee " + id + " not found"));
        EmployeeMapper.updateEntity(e, request);
        return EmployeeMapper.toResponse(repo.save(e));
    }

    @Override
    public void delete(Long id) {
        if (!repo.existsById(id)) throw new NotFoundException("Employee " + id + " not found");
        repo.deleteById(id);
    }
}
