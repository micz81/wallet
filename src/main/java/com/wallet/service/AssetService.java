package com.wallet.service;

import com.wallet.model.Asset;
import com.wallet.repository.AssetCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<Asset> findAssetsByWallet(String wallet) {
        return assetCrudRepository.findAll()
                .stream()
                .filter(asset -> asset.getWallet() != null && asset.getWallet().equals(wallet))
                .collect(Collectors.toList());
    }

    public void removeAllAssets() {
        assetCrudRepository.deleteAll();
    }
}
