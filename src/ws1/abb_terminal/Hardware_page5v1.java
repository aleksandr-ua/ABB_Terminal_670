package ws1.abb_terminal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.TextView;

public class Hardware_page5v1 extends Activity implements OnClickListener,
		OnItemSelectedListener {
	TextView resultText;
	Button btnNext;
	String confVar;
	String[] dataOutIn,dataOutIn1,dataOutIn2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hardware_page5v1);

		resultText = (TextView) findViewById(R.id.resultText);
		btnNext = (Button) findViewById(R.id.btnNext);
		btnNext.setOnClickListener(this);
		confVar = getIntent().getStringExtra("confV");
		dataOutIn=getResources().getStringArray(R.array.dataOutInREB);
		dataOutIn1=new String[4];
		dataOutIn1[0]=dataOutIn[2];
		dataOutIn1[1]=dataOutIn[3];
		dataOutIn1[2]=dataOutIn[4];
		dataOutIn1[3]=dataOutIn[5];
		dataOutIn2=new String[1];
		dataOutIn2[0]=dataOutIn[1];
		// адаптер
		ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, dataOutIn1);
		adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		Spinner spinner1 = (Spinner) findViewById(R.id.spOI1);
		spinner1.setAdapter(adapter1);
		spinner1.setOnItemSelectedListener(this);

		// адаптер
		ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, dataOutIn2);
		adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		Spinner spinner2 = (Spinner) findViewById(R.id.spOI2);
		spinner2.setAdapter(adapter2);
		spinner2.setOnItemSelectedListener(this);

		// адаптер
		ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, dataOutIn);
		adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		Spinner spinner3 = (Spinner) findViewById(R.id.spOI3);
		spinner3.setAdapter(adapter3);
		spinner3.setOnItemSelectedListener(this);

	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		int pos = parent.getSelectedItemPosition();

		switch (parent.getId()) {
		case R.id.spOI1:
			switch (pos) {
			case 0:
				getIntent().putExtra("OutIn1", "B");

				break;
			case 1:
				getIntent().putExtra("OutIn1", "C");

				break;
			case 2:
				getIntent().putExtra("OutIn1", "D");

				break;
			case 3:
				getIntent().putExtra("OutIn1", "E");

				break;

			}
			break;

		case R.id.spOI2:
			getIntent().putExtra("OutIn2", "A");
			break;

		case R.id.spOI3:
			int Rid = 3;
			setOutIn(pos, Rid);
			break;
		}
		for (int i = 4; i < 12; i++) {
			String s = "OutIn";
			s = s + i;
			getIntent().putExtra("s", "");
		}

		String OutIn = "";
		for (int i = 1; i < 12; i++) {
			String str = "OutIn";
			str = str + i;
			if (getIntent().getStringExtra(str) != null) {
				OutIn = OutIn + getIntent().getStringExtra(str);
			}
		}
		getIntent().putExtra("OutIn", OutIn);
		resultText.setText(getIntent().getStringExtra("MODEL") + "*1.1" + "-"
				+ getIntent().getStringExtra("software") + "-"
				+ getIntent().getStringExtra("hardware1") + "-"
				+ getIntent().getStringExtra("OutIn"));
	}

	void setOutIn(int pos, int Rid) {
		String str = "OutIn";
		if (Rid == 3) {
			str = str + 3;
		}
		switch (pos) {
		case 0:
			getIntent().putExtra(str, "X");

			break;
		case 1:
			getIntent().putExtra(str, "A");

			break;
		case 2:
			getIntent().putExtra(str, "B");

			break;
		case 3:
			getIntent().putExtra(str, "C");

			break;
		case 4:
			getIntent().putExtra(str, "D");

			break;
		case 5:
			getIntent().putExtra(str, "E");

			break;
		case 6:
			getIntent().putExtra(str, "F");

			break;
		case 7:
			getIntent().putExtra(str, "G");

			break;
		case 8:
			getIntent().putExtra(str, "H");

			break;
		case 9:
			getIntent().putExtra(str, "K");

			break;
		case 10:
			getIntent().putExtra(str, "L");

			break;
		case 11:
			getIntent().putExtra(str, "M");

			break;
		case 12:
			getIntent().putExtra(str, "N");

			break;
		case 13:
			getIntent().putExtra(str, "P");

			break;
		case 14:
			getIntent().putExtra(str, "U");

			break;
		case 15:
			getIntent().putExtra(str, "V");

			break;
		case 16:
			getIntent().putExtra(str, "W");

			break;
		case 17:
			getIntent().putExtra(str, "Y");

			break;
		case 18:
			getIntent().putExtra(str, "S");

			break;
		case 19:
			getIntent().putExtra(str, "T");

			break;

		}
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent = getIntent();
		intent.setClass(this, Hardware_page6v1.class);
		startActivity(intent);

	}
}
