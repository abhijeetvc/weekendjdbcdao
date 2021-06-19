package com.weekendjdbcdao.weekendjdbcdao.dao;

import com.weekendjdbcdao.weekendjdbcdao.model.Employee;
import com.weekendjdbcdao.weekendjdbcdao.respository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDao implements EmployeeRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Employee> getAllEmployees() {
        String sql="select * from employee";
        List<Employee> list=jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<>(Employee.class));
        return list;
    }

    @Override
    public String saveEmployee(Employee employee) {
        String sql="insert into employee(name,city) values (?,?)";
        jdbcTemplate.update(sql,new Object[]{employee.getName(),employee.getCity()});
        return "Employee Added Successfully";
    }

    @Override
    public String updateEmployee(Employee employee) {
        String sql="update employee set name=?,city=? where id=?";
        jdbcTemplate.update(sql,new Object[]{employee.getName(),employee.getCity()
                ,employee.getId()});
        return "Employee updated successfully";
    }

    @Override
    public String deleteEmployee(Integer id) {
        String sql="delete from employee where id=?";
        jdbcTemplate.update(sql,new Object[]{id});
        return "Employee deleted";
    }
}
