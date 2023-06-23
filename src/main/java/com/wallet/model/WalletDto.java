package com.wallet.model;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class WalletDto {

    private int id;

    @NotEmpty(message = "Wallet name can't be empty")
    private String name;
}
