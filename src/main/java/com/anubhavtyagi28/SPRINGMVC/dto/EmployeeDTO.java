package com.anubhavtyagi28.SPRINGMVC.dto;

import com.anubhavtyagi28.SPRINGMVC.annotations.EmployeeRoleValidation;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    private Long id;
    @NotBlank(message = "Required field in Employee: name")
    @Size(min = 3, max = 10, message = "Minimum characters in name should be 3")
    private String name;
    @NotBlank(message = "Required field in Employee: email")
    @Email(message = "Please provide valid email address")
    private String email;
    @NotNull
    @Max(value = 80, message = "Age can not be greater than 80")
    @Min(value = 18, message = "Age can not be less than 18")
    private Integer age;
    @NotNull(message = "Role of Employee is required") //can use @NotBlank as well, depends on the use case
//    @Pattern(regexp = "^(ADMIN|USER)$",message = "Role of Employee can either be USER or ADMIN")
    @EmployeeRoleValidation
    private String role;
    @NotNull(message = "Salary can't be null")
    @Positive(message = "Salary should be positive")
    @Digits(integer = 6, fraction = 2)
    @DecimalMin(value = "100000.00")
    @DecimalMax(value = "900000.00")
    private Double salary;
    @Past(message = "Date of joining should be in past")  //can use @PastOrPresent as well
    private LocalDate dateOfJoining;
    @JsonProperty("isActive")
    @AssertTrue(message = "isActive has to be true")  // can try @AssertFalse as well
    private Boolean active;

}

//    public EmployeeDTO() {
//
//    }
//
//
//    public EmployeeDTO(Long id, String name, String email, Integer age, LocalDate dateOfJoining, Boolean active) {
//        this.id = id;
//        this.name = name;
//        this.email = email;
//        this.age = age;
//        this.dateOfJoining = dateOfJoining;
//        this.active = active;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public Integer getAge() {
//        return age;
//    }
//
//    public void setAge(Integer age) {
//        this.age = age;
//    }
//
//    public LocalDate getDateOfJoining() {
//        return dateOfJoining;
//    }
//
//    public void setDateOfJoining(LocalDate dateOfJoining) {
//        this.dateOfJoining = dateOfJoining;
//    }
//    public Boolean getActive() {
//        return active;
//    }
//
//    public void setActive(Boolean active) {
//        this.active = active;
//    }
//}
