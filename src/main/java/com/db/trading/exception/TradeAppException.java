package com.db.trading.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TradeAppException extends RuntimeException {
    public TradeAppException(String message) {
        super(message);
    }
}
