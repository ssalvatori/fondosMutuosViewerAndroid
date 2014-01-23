package com.ssalvatori.fondosmutuos;

import android.os.Bundle;



public class SelectorActivity extends BaseActivity {

	private static final String URL_FONDOS_MUTUOS = "http://fondosapi.salvatori.cl/fondosMutuos/record/names";

	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selector);
    }

        
}
