package com.example.springpractice.employee;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {

    //Admin front page
    @GetMapping("/admin")
    String admin(){
        return "admin/index";
    }


    @Autowired
    private EmployeeService employeeService;

    /*
    @GetMapping("admin/employee")
    public String index(Model model) {
        List<Employee> employeeList = employeeService.fetchAllEmployees();
        model.addAttribute("listOfEmployees", employeeList);
        return "admin/employee/index";
    }

     */


    //display list of employees
    @GetMapping("/viewEmployeePage")
    public String viewEmployeePage(Model model){
    model.addAttribute("listOfEmployees",employeeService.getAllEmployees());
    return "admin/employee/index";
    }

    //add new employee
    @GetMapping("/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee",employee);
        return "admin/employee/newEmployee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:viewEmployeePage";
    }

    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable(value = "id") int id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee",employee);
        return "admin/employee/updateEmployee";
    }


    /*
    //get the mapping for index page
    @GetMapping("/")
    //create a list of users @fetchAll() - add them to the model
    public String index(Model model) {
        List<Employee> employeeList = EmployeeService.fetchAll();
        model.addAttribute("employee", employeeList);
        return "employee/index";
    }

    //get the mapping for addUser page
    @GetMapping("/addEmployee")
    public String add() {
        return "admin/employee/addEmployee";
    }

    //from addUser page - posts the new employee into the model(table)
    //redirects to index page
    @PostMapping("/addEmployee")
    public String addUser(@ModelAttribute Employee employee) {
        EmployeeService.addEmployee(employee);
        return "redirect:/";
    }

    //get the mapping for viewUser page
    //returns user via id
    @GetMapping("/viewEmployee/{id}")
    public String viewEmployee(@PathVariable("id") int id, Model model) {
        model.addAttribute("employee", EmployeeService.findEmployeeById(id));
        return "admin/employee/viewEmployee";
    }

    //deletes user via id
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        boolean deleted = EmployeeService.deleteEmployee(id);
        return "redirect:/";
    }

    //get the mapping for editUser page
    //returns user via id
    @GetMapping("/editEmployee/{id}")
    public String editEmployee(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", EmployeeService.findEmployeeById(id));
        return "admin/employee/editEmployee";
    }

    //from editUser page - posts the edited employee into the model(table)
    //redirects to index page
    @PostMapping("/edit")
    public String edit(@ModelAttribute Employee employee) {
        EmployeeService.updateEmployee(employee.getId(), employee);
        return "redirect:/";
    }

     */
}

