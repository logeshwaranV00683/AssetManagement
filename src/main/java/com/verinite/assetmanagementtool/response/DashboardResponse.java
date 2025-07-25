package com.verinite.assetmanagementtool.response;

import com.verinite.assetmanagementtool.entity.AssetsEntity;
import com.verinite.assetmanagementtool.entity.LocationEntity;

import java.util.List;

public class DashboardResponse {
    // assetType+location+unassined
    List<AssetsEntity> assetsEntities;
    List<LocationEntity> locationEntities;

    public DashboardResponse() {
        super();
    }

    public DashboardResponse(List<AssetsEntity> assetsEntities, List<LocationEntity> locationEntities) {
        super();
        this.assetsEntities = assetsEntities;
        this.locationEntities = locationEntities;
    }

    public List<AssetsEntity> getAssetsEntities() {
        return assetsEntities;
    }

    public void setAssetsEntities(List<AssetsEntity> assetsEntities) {
        this.assetsEntities = assetsEntities;
    }

    public List<LocationEntity> getLocationEntities() {
        return locationEntities;
    }

    public void setLocationEntities(List<LocationEntity> locationEntities) {
        this.locationEntities = locationEntities;
    }

}
