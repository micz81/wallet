package com.wallet.service;

import com.wallet.model.Wallet;
import com.wallet.model.WalletDto;
import com.wallet.repository.WalletCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WalletService {

    @Autowired
    private WalletCrudRepository walletCrudRepository;

    public List<Wallet> getWallets() {
        return walletCrudRepository.findAll();
    }

    public Wallet addWallet(String name) {
        Wallet wallet = Wallet.builder()
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

    public void


}
