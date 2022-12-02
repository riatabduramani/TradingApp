package com.db.trading.dto;

import com.db.trading.enums.TradeType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Signal {
    private Integer signal;
    private TradeType type;
    private Boolean calculate;
    private List<ParamList> params;

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ParamList {
        private int param;
        private int value;
    }
}
