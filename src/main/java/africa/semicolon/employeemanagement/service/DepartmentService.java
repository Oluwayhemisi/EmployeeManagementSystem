package africa.semicolon.employeemanagement.service;

import africa.semicolon.employeemanagement.data.model.enums.Department;
import africa.semicolon.employeemanagement.exceptions.DepartmentException;

import java.util.List;

public interface DepartmentService {

    List<Department> listOfDepartment() throws DepartmentException;
}
