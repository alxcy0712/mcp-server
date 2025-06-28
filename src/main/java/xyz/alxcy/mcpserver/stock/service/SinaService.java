package xyz.alxcy.mcpserver.stock.service;


public interface SinaService {

    /**
     * 获取当天股票数据
     * @param stockCode 股票代码
     * @return
     */
    String getStockPrice(String stockCode);


}
