package africa.semicolon.employeemanagement.service;

import africa.semicolon.employeemanagement.data.model.Employee;
import africa.semicolon.employeemanagement.data.model.enums.JobPosition;
import africa.semicolon.employeemanagement.data.model.enums.Salary;
import africa.semicolon.employeemanagement.data.repositories.EmployeeRepository;
import africa.semicolon.employeemanagement.dto.requests.CreateEmployeeRequest;
import africa.semicolon.employeemanagement.dto.requests.UpdateRequest;
import africa.semicolon.employeemanagement.dto.responses.EmployeeResponse;
import africa.semicolon.employeemanagement.dto.responses.DeleteEmployeeResponse;
import africa.semicolon.employeemanagement.exceptions.EmployeeException;
import lombok.extern.slf4j.Slf4j;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
   private  EmployeeRepository employeeRepository;

   @Autowired
   private ModelMapper modelMapper;


    @Override
    public EmployeeResponse createEmployeeAccount(CreateEmployeeRequest request) throws EmployeeException{
        validateEmployeeEmail(request.getEmail());

        Employee employee = modelMapper.map(request, Employee.class);
           employee.setSalary(employeeSalaryBasedOnLevel(request.getJobPosition()));
           employee.setEmployeeId(generateId());
        log.info("Before saving");
           Employee savedEmployee = employeeRepository.save(employee);
           log.info("Employee saved -> {}",savedEmployee.getEmployeeId());

           return modelMapper.map(savedEmployee, EmployeeResponse.class);

       }

    @Override
    public EmployeeResponse findEmployeeByEmployeeId(String employeeId) throws EmployeeException{
        Employee employee = employeeRepository.findByEmployeeId(employeeId).orElseThrow(()-> new EmployeeException("Employee Id does not exist",404));
        return modelMapper.map(employee,EmployeeResponse.class);
    }

    private void validateEmployeeEmail(String email) {
        Optional <Employee> employee = employeeRepository.findByEmail(email);
        if (employee.isPresent()){ throw new EmployeeException("Email already exist",404);}
    }


    @Override
    public EmployeeResponse updateEmployee(String employeeId, String email, UpdateRequest updateRequest) {
        Employee updatedEmployee = employeeRepository.findByEmployeeId(employeeId).orElseThrow(()-> new EmployeeException("Employee id not found",404));
        if(updatedEmployee.getFirstName().length() > 0){
            updatedEmployee.setFirstName(updateRequest.getFirstName());
        }
        if(updatedEmployee.getLastName().length() > 0){
            updatedEmployee.setLastName(updateRequest.getLastName());
        }
        if(updatedEmployee.getAddress().length() > 0){
            updatedEmployee.setAddress(updatedEmployee.getAddress());
        }
        if(updatedEmployee.getPhoneNumber().length() > 0){
            updatedEmployee.setPhoneNumber(updateRequest.getPhoneNumber());
        }
        if(updatedEmployee.getSchoolQualification().toString().length() > 0){
            updatedEmployee.setSchoolQualification(updateRequest.getSchoolQualification());
        }
        if(updatedEmployee.getPassword().length() > 0){
            updatedEmployee.setPassword(updateRequest.getPassword());
        }
        if(updatedEmployee.getJobPosition().toString().length() > 0){
            updatedEmployee.setJobPosition(updateRequest.getJobPosition());
        }
        validateEmployeeEmail(email);
        updatedEmployee.setEmail(updateRequest.getEmail());
        Employee savedEmployee = employeeRepository.save(updatedEmployee);
        return modelMapper.map(savedEmployee,EmployeeResponse.class);


    }

    @Override
    public List<Employee> getAllEmployee() {
            List<Employee> employeeList = employeeRepository.findAll();
            if (employeeList.isEmpty()) {
                throw new EmployeeException("Employee list is empty",404);
            }
            return employeeList;

    }

    @Override
    public Salary employeeSalaryBasedOnLevel(JobPosition jobPosition) {
        if(jobPosition == JobPosition.INTERNSHIP){
            return Salary.TWO_HUNDRED_THOUSAND;
        }
        else if(jobPosition == JobPosition.ENTRY_LEVEL){
            return Salary.TWO_HUNDRED_THOUSAND;
        }
        else  if (jobPosition == JobPosition.MID_LEVEL){
            return Salary.FIVE_HUNDRED_THOUSAND;
        }
        else if (jobPosition == JobPosition.SENIOR){
            return Salary.EIGHT_HUNDRED_THOUSAND;
        }
        throw new EmployeeException("salary range not found!",400);
    }

    @Override
    public void deleteAllEmployee(Employee employee) {
        employeeRepository.deleteAll();
    }

    @Override
    public DeleteEmployeeResponse deleteEmployee(String employeeId) throws EmployeeException{
        Employee  findEmployee = employeeRepository.findByEmployeeId(employeeId).orElseThrow(()-> new EmployeeException("Employee id cannot be found",404));
        employeeRepository.delete(findEmployee);

        return modelMapper.map(findEmployee,DeleteEmployeeResponse.class);
    }



    private String generateId(){
        int number = employeeRepository.findAll().size();
        String id = String.format("%02d",number+1);
        return "Em"+ id;
    }


}
