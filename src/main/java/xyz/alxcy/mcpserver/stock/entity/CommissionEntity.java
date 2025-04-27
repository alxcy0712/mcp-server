package xyz.alxcy.mcpserver.stock.entity;

import java.math.BigDecimal;

public class CommissionEntity {
    /**
     * 佣金费率 默认万分之一
     */
    public static final BigDecimal COMMISSION_RATE = new BigDecimal("0.0001");

    /**
     * 最低佣金 5元
     */
    public static final int MIN_COMMISSION = 5;

    /**
     * 印花税（国税局收取） 卖出时收取
     */
    public static final BigDecimal SOLD_OUT_STAMP_DUTY = new BigDecimal("0.0005");

    /**
     * 其他费用 包括过户费（中登结算收取）
     */
    public static final BigDecimal OTHER_FEE = new BigDecimal("0.00001");

    /**
     * 默认保留两位小数 四舍五入
     */
    public static final int SCALE = 2;
}
