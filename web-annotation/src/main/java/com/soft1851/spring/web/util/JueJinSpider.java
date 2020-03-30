package com.soft1851.spring.web.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.soft1851.spring.web.entity.Topic;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/3/27
 * @Version 1.0
 */
public class JueJinSpider {
    private Integer SUCCESS = 200;

    public static List<Topic> getTopic() {
        List<Topic> topicList = new ArrayList<>();
        //链接到目标地址
        String url = "https://short-msg-ms.juejin.im/v1/topicList?uid=5e7e02d1f265da795c71f859&device_id=1585316561629&token=eyJhY2Nlc3NfdG9rZW4iOiJVMWVIdVd4TUtUNW1VVHpoIiwicmVmcmVzaF90b2tlbiI6InRQUmxvSjVEd2lJS2swSksiLCJ0b2tlbl90eXBlIjoibWFjIiwiZXhwaXJlX2luIjoyNTkyMDAwfQ%3D%3D&src=web&sortType=hot&page=0&pageSize=100";
        //创建httpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //创建get对象
        HttpGet get = new HttpGet(url);
        // 创建Context对象
        HttpClientContext context = HttpClientContext.create();
        //创建response对象
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(get, context);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //如果请求成功，则获取网页源码
        if(response.getStatusLine().getStatusCode() == 200){
            //获取响应对象实体，并转成utf-8
            HttpEntity entity = response.getEntity();
            String res = null;
            try {
                res = EntityUtils.toString(entity, "UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            }
            JSONObject jsonObject = JSONObject.parseObject(res);
            JSONArray list = jsonObject.getJSONObject("d").getJSONArray("list");
            list.forEach(e ->{
                JSONObject json = JSONObject.parseObject(e.toString());
                Topic topic = Topic.builder()
                        .id(json.getString("objectId")
                        )
                        .topicName(json.getString("title"))
                        .description(json.getString("description"))
                        .msgCount(json.getInteger("msgsCount"))
                        .followsCount(json.getInteger("followersCount"))
                        .followed(json.getBoolean("followed"))
                        .build();
                topicList.add(topic);
            });
        }
        return topicList;
    }

    public static void main(String[] args) {
        List<Topic> topics = getTopic();
        System.out.println(topics.size());
        System.out.println(topics.get(0));
    }
}
