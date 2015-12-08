package com.test.test;

import com.stock.service.StockInfo;
import mockit.Tested;
import org.testng.annotations.Test;

/**
 * @author Vishcn
 * @since 2015年10月20日
 */
public class Ten2TestTest {


    @Tested
    private Ten2Test stockInfo;


    @Test
    public void test() throws Exception {
        String input = "80";
        System.out.println("from:" + input);
        stockInfo.str2SixTy(140);
    }
}
