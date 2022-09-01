package africa.semicolon.employeemanagement.dto.requests;

import africa.semicolon.employeemanagement.data.model.enums.Department;
import africa.semicolon.employeemanagement.data.model.enums.Gender;
import africa.semicolon.employeemanagement.data.model.enums.JobPosition;
import africa.semicolon.employeemanagement.data.model.enums.Qualification;
import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateEmployeeRequest {
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private Qualification schoolQualification;
    private Gender gender;
    private String phoneNumber;
    private String password;
    private JobPosition jobPosition;
    private Department department;

}
