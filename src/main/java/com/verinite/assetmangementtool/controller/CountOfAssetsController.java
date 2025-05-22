package com.verinite.assetmangementtool.controller;

import com.verinite.assetmangementtool.entity.AssetsEntity;
import com.verinite.assetmangementtool.entity.CountOfAssets;
import com.verinite.assetmangementtool.service.AssetService;
import com.verinite.assetmangementtool.service.CountOFAssetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/assetManager/v1/")
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
//@CrossOrigin(origins = "https://asset-tool.netlify.app", allowedHeaders = "*", allowCredentials = "true")
public class CountOfAssetsController {
    @Autowired
    CountOFAssetsService countOFAssetsService;

    @Autowired
    private AssetService assetService;

    @PostMapping("save/count")
    public CountOfAssets saveCount(@RequestBody CountOfAssets countOfAssets) {
        return countOFAssetsService.postAssestCount(countOfAssets);
    }

    @GetMapping("Assetcount/allLocationCount")
    public List<CountOfAssets> getAll() {
        return countOFAssetsService.getAll();
    }

    @PutMapping("update/count/{location}")
    public Object updateCount(@PathVariable String location, @RequestBody CountOfAssets countOfAssets) {
        return countOFAssetsService.updateAssetCount(location, countOfAssets);
    }

    @GetMapping("count/totallaptops")
    public int getAllLaptopCount() {
        return countOFAssetsService.totalLaptops();
    }

    @GetMapping("/unassignedCount")
    public ResponseEntity<Integer> getCountOfUnassigned() {
        int unassignedCount = assetService.getCountOfUnassigned();
        return ResponseEntity.ok(unassignedCount);
    }

    @GetMapping("/assignedCount")
    public ResponseEntity<Integer> getCountOfAssigned() {
        int assignedCount = assetService.getCountOfAssigned();
        return ResponseEntity.ok(assignedCount);
    }

    @GetMapping("/count/laptops/{locationId}")
    public ResponseEntity<Integer> getLaptopCountByLocation(@PathVariable String locationId) {
        int laptopCount = assetService.getLaptopCountByLocation(locationId);
        return ResponseEntity.ok(laptopCount);
    }

    @GetMapping("/unassignedList")
    public ResponseEntity<List<AssetsEntity>> getUnAssignedAssets() {
        List<AssetsEntity> unAssignedAssets = assetService.getUnAssigned();
        return ResponseEntity.ok(unAssignedAssets);
    }

    @GetMapping("/assignedList")
    public ResponseEntity<List<AssetsEntity>> getAssignedAssets() {
        List<AssetsEntity> assignedAssets = assetService.getAssigned();
        return ResponseEntity.ok(assignedAssets);
    }

}
