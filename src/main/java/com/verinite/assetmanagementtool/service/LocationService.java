package com.verinite.assetmanagementtool.service;

import com.verinite.assetmanagementtool.entity.LocationEntity;

import java.util.List;


public interface LocationService {
    LocationEntity saveLocation(LocationEntity location);

    Object getLocatioById(int id);

    List<Object> getByStateName(String locName);

    List<Object> getByCountry(String countryName);

    List<LocationEntity> getAllLocations();

    Object updateLocation(int id, LocationEntity location);


}
