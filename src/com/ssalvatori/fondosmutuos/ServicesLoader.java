package com.ssalvatori.fondosmutuos;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import android.content.AsyncTaskLoader;
import android.content.Context;

import com.ssalvatori.fondosmutuos.client.Downloader;

public class ServicesLoader extends AsyncTaskLoader<ArrayList<Result>>{

	private String urlString;
	
	public ServicesLoader(Context context, String urlString) {
		super(context);
		this.urlString = urlString;
	}
	
	@Override
	public ArrayList<Result> loadInBackground() {
		ArrayList<Result> results;
    	try {
    		results = new ArrayList<Result>();
    		JSONObject jsonObj = new JSONObject(Downloader.getData(urlString));
    		JSONArray names = jsonObj.getJSONArray("names");
    		
    		for (int i = 0; i < names.length(); i++) {
    			Result result = new Result();
    			result.name = names.getString(i);
    			results.add(result);
    		}
		} catch (Exception exception) {
			results = null;
		}
    	
    	return results;
	}
}
