package com.anubhavtyagi28.SPRINGMVC.controllers;

import com.anubhavtyagi28.SPRINGMVC.dto.EmployeeDTO;
import com.anubhavtyagi28.SPRINGMVC.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="employees")
public class EmployeeController {
//    @GetMapping(path = "/getSecretMessage")
//    public String getMySuperSecretMessage() {
//        return "Secret Message: a55sgu6ygd78$^%%&#$";
//    }
    private final EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }
    @GetMapping(path = "/{employeeId}")
    public EmployeeDTO getEmployeeById(@PathVariable(name="employeeId") Long id){
        return employeeService.getEmployeeById(id);
    }
    @GetMapping
    public List<EmployeeDTO> getAllEmployees(@RequestParam(required = false) Integer age, @RequestParam(required = false) String sortBy) {
        return employeeService.getAllEmployees();
    }
    @PostMapping
    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO inputEmployee){
        return employeeService.createNewEmployee(inputEmployee);
    }
    @PutMapping
    public String updateEmployeeById(){
        return "Hello from PUT";
    }
}
