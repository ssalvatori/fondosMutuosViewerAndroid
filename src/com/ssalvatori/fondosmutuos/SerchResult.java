package com.ssalvatori.fondosmutuos;

import java.util.ArrayList;


import android.content.AsyncTaskLoader;
import android.content.Context;

public class SerchResult extends AsyncTaskLoader<ArrayList<Result>> {
	
	private static final String URL_FONDOS_MUTUOS = "http://fondosapi.salvatori.cl/fondosMutuos/record/names";

	public SerchResult(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<Result> loadInBackground() {
		// TODO Auto-generated method stub
		return null;
	}

}