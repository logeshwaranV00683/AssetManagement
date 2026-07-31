package com.verinite.assetmanagementtool.dto;

import com.verinite.assetmanagementtool.validation.ValidationGroups;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

    @Pattern(regexp = "^(V\\d{5})?$", message = "Must be V followed by 5 digits")
    @NotNull
    @NotBlank
    private String empId;
    @NotBlank(groups = ValidationGroups.OnCreate.class)
    @NotNull
    @Pattern(regexp = "^(?i)[a-z]+(?:[ '-][a-z]+)*$", message = "First Name must contain only letters, spaces, or hyphens")
    @Size(min = 3,max = 20, message = "First name cannot exceeds more than 20 characters and cannot be below 3 characters")
    private String firstName;
    @NotNull
    @NotBlank(groups = ValidationGroups.OnCreate.class)
    @Pattern(regexp = "^(?i)[a-z]+(?:[ '-][a-z]+)*$", message = "Last Name must contain only letters, spaces, or hyphens")
    @Size(max = 20, message = "Last name cannot exceeds more than 20 characters")
    private String lastName;
    @NotNull
    @NotBlank(groups = ValidationGroups.OnCreate.class)
    @Pattern(regexp = "^(?i)(Employee|Admin)?$", message = "Role can be Admin or Employee")
    private String role;
    @NotBlank(groups = ValidationGroups.OnCreate.class)
    @Email
    @NotNull
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@([A-Za-z_]+\\.)[A-Za-z]{2,3}$", message = "Invalid email address")
    @Size(max = 50, message = "Email address cannot exceed 50 characters")
    private String mail;
    @NotBlank(groups = ValidationGroups.OnCreate.class)
    @NotNull
    @Pattern(regexp = "^(0|\\+91)?[6-9]\\d{9}$", message = "Valid Mobile Number Needed")
    private String mobile;
    @NotNull
    @NotBlank(groups = ValidationGroups.OnCreate.class)
    @Pattern(regexp = "^(?i)[a-z]+(?:[ '-][a-z]+)*$", message = "Location must contain only letters, spaces, or hyphens")
    @Size(max =30,message = "Location Cannot Exceed More Than 30 Characters")
    private String location;
    @NotNull
    @NotBlank(groups = ValidationGroups.OnCreate.class)
    @Pattern(regexp = "^(?i)(Active|Inactive)?$", message = "status can be Active or Inactive")
    private String status;
    @NotNull
    @Size(max = 30, message = "Department Cannot Exceed More Than 30 Characters")
    @NotBlank(groups = ValidationGroups.OnCreate.class)
    @Pattern(regexp = "^(?i)[a-z]+(?:[ '-][a-z]+)*$", message = "Department must contain only letters, spaces, or hyphens")
    private String department;
    @Size(max = 30, message = "Designation Cannot Exceed More Than 30 Characters")
    @NotBlank(groups = ValidationGroups.OnCreate.class)
    @Pattern(regexp = "^(?i)[a-z]+(?:[ '-][a-z]+)*$", message = "Designation must contain only letters, spaces, or hyphens")
    @NotNull
    private String designation;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeDto e)) return false;
        return this.empId != null && e.empId != null && this.empId.equals(e.empId);
    }

    @Override
    public int hashCode() {
        return empId != null ? empId.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "EmployeeDto{" +
                "empId='" + empId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", role='" + role + '\'' +
                ", mail='" + mail + '\'' +
                ", mobile='" + mobile + '\'' +
                ", location='" + location + '\'' +
                ", status='" + status + '\'' +
                ", department='" + department + '\'' +
                ", designation='" + designation + '\'' +
                '}';
    }
}
