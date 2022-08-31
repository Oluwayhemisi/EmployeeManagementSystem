package africa.semicolon.employeemanagement.controller.RequestAndResponse;


import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {
    private String message;
    private String status;
    private int result;
    private Object data;
}
