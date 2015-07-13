package com.stock.service;

import com.alibaba.fastjson.JSON;
import com.stock.model.StockInformaction;
import mockit.Tested;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;

/**
 * <p/>
 * Project: javawebTemplate <br>
 * Package com.stock.service <br>
 * Description: <br>
 * DATE 15/7/6 18:11 <br>
 *
 * @author Vishcn<br>
 * @version V1.0 <br>
 */
public class StockInfoTest {

    @Tested
    private StockInfo stockInfo;

    @Test
    public void queryStockInfo() throws Exception {
        int i =0;
        while(true){
            StockInformaction informaction = stockInfo.queryStockInfo("sh601398");
            i++;
            if (i > 100) {
                i=0;
                System.out.println("================");
                System.out.println("卖1：" + informaction.getSell1_m());
                System.out.println("卖1：" + informaction.getSell5_n()/100);
                System.out.println("卖1：" + informaction.getSell4_n()/100);
                System.out.println("卖1：" + informaction.getSell3_n()/100);
                System.out.println("卖1：" + informaction.getSell2_n()/100);
                System.out.println("卖1：" + informaction.getSell1_n()/100);
                System.out.println("*");
                System.out.println("买1：" + informaction.getBuy1_m());
                System.out.println("买1：" + informaction.getBuy1_n()/100);
                System.out.println("买1：" + informaction.getBuy2_n()/100);
                System.out.println("买1：" + informaction.getBuy3_n()/100);
                System.out.println("买1：" + informaction.getBuy4_n()/100);
                System.out.println("买1：" + informaction.getBuy5_n()/100);
                System.out.println(informaction.getTime());
                System.out.println("================");
            }
            if ((new BigDecimal("4.10").compareTo(informaction.getSell1_m()) > 0) &&
                    informaction.getSell1_n() <100*100) {
                System.out.println("================");
                System.out.println("卖1：" + informaction.getSell1_m());
                System.out.println("卖1：" + informaction.getSell1_n()/100);
                System.out.println("*");
                System.out.println("买1：" + informaction.getBuy1_m());
                System.out.println("买1：" + informaction.getBuy1_n()/100);
                System.out.println(informaction.getTime());
                System.out.println("================");
                Assert.fail();
            }
        }

    }
}
