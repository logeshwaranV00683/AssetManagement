package com.verinite.assetmanagementtool.service;


import com.verinite.assetmanagementtool.entity.ScrapEntity;

import java.util.List;

public interface ScrapService {
    ScrapEntity postScrap(ScrapEntity scrapTable);

    List<ScrapEntity> getScrap();

    Object getScrapById(int scrapId);

    Object ScrapPut(ScrapEntity scrapTable, int scrapId);
}
