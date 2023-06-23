package com.wallet.controller;

import com.wallet.model.Wallet;
import com.wallet.model.WalletDto;
import com.wallet.service.AssetService;
import com.wallet.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ApplicationController {

    @Autowired
    private AssetService assetService;
    @Autowired
    private WalletService walletService;

    @GetMapping("/")
    public String home(Model model) {

        List<WalletDto> wallets = walletService.getWallets().stream()
                .map(this::asDto)
                .collect(Collectors.toList());

        model.addAttribute("wallets", wallets);

        return "index";
    }

    public WalletDto asDto(Wallet wallet) {
        return WalletDto.builder()
                .id(wallet.getId())
                .name(wallet.getName())
                .build();
    }
}
