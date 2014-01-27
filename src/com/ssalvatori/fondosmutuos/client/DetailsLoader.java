package com.ssalvatori.fondosmutuos.client;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import android.content.AsyncTaskLoader;
import android.content.Context;

import com.ssalvatori.fondosmutuos.Detail;
import com.ssalvatori.fondosmutuos.utils.Downloader;

public class DetailsLoader extends AsyncTaskLoader<ArrayList<Detail>>{

	public String url;
	public String name;
	
	public DetailsLoader(Context context, String urlString, String name) {
		super(context);
		this.url = urlString;
		this.name = name;
	}
	
	@Override
	public ArrayList<Detail> loadInBackground() {
		ArrayList<Detail> details;
    	try {
    		details = new ArrayList<Detail>();
    		JSONObject jsonObj = new JSONObject(Downloader.getData(this.url, this.name));
    		JSONArray data = jsonObj.getJSONArray("data");
    		
    		for (int i = 0; i < data.length(); i++) {
    			JSONObject jsonDetails = data.getJSONObject(i);
    			jsonDetails.getString("price");
    			Detail detail = new Detail();
    			detail.price = jsonDetails.getString("price");
    			detail.date = jsonDetails.getString("priceDate");
    			detail.name = jsonDetails.getString("name");
    			details.add(detail);
    		}
		} catch (Exception exception) {
			details = null;
		}
    	
    	return details;
	}
}