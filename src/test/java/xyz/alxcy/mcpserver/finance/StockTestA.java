package xyz.alxcy.mcpserver.finance;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import xyz.alxcy.mcpserver.stock.enums.TradeType;
import xyz.alxcy.mcpserver.stock.strategy.BuyCalculateCommission;
import xyz.alxcy.mcpserver.stock.strategy.SoldOutCalculateCommission;

import java.math.BigDecimal;

@SpringBootTest
public class StockTestA {


    /**
     * 计算佣金测试
     */
    @Test
    public void test1(){
        BigDecimal unitPrice = new BigDecimal("52.750");
        int number = 5000;
        TradeType tradeType = TradeType.SELL;

        BigDecimal commission;
        if (tradeType == TradeType.BUY) {
            // 买入时计算佣金
            commission = new BuyCalculateCommission().calculateCommission(unitPrice, number);
        }else if(tradeType == TradeType.SELL){
            // 卖出时计算佣金
            commission = new SoldOutCalculateCommission().calculateCommission(unitPrice, number);
        }else{
            throw new RuntimeException("交易类型错误");
        }

        System.out.println(commission);
    }
}
