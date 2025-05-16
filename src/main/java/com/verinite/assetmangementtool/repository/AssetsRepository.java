package com.verinite.assetmangementtool.repository;

import java.util.List;
import java.util.Optional;

import com.verinite.assetmangementtool.entity.AssignedAssetsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.verinite.assetmangementtool.entity.AssetsEntity;

import javax.transaction.Transactional;

@Repository
public interface AssetsRepository extends JpaRepository<AssetsEntity, Number> {

	List<AssetsEntity> findByStatus(String str);
	List<AssetsEntity>	findAllByOrderByAssetIdDesc();
	@Query(value = "select laptop_count from tbl_Count where id=?1", nativeQuery = true)
	int getTotal(int id);

	AssetsEntity findBySerialNumber(String id);

	Optional<AssetsEntity> findByAssetId(int assetId);

	Optional<AssetsEntity> findByEmpId(String empId);

	@Query(value = "SELECT LOWER(asset_name) AS assetName, LOWER(location) AS location, "
			+ "SUM(CASE WHEN LOWER(status) = 'unassigned' THEN 1 ELSE 0 END) AS unassignedCount, "
			+ "SUM(CASE WHEN LOWER(status) = 'assigned' THEN 1 ELSE 0 END) AS assignedCount, "
			+ "SUM(CASE WHEN LOWER(status) IN ('unassigned', 'assigned') THEN 1 ELSE 0 END) AS totalCount "
			+ "FROM tbl_assets " + "WHERE LOWER(location) IN :locations "
			+ "GROUP BY LOWER(asset_name), LOWER(location)", nativeQuery = true)
	List<Object[]> findAggregatedAssetCountsByLocation(@Param("locations") List<String> locations);

	@Query(value = "SELECT LOWER(location) AS location, " + "LOWER(asset_name) AS assetName, "
			+ "SUM(CASE WHEN LOWER(status) = 'unassigned' THEN 1 ELSE 0 END) AS unassignedCount, "
			+ "SUM(CASE WHEN LOWER(status) = 'assigned' THEN 1 ELSE 0 END) AS assignedCount, "
			+ "SUM(CASE WHEN LOWER(status) IN ('unassigned', 'assigned') THEN 1 ELSE 0 END) AS totalCount "
			+ "FROM tbl_assets " + "WHERE LOWER(location) IN :locations "
			+ "GROUP BY LOWER(location), LOWER(asset_name)", nativeQuery = true)
	List<Object[]> findAggregatedAssetCountsByLocations(@Param("locations") List<String> locations);

	//@Query("SELECT DISTINCT LOWER(a.location) FROM tbl_assets a")
	//List<String> findDistinctLocations();
	@Transactional
	@Modifying
	@Query(value = "update tbl_assets set status =:status where serial_number =:serialNumber", nativeQuery = true)
	int updateUnassignStatus(@Param("status") String status,@Param("serialNumber") String serialNumber);
	@Query(value = "SELECT LOWER(location) AS location," +
            "SUM(CASE WHEN LOWER(status) = 'unassigned' THEN 1 ELSE 0 END) AS unassignedCount, " +
            "SUM(CASE WHEN LOWER(status) = 'assigned' THEN 1 ELSE 0 END) AS assignedCount, " +
            "SUM(CASE WHEN LOWER(status) IN ('unassigned', 'assigned') THEN 1 ELSE 0 END) AS totalCount " +
            "FROM tbl_assets " +
            "WHERE LOWER(asset_name) = LOWER(:assetName) " +
            "GROUP BY LOWER(location), LOWER(asset_name)", 
    nativeQuery = true)
List<Object[]> findAggregatedAssetCountsByAssetNameAndLocation(@Param("assetName") String assetName);

	@Query(value = "SELECT DISTINCT LOWER(a.asset_name) FROM tbl_assets a",nativeQuery = true)
	List<String> findDistinctAssetTypes();

	// Method to find assets by status with filter
	@Query("SELECT a FROM AssetsEntity a WHERE LOWER(a.status) = LOWER(:status) AND ("
			+ "LOWER(a.assetName) LIKE LOWER(:filter) "
			+ "OR LOWER(a.serialNumber) LIKE LOWER(:filter) "
			+ "OR LOWER(a.empId) LIKE LOWER(:filter) "
			+ "OR LOWER(a.type) LIKE LOWER(:filter) "
			+ "OR LOWER(a.purchaseDate) LIKE LOWER(:filter) "
			+ "OR LOWER(a.warrantyDate) LIKE LOWER(:filter) "
			+ "OR LOWER(a.location) LIKE LOWER(:filter) "
			+ "OR LOWER(CAST(a.locCode AS string)) LIKE LOWER(:filter) "
			+ "OR LOWER(a.modelName) LIKE LOWER(:filter) "
			+ "OR LOWER(a.operatingSystem) LIKE LOWER(:filter) "
			+ "OR LOWER(CAST(a.returnDate AS string)) LIKE LOWER(:filter) "
			+ "OR LOWER(a.addedBy) LIKE LOWER(:filter) "
			+ "OR LOWER(CAST(a.assignedDate AS string)) LIKE LOWER(:filter) "
			+ "OR LOWER(a.assignedBy) LIKE LOWER(:filter) "
			+ "OR LOWER(CAST(a.assetId AS string)) LIKE LOWER(:filter))"
			+ "OR LOWER(CAST(a.assertSourcedBy AS string)) LIKE LOWER(:filter)")
	List<AssetsEntity> findByStatusAndFilter(@Param("status") String status, @Param("filter") String filter);

	// Method to find assets using only a filter (without status)
	@Query("SELECT a FROM AssetsEntity a WHERE "
			+ "LOWER(a.assetName) LIKE LOWER(:filter) "
			+ "OR LOWER(a.serialNumber) LIKE LOWER(:filter) "
			+ "OR LOWER(a.empId) LIKE LOWER(:filter) "
			+ "OR LOWER(a.type) LIKE LOWER(:filter) "
			+ "OR LOWER(a.purchaseDate) LIKE LOWER(:filter) "
			+ "OR LOWER(a.warrantyDate) LIKE LOWER(:filter) "
			+ "OR LOWER(a.location) LIKE LOWER(:filter) "
			+ "OR LOWER(CAST(a.locCode AS string)) LIKE LOWER(:filter) "
			+ "OR LOWER(a.modelName) LIKE LOWER(:filter) "
			+ "OR LOWER(a.operatingSystem) LIKE LOWER(:filter) "
			+ "OR LOWER(CAST(a.returnDate AS string)) LIKE LOWER(:filter) "
			+ "OR LOWER(a.addedBy) LIKE LOWER(:filter) "
			+ "OR LOWER(CAST(a.assignedDate AS string)) LIKE LOWER(:filter) "
			+ "OR LOWER(a.assignedBy) LIKE LOWER(:filter) "
			+ "OR LOWER(CAST(a.assetId AS string)) LIKE LOWER(:filter)"
			+ "OR LOWER(CAST(a.assertSourcedBy AS string)) LIKE LOWER(:filter)")
	List<AssetsEntity> findByFilter(@Param("filter") String filter);

}
