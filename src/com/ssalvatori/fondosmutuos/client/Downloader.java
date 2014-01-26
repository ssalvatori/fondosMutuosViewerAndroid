package com.ssalvatori.fondosmutuos.client;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.edwrodrig.edroid.content.StringUtils;

/**
 * 
 * @author stefano
 *
 */

public class Downloader {

	
	public static String getData(String url) {
		HashMap<String, String> params = null;
		return getData(url , params);
	}
	
	public static String getData(String url, HashMap<String, String> params) {
		
		HttpClient httpClient = new DefaultHttpClient();
		HttpGet httpget = new HttpGet(url);
				
		if(params != null) {
			for(Entry<String, String> header : params.entrySet()) {
				httpget.setHeader(header.getKey(), header.getValue());
			}
		}
		
		HttpResponse response;
		HttpEntity entity;
		String result = null;

		try {
			response = httpClient.execute(httpget);
			entity = response.getEntity();

			InputStream instream = entity.getContent();
			result =  StringUtils.toString(new BufferedReader(new InputStreamReader(instream)));
			
		}
		catch (Exception e) {			
			result = "";
		}
		
		return result;

	}
	

}
