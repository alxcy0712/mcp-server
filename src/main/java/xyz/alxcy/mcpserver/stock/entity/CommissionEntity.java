package xyz.alxcy.mcpserver.stock.entity;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import java.math.BigDecimal;

@Configuration
@Slf4j
public class CommissionEntity {
    /**
     * 佣金费率 默认万分之一
     */
    public static BigDecimal COMMISSION_RATE;

    /**
     * 最低佣金 5元
     */
    public static int MIN_COMMISSION;

    /**
     * 印花税（国税局收取） 卖出时收取
     */
    public static BigDecimal SOLD_OUT_STAMP_DUTY;

    /**
     * 其他费用 包括过户费（中登结算收取）
     */
    public static BigDecimal OTHER_FEE;

    /**
     * 默认保留两位小数 四舍五入
     */
    public static final int SCALE = 2;


    @Value("${stock.commission.rate}")
    private String commissionRate;
    @Value("${stock.commission.min}")
    private int commissionMin;
    @Value("${stock.commission.stamp}")
    private String soldOutStampDuty;
    @Value("${stock.commission.other}")
    private String otherFee;


    @PostConstruct
    public void init(){
        COMMISSION_RATE = new BigDecimal(commissionRate);
        MIN_COMMISSION = commissionMin;
        SOLD_OUT_STAMP_DUTY = new BigDecimal(soldOutStampDuty);
        OTHER_FEE = new BigDecimal(otherFee);
        log.info("【股票佣金】佣金初始化完毕");
        log.info("佣金费率：{} 最低佣金：{} 印花税：{} 其他费用：{}", COMMISSION_RATE, MIN_COMMISSION, SOLD_OUT_STAMP_DUTY, OTHER_FEE);
    }
}
