package com.wallet.controller;

import com.wallet.model.Wallet;
import com.wallet.model.WalletDto;
import com.wallet.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class WalletController {

    @Autowired
    WalletService walletService;

    @GetMapping("/wallet")
    public String addWalletForm(Model model) {

        model.addAttribute("wallet", new Wallet());

        return "add_wallet_page";
    }

    @PostMapping("/wallet")
    public String addWallet(@ModelAttribute WalletDto walletDto) {

        walletService.addWallet(walletDto.getName());

        return "redirect:/";
    }

    @GetMapping("/deleteWallet")
    public String deleteWallet(@ModelAttribute Wallet wallet) {

//        model.addAttribute("wallet", wallet);

        return "delete_wallet_page";
    }
}
