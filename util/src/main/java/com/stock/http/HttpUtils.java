package com.stock.http;



import com.google.common.base.Preconditions;
import org.apache.http.client.HttpResponseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
/**
 * <p/>
 * Project: javawebTemplate <br>
 * Package com.stock.http <br>
 * Description: <br>
 * DATE 15/7/6 16:22 <br>
 *
 * @author Vishcn<br>
 * @version V1.0 <br>
 */
public class HttpUtils {
    private static final Logger LOGGER = LoggerFactory
            .getLogger(HttpUtils.class);


    public static final String DEFAULT_USER_AGENT = "http";
    /**
     * 最大连接数,参照 {@link RequestConfig} 中的相关设置
     */
    public static final int DEFAULT_MAX_TOTAL_CONNECTION_COUNT = 400;
    public static final int DEFAULT_MAX_PER_ROUTE_COUNT = 20;
    public static final int DEFAULT_SOCKET_TIMEOUT = 30000;
    public static final int DEFAULT_CONNECTION_TIMEOUT = 30000;
    /**
     * 设置连接允许的最大空闲时间
     */
    public static final int DEFAULT_CONNECTION_MAX_IDLE_TIME =30;

    // https相关参数设置
    /**
     * 设置检查超时连接时间
     */
    public static final int DEFAULT_MONITOR_INTERVAL = 30000;

    public static final String DEFAULT_HTTPS_USER_AGENT = "https";
    public static final int DEFAULT_HTTPS_MONITOR_INTERVAL = 30000;
    public static final int DEFAULT_HTTPS_MAX_TOTAL_CONNECTION_COUNT = 200;
    public static final int DEFAULT_HTTPS_MAX_PER_ROUTE_COUNT =10;
    public static final int DEFAULT_HTTPS_SOCKET_TIMEOUT = 30000;
    public static final int DEFAULT_HTTPS_CONNECTION_TIMEOUT = 10000;
    public static final int DEFAULT_HTTPS_CONNECTION_MAX_IDLE_TIME = 30;


    /**
     * get 请求<br />
     *
     * @author jiafu.he
     * @return http请求返回的文本
     * @throws Exception
     *             请求url格式不对时抛出
     *             请求返回状态码不为200时抛出
     * @throws HttpResponseException
     *             其它任何异常时抛出
     */
    public static String get(String url, Map<String, ?> params)
            throws Exception{
        Preconditions.checkNotNull(url, "请求url不能为空");
        String queryString = mapToQueryString(params);
        if (queryString != null) {
            url += "?" + queryString;
        }
        LOGGER.info("get请求: " + url);
        HttpGet httpGet = null;
        try {
            httpGet = new HttpGet(url);
        } catch (Exception e) {
            throw new Exception("url[" + url + "]格式不对", e);
        }

        HttpResponse response = execute(httpClient, httpGet);
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            try {
                String ret = EntityUtils.toString(entity);
                LOGGER.info("get请求结果: " + ret);
                return ret;
            } catch (ParseException e) {
                throw new Exception("http entity解析成String时出错", e);
            } catch (IOException e) {
                throw new Exception("http entity解析成String时出错", e);
            } finally {
                httpGet.abort();
            }
        }
        return null;
    }

    /**
     * post 请求 <br />
     *
     * @author jiafu.he
     * @return http请求返回的文本
     * @throws Exception
     *             请求url格式不对时抛出
     *             请求返回状态码不为200时抛出
     * @throws HttpResponseException
     *             其它任何异常时抛出
     */
    public static String post(String url, Map<String, ?> params)
            throws Exception {
        List<NameValuePair> nvps = mapToNameValuePair(params);
        LOGGER.info("post请求: " + url + ", params: " + nvps);
        HttpPost httpPost = null;
        try {
            httpPost = new HttpPost(url);
        } catch (Exception e) {
            throw new Exception("url[" + url + "]格式不对", e);
        }

        if (nvps != null) {
            HttpEntity formEntity = null;
            try {
                formEntity = new UrlEncodedFormEntity(nvps, "UTF-8");
                httpPost.setEntity(formEntity);
            } catch (UnsupportedEncodingException e) {
                throw new Exception("设置http post数据时出错", e);
            }
        }

        HttpResponse response = execute(httpClient, httpPost);
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            try {
                String ret = EntityUtils.toString(entity);
                LOGGER.info("post请求结果: " + ret);
                return ret;
            } catch (ParseException e) {
                throw new Exception("http entity解析成String时出错", e);
            } catch (IOException e) {
                throw new Exception("http entity解析成String时出错", e);
            } finally {
                httpPost.abort();
            }
        }
        return null;
    }

    /**
     * https 请求<br />
     *
     * @author jiafu.he
     * @return http请求返回的文本
     * @throws Exception
     *             请求url格式不对时抛出
     *             请求返回状态码不为200时抛出
     * @throws HttpResponseException
     *             其它任何异常时抛出
     */
    public static String https(String url, Map<String, ?> params)
            throws Exception {
        HttpPost post = null;
        try {
            List<NameValuePair> nvps = mapToNameValuePair(params);
            LOGGER.info("https请求: " + url + ", params: " + nvps);
            post = new HttpPost(url);
            if (nvps != null) {
                HttpEntity formEntity = new UrlEncodedFormEntity(nvps, "UTF-8");
                post.setEntity(formEntity);
            }

            HttpResponse response = execute(httpsClient, post);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                String str = EntityUtils.toString(entity);
                LOGGER.info("https请求结果: " + str);
                return str;
            }
            return null;
        } catch (HttpResponseException e) {
            throw e;
        } catch (Exception e) {
            if (post != null) {
                post.abort();
            }
            throw new Exception("post[" + post + "]请求出错", e);
        }
    }

    /**
     * 执行请求操作
     *
     * @author jiafu.he
     * @param httpClient
     * @param request
     * @return
     * @throws HttpResponseException
     */
    private static final HttpResponse execute(HttpClient httpClient,
                                              HttpUriRequest request) {
        HttpResponse response = null;
        try {
            response = httpClient.execute(request);
        } catch (ClientProtocolException e) {
            request.abort();
            throw new RuntimeException();
        } catch (IOException e) {
            request.abort();
            throw new RuntimeException();
        }

        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode != HttpStatus.SC_OK) {
            request.abort();
            throw new RuntimeException();
        }

        return response;
    }

    /**
     * map转换到NameValuePair
     *
     * @param params
     * @return
     */
    private static List<NameValuePair> mapToNameValuePair(Map<String, ?> params) {
        if (params == null) {
            return null;
        }

        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        for (Map.Entry<String, ?> entry : params.entrySet()) {
            Object value = entry.getValue();
            if (value != null) {
                nvps.add(new BasicNameValuePair(entry.getKey(), String
                        .valueOf(value)));
            }
        }
        return nvps;
    }

    /**
     * MAP形式的参数到queryString的转换
     *
     * @param params
     * @return
     */
    private static String mapToQueryString(Map<String, ?> params) {
        if (params == null) {
            return null;
        }
        // 判断是否有有效的参数对，空值的参数列表不计入统计
        boolean hasValidParameter = false;
        StringBuffer buffer = new StringBuffer();
        for (Map.Entry<String, ?> entry : params.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value != null) {
                hasValidParameter = true;
                buffer.append(key).append("=").append(String.valueOf(value))
                        .append("&");
            }
        }
        if (hasValidParameter) {
            buffer.deleteCharAt(buffer.length() - 1);
            return buffer.toString();
        }
        return null;
    }

    /**
     * @author jiafu.he
     */
    private static HttpClient createHttpClient() {
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        cm.setMaxTotal(DEFAULT_MAX_TOTAL_CONNECTION_COUNT);
        cm.setDefaultMaxPerRoute(DEFAULT_MAX_PER_ROUTE_COUNT);
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectionRequestTimeout(DEFAULT_CONNECTION_TIMEOUT)
                .setSocketTimeout(DEFAULT_SOCKET_TIMEOUT).build();
        HttpClient httpClient = HttpClients.custom().setConnectionManager(cm)
                .setDefaultRequestConfig(requestConfig)
                .setUserAgent(DEFAULT_USER_AGENT).build();
        return httpClient;
    }

    /**
     * @author jiafu.he
     */
    private static HttpClient createHttpsClient() {
        X509TrustManager tm = new X509TrustManager() {
            @Override
            public void checkClientTrusted(
                    java.security.cert.X509Certificate[] chain, String authType)
                    throws java.security.cert.CertificateException {
            }

            @Override
            public void checkServerTrusted(
                    java.security.cert.X509Certificate[] chain, String authType)
                    throws java.security.cert.CertificateException {
            }

            @Override
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return null;
            }
        };

        HttpClient httpClient = null;
        try {
            SSLContext sslContext = SSLContexts.custom().useTLS().build();
            sslContext.init(null, new TrustManager[] { tm }, null);
            SSLConnectionSocketFactory scsf = new SSLConnectionSocketFactory(
                    sslContext);
            PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager(
                    RegistryBuilder.<ConnectionSocketFactory> create()
                            .register("https", scsf).build());
            cm.setMaxTotal(DEFAULT_HTTPS_MAX_TOTAL_CONNECTION_COUNT);
            cm.setDefaultMaxPerRoute(DEFAULT_HTTPS_MAX_PER_ROUTE_COUNT);
            RequestConfig requestConfig = RequestConfig
                    .custom()
                    .setConnectionRequestTimeout(
                            DEFAULT_HTTPS_CONNECTION_TIMEOUT)
                    .setSocketTimeout(DEFAULT_HTTPS_SOCKET_TIMEOUT).build();
            httpClient = HttpClients.custom().setConnectionManager(cm)
                    .setDefaultRequestConfig(requestConfig)
                    .setUserAgent(DEFAULT_USER_AGENT).build();
        } catch (Exception e) {
            LOGGER.error("创建httpsClient失败", e);
        }

        return httpClient;
    }





    private static final HttpClient httpClient = createHttpClient();
    private static final HttpClient httpsClient = createHttpsClient();
}

