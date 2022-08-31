package africa.semicolon.employeemanagement.service;

import africa.semicolon.employeemanagement.data.model.Employee;
import africa.semicolon.employeemanagement.data.model.enums.JobPosition;
import africa.semicolon.employeemanagement.data.model.enums.Salary;
import africa.semicolon.employeemanagement.dto.requests.CreateEmployeeRequest;
import africa.semicolon.employeemanagement.dto.requests.UpdateRequest;
import africa.semicolon.employeemanagement.dto.responses.EmployeeResponse;
import africa.semicolon.employeemanagement.dto.responses.DeleteEmployeeResponse;
import africa.semicolon.employeemanagement.exceptions.EmployeeException;

import java.util.List;

public interface EmployeeService {
    EmployeeResponse createEmployeeAccount(CreateEmployeeRequest requests) throws EmployeeException;

    EmployeeResponse findEmployeeByEmployeeId(String employeeId) throws EmployeeException;
     EmployeeResponse updateEmployee(String employeeId, String email, UpdateRequest updateRequest);
     List<Employee> getAllEmployee();
     Salary employeeSalaryBasedOnLevel(JobPosition jobPosition);

     void deleteAllEmployee (Employee employee);
     DeleteEmployeeResponse deleteEmployee (String employeeId) throws EmployeeException;

}
