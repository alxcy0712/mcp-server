package xyz.alxcy.mcpserver.finance;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Random;

@SpringBootTest
public class FinanceTest {

    /**
     * 复利计算
     */
    @Test
    void test1(){
        // 初始本金
        final BigDecimal startMoney = new BigDecimal(20_0000);
        //每个月赚百分之几
        final float fixRatio = 1.0f;
        //模拟多少个月
        final int fixMonth = 12*1;

        System.out.printf("========= 本金%6.2f   共%d个月 =========\n", startMoney.doubleValue(), fixMonth);

        BigDecimal money = startMoney;
        float[] ratioArray = new float[fixMonth];
        // 填充元素到数组中
        fillArray(ratioArray, fixRatio, true);

        for (int i = 0; i < fixMonth; i++) {
            double ratio = ratioArray[i];
            BigDecimal newMoney = money
                    .multiply(new BigDecimal("100")
                            .add(new BigDecimal(ratio))
                            .divide(new BigDecimal("100"), 4, RoundingMode.HALF_DOWN));
            double earn = newMoney.subtract(money).doubleValue();
            double earnTotal = newMoney.subtract(startMoney).doubleValue();
            double earnRatio = BigDecimal.valueOf(earnTotal)
                    .multiply(new BigDecimal("100"))
                    .divide(new BigDecimal(String.valueOf(startMoney)), 2, RoundingMode.HALF_DOWN).floatValue();
            System.out.printf("第%03d个月  ｜  当月收益率%6.2f%%  ｜  当月获利%6.2f  ｜  总收益%8.2f  ｜  收益率%6.2f%%  ｜  总金额%8.2f\n",
                    (i + 1), ratio, earn, earnTotal, earnRatio, newMoney.floatValue());
            money = newMoney;
        }
    }


    /**
     * 计算复利
     * 循环
     */
    @Test
    void test2(){
        // 初始本金
        final BigDecimal startMoney = new BigDecimal("200000");
        //每个月赚百分之几
        final float fixRatio = 3.0f;
        //模拟多少个月
        final int fixMonth = 12;
        // 模拟多少次循环
        final int fixCycle = 1000000;

        // 记录
        double minFinalMoney = Double.MAX_VALUE;
        double maxFinalMoney = Double.MIN_VALUE;
        long averageFinalMoney = 0;

        System.out.printf("========= 本金%6.2f   共%d个月 =========\n", startMoney.doubleValue(), fixMonth);
        for(int cycle = 0 ; cycle < fixCycle ; cycle++){
            BigDecimal money = startMoney;
            float[] ratioArray = new float[fixMonth];
            // 填充元素到数组中
            fillArray(ratioArray, fixRatio, false);
            for (int i = 0; i < fixMonth; i++) {
                double ratio = ratioArray[i];
                BigDecimal newMoney = money
                        .multiply(new BigDecimal("100")
                                .add(new BigDecimal(ratio))
                                .divide(new BigDecimal("100"), 2, RoundingMode.HALF_DOWN));
                money = newMoney;
            }
            minFinalMoney = Math.min(minFinalMoney , money.doubleValue());
            maxFinalMoney = Math.max(maxFinalMoney, money.doubleValue());
            averageFinalMoney += money.doubleValue();
//            System.out.printf("本金%6d  第%3d次循环 平均月化收益%6.2f%% 复利后总金额%6d\n", startMoney, (cycle + 1), (double)Arrays.stream(ratioArray).sum()/fixMonth ,money);
        }

        System.out.printf("本金%6.2f  %d次循环  平均复利后总金额%6.2f  最大获利%6.2f 最小获利%6.2f\n",startMoney.doubleValue(), fixCycle, (double)averageFinalMoney/fixCycle , maxFinalMoney , minFinalMoney);
    }

    /**
     * 填充数组
     * @param array 数组
     * @param fixValue 固定值
     * @param fixMode 是否固定
     */
    static void fillArray(final float[] array, final float fixValue, final boolean fixMode) {
        if (fixMode) {
            Arrays.fill(array, fixValue);
        }else{
            // value值应该在-10到10之间
            for (int i = 0; i < array.length; i++) {
                array[i] = nextNormalDistributedInt(-10,10 , 3.0f); // 生成-10到10之间的随机数
            }
        }
    }

    /**
     * 生成正态分布的随机数
     * @param leftBorder 左边界
     * @param rightBorder 右边界
     * @param standardDeviation 标准差
     * @return
     */
    static int nextNormalDistributedInt(final int leftBorder,
                                                final int rightBorder,
                                                final double standardDeviation) {
        final Random random = new Random();

        // 生成符合正态分布的值
        double value = random.nextGaussian() * standardDeviation;

        // 将值限制在-10到10范围内
        value = Math.max(leftBorder, Math.min(rightBorder, value));

        // 四舍五入为整数
        return (int) Math.round(value);
    }

}
