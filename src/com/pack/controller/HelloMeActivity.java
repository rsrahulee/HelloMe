package com.pack.controller;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class HelloMeActivity extends Activity {

	EditText editName, editAge, editAddress;

	Context mCtx;

	AlertDialog alertDialog;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		mCtx = this;

		editName = (EditText) findViewById(R.id.editText1);
		editAge = (EditText) findViewById(R.id.editText2);
		editAddress = (EditText) findViewById(R.id.editText3);

		Button btnSubmit = (Button) findViewById(R.id.button1);
		btnSubmit.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				Intent intentUserDetails = new Intent(mCtx, UserDetails.class);

				String name = editName.getText().toString();
				String age = editAge.getText().toString();
				String address = editAddress.getText().toString();

				if (name.equals("")) {
					Toast.makeText(mCtx, "Please enter Name",
							Toast.LENGTH_SHORT).show();

				} else if (age.equals("")) {
					Toast.makeText(mCtx, "Please enter age", Toast.LENGTH_SHORT)
							.show();
				} else if (address.equals("")) {
					Toast.makeText(mCtx, "Please enter Address",
							Toast.LENGTH_SHORT).show();
				} else {
					Bundle bundle = new Bundle();

					bundle.putString("name", name);
					bundle.putString("age", age);
					bundle.putString("address", address);

					intentUserDetails.putExtras(bundle);

					mCtx.startActivity(intentUserDetails);
				}
			}
		});

		alertDialog = new AlertDialog.Builder(mCtx).create();

		alertDialog.setTitle("Exit Application?");
		alertDialog.setMessage("R u sure?");

		alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				System.exit(0);
			}
		});
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if ((keyCode == KeyEvent.KEYCODE_BACK)) {
			alertDialog.show();
		}
		return super.onKeyDown(keyCode, event);
	}
}