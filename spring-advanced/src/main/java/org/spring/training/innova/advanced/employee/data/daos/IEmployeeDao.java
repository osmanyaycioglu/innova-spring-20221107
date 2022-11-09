package org.spring.training.innova.advanced.employee.data.daos;

import org.spring.training.innova.advanced.employee.services.EEmployeeStatus;
import org.spring.training.innova.advanced.employee.services.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.Future;
import java.util.stream.Stream;

public interface IEmployeeDao extends JpaRepository<Employee, Long> {

    List<Employee> findBySurname(String surname);

    List<Employee> findBySurnameAndName(String surname,
                                        String name);

    List<Employee> findBySurnameAndNameOrderByName(String surname,
                                                   String name);

    List<Employee> findBySurnameIn(List<String> surname);

    @Query("select e from Employee e where e.surname=?1")
    List<Employee> searchSurname(String surname);

    @Query(value = "select * from employee e where e.surname=?1", nativeQuery = true)
    List<Employee> searchSurnameNative(String surname);

    @Query("select e.name,e.surname from Employee e where e.surname=?1")
    List<Object[]> searchNameSurname(String surname);

    @Query("select e from Employee e where e.surname=?1")
    Future<List<Employee>> searchSurnameFuture(String surname);

    @Query("select e from Employee e where e.surname=?1")
    Optional<List<Employee>> searchSurname2(String surname);

    @Query("select e from Employee e where e.surname=?1")
    Stream<Employee> searchSurname3(String surname);

    @Modifying
    @Transactional
    @Query("update Employee e set e.employeeStatus=?2 where e.employeeId=?1")
    int updateEmployeeStatus(Long employeeId,
                             EEmployeeStatus employeeStatus);

}
