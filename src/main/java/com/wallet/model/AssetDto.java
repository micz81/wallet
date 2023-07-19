package com.wallet.model;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
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
    private BigDecimal buyPrice;

    @NotEmpty(message = "last price must not be empty")
    private BigDecimal lastPrice;

    @NotEmpty(message = "buy date must not be empty")
    private LocalDate buyDate;
    @NotNull
    private BigDecimal marketValue;

    @NotNull
    private BigDecimal percentagePnL;

    @NotNull
    private BigDecimal unrealizedPnL;

    @NotEmpty
    private String wallet;
}
