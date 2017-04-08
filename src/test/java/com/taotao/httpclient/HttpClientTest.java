package com.taotao.httpclient;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Ignore;
import org.junit.Test;

public class HttpClientTest {
	@Ignore
	@Test
	public void doGet() throws Exception {
		//创建一个 httpClient 对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		//创建一个 GET 对象
		HttpGet get = new HttpGet("https://www.google.com.hk/");
		//执行请求
		CloseableHttpResponse response = httpClient.execute(get);
		//响应结果
		int statusCode = response.getStatusLine().getStatusCode();
		System.out.println(statusCode);
		HttpEntity entity = response.getEntity();
		String string = EntityUtils.toString(entity, "utf-8");
		System.out.println(string);
		//关闭
		response.close();
		httpClient.close();
	}
	@Ignore
	@Test
	public void doGetWithParam() throws Exception {
		//创建一个 httpClient 对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		//创建一个rui 对象
		URIBuilder uri = new URIBuilder("https://www.baidu.com/s");
		uri.addParameter("wd", "redis");
		HttpGet get = new HttpGet(uri.build());
		//执行请求
		CloseableHttpResponse response = httpClient.execute(get);
		//响应结果
		int statusCode = response.getStatusLine().getStatusCode();
		System.out.println(statusCode);
		HttpEntity entity = response.getEntity();
		String string = EntityUtils.toString(entity, "utf-8");
		System.out.println(string);
		//关闭
		response.close();
		httpClient.close();
	}
	
	@Test
	public void doPost() throws Exception {
		//创建一个 httpClient 对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		//创建一个 post 对象
		HttpPost post = new HttpPost("http://localhost:8082/httpclient/post.html");
		//执行请求
		CloseableHttpResponse response = httpClient.execute(post);
		//响应结果
		int statusCode = response.getStatusLine().getStatusCode();
		System.out.println(statusCode);
		HttpEntity entity = response.getEntity();
		String string = EntityUtils.toString(entity, "utf-8");
		System.out.println(string);
		//关闭
		response.close();
		httpClient.close();
	}
	
	@Test
	public void doPostWithParam() throws Exception {
		//创建一个 httpClient 对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		//创建一个 post 对象
		HttpPost post = new HttpPost("http://localhost:8082/httpclient/post.html");
		//创建一个entity, 相当一个表单
		List<NameValuePair> kvList = new ArrayList<>();
		kvList.add(new BasicNameValuePair("username", "张三"));
		kvList.add(new BasicNameValuePair("password", "666666"));
		//包装成一个 Entity对象
		StringEntity entity = new UrlEncodedFormEntity(kvList, "utf-8");
		post.setEntity(entity);
		//执行请求
		CloseableHttpResponse response = httpClient.execute(post);
		//响应结果
		int statusCode = response.getStatusLine().getStatusCode();
		System.out.println(statusCode);
		HttpEntity entity2 = response.getEntity();
		String string = EntityUtils.toString(entity2, "utf-8");
		System.out.println(string);
		//关闭
		response.close();
		httpClient.close();
	}
}
