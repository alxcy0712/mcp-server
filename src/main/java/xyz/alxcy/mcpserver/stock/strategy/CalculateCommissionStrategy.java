package xyz.alxcy.mcpserver.stock.strategy;

import java.math.BigDecimal;

public interface CalculateCommissionStrategy {

    BigDecimal calculateCommission(BigDecimal stockPrice, int stockNumber);
}
