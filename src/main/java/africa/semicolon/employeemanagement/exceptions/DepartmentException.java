package africa.semicolon.employeemanagement.exceptions;

public class DepartmentException extends EmployeeException{
    public DepartmentException(String message, int statusCode) {
        super(message, statusCode);
    }
}
