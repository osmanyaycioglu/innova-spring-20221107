package org.spring.training.innova.advanced.employee.data.daos;

import org.spring.training.innova.advanced.employee.services.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeDao extends JpaRepository<Employee,Long> {
}
