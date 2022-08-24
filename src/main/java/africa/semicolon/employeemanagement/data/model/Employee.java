package africa.semicolon.employeemanagement.data.model;

import africa.semicolon.employeemanagement.data.model.enums.*;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @NotBlank
    private String firstName;

    @NotNull
    @NotBlank
    private String lastName;

    private String Address;

    @Email
    @NotNull
    @NotBlank
    @Column(unique = true)
    private String email;

    @NotNull
    @NotBlank
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private Salary salary;

    @Getter(AccessLevel.PRIVATE)
    private String passWord;

    @NotNull
    @NotBlank
    private String EmployeeId;

    private LocalDateTime dateRegistered = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    private Department department;


    @Enumerated(EnumType.STRING)
    private Qualification schoolQualification;


    @Enumerated(EnumType.STRING)
    private JobPosition jobPosition;





}
