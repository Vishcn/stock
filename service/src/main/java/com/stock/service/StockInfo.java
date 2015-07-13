package com.stock.service;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.stock.http.HttpUtils;
import com.stock.model.StockInformaction;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;

/**
 * <p/>
 * Project: javawebTemplate <br>
 * Package com.stock.service <br>
 * Description: <br>
 * DATE 15/7/6 16:57 <br>
 *
 * @author Vishcn<br>
 * @version V1.0 <br>
 */
@Service
public class StockInfo {


    public StockInformaction queryStockInfo(String id) throws Exception{
        Map<String,String> params = Maps.newHashMap();
        params.put("list", id);
        String result = HttpUtils.get("http://hq.sinajs.cn/" , params);
        String[] results = result.split("\"");
        String info = results[1];
        String[] infos = info.split(",");
        StockInformaction stock = new StockInformaction();
        stock.setName(infos[0]);
        stock.setTodayOpenPrice(new BigDecimal(infos[1]));
        stock.setYesterdayEndPrice(new BigDecimal(infos[2]));
        stock.setNowPrice(new BigDecimal(infos[3]));
        stock.setMaxPrice(new BigDecimal(infos[4]));
        stock.setMinPrice(new BigDecimal(infos[5]));
        stock.setCompetBuyPrice(new BigDecimal(infos[6]));
        stock.setCompetSellPrice(new BigDecimal(infos[7]));
        stock.setTradeNum(Integer.valueOf(infos[8]));
        stock.setTradeAmount(new BigDecimal(infos[9]));
        stock.setBuy1_n(Integer.valueOf(infos[10]));
        stock.setBuy1_m(new BigDecimal(infos[11]));
        stock.setBuy2_n(Integer.valueOf(infos[12]));
        stock.setBuy2_m(new BigDecimal(infos[13]));
        stock.setBuy3_n(Integer.valueOf(infos[14]));
        stock.setBuy3_m(new BigDecimal(infos[15]));
        stock.setBuy4_n(Integer.valueOf(infos[16]));
        stock.setBuy4_m(new BigDecimal(infos[17]));
        stock.setBuy5_n(Integer.valueOf(infos[18]));
        stock.setBuy5_m(new BigDecimal(infos[19]));
        stock.setSell1_n(Integer.valueOf(infos[20]));
        stock.setSell1_m(new BigDecimal(infos[21]));
        stock.setSell2_n(Integer.valueOf(infos[22]));
        stock.setSell2_m(new BigDecimal(infos[23]));
        stock.setSell3_n(Integer.valueOf(infos[24]));
        stock.setSell3_m(new BigDecimal(infos[25]));
        stock.setSell4_n(Integer.valueOf(infos[26]));
        stock.setSell4_m(new BigDecimal(infos[27]));
        stock.setSell5_n(Integer.valueOf(infos[28]));
        stock.setSell5_m(new BigDecimal(infos[29]));
        stock.setDate(infos[30]);
        stock.setTime(infos[31]);
        return stock;
    }
}
