package com.stock.model;

import java.math.BigDecimal;

/**
 * <p/>
 * Project: javawebTemplate <br>
 * Package com.stock.model <br>
 * Description: <br>
 * DATE 15/7/6 17:01 <br>
 *
 * @author Vishcn<br>
 * @version V1.0 <br>
 */
public class StockInformaction {

    private String name;

    private BigDecimal todayOpenPrice;

    private BigDecimal yesterdayEndPrice;

    private BigDecimal nowPrice;

    private BigDecimal maxPrice;

    private BigDecimal minPrice;

    private int tradeNum;

    private BigDecimal tradeAmount;

    //竞买价，即“买一”报价
    private BigDecimal competBuyPrice;

    //竞卖价，即“卖一”报价
    private BigDecimal competSellPrice;

    private BigDecimal buy1_m;

    private int buy1_n;

    private BigDecimal buy2_m;

    private int buy2_n;

    private BigDecimal buy3_m;

    private int buy3_n;

    private BigDecimal buy4_m;

    private int buy4_n;

    private BigDecimal buy5_m;

    private int buy5_n;

    private BigDecimal sell1_m;

    private int sell1_n;

    private BigDecimal sell2_m;

    private int sell2_n;

    private BigDecimal sell3_m;

    private int sell3_n;

    private BigDecimal sell4_m;

    private int sell4_n;

    private BigDecimal sell5_m;

    private int sell5_n;

    private String date;

    private String time;

    public BigDecimal getBuy1_m() {
        return buy1_m;
    }

    public void setBuy1_m(BigDecimal buy1_m) {
        this.buy1_m = buy1_m;
    }

    public int getBuy1_n() {
        return buy1_n;
    }

    public void setBuy1_n(int buy1_n) {
        this.buy1_n = buy1_n;
    }

    public BigDecimal getBuy2_m() {
        return buy2_m;
    }

    public void setBuy2_m(BigDecimal buy2_m) {
        this.buy2_m = buy2_m;
    }

    public int getBuy2_n() {
        return buy2_n;
    }

    public void setBuy2_n(int buy2_n) {
        this.buy2_n = buy2_n;
    }

    public BigDecimal getBuy3_m() {
        return buy3_m;
    }

    public void setBuy3_m(BigDecimal buy3_m) {
        this.buy3_m = buy3_m;
    }

    public int getBuy3_n() {
        return buy3_n;
    }

    public void setBuy3_n(int buy3_n) {
        this.buy3_n = buy3_n;
    }

    public BigDecimal getBuy4_m() {
        return buy4_m;
    }

    public void setBuy4_m(BigDecimal buy4_m) {
        this.buy4_m = buy4_m;
    }

    public int getBuy4_n() {
        return buy4_n;
    }

    public void setBuy4_n(int buy4_n) {
        this.buy4_n = buy4_n;
    }

    public BigDecimal getBuy5_m() {
        return buy5_m;
    }

    public void setBuy5_m(BigDecimal buy5_m) {
        this.buy5_m = buy5_m;
    }

    public int getBuy5_n() {
        return buy5_n;
    }

    public void setBuy5_n(int buy5_n) {
        this.buy5_n = buy5_n;
    }

    public BigDecimal getCompetBuyPrice() {
        return competBuyPrice;
    }

    public void setCompetBuyPrice(BigDecimal competBuyPrice) {
        this.competBuyPrice = competBuyPrice;
    }

    public BigDecimal getCompetSellPrice() {
        return competSellPrice;
    }

    public void setCompetSellPrice(BigDecimal competSellPrice) {
        this.competSellPrice = competSellPrice;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public BigDecimal getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(BigDecimal maxPrice) {
        this.maxPrice = maxPrice;
    }

    public BigDecimal getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(BigDecimal minPrice) {
        this.minPrice = minPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getNowPrice() {
        return nowPrice;
    }

    public void setNowPrice(BigDecimal nowPrice) {
        this.nowPrice = nowPrice;
    }

    public BigDecimal getSell1_m() {
        return sell1_m;
    }

    public void setSell1_m(BigDecimal sell1_m) {
        this.sell1_m = sell1_m;
    }

    public int getSell1_n() {
        return sell1_n;
    }

    public void setSell1_n(int sell1_n) {
        this.sell1_n = sell1_n;
    }

    public BigDecimal getSell2_m() {
        return sell2_m;
    }

    public void setSell2_m(BigDecimal sell2_m) {
        this.sell2_m = sell2_m;
    }

    public int getSell2_n() {
        return sell2_n;
    }

    public void setSell2_n(int sell2_n) {
        this.sell2_n = sell2_n;
    }

    public BigDecimal getSell3_m() {
        return sell3_m;
    }

    public void setSell3_m(BigDecimal sell3_m) {
        this.sell3_m = sell3_m;
    }

    public int getSell3_n() {
        return sell3_n;
    }

    public void setSell3_n(int sell3_n) {
        this.sell3_n = sell3_n;
    }

    public BigDecimal getSell4_m() {
        return sell4_m;
    }

    public void setSell4_m(BigDecimal sell4_m) {
        this.sell4_m = sell4_m;
    }

    public int getSell4_n() {
        return sell4_n;
    }

    public void setSell4_n(int sell4_n) {
        this.sell4_n = sell4_n;
    }

    public BigDecimal getSell5_m() {
        return sell5_m;
    }

    public void setSell5_m(BigDecimal sell5_m) {
        this.sell5_m = sell5_m;
    }

    public int getSell5_n() {
        return sell5_n;
    }

    public void setSell5_n(int sell5_n) {
        this.sell5_n = sell5_n;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public BigDecimal getTodayOpenPrice() {
        return todayOpenPrice;
    }

    public void setTodayOpenPrice(BigDecimal todayOpenPrice) {
        this.todayOpenPrice = todayOpenPrice;
    }

    public BigDecimal getTradeAmount() {
        return tradeAmount;
    }

    public void setTradeAmount(BigDecimal tradeAmount) {
        this.tradeAmount = tradeAmount;
    }

    public int getTradeNum() {
        return tradeNum;
    }

    public void setTradeNum(int tradeNum) {
        this.tradeNum = tradeNum;
    }

    public BigDecimal getYesterdayEndPrice() {
        return yesterdayEndPrice;
    }

    public void setYesterdayEndPrice(BigDecimal yesterdayEndPrice) {
        this.yesterdayEndPrice = yesterdayEndPrice;
    }
}
