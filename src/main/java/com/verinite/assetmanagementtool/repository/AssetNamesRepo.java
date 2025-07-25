package com.verinite.assetmanagementtool.repository;

import com.verinite.assetmanagementtool.dto.AssetNameDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetNamesRepo extends JpaRepository<AssetNameDTO, Long> {

    AssetNameDTO findByAssetName(String assetName);
}
