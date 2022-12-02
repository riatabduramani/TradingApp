package com.db.trading.dto;

import com.db.trading.enums.TradeType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TradeSignalRequest {
    private Integer signal;
    private TradeType type;
    private Boolean calculate;
    private List<Specification> specifications;

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Specification {
        private int param;
        private int value;
    }
}
