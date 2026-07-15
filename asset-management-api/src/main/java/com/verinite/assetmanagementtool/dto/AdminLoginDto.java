package com.verinite.assetmanagementtool.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
public class AdminLoginDto {
    @Pattern(regexp = "^(V\\d{5})$", message = "Must be V followed by 5 digits")
    @NotNull
    private String empId;
    @NotBlank
    @Size(min = 8, max = 15, message = "Password must between 8 and 15 characters")
    private String password;
}
