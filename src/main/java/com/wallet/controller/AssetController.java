package com.wallet.controller;

import com.wallet.model.Asset;
import com.wallet.model.Wallet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AssetController {

    @GetMapping("/asset")
    public String addAsset(Model model, Wallet wallet) {

        model.addAttribute("asset", new Asset());
        model.addAttribute("wallet", wallet);

        return "add_asset";
    }
}
