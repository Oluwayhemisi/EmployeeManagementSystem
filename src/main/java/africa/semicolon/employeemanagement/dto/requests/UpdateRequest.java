package africa.semicolon.employeemanagement.dto.requests;


import africa.semicolon.employeemanagement.data.model.enums.Gender;
import africa.semicolon.employeemanagement.data.model.enums.JobPosition;
import africa.semicolon.employeemanagement.data.model.enums.Qualification;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRequest {
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private Qualification schoolQualification;
    private String phoneNumber;
    private String password;
    private JobPosition jobPosition;
}
