package com.anubhavtyagi28.SPRINGMVC.controllers;

import com.anubhavtyagi28.SPRINGMVC.dto.EmployeeDTO;
import com.anubhavtyagi28.SPRINGMVC.entities.EmployeeEntity;
import com.anubhavtyagi28.SPRINGMVC.repositories.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path="employees")
public class EmployeeController {
//    @GetMapping(path = "/getSecretMessage")
//    public String getMySuperSecretMessage() {
//        return "Secret Message: a55sgu6ygd78$^%%&#$";
//    }
    private final EmployeeRepository employeeRepository;
    public EmployeeController(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }
    @GetMapping(path = "/{employeeId}")
    public EmployeeEntity getEmployeeById(@PathVariable(name="employeeId") Long id){
        return employeeRepository.findById(id).orElse(null);
    }
    @GetMapping
    public List<EmployeeEntity> getAllEmployees(@RequestParam(required = false) Integer age, @RequestParam(required = false) String sortBy) {
        return employeeRepository.findAll();
    }
    @PostMapping
    public EmployeeEntity createNewEmployee(@RequestBody EmployeeEntity inputEmployee){
        return employeeRepository.save(inputEmployee);
    }
    @PutMapping
    public String updateEmployeeById(){
        return "Hello from PUT";
    }
}
