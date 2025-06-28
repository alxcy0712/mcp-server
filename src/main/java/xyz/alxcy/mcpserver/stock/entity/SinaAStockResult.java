package xyz.alxcy.mcpserver.stock.entity;


import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 新浪股票返回结果
 * A股
 * 请求返回：浦发银行, -- 股票名称
 *          13.630, -- 今日开盘价
 *          13.620, -- 昨日收盘价
 *          13.550, -- 当前价格
 *          13.990, -- 今日最高价
 *          13.440, -- 今日最低价
 *          13.540, -- 竞买价，即“买一”报价
 *          13.550, -- 竞卖价，即“卖一”报价
 *          145112686, -- 成交的股票数，由于股票交易以一百股为基本单位，所以在使用时，通常把该值除以一百
 *          1990098971.000, -- 成交金额，单位为“元”，为了一目了然，通常以“万元”为成交金额的单位，所以通常把该值除以一万
 *          8100, -- 买一申请8100股，即81手
 *          13.540, -- 买一报价
 *          32100, -- 买二申请
 *          13.530, -- 买二报价
 *          154700, -- 买三申请
 *          13.520, -- 买三报价
 *          4200, -- 买四申请
 *          13.510, -- 买四报价
 *          172804, --买五申请
 *          13.500, -- 买五报价
 *          38897, -- 卖一申请
 *          13.550, -- 卖一报价
 *          94041, -- 卖二申请
 *          13.560, -- 卖二报价
 *          298100, -- 卖三申请
 *          13.570, -- 卖三报价
 *          28700, -- 卖四申请
 *          13.580, -- 卖四报价
 *          26200, -- 卖五申请
 *          13.590, -- 卖五报价
 *          2025-06-27, -- 日期
 *          15:00:03, -- 时间
 *          00,
 */
public class SinaAStockResult {

    /** 股票名称*/
    private String stockName;
    /** 今日开盘价*/
    private String todayOpenPrice;
    /** 昨日收盘价*/
    private String yesterdayClosePrice;
    /** 当前价格*/
    private String currentPrice;
    /** 今日最高价*/
    private String todayHighestPrice;
    /** 今日最低价*/
    private String todayLowestPrice;
    /** 竞买价，即“买一”报价*/
    private String currentBuyPrice;
    /** 竞卖价，即“卖一”报价*/
    private String currentAskPrice;
    /** 成交的股票数，由于股票交易以一百股为基本单位，所以在使用时，通常把该值除以一百*/
    private String dealStockNum;
    /** 成交金额，单位为“元”，为了一目了然，通常以“万元”为成交金额的单位，所以通常把该值除以一万*/
    private String dealAmount;
    /** 买一申请股数，手数应该除以100*/
    private String buyOneNum;
    /** 买一报价*/
    private String buyOnePrice;
    /** 买二申请股数，手数应该除以100*/
    private String buyTwoNum;
    /** 买二报价*/
    private String buyTwoPrice;
    /** 买三申请股数，手数应该除以100*/
    private String buyThreeNum;
    /** 买三报价*/
    private String buyThreePrice;
    /** 买四申请股数，手数应该除以100*/
    private String buyFourNum;
    /** 买四报价*/
    private String buyFourPrice;
    /** 买五申请股数，手数应该除以100*/
    private String buyFiveNum;
    /** 买五报价*/
    private String buyFivePrice;
    /** 卖一申请股数，手数应该除以100*/
    private String sellOneNum;
    /** 卖一报价*/
    private String sellOnePrice;
    /** 卖二申请股数，手数应该除以100*/
    private String sellTwoNum;
    /** 卖二报价*/
    private String sellTwoPrice;
    /** 卖三申请股数，手数应该除以100*/
    private String sellThreeNum;
    /** 卖三报价*/
    private String sellThreePrice;
    /** 卖四申请股数，手数应该除以100*/
    private String sellFourNum;
    /** 卖四报价*/
    private String sellFourPrice;
    /** 卖五申请股数，手数应该除以100*/
    private String sellFiveNum;
    /** 卖五报价*/
    private String sellFivePrice;
    /** 日期*/
    private String date;
    /** 时间*/
    private String time;
    /** 00*/
    private String zero;


    public SinaAStockResult(String dataStr){
        String[] dataArr = dataStr.split(",");
        this.stockName = dataArr[0];
        this.todayOpenPrice = dataArr[1];
        this.yesterdayClosePrice = dataArr[2];
        this.currentPrice = dataArr[3];
        this.todayHighestPrice = dataArr[4];
        this.todayLowestPrice = dataArr[5];
        this.currentBuyPrice = dataArr[6];
        this.currentAskPrice = dataArr[7];
        this.dealStockNum = dataArr[8];
        this.dealAmount = dataArr[9];
        this.buyOneNum = dataArr[10];
        this.buyOnePrice = dataArr[11];
        this.buyTwoNum = dataArr[12];
        this.buyTwoPrice = dataArr[13];
        this.buyThreeNum = dataArr[14];
        this.buyThreePrice = dataArr[15];
        this.buyFourNum = dataArr[16];
        this.buyFourPrice = dataArr[17];
        this.buyFiveNum = dataArr[18];
        this.buyFivePrice = dataArr[19];
        this.sellOneNum = dataArr[20];
        this.sellOnePrice = dataArr[21];
        this.sellTwoNum = dataArr[22];
        this.sellTwoPrice = dataArr[23];
        this.sellThreeNum = dataArr[24];
        this.sellThreePrice = dataArr[25];
        this.sellFourNum = dataArr[26];
        this.sellFourPrice = dataArr[27];
        this.sellFiveNum = dataArr[28];
        this.sellFivePrice = dataArr[29];
        this.date = dataArr[30];
        this.time = dataArr[31];
        this.zero = dataArr[32];
    }

    public String getString(){
        StringBuilder sb = new StringBuilder();
        sb.append("股票名称：").append(stockName)
                .append("\n今日开盘价：").append(todayOpenPrice)
                .append("\n昨日收盘价：").append(yesterdayClosePrice)
                .append("\n当前价格：").append(currentPrice)
                .append("\n今日最高价：").append(todayHighestPrice)
                .append("\n今日最低价：").append(todayLowestPrice)
                .append("\n竞买价，即“买一”报价：").append(currentBuyPrice)
                .append("\n竞卖价，即“卖一”报价：").append(currentAskPrice)
                .append("\n成交的股票数：").append(dealStockNum)
                .append("\n成交金额：").append(new BigDecimal(dealAmount).divide(new BigDecimal("10000"),2, RoundingMode.HALF_UP)).append("万元")
                .append("\n买一申请股数，手数应该除以100：").append(buyOneNum)
                .append("\n买一报价：").append(buyOnePrice)
                .append("\n买二申请股数：").append(buyTwoNum)
                .append("\n买二报价：").append(buyTwoPrice)
                .append("\n买三申请股数：").append(buyThreeNum)
                .append("\n买三报价：").append(buyThreePrice)
                .append("\n买四申请股数：").append(buyFourNum)
                .append("\n买四报价：").append(buyFourPrice)
                .append("\n买五申请股数：").append(buyFiveNum)
                .append("\n买五报价：").append(buyFivePrice)
                .append("\n卖一申请股数：").append(sellOneNum)
                .append("\n卖一报价：").append(sellOnePrice)
                .append("\n卖二申请股数：").append(sellTwoNum)
                .append("\n卖二报价：").append(sellTwoPrice)
                .append("\n卖三申请股数：").append(sellThreeNum)
                .append("\n卖三报价：").append(sellThreePrice)
                .append("\n卖四申请股数：").append(sellFourNum)
                .append("\n卖四报价：").append(sellFourPrice)
                .append("\n卖五申请股数：").append(sellFiveNum)
                .append("\n卖五报价：").append(sellFivePrice)
                .append("\n日期：").append(date)
                .append("\n时间：").append(time)
                .append("\n状态：").append(zero)
                .append("\n");
        return sb.toString();
    }
}
