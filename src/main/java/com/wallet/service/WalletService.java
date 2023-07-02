package com.wallet.service;

import com.wallet.model.Asset;
import com.wallet.model.Wallet;
import com.wallet.repository.WalletCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WalletService {

    @Autowired
    private WalletCrudRepository walletCrudRepository;

    public List<Wallet> getWallets() {
        return walletCrudRepository.findAll();
    }

    public Wallet getByName(String name) {
        return walletCrudRepository.findByName(name);
    }

    public Wallet addWallet(String name) {
        Wallet wallet = Wallet.builder()
                .name(name)
                .build();
        return walletCrudRepository.save(wallet);
    }

    public Wallet updateWallet(int id, String name) {
        Wallet wallet = Wallet.builder()
                .id(id)
                .name(name)
                .build();
        return walletCrudRepository.save(wallet);
    }

    public void deleteWallet(int id) {
        walletCrudRepository.deleteById(id);
    }

    public Wallet findById(Integer id) {
        return walletCrudRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException(id + " wallet not found"));
    }


    public Integer findWalletIdforAsset(Asset asset) {
        return getWallets().stream()
                .filter(w -> w.getName().equals(asset.getWallet()))
                .map(Wallet::getId)
                .findFirst()
                .get();
    }
}
