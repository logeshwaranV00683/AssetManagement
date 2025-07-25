package com.verinite.assetmanagementtool.service;

import com.verinite.assetmanagementtool.dto.AssetNameDTO;

import java.util.List;

public interface AssetNamesInterface {

    List<AssetNameDTO> getAll();

    AssetNameDTO save(AssetNameDTO assetNamesDto);
}
