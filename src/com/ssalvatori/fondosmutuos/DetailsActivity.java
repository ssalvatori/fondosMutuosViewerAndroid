package com.ssalvatori.fondosmutuos;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.LoaderManager;
import android.content.Loader;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;


import com.ssalvatori.fondosmutuos.client.DetailsLoader;


public class DetailsActivity extends BaseActivity implements LoaderManager.LoaderCallbacks<ArrayList<Detail>> {
	
	private static final String URL_FONDOS_MUTUOS = "http://fondosapi.salvatori.cl/fondosMutuos/record/find";
	
	public String name;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_details);

		Bundle extras = getIntent().getExtras();
		this.name = extras.getString("fondosMutuoSelected");
		
		 TextView view = (TextView) findViewById(R.id.fondoMutuoName);
		 view.setText(this.name);
		 
		 getLoaderManager().initLoader(0, null, this).forceLoad();
		 
	}
	
	@Override
	public Loader<ArrayList<Detail>> onCreateLoader(int id, Bundle args) {
		// TODO Auto-generated method stub
		return new DetailsLoader(this, URL_FONDOS_MUTUOS, this.name);
	}

	@Override
	public void onLoadFinished(Loader<ArrayList<Detail>> arg0, ArrayList<Detail> details) {

		ListView lv = (ListView) findViewById(R.id.listView1);

		final ArrayList<Detail> resultServer = details;
		
		List<Map<String, String>> data = new ArrayList<Map<String, String>>();
		for (Detail detail : resultServer) {
			Map<String, String> datum = new HashMap<String, String>(2);
			datum.put("price", detail.price);
			datum.put("date", detail.date);
			data.add(datum);
		}
		SimpleAdapter adapter = new SimpleAdapter(this, data,
				android.R.layout.simple_list_item_2,
				new String[] {"price", "date"},
				new int[] {android.R.id.text1,
				android.R.id.text2});
		
		lv.setAdapter(adapter); 

	}

	@Override
	public void onLoaderReset(Loader<ArrayList<Detail>> arg0) {
		// TODO Auto-generated method stub

	}

}
