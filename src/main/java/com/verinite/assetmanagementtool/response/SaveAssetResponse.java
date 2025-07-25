package com.verinite.assetmanagementtool.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Data
public class SaveAssetResponse {

    private int assetId;
    @Pattern(regexp = "^(\\w+)?$", message = "Must be a Alphanumeric & _")
    private String assetName;
    @Pattern(regexp = "^(\\w+)?$", message = "Must be a Alphanumeric & _")
    private String serialNumber;
    @Pattern(regexp = "^(V\\d{5})?$", message = "Must be V followed by 5 digits or empty")
    private String empId;
    private String status;
    @Pattern(regexp = "^(\\w+)?$", message = "Must be a Alphanumeric & _")
    private String type;
    @Pattern(regexp = "^(\\d{4}-\\d{2}-\\d{2})?$", message = "Date must be in format yyyy-MM-dd")
    private String purchaseDate;
    @Pattern(regexp = "^(\\d{4}-\\d{2}-\\d{2})?$", message = "Date must be in format yyyy-MM-dd")
    private String warrantyDate;
    @Pattern(regexp = "^(\\w+)?$", message = "Must be a Alphanumeric & _")
    private String location;
    @Pattern(regexp = "^(\\d+)?$", message = "locCode Must be a Number")
    private Integer locCode;
    @Pattern(regexp = "^(\\w+)?$", message = "ModelName must be alphanumeric & _")
    private String modelName;
    private String operatingSystem;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate returnDate;
    @Pattern(regexp = "^(V\\d{5})?$", message = "Must be V followed by 5 digits or empty")
    private String addedBy;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate assignedDate;
    @Pattern(regexp = "^(V\\d{5})?$", message = "Must be V followed by 5 digits or empty")
    private String assignedBy;
    @Pattern(regexp = "^(\\w+)?$", message = "Must be a Alphanumeric & _")
    private String assertSourcedBy;
}
