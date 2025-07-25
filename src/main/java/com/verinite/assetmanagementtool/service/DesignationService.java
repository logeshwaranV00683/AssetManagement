package com.verinite.assetmanagementtool.service;


import com.verinite.assetmanagementtool.entity.DesignationEntity;

import java.util.List;

public interface DesignationService {

    DesignationEntity newDesigination(DesignationEntity designation);

    List<DesignationEntity> getAll();

    DesignationEntity getByTitle(String title);

    DesignationEntity getByCode(long code);

    DesignationEntity getByPosition(String position);
}
