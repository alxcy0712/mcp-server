package xyz.alxcy.mcpserver.finance;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import xyz.alxcy.mcpserver.stock.entity.SinaAStockResult;
import xyz.alxcy.mcpserver.stock.enums.TradeType;
import xyz.alxcy.mcpserver.stock.service.SinaService;
import xyz.alxcy.mcpserver.stock.strategy.BuyCalculateCommission;
import xyz.alxcy.mcpserver.stock.strategy.SoldOutCalculateCommission;

import java.math.BigDecimal;
import java.math.RoundingMode;

@SpringBootTest
@Slf4j
public class StockTestA {

    @Resource
    private SinaService sinaService;


    /**
     * 计算佣金测试
     */
    @Test
    public void test1(){
        BigDecimal unitPrice = new BigDecimal("5.34");
        int number = 5000;
        TradeType tradeType = TradeType.BUY;

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

    /**
     * 做t操作测试
     */
    @Test
    public void testMakeTOperation(){
        // 假设做t前后总股数不变，也就是说操作股数为固定值
        int stockNum = 10000;
        BigDecimal pricePre = new BigDecimal("5.31");
        BigDecimal priceAfter = new BigDecimal("5.33");

        // 买入手续费
        BigDecimal buyCommission = new BuyCalculateCommission().calculateCommission(pricePre, stockNum);
        // 卖出手续费
        BigDecimal sellCommission = new SoldOutCalculateCommission().calculateCommission(priceAfter, stockNum);
        // 净利润
        BigDecimal profit = priceAfter.multiply(BigDecimal.valueOf(stockNum)).subtract(pricePre.multiply(BigDecimal.valueOf(stockNum))).subtract(buyCommission).subtract(sellCommission);
        System.out.printf("买入手续费：%.2f，卖出手续费：%.2f，T操作净利润：%.2f\n" ,
                buyCommission.setScale(2, RoundingMode.HALF_UP).doubleValue(),
                sellCommission.setScale(2, RoundingMode.HALF_UP).doubleValue(),
                profit.setScale(2, RoundingMode.HALF_UP).doubleValue());
    }

    @Test
    public void testStockPrice(){
        String stockPrice = sinaService.getStockPrice("sh600000");
        SinaAStockResult sinaAStockResult = new SinaAStockResult(stockPrice);
        log.info("\n"+sinaAStockResult.getString());

    }
}
