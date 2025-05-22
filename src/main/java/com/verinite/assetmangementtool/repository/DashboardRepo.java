package com.verinite.assetmangementtool.repository;

import com.verinite.assetmangementtool.entity.AssetTypes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DashboardRepo extends JpaRepository<AssetTypes, Integer> {

}
