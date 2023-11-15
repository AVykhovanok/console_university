package com.oles.consoleuniversity.service;

import com.oles.consoleuniversity.exception.NotExistException;
import com.oles.consoleuniversity.model.Lector;

public interface DepartmentService{
    Lector getHeadOfDepartment(String departmentName) throws NotExistException;

    String getDepartmentStatistics(String departmentName) throws NotExistException;

    Double getAverageSalaryForDepartment(String departmentName) throws NotExistException;

    Integer getNumOfEmployees(String departmentName) throws NotExistException;
}
