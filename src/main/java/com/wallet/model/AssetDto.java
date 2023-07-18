package com.wallet.model;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class AssetDto {

    private int id;

    @NotEmpty(message = "ticker must not be empty")
    private String ticker;

    @NotEmpty(message = "name must not be empty")
    private String name;

    @NotEmpty(message = "asset class must not be empty")
    private String assetClass;

    @NotEmpty(message = "quantity must not be empty")
    private double quantity;

    @NotEmpty(message = "buy price must not be empty")
    private double buyPrice;

    @NotEmpty(message = "last price must not be empty")
    private double lastPrice;

    @NotEmpty(message = "buy date must not be empty")
    private LocalDate buyDate;
    @NotNull
    private double marketValue;
    @NotNull
    private double unrealizedPnL;

    @NotEmpty
    private String wallet;
}
