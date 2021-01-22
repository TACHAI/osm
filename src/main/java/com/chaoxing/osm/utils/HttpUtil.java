package com.chaoxing.osm.utils;

import com.chaoxing.osm.common.ServerResponse;
import com.github.pagehelper.PageException;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @ClassName HttpUtil
 * @Author https://github.com/TACHAI
 * @Email tc1206966083@gmail.com
 * @Date 2019-06-21 14:19
 **/
@Slf4j
public class HttpUtil {

    private static final String ENCODING = "UTF-8";

    public static ServerResponse<String> doGet(String url){
        // 获得Http 客户端
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        String resoult = null;
        // 创建Get请求
        HttpGet   httpGet = new HttpGet(url);

        // 响应模型
        CloseableHttpResponse response = null;

        try{
            // 由客户端发送请求
            response = httpClient.execute(httpGet);

            HttpEntity entity = response.getEntity();

            if(entity!=null){
                resoult = EntityUtils.toString(entity,ENCODING);
            }

        }catch (ClientProtocolException e){
            log.error("HttpUtil:{}---msg:{}",url,e.getMessage());
        }catch (PageException e){
            log.error("HttpUtil:{}---msg:{}",url,e.getMessage());
        }catch (IOException e){
            log.error("HttpUtil:{}---msg:{}",url,e.getMessage());
        }finally {
            try {
                // 释放资源
                if(httpClient != null){
                    httpClient.close();
                }
                if(response != null){
                    response.close();
                }
            }catch (IOException e){
                log.error("HttpUtil:{}---msg:{}",url,e.getMessage());
            }

        }
        if(resoult!=null){
            return  ServerResponse.createBySuccess(resoult,"请求成功"+url);
        }
        return ServerResponse.createByErrorMessage("获取失败"+url);
    }

}
