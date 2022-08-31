package africa.semicolon.employeemanagement.utils;

import africa.semicolon.employeemanagement.data.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ModelMapper returnMapper(){
        return new ModelMapper();
    }
}
