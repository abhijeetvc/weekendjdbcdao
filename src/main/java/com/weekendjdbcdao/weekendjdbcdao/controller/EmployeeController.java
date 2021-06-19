package com.weekendjdbcdao.weekendjdbcdao.controller;

import com.weekendjdbcdao.weekendjdbcdao.dao.EmployeeDao;
import com.weekendjdbcdao.weekendjdbcdao.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController   // = @Controller + @ResponseBody
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @GetMapping("/getAllEmployees")
    public List<Employee> getEmployeeList(){
        return employeeDao.getAllEmployees();
    }

    @PostMapping("/saveEmployee")
    public String saveData(@RequestBody Employee employee){
        return employeeDao.saveEmployee(employee);
    }

    @PutMapping("/updateEmployee")
    public String updateEmployee(@RequestBody Employee employee){
        return employeeDao.updateEmployee(employee);
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public String deleteData(@PathVariable Integer id){
        return employeeDao.deleteEmployee(id);
    }
}
