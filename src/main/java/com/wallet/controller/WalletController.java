package com.wallet.controller;

import com.wallet.model.Wallet;
import com.wallet.model.WalletDto;
import com.wallet.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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

    @GetMapping("/edit/{id}")
    public String editWalletNamePage(@PathVariable("id") int id, Model model) {

        Wallet wallet = walletService.findById(id);
        model.addAttribute("wallet", wallet);

        return "edit_wallet_page";
    }

    @PostMapping("/wallet/edit/{id}")
    public String renameWallet(@PathVariable("id") int id, @Valid Wallet wallet, Model model) {

        walletService.updateWallet(wallet.getId(), wallet.getName());

        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String showDeleteWalletPage(@PathVariable("id") int id, Model model) {

        Wallet wallet = walletService.findById(id);
        model.addAttribute("wallet", wallet);

        return "delete_wallet_page";
    }

    @GetMapping("/wallet/delete/{id}")
    public String deleteWallet(@PathVariable("id") int id, Model model) {

        walletService.deleteWallet(id);

        return "redirect:/";
    }

}
