package africa.semicolon.employeemanagement.data.repositories;

import africa.semicolon.employeemanagement.data.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
//@EnableJpaRepositories
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    boolean existsByEmail(String email);

    Optional <Employee> findByEmail(String email);


    Optional<Employee> findByEmployeeId(String employeeId);
}
