package africa.semicolon.employeemanagement.service;

import africa.semicolon.employeemanagement.data.model.Employee;
import africa.semicolon.employeemanagement.data.model.enums.JobPosition;
import africa.semicolon.employeemanagement.data.model.enums.Salary;
import africa.semicolon.employeemanagement.dto.requests.CreateEmployeeRequest;
import africa.semicolon.employeemanagement.dto.responses.CreateEmployeeResponse;
import africa.semicolon.employeemanagement.dto.responses.DeleteEmployeeResponse;
import africa.semicolon.employeemanagement.dto.responses.FindEmployeeResponse;
import africa.semicolon.employeemanagement.dto.responses.UpdateResponse;

import java.util.List;

public interface EmployeeService {
    CreateEmployeeResponse create(CreateEmployeeRequest requests);

     FindEmployeeResponse findEmployeeByName(String name);
     UpdateResponse updateEmployee(String name, Employee employeeDetails);
     List<Employee> getAllEmployee();
     Salary employeeSalaryBasedOnLevel(JobPosition jobPosition);

     DeleteEmployeeResponse deleteEmployee (Employee employee);

}
