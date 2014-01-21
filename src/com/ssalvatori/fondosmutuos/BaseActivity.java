package com.ssalvatori.fondosmutuos;

import android.app.Activity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class BaseActivity extends Activity {


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu items for use in the action bar
		 MenuInflater inflater = getMenuInflater();
		 inflater.inflate(R.menu.base, menu);
		 return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle presses on the action bar items
	    switch (item.getItemId()) {
	        case R.id.action_selector:
	        	this.openSelector();
	            return true;
	        case R.id.action_settings:
	            this.openAbout();
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
	
	
	private boolean openAbout() {
    	setContentView(R.layout.activity_about);
		return true;		
	}

	public boolean openSelector() {
    	setContentView(R.layout.activity_selector);
		return true;
	}

}
