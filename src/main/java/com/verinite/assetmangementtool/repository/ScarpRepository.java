package com.verinite.assetmangementtool.repository;

import com.verinite.assetmangementtool.entity.ScrapEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ScarpRepository extends JpaRepository<ScrapEntity, Integer> {

    @Query("SELECT s FROM ScrapEntity s WHERE "
            + "LOWER(s.Assetname) LIKE LOWER(:filter) "
            + "OR LOWER(s.SerialNo) LIKE LOWER(:filter) "
            + "OR LOWER(CAST(s.purchaseDate AS string)) LIKE LOWER(:filter) "
            + "OR LOWER(CAST(s.warrantyDate AS string)) LIKE LOWER(:filter) "
            + "OR LOWER(s.users) LIKE LOWER(:filter) "
            + "OR LOWER(s.status) LIKE LOWER(:filter) "
            + "OR LOWER(s.type) LIKE LOWER(:filter) "
            + "OR LOWER(CAST(s.assetId AS string)) LIKE LOWER(:filter) "
            + "OR LOWER(CAST(s.scrapId AS string)) LIKE LOWER(:filter)")
    List<ScrapEntity> findByFilter(@Param("filter") String filter);
}
