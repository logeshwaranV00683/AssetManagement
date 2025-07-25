package com.verinite.assetmanagementtool.service.serviceImpl;


import com.verinite.assetmanagementtool.entity.DesignationEntity;
import com.verinite.assetmanagementtool.repository.DesignationRepository;
import com.verinite.assetmanagementtool.service.DesignationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DesignationServiceImpl implements DesignationService {
    @Autowired
    DesignationRepository repository;

    public DesignationEntity newDesigination(DesignationEntity designation) {
        return repository.save(designation);
    }

    public List<DesignationEntity> getAll() {
        return repository.findAll();
    }

    public DesignationEntity getByTitle(String title) {
        return repository.findByTitle(title);
    }

    public DesignationEntity getByCode(long code) {
        return repository.findByDescId(code);
    }

    public DesignationEntity getByPosition(String position) {
        return repository.findByPosition(position);
    }
}
