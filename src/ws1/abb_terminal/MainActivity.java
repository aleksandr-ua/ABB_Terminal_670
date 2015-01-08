package ws1.abb_terminal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {

	TextView tV1;
	Button REB, REC, RED, REL, RET;
	public String button1 = "";

	public String getButtonName() {
		return button1;
	}

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		tV1 = (TextView) findViewById(R.id.tV1);
		REB = (Button) findViewById(R.id.REB);
		REC = (Button) findViewById(R.id.REC);
		RED = (Button) findViewById(R.id.RED);
		REL = (Button) findViewById(R.id.REL);
		RET = (Button) findViewById(R.id.RET);

		REB.setOnClickListener(this);
		REC.setOnClickListener(this);
		RED.setOnClickListener(this);
		REL.setOnClickListener(this);
		RET.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		Intent intent = new Intent(this, Soft_page1.class);
		switch (v.getId()) {
		case R.id.REB:
			intent.putExtra("MODEL", "REB 670");
			break;
		case R.id.REC:
			intent.putExtra("MODEL", "REC 670");
			break;
		case R.id.RED:
			intent.putExtra("MODEL", "RED 670");
			break;
		case R.id.REL:
			intent.putExtra("MODEL", "REL 670");
			break;
		case R.id.RET:
			intent.putExtra("MODEL", "RET 670");
			break;
		}

		startActivity(intent);
	}

}