package xyz.alxcy.mcpserver.stock.strategy;

import java.math.BigDecimal;

public interface CalculateCommissionStrategy {

    /**
     * 计算佣金
     * @param stockPrice 股票价格
     * @param stockNumber 股票数量
     * @return 佣金
     */
    BigDecimal calculateCommission(BigDecimal stockPrice, int stockNumber);
}
