package com.makemymachine.thymeleafdemo.controller;


import com.makemymachine.thymeleafdemo.entity.Employee;
import com.makemymachine.thymeleafdemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;
    public EmployeeController(EmployeeService theEmployeeService){
        employeeService = theEmployeeService;
    }
    @GetMapping("/list")
    public String listEmployees(Model theModel){

        List<Employee> theEmployees = employeeService.findAll();
        theModel.addAttribute("employees",theEmployees);
        return "employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){
        Employee theEmployee = new Employee();
        theModel.addAttribute("employee",theEmployee);
        return "employees/employee-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int theId,Model theModel){
        //        get the employee from the service
        Employee theEmployee = employeeService.findById(theId);

//        set employee in the model to prepopulate the form
        theModel.addAttribute("employee",theEmployee);

        return "employees/employee-form";
    }


    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int theId){
        employeeService.deleteById(theId);

        return "redirect:/employees/list";
    }
}
