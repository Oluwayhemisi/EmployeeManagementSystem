package africa.semicolon.employeemanagement.controller;


import africa.semicolon.employeemanagement.controller.RequestAndResponse.ApiResponse;
import africa.semicolon.employeemanagement.data.model.Employee;
import africa.semicolon.employeemanagement.dto.requests.CreateEmployeeRequest;
import africa.semicolon.employeemanagement.dto.requests.UpdateRequest;
import africa.semicolon.employeemanagement.dto.responses.EmployeeResponse;
import africa.semicolon.employeemanagement.exceptions.EmployeeException;
import africa.semicolon.employeemanagement.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("api/v1/employee")
@Slf4j
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/")
    public ResponseEntity<?> createEmployeeForm(@RequestBody CreateEmployeeRequest createEmployeeRequest){
        try{
            EmployeeResponse employeeResponse = employeeService.createEmployeeAccount(createEmployeeRequest);
            ApiResponse apiResponse = ApiResponse.builder()
                    .status("success")
                    .message("Employee created successfully")
                    .data(employeeResponse)
                    .build();
            return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
        }catch(EmployeeException e){
            ApiResponse apiResponse = ApiResponse.builder()
                    .status("Fail")
                    .message(e.getMessage())
                    .build();
            return new ResponseEntity<>(apiResponse,HttpStatus.valueOf(400));
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getEmployee(@PathVariable String studentId){
        try{
            if(("null").equals(studentId) || ("").equals(studentId)){
                throw new EmployeeException("Employee id cannot be found",400);
            }
            EmployeeResponse employeeResponse = employeeService.findEmployeeByEmployeeId(studentId);
            ApiResponse apiResponse = ApiResponse.builder()
                    .status("success")
                    .message("Employee found")
                    .data(employeeResponse)
                    .build();
            return new ResponseEntity<>(apiResponse,HttpStatus.FOUND);
        }catch (EmployeeException e){
            ApiResponse apiResponse = ApiResponse.builder()
                    .status("fail")
                    .message(e.getMessage())
                    .build();
            return new ResponseEntity<>(apiResponse,HttpStatus.valueOf(e.getStatusCode()));
        }
    }

    @PatchMapping("/")
    public ResponseEntity<?> updateEmployeeDetails(@NotNull @Valid @NotBlank String employeeId, @NotNull @Valid @NotBlank String email, @RequestBody @NotNull UpdateRequest updateRequest){
        try{
            EmployeeResponse employeeResponse = employeeService.updateEmployee(employeeId,email,updateRequest);
            ApiResponse apiResponse = ApiResponse.builder()
                    .status("success")
                    .message("Employee details updated")
                    .data(employeeResponse)
                    .build();
            return new ResponseEntity<>(apiResponse, HttpStatus.ACCEPTED);
        }catch (EmployeeException e){
            ApiResponse apiResponse = ApiResponse.builder()
                    .message(e.getMessage())
                    .status("failed")
                    .build();
            return new ResponseEntity<>(apiResponse,HttpStatus.valueOf(e.getStatusCode()));
        }
    }

    @GetMapping("employees")
    public ResponseEntity<?> listOfAllEmployee(){
        List<Employee> employee = employeeService.getAllEmployee();
        ApiResponse apiResponse = ApiResponse.builder()
                .status("success")
                .message("Employees found")
                .build();
        return new ResponseEntity<>(apiResponse,HttpStatus.FOUND);
    }

}
