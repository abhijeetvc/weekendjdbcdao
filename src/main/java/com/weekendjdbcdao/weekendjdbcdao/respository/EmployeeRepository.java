package com.weekendjdbcdao.weekendjdbcdao.respository;

import com.weekendjdbcdao.weekendjdbcdao.model.Employee;

import java.util.List;

public interface EmployeeRepository {

    List<Employee> getAllEmployees();

    String saveEmployee(Employee employee);

    String updateEmployee(Employee employee);

    String deleteEmployee(Integer id);
}
