package com.wallet.service;

import com.wallet.model.Asset;
import com.wallet.repository.AssetCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AssetService {

    @Autowired
    private AssetCrudRepository assetCrudRepository;

    public Asset findById(int id) {
        return assetCrudRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(id + " asset not found"));
    }

    public Asset addAsset(Asset asset) {
        List<String> tickers = findAssetsByWallet(asset.getWallet()).stream()
                .map(Asset::getTicker)
                .map(String::toLowerCase)
                .collect(Collectors.toList());

        if(tickers.contains(asset.getTicker().toLowerCase())) {
            return asset;
        } else {
            return assetCrudRepository.save(asset);
        }
    }

    public Asset updateAsset(Asset updatedAsset) {
        return assetCrudRepository.save(updatedAsset);
    }

    public void deleteAsset(int id) {
        assetCrudRepository.deleteById(id);
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
