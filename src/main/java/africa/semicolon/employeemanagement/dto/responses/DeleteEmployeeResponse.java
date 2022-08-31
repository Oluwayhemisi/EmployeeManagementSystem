package africa.semicolon.employeemanagement.dto.responses;

import africa.semicolon.employeemanagement.data.model.Employee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeleteEmployeeResponse {
    private Employee employee;
}
