package com.verinite.assetmanagementtool.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.verinite.assetmanagementtool.validation.ValidationGroups;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssetsDto {

    private int assetId;
    @NotBlank
    @Pattern(regexp = "^(?!.* {2})[A-Za-z][\\w ]+$", message = "Must be start with letters followed by alphanumeric, underscores, and spaces only")
    @Size(min = 3,max = 50, message = "Asset Name Cannot be less than 3 characters and cannot exceed 50 characters")
    private String assetName;
    @Pattern(regexp = "^(\\w+)?$", message = "Must be a Alphanumeric & _")
    @Size(min = 5,max = 50,message = "Cannot exceed 30 characters and should not be less than 5 characters" )
    private String serialNumber;
    @NotBlank(groups = ValidationGroups.OnAssigned.class, message = "Employee ID is required when asset status is Assigned")
    @Pattern(regexp = "^(V\\d{5})?$", message = "Must be V followed by 5 digits or empty")
    private String empId;
    @NotBlank
    private String status;
    @NotBlank
    @Pattern(regexp = "^(?!.* {2})[A-Za-z][A-Za-z0-9-_\\s]*$",message = "Should starts with letters followed by alphanumeric, underscores, and spaces only")
    @Size(min = 2, max = 30, message = "Type cannot exceed 30 characters and should not be less than 2 characters")
    private String type;
    @NotNull(message = "Purchase Date is required")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate purchaseDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Warranty Date is required")
    private LocalDate warrantyDate;
    @NotBlank
    @Pattern(regexp = "^(?i)[a-z]+(?:[ '-][a-z]+)*$", message = "Location must contain only letters, spaces, or hyphens")
    @Size(max = 30,message = "Location cannot exceeds 30 characters")
    private String location;
    @NotNull
    @Pattern(regexp = "^(?!.* {2})[A-Za-z][A-Za-z0-9-_/\\s]*$",message = "Should starts with letters followed by alphanumeric, underscores, and spaces only")
    private String modelName;
    @NotBlank
    @Size(min = 3,max = 30, message = "OS name cannot be less than 3 characters and should not exceed 30 characters")
    @Pattern(regexp = "^(?!.* {2})[A-Za-z][A-Za-z0-9-_/\\s]*$",message = "Should starts with letters followed by alphanumeric, underscores, and spaces only")
    private String operatingSystem;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate returnDate;
    @NotBlank
    @Pattern(regexp = "^(V\\d{5})?$", message = "Must be V followed by 5 digits or empty")
    private String addedBy;
    @NotNull(groups = ValidationGroups.OnAssigned.class, message = "Assigned Date is required when asset status is Assigned")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate assignedDate;
    @Pattern(regexp = "^(V\\d{5})?$", message = "Must be V followed by 5 digits or empty")
    @NotBlank(groups = ValidationGroups.OnAssigned.class, message = "Assigned By is required when asset status is Assigned")
    private String assignedBy;
    @NotBlank
    private String assetSourcedBy;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AssetsDto e)) return false;
        if (this.serialNumber != null && e.serialNumber != null && this.serialNumber.equals(e.serialNumber) && this.assetId != 0 && e.assetId != 0) {
            return this.assetId == (e.assetId);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return serialNumber != null ? serialNumber.hashCode() + assetId : 0;
    }

    @Override
    public String toString() {
        return "AssetsDto{" +
                "assetId=" + assetId +
                ", assetName='" + assetName + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", empId='" + empId + '\'' +
                ", status='" + status + '\'' +
                ", type='" + type + '\'' +
                ", purchaseDate='" + purchaseDate + '\'' +
                ", warrantyDate='" + warrantyDate + '\'' +
                ", location='" + location + '\'' +
                ", modelName='" + modelName + '\'' +
                ", operatingSystem='" + operatingSystem + '\'' +
                ", returnDate=" + returnDate +
                ", addedBy='" + addedBy + '\'' +
                ", assignedDate=" + assignedDate +
                ", assignedBy='" + assignedBy + '\'' +
                ", assetSourcedBy='" + assetSourcedBy + '\'' +
                '}';
    }
}