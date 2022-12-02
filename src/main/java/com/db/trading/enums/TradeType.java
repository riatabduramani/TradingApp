package com.db.trading.enums;

public enum TradeType {
    SETUP("setup"),
    REVERSE("reverse");

    public final String value;

    TradeType(String value) {
        this.value = value;
    }
}
