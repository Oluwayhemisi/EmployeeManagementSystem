package africa.semicolon.employeemanagement.exceptions;

public class DuplicateEmailException extends EmployeeException{


    public DuplicateEmailException(String message){
        super(message);
    }
}
