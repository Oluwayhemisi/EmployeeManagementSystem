package africa.semicolon.employeemanagement.dto.requests;

import africa.semicolon.employeemanagement.data.model.enums.Gender;
import africa.semicolon.employeemanagement.data.model.enums.JobPosition;
import africa.semicolon.employeemanagement.data.model.enums.Qualification;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateEmployeeRequest {
    private String firstName;
    private String lastName;
    private String Address;
    private String email;
    private String EmployeeId;
    private Qualification schoolQualification;
    private Gender gender;
    private String phoneNumber;
    private String password;
    private BigDecimal salary;
    private JobPosition jobPosition;

}
