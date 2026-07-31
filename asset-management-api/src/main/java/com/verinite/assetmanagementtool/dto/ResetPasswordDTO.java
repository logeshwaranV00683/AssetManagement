package com.verinite.assetmanagementtool.dto;

import com.verinite.assetmanagementtool.validation.ValidationGroups;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class ResetPasswordDTO {
    @Email
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Invalid email address")
    @NotBlank
    private String mail;
    @NotBlank(groups = ValidationGroups.OnChangeWithOldPassword.class,message = "Old password is required")
    private String oldPassword;
    @NotBlank(message = "New password is required")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$", message = "New password is weak")
    private String newPassword;
    @NotBlank(groups = ValidationGroups.OnForgotViaOtp.class,message = "OTP is required")
    @Pattern(regexp = "^[0-9]{6}$", message = "OTP must be exactly 6 digits")
    private String otp;
}
