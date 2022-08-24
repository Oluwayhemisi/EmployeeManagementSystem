package africa.semicolon.employeemanagement.service;

import africa.semicolon.employeemanagement.data.model.Employee;
import africa.semicolon.employeemanagement.data.model.enums.JobPosition;
import africa.semicolon.employeemanagement.data.model.enums.Salary;
import africa.semicolon.employeemanagement.data.repositories.EmployeeRepository;
import africa.semicolon.employeemanagement.dto.requests.CreateEmployeeRequest;
import africa.semicolon.employeemanagement.dto.responses.CreateEmployeeResponse;
import africa.semicolon.employeemanagement.dto.responses.DeleteEmployeeResponse;
import africa.semicolon.employeemanagement.dto.responses.FindEmployeeResponse;
import africa.semicolon.employeemanagement.dto.responses.UpdateResponse;
import africa.semicolon.employeemanagement.exceptions.DuplicateEmailException;
import africa.semicolon.employeemanagement.exceptions.EmployeeException;
import africa.semicolon.employeemanagement.exceptions.ResourceNotFoundException;
import africa.semicolon.employeemanagement.utils.Mapper;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
   private EmployeeRepository employeeRepository;


    @Override
    public CreateEmployeeResponse create(CreateEmployeeRequest request) {
       Employee employee = employeeRepository.findByEmail(request.getEmail());
           if (employee != null){ throw new DuplicateEmailException(request.getEmail() + "already exist");}
           employee = new Employee();
           Mapper.map(request, employee);
           employee.setSalary(employeeSalaryBasedOnLevel(request.getJobPosition()));
           employee.setEmployeeId(generateId(request.getEmployeeId()));
           Employee savedEmployee = employeeRepository.save(employee);



           CreateEmployeeResponse response = new CreateEmployeeResponse();
           Mapper.map(savedEmployee,response);
           return response;
       }



    @Override
    public FindEmployeeResponse findEmployeeByName(String firstName) {
        Employee employee = employeeRepository.findEmployeeByFullName(firstName);
        if (employee == null) {
            throw new ResourceNotFoundException("Employee Not Found");
        }
        FindEmployeeResponse response = new FindEmployeeResponse();
        response.setFullName(employee.getFirstName() + " " + employee.getLastName());
        response.setEmail(employee.getEmail());
        return response;


    }

    @Override
    public UpdateResponse updateEmployee(String name, Employee employeeDetails) {
        Employee updateEmployee = employeeRepository.findEmployeeByFullName(name);
        if(updateEmployee == null){
            throw new ResourceNotFoundException("Employee Not found");
        }
        Mapper.map(updateEmployee,employeeDetails);

        UpdateResponse response = new UpdateResponse();
        response.setMessage(updateEmployee +"with "+ employeeDetails+" has been updated");


        return response;
    }

    @Override
    public List<Employee> getAllEmployee() {
            List<Employee> employeeList = employeeRepository.findAll();
            if (employeeList.isEmpty()) {
                throw new EmployeeException("Employee list is empty");
            }
            return employeeList;

    }

    @Override
    public Salary employeeSalaryBasedOnLevel(JobPosition jobPosition) {
        Employee employee = new Employee();
        if(jobPosition == JobPosition.INTERNSHIP){
            employee.setSalary(Salary.TWO_HUNDRED_THOUSAND);
        }
        else if(jobPosition == JobPosition.ENTRY_LEVEL){
            employee.setSalary(Salary.TWO_HUNDRED_THOUSAND);
        }
        else  if (jobPosition == JobPosition.MID_LEVEL){
            employee.setSalary(Salary.FIVE_HUNDRED_THOUSAND);
        }
        else if (jobPosition == JobPosition.SENIOR){
            employee.setSalary(Salary.EIGHT_HUNDRED_THOUSAND);
        }

        employeeRepository.save(employee);
        return employee.getSalary();
    }

    @Override
    public DeleteEmployeeResponse deleteEmployee(Employee employee) {
        return null;
    }


    private String generateId(String employeeId){
        int number = employeeRepository.findAll().size();
        String id = String.format("%02d",number);
        return "Em"+ id;
    }


}
