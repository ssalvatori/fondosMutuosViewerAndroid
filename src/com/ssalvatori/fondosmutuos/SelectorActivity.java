package com.ssalvatori.fondosmutuos;

import java.util.ArrayList;

import com.ssalvatori.fondosmutuos.client.ServicesLoader;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.app.LoaderManager;
import android.content.Loader;

public class SelectorActivity extends BaseActivity implements LoaderManager.LoaderCallbacks<ArrayList<Result>>{

	private static final String URL_FONDOS_MUTUOS = "http://fondosapi.salvatori.cl/fondosMutuos/record/names";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_selector);
		getLoaderManager().initLoader(0, null, this).forceLoad();
		
		final ListView lv = (ListView) findViewById(R.id.listView1);
		lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){
			
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long arg3) {
				Result itemSelected =  (Result) lv.getItemAtPosition(position);
				String textSelected = itemSelected.name;
				openDetails(textSelected);
			}
		});

	}

	@Override
	public Loader<ArrayList<Result>> onCreateLoader(int id, Bundle args) {
		// TODO Auto-generated method stub
		return new ServicesLoader(this, URL_FONDOS_MUTUOS);
	}

	@Override
	public void onLoadFinished(Loader<ArrayList<Result>> arg0, ArrayList<Result> result) {

		ListView lv = (ListView) findViewById(R.id.listView1);

		ArrayList<Result> resultServer = result;

		ArrayAdapter<Result> arrayAdapter = new ArrayAdapter<Result>(
				this, 
				android.R.layout.simple_list_item_1,
				resultServer);



		lv.setAdapter(arrayAdapter); 

	}

	@Override
	public void onLoaderReset(Loader<ArrayList<Result>> arg0) {
		// TODO Auto-generated method stub

	}




}
