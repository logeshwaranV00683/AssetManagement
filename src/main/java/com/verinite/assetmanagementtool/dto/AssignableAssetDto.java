package com.verinite.assetmanagementtool.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Data
public class AssignableAssetDto {

    @Pattern(regexp = "^(V\\d{5})?$", message = "Must be V followed by 5 digits or empty")
    private String empId;
    @NotBlank
    private String serialNumber;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate assignedDate;
    @Pattern(regexp = "^(V\\d{5})?$", message = "Must be V followed by 5 digits or empty")
    private String assignedBy;
}
