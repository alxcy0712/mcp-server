package xyz.alxcy.mcpserver.stock.enums;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public enum TradeType {
    /**
     * 交易类型
     */
    BUY("买入"),
    SELL("卖出")
    ;
    private String name;
}
