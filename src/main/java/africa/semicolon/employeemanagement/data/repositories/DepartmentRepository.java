package africa.semicolon.employeemanagement.data.repositories;

import africa.semicolon.employeemanagement.data.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Employee,Long> {
}
