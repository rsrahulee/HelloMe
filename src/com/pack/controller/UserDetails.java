package com.pack.controller;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class UserDetails extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.userdetails);
		
		 Bundle extras = this.getIntent().getExtras();
          String name=extras.getString("name");
          String age=extras.getString("age");
          String address=extras.getString("address");
          
          TextView nameText = (TextView)findViewById(R.id.textView4);
          TextView ageText = (TextView)findViewById(R.id.textView5);
          TextView addressText = (TextView)findViewById(R.id.textView6);        
          
          nameText.setText(name);
          ageText.setText(age);
          addressText.setText(address);

	}
}
