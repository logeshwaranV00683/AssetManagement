package com.verinite.assetmangementtool.service;

import com.verinite.assetmangementtool.entity.AssetsHistoryEntity;
import com.verinite.assetmangementtool.repository.AssetsHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetsHistoryServiceImpl implements AssetsHistoryServices {

    @Autowired
    AssetsHistoryRepository assetsHistoryRepository;

    @Override
    public AssetsHistoryEntity saveHistory(AssetsHistoryEntity assetsHistoryEntity) {

        return assetsHistoryRepository.save(assetsHistoryEntity);

    }

    @Override
    public List<AssetsHistoryEntity> getAll() {
        return assetsHistoryRepository.findAll();
    }

    @Override
    public Object getByHistoryId(String serialNumber) {

        for (AssetsHistoryEntity assetsHistoryEntity : getAll()) {
            if (serialNumber.equalsIgnoreCase(assetsHistoryEntity.getSerialNumber())) {
                return assetsHistoryRepository.findById(assetsHistoryEntity.getHistoryId()).orElseThrow(() -> new UsernameNotFoundException(" there is no Asset  not found with serial number " + serialNumber));

            }
        }
        return null;
    }

}