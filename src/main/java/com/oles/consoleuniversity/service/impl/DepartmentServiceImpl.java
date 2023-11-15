package com.oles.consoleuniversity.service.impl;

import com.oles.consoleuniversity.exception.NotExistException;
import com.oles.consoleuniversity.model.Lector;
import com.oles.consoleuniversity.repository.DepartmentRepository;
import com.oles.consoleuniversity.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {
    private static final String HEAD_OF_DEPARTMENT_EXCEPTION =
            "There is no head of department in -> %s";
    private static final String DEPARTMENT_STATISTICS_EXCEPTION = "There is no department statistics in -> %s";
    private static final String AVERAGE_SALARY_EXCEPTION = "There is no average salary in %s";
    private static final String NUM_OF_EMPLOYEES_EXCEPTION = "There is no employees in %s";
    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Lector getHeadOfDepartment(String departmentName) throws NotExistException {
        return departmentRepository.getHeadOfDepartment(departmentName)
            .orElseThrow(() -> new NotExistException(
                    String.format(HEAD_OF_DEPARTMENT_EXCEPTION, departmentName)));
    }

    @Override
    public String getDepartmentStatistics(String departmentName) throws NotExistException {
        return departmentRepository.getDepartmentStatistics(departmentName)
            .orElseThrow(() -> new NotExistException(
                String.format(DEPARTMENT_STATISTICS_EXCEPTION, departmentName)));
    }

    @Override
    public Double getAverageSalaryForDepartment(String departmentName) throws NotExistException {
        return departmentRepository.getAverageSalaryForDepartment(departmentName)
            .orElseThrow(() -> new NotExistException(String.format(AVERAGE_SALARY_EXCEPTION, departmentName)));
    }

    @Override
    public Integer getNumOfEmployees(String departmentName) throws NotExistException {
        return departmentRepository.getNumOfEmployees(departmentName)
            .orElseThrow(() -> new NotExistException(String.format(NUM_OF_EMPLOYEES_EXCEPTION, departmentName)));
    }
}
