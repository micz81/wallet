package com.wallet.model;

public enum AssetClass {
    STOCK("stock"),
    BOND("bond"),
    ETF("ETF"),
    REIT("REIT"),
    CRYPTO("crypto"),
    CASH("cash"),
    PHYS("physical metals");

    private final String displayValue;

    private AssetClass(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
