package com.makemymachine.thymeleafdemo.dao;
import com.makemymachine.thymeleafdemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

public List<Employee> findAllByOrderByLastNameAsc();

}
