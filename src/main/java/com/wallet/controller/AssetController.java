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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.util.List;

@Controller
public class AssetController {

    @Autowired
    AssetService assetService;

    @Autowired
    WalletService walletService;

    @GetMapping("/asset/{id}")
    public String showRemoveAssetPage(@PathVariable("id") int id, Model model) {

        Asset asset = assetService.findById(id);
        model.addAttribute("asset", asset);

        return "delete_asset_page";
    }

    @GetMapping("/asset/refresh/{id}")
    public String refreshAssetPrice(@PathVariable("id") int id, Model model) throws IOException {
        Wallet wallet = walletService.getByName(assetService.findById(id).getWallet());

        assetService.refreshAssetPrice(id);

        List<Asset> assets = assetService.findAssetsByWallet(wallet.getName());
        model.addAttribute("wallet", wallet);
        model.addAttribute("assets", assets);

        return "wallet_view";
    }

    @GetMapping("/asset/delete/{id}")
    public String deleteAsset(@PathVariable("id") int id, Model model) {

        Wallet wallet = walletService.getByName(assetService.findById(id).getWallet());

        assetService.deleteAsset(id);

        List<Asset> assets = assetService.findAssetsByWallet(wallet.getName());
        model.addAttribute("wallet", wallet);
        model.addAttribute("assets", assets);

        return "wallet_view";
    }

    @GetMapping("/asset/edit/{id}")
    public String showEditAssetPage(@PathVariable("id") int id, Model model) {

        Asset asset = assetService.findById(id);
        model.addAttribute("asset", asset);
        model.addAttribute("wallets", walletService.getWallets());

        return "edit_asset";
    }

    @PostMapping("/asset/update/{id}")
    public String updateAsset(@PathVariable("id") int id, Asset updatedAsset, Model model) {

        assetService.updateAsset(updatedAsset);
        model.addAttribute("wallet", walletService.getByName(updatedAsset.getWallet()));
        model.addAttribute("assets", assetService.findAssetsByWallet(updatedAsset.getWallet()));

        return "wallet_view";
    }

    @GetMapping("/asset")
    public String addAssetPage(Model model, Wallet wallet) {

        model.addAttribute("asset", new Asset());
        model.addAttribute("wallet", wallet);
        model.addAttribute("wallets", walletService.getWallets());

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
