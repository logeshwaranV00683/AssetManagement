package com.verinite.assetmangementtool.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_employee")
@Data
public class EmployeeEntity {
    @Id
    @Column(name = "emp_id")
    private String empId;

    private String firstName;

    private String lastName;

    private String role;

    private String mail;

    private String mobile;

    private String location;

    //private int locCode;

    private String status;

    private String department;

    private String designation;

//	public int getLocCode() {
//		return locCode;
//	}
//
//	public void setLocCode(int locCode) {
//		this.locCode = locCode;
//	}

}