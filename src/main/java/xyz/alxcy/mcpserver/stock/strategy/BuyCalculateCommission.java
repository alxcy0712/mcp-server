package xyz.alxcy.mcpserver.stock.strategy;


import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static xyz.alxcy.mcpserver.stock.entity.CommissionEntity.*;

/**
 * 买入时计算佣金
 */
@Service
public class BuyCalculateCommission implements CalculateCommissionStrategy{

    @Override
    public BigDecimal calculateCommission(BigDecimal stockPrice, int stockNumber) {
        // 1. 计算总金额
        BigDecimal totalAmount = stockPrice.multiply(new BigDecimal(stockNumber));
        // 2. 计算佣金
        BigDecimal commission = totalAmount.multiply(COMMISSION_RATE);
        // 佣金不能低于最低佣金金额
        commission = commission.compareTo(new BigDecimal(MIN_COMMISSION)) < 0 ? new BigDecimal(MIN_COMMISSION) : commission;
        // 3. 计算其他费用
        BigDecimal otherFee = totalAmount.multiply(OTHER_FEE);
        // 4. 计算总佣金
        return commission.add(otherFee).setScale(SCALE, RoundingMode.HALF_UP);
    }
}
