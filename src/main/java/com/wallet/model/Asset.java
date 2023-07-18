package com.wallet.model;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@DynamicUpdate
@Table(name = "asset")
public class Asset {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "ticker")
    private String ticker;

    @Column(name = "name")
    private String name;
    @Column(name = "asset_class")
    private AssetClass assetClass;

    @Column(name = "quantity")
    private double quantity;

    @Column(name = "buy_price")
    private BigDecimal buyPrice;

    @Column(name = "last_price")
    private BigDecimal lastPrice;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "buy_date")
    private LocalDate buyDate;

    @Column(name = "market_value")
    private BigDecimal marketValue;

    @Column(name = "unrealized_pnl")
    private BigDecimal unrealizedPnL;

    @Column(name = "wallet")
    private String wallet;

}
