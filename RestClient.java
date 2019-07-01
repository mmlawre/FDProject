package com.qa.client;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;


public class RestClient {

    //1. GET Method

        public CloseableHttpResponse get (String url) throws ClientProtocolException, IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpget = new HttpGet(url); //http get request
        CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpget); //hit the GET URL
        int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
        System.out.println("Status code is " + statusCode);

        String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");

        JSONObject responseJson = new JSONObject(responseString);
        System.out.println("Response JSON from API is " + responseJson);

        Header[] headersArray = closeableHttpResponse.getAllHeaders();

        HashMap<String, String> allHeaders = new HashMap<String, String>();

        for(Header header : headersArray){
            allHeaders.put(header.getName(), header.getValue());
        }

        System.out.println("Headers array" + allHeaders);


            return closeableHttpResponse;
        }






}
