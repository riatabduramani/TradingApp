package com.db.trading.dto;

import com.db.trading.enums.TradeType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import javax.validation.constraints.NotNull;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TradeSignalRequest {

    @NotNull(message = "Please add trading signal number")
    private Integer signal;

    @NotNull(message = "Please add trading signal type")
    private TradeType type;

    @NotNull(message = "Please add trading signal specification/s")
    private Boolean calculate;

    @NotNull(message = "Please add trading signal specification/s")
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
