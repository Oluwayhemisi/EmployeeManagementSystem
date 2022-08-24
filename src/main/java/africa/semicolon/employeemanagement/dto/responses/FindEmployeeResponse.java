package africa.semicolon.employeemanagement.dto.responses;

import africa.semicolon.employeemanagement.utils.GenerateEmployeeId;
import lombok.Data;

@Data
public class FindEmployeeResponse {
    private String email;
    private String fullName;
    private String firstName;
    private String lastName;
}
