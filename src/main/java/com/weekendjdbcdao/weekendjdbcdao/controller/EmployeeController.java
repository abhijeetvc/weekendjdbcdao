package com.weekendjdbcdao.weekendjdbcdao.controller;

import com.weekendjdbcdao.weekendjdbcdao.dao.EmployeeDao;
import com.weekendjdbcdao.weekendjdbcdao.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController   // = @Controller + @ResponseBody
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @GetMapping("/getAllEmployees")
    public List<Employee> getEmployeeList(){
        return employeeDao.getAllEmployees();
    }

//    @PostMapping("/saveEmployee")
//    public String saveData(@RequestBody Employee employee){
//        return employeeDao.saveEmployee(employee);
//    }

    @PostMapping("/saveEmployee")
    public String saveData(@RequestParam String name,
                           @RequestParam String city,
                           @RequestParam MultipartFile file,
                           @RequestParam Integer deptId) throws IOException {

        String fileName=file.getOriginalFilename();
        File f=new File("/Users/abhi/Desktop/uploadFiles/"+fileName);
        String imagePath=f.getAbsolutePath();
        file.transferTo(f);
        return employeeDao.saveEmployee1(name,city,deptId,imagePath);
    }

    @PutMapping("/updateEmployee")
    public String updateEmployee(@RequestBody Employee employee){
        return employeeDao.updateEmployee(employee);
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public String deleteData(@PathVariable Integer id){
        return employeeDao.deleteEmployee(id);
    }

    @GetMapping("/getdata")
    public List<Map<String,Object>> getData(){
        return employeeDao.getCombinedData();
    }
}
