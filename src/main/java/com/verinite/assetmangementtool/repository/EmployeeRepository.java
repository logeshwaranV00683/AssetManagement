package com.verinite.assetmangementtool.repository;

import com.verinite.assetmangementtool.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, String> {

    List<EmployeeEntity> findByIgnoreCaseStatus(String str);

    List<EmployeeEntity> findByIgnoreCaseLocation(String str);

    EmployeeEntity findByEmpId(String empId);

    List<EmployeeEntity> findAllByOrderByEmpIdDesc();

    List<EmployeeEntity> findByStatus(String status);

    EmployeeEntity findTopByOrderByEmpIdDesc();

    @Query("SELECT e FROM EmployeeEntity e WHERE " +
            "LOWER(e.empId) LIKE %:filter% OR " +
            "LOWER(e.firstName) LIKE %:filter% OR " +
            "LOWER(e.lastName) LIKE %:filter% OR " +
            "LOWER(e.role) LIKE %:filter% OR " +
            "LOWER(e.mail) LIKE %:filter% OR " +
            "LOWER(e.mobile) LIKE %:filter% OR " +
            "LOWER(e.location) LIKE %:filter% OR " +
            "LOWER(e.status) LIKE %:filter% OR " +
            "LOWER(e.department) LIKE %:filter% OR " +
            "LOWER(e.designation) LIKE %:filter%")
    List<EmployeeEntity> findByFilter(@Param("filter") String filter);

    @Query("SELECT e FROM EmployeeEntity e WHERE " +
            "(:status IS NULL OR LOWER(e.status) = LOWER(:status)) AND " +
            "(" +
            "LOWER(e.empId) LIKE LOWER(CONCAT('%', :filter, '%')) OR " +
            "LOWER(e.firstName) LIKE LOWER(CONCAT('%', :filter, '%')) OR " +
            "LOWER(e.lastName) LIKE LOWER(CONCAT('%', :filter, '%')) OR " +
            "LOWER(e.role) LIKE LOWER(CONCAT('%', :filter, '%')) OR " +
            "LOWER(e.mail) LIKE LOWER(CONCAT('%', :filter, '%')) OR " +
            "LOWER(e.mobile) LIKE LOWER(CONCAT('%', :filter, '%')) OR " +
            "LOWER(e.location) LIKE LOWER(CONCAT('%', :filter, '%')) OR " +
            "LOWER(e.department) LIKE LOWER(CONCAT('%', :filter, '%')) OR " +
            "LOWER(e.designation) LIKE LOWER(CONCAT('%', :filter, '%'))" +
            ")")
    List<EmployeeEntity> findByStatusAndFilter(@Param("status") String status, @Param("filter") String filter);

}