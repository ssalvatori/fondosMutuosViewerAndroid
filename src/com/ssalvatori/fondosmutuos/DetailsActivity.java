package com.ssalvatori.fondosmutuos;

import android.os.Bundle;
import android.widget.TextView;
import android.app.Activity;

public class DetailsActivity extends Activity {
	
	public String name;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_details);

		Bundle extras = getIntent().getExtras();
		this.name = extras.getString("fondosMutuoSelected");
		
		 TextView view = (TextView) findViewById(R.id.fondoMutuoName);
		 view.setText(this.name);
	}

}
