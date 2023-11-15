package com.oles.consoleuniversity.repository;

import com.oles.consoleuniversity.model.Department;
import com.oles.consoleuniversity.model.Lector;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    @Query("select d.head "
        + "from Department d "
        + "where d.name = :departmentName")
    Optional<Lector> getHeadOfDepartment(String departmentName);

    @Query("select l.degree.name, count(l) from Department d " +
        "join d.lectors l " +
        "where d.name = :departmentName " +
        "group by l.degree.name")
    Optional<String> getDepartmentStatistics(String departmentName);

    @Query("select avg(l.salary) "
        + "from Department d "
        + "join d.lectors l "
        + "where d.name = :departmentName "
        + "group by l.degree")
    Optional<Double> getAverageSalaryForDepartment(String departmentName);

    @Query("select count(l)"
        + "from Department d "
        + "join d.lectors l "
        + "where d.name = :departmentName")
    Optional<Integer> getNumOfEmployees(String departmentName);

}
