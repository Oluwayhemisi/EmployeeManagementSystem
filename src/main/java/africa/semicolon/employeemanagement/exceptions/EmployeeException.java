package africa.semicolon.employeemanagement.exceptions;

public class EmployeeException extends RuntimeException{
    private int statusCode;
    public EmployeeException(String message, int statusCode){
        super(message);
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
