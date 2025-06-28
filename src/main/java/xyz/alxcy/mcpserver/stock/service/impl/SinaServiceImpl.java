package xyz.alxcy.mcpserver.stock.service.impl;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import xyz.alxcy.mcpserver.stock.entity.SinaEntity;
import xyz.alxcy.mcpserver.stock.service.SinaService;

import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class SinaServiceImpl implements SinaService {

    @Resource
    private SinaEntity sinaEntity;

    @Override
    public String getStockPrice(String stockCode) {
        String api = sinaEntity.getUrl() + sinaEntity.getGetListUrl() + "=" + stockCode;
        log.info("请求地址：{}", api);
        HttpRequest request = HttpUtil.createGet(api)
                .header(Map.of("Referer", List.of(sinaEntity.getReferer())));
        HttpResponse response = request.execute();
        String body = response.body();
        log.info("请求返回：{}", body);
        String dataStr = body.substring(body.indexOf("=") + 1)
                .replaceAll("^\\s*\"|\"\\s*;$", "")
                .trim();
        return dataStr;
    }
}
