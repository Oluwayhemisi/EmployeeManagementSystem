package africa.semicolon.employeemanagement.dto.responses;

import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponse {
        private String employeeId;
        private LocalDateTime dateCreated = LocalDateTime.now();







}
