package com.Desktop.notifications.config;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;


@Configuration
public class config {

    @Value("${httpconfig.maxPoolSize:20}")
    private int maxPoolSize;

    @Value("${httpconfig.connectionTimeOut:500}")
    private  int connectionTimeOut;

    @Value("${httpconfig.socketTimeOut:1000}")
    private int socketTimeOut;

    @Value("${httpconfig.connectionRequestTimeout:500}")
    private int connectionRequestTimeout;

    @Bean
    public PoolingHttpClientConnectionManager poolingHttpMnager()
    {
        PoolingHttpClientConnectionManager result= new PoolingHttpClientConnectionManager();
        result.setMaxTotal(maxPoolSize);
        return result;

    }


    @Bean
    public RequestConfig requestConfig()
    {
        return  RequestConfig.custom()
                .setConnectTimeout(connectionTimeOut)
                .setConnectionRequestTimeout(connectionRequestTimeout)
                .setSocketTimeout(socketTimeOut)
                .build();
    }



    @Bean
    public  CloseableHttpClient closeableHttpRequest(PoolingHttpClientConnectionManager poolingHttpClientConnectionManager, RequestConfig requestConfig)
    {
      return HttpClientBuilder
                .create()
                .setConnectionManager(poolingHttpClientConnectionManager)
                .setDefaultRequestConfig(requestConfig)
                .build();
    }


    @Bean
    public RestTemplate restTemplate( CloseableHttpClient closeableHttpClient)
    {
        System.out.println("Creating Rest template");
        HttpComponentsClientHttpRequestFactory httpClientFactory = new HttpComponentsClientHttpRequestFactory();
        httpClientFactory.setHttpClient(closeableHttpClient);
        System.out.println("Created a Rest template !!!!!");
        return new RestTemplate(httpClientFactory);
    }

}
