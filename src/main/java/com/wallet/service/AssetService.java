package com.wallet.service;

import com.wallet.model.Asset;
import com.wallet.repository.AssetCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetService {

    @Autowired
    private AssetCrudRepository assetCrudRepository;

    public Asset addAsset(Asset asset) {
        return assetCrudRepository.save(asset);
    }

    public List<Asset> getAssets() {
        return assetCrudRepository.findAll();
    }

    public void removeAllAssets() {
        assetCrudRepository.deleteAll();
    }
}
