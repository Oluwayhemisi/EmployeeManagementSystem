package africa.semicolon.employeemanagement.data.repositories;

import africa.semicolon.employeemanagement.data.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    boolean existsByEmail(String email);

    Employee findByEmail(String email);
    Employee findEmployeeByFullName(String name);
}
