package com.stock.http;

import org.testng.annotations.Test;

/**
 * <p/>
 * Project: javawebTemplate <br>
 * Package com.stock.http <br>
 * Description: <br>
 * DATE 15/7/6 16:51 <br>
 *
 * @author Vishcn<br>
 * @version V1.0 <br>
 */
public class HttpUtilsTest {

    @Test
    public void test() throws Exception{
        String result = HttpUtils.get("http://hq.sinajs.cn/list=sh600109", null);
        System.out.println(result);
    }
}
