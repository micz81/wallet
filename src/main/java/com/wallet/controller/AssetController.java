package com.wallet.controller;

import com.wallet.model.Asset;
import com.wallet.model.Wallet;
import com.wallet.service.AssetService;
import com.wallet.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class AssetController {

    @Autowired
    AssetService assetService;

    @Autowired
    WalletService walletService;

    @GetMapping("/asset")
    public String addAssetPage(Model model, Wallet wallet) {

        model.addAttribute("asset", new Asset());
        model.addAttribute("wallet", wallet);

        return "add_asset";
    }

    @PostMapping("/asset")
    public String addAsset(@ModelAttribute Asset asset, Model model) {

        assetService.addAsset(asset);
        int walletId = walletService.findWalletIdforAsset(asset);

        model.addAttribute("wallet", walletService.findById(walletId));
        model.addAttribute("assets", assetService.findAssetsByWallet(asset.getWallet()));

        return "wallet_view";

    }
}
