package xyz.alxcy.mcpserver.stock.entity;

import jakarta.annotation.PostConstruct;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Data
public class SinaEntity {

    /**
     * 新浪股票api地址
     */
    @Value("${sina.url}")
    private String url;

    /**
     * 新浪股票头部referer地址
     */
    @Value("${sina.referer}")
    private String referer;

    /**
     * 新浪股票获取列表api地址
     */
    @Value("${sina.getList}")
    private String getListUrl;

    @PostConstruct
    public void init() {
        log.info("SinaEntity初始化完成");
        log.info("Sina地址：{}", url);
    }
}
