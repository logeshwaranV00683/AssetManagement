package com.verinite.assetmangementtool.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.Email;

@Getter
@Setter
public class ResetPasswordDTO {
    @Email
    private String mail;
    private String oldPassword;
    private String newPassword;
    @NumberFormat
    private String otp;
}
