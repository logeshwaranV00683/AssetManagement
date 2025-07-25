package com.verinite.assetmanagementtool.repository;

import com.verinite.assetmanagementtool.entity.AssetTypes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DashboardRepo extends JpaRepository<AssetTypes, Integer> {

}
