package africa.semicolon.employeemanagement.utils;

import africa.semicolon.employeemanagement.data.model.Employee;
import africa.semicolon.employeemanagement.dto.requests.CreateEmployeeRequest;
import africa.semicolon.employeemanagement.dto.responses.CreateEmployeeResponse;

import java.time.format.DateTimeFormatter;

public class Mapper {
    public static void map (CreateEmployeeRequest request, Employee employee){
        employee.setFirstName(request.getFirstName());
        employee.setLastName(request.getLastName());
        employee.setEmail(request.getEmail());
        employee.setPhoneNumber(request.getPhoneNumber());
        employee.setAddress(request.getAddress());
        employee.setPassWord(request.getPassword());
        employee.setSchoolQualification(request.getSchoolQualification());
        employee.setGender(request.getGender());
    }
    public static void map (Employee savedEmployee, CreateEmployeeResponse response){
      response.setEmployeeId(response.getEmployeeId());
      response.setDateCreated(DateTimeFormatter.ofPattern("EEE, dd/MM/yyyy, hh:mm, a").format(savedEmployee.getDateRegistered()));
    }

    public static void map (Employee employee, Employee employeeDetails){
        employee.setFirstName(employeeDetails.getFirstName());
        employee.setLastName(employeeDetails.getLastName());
        employee.setSchoolQualification(employeeDetails.getSchoolQualification());
//        employee.setPassWord(employee.setPassWord();
    }
}
