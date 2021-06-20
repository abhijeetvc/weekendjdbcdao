package com.weekendjdbcdao.weekendjdbcdao.respository;

import com.weekendjdbcdao.weekendjdbcdao.model.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeRepository {

    List<Employee> getAllEmployees();

    String saveEmployee(Employee employee);

    String saveEmployee1(String name,String city,Integer deptId,String imagePath);

    String updateEmployee(Employee employee);

    String deleteEmployee(Integer id);

    List<Map<String,Object>> getCombinedData();
}
