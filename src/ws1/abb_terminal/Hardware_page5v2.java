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

public class Hardware_page5v2 extends Activity implements OnClickListener,
		OnItemSelectedListener {
	TextView resultText;
	Button btnNext;
	String confVar;
	int[] countA = { 0, 0, 0, 0, 0, 0, 0, 0 };
	String[] dataOutIn,dataOutIn1,dataOutIn2,dataOutIn3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hardware_page5v2);

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
		dataOutIn3=new String[19];
		for (int i = 0; i < 18; i++) {
			dataOutIn3[i]=dataOutIn[i];
		}
		dataOutIn3[18]=dataOutIn[19];

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
				android.R.layout.simple_spinner_item, dataOutIn3);
		adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		Spinner spinner3 = (Spinner) findViewById(R.id.spOI3);
		spinner3.setAdapter(adapter3);
		spinner3.setOnItemSelectedListener(this);

		// адаптер

	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		int pos = parent.getSelectedItemPosition();
		int sum;

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
			countA[1] = 1;

			break;

		case R.id.spOI3:
			setOutIn(pos, 3);
			// адаптер
			ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(this,
					android.R.layout.simple_spinner_item, dataOutIn3);
			adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

			Spinner spinner4 = (Spinner) findViewById(R.id.spOI4);
			spinner4.setAdapter(adapter4);
			spinner4.setOnItemSelectedListener(this);
			break;
		case R.id.spOI4:
			setOutIn(pos, 4);
			// адаптер
			ArrayAdapter<String> adapter5 = new ArrayAdapter<String>(this,
					android.R.layout.simple_spinner_item, dataOutIn3);
			adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

			Spinner spinner5 = (Spinner) findViewById(R.id.spOI5);
			spinner5.setAdapter(adapter5);
			spinner5.setOnItemSelectedListener(this);

			break;
		case R.id.spOI5:
			for (int i = 5; i < countA.length; i++) {
				if (countA[i] == 1) {
					countA[i] = 0;
				}
			}
			setOutIn(pos, 5);
			sum = sumcountA();
			// адаптер
			ArrayAdapter<String> adapter6;

			if (sum > 3) {
				adapter6 = new ArrayAdapter<String>(this,
						android.R.layout.simple_spinner_item, getResources()
								.getStringArray(R.array.OutIn3_3AREB));

			} else {
				adapter6 = new ArrayAdapter<String>(this,
						android.R.layout.simple_spinner_item, dataOutIn3);

			}

			adapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			Spinner spinner6 = (Spinner) findViewById(R.id.spOI6);
			spinner6.setAdapter(adapter6);
			spinner6.setOnItemSelectedListener(this);

			break;
		case R.id.spOI6:
			for (int i = 6; i < countA.length; i++) {
				if (countA[i] == 1) {
					countA[i] = 0;
				}
			}
			// адаптер
			sum = sumcountA();
			ArrayAdapter<String> adapter7;
			if (sum > 3) {
				setOutInA(pos, 6);

			} else {
				setOutIn(pos, 6);

			}
			sum = sumcountA();
			if (sum > 3) {
				adapter7 = new ArrayAdapter<String>(this,
						android.R.layout.simple_spinner_item, getResources()
								.getStringArray(R.array.OutIn3_3AREB));
			} else {
				adapter7 = new ArrayAdapter<String>(this,
						android.R.layout.simple_spinner_item, dataOutIn3);
			}
			adapter7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			Spinner spinner7 = (Spinner) findViewById(R.id.spOI7);
			spinner7.setAdapter(adapter7);
			spinner7.setOnItemSelectedListener(this);

			break;

		case R.id.spOI7:
			for (int i = 7; i < countA.length; i++) {
				if (countA[i] == 1) {
					countA[i] = 0;
				}
			}
			sum = sumcountA();
			// адаптер
			ArrayAdapter<String> adapter8;
			if (sum > 3) {
				setOutInA(pos, 7);

			} else {
				setOutIn(pos, 7);

			}
			sum = sumcountA();
			if (sum > 3) {
				adapter8 = new ArrayAdapter<String>(this,
						android.R.layout.simple_spinner_item, getResources()
								.getStringArray(R.array.OutIn3_1AREB));
			} else {
				adapter8 = new ArrayAdapter<String>(this,
						android.R.layout.simple_spinner_item, dataOutIn);
			}

			adapter8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			Spinner spinner8 = (Spinner) findViewById(R.id.spOI8);
			spinner8.setAdapter(adapter8);
			spinner8.setOnItemSelectedListener(this);

			break;

		case R.id.spOI8:
			sum = sumcountA();
			if (sum > 3) {
				setOutInSA(pos, 8);
			} else {
				setOutInS(pos, 8);
			}

			break;
		}

		for (int i = 9; i < 12; i++) {
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

	int sumcountA() {
		int sum = 0;
		for (int i = 0; i < countA.length; i++) {
			sum = sum + countA[i];
		}
		return sum;
	}

	void setOutIn(int pos, int Rid) {
		String str = "OutIn";

		str = str + Rid;
		if (pos == 1) {
			countA[Rid - 1] = 1;
		} else
			countA[Rid - 1] = 0;

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
			getIntent().putExtra(str, "T");

			break;

		}
	}

	void setOutInA(int pos, int Rid) {
		String str = "OutIn";

		str = str + Rid;
		countA[Rid - 1] = 0;

		switch (pos) {
		case 0:
			getIntent().putExtra(str, "X");

			break;
		case 1:
			getIntent().putExtra(str, "B");

			break;
		case 2:
			getIntent().putExtra(str, "C");

			break;
		case 3:
			getIntent().putExtra(str, "D");

			break;
		case 4:
			getIntent().putExtra(str, "E");

			break;
		case 5:
			getIntent().putExtra(str, "F");

			break;
		case 6:
			getIntent().putExtra(str, "G");

			break;
		case 7:
			getIntent().putExtra(str, "H");

			break;
		case 8:
			getIntent().putExtra(str, "K");

			break;
		case 9:
			getIntent().putExtra(str, "L");

			break;
		case 10:
			getIntent().putExtra(str, "M");

			break;
		case 11:
			getIntent().putExtra(str, "N");

			break;
		case 12:
			getIntent().putExtra(str, "P");

			break;
		case 13:
			getIntent().putExtra(str, "U");

			break;
		case 14:
			getIntent().putExtra(str, "V");

			break;
		case 15:
			getIntent().putExtra(str, "W");

			break;
		case 16:
			getIntent().putExtra(str, "Y");

			break;
		case 17:
			getIntent().putExtra(str, "T");

			break;

		}
	}

	void setOutInS(int pos, int Rid) {
		String str = "OutIn";

		str = str + Rid;
		if (pos == 1) {
			countA[Rid - 1] = 1;
		} else
			countA[Rid - 1] = 0;

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

	void setOutInSA(int pos, int Rid) {
		String str = "OutIn";

		str = str + Rid;

		countA[Rid - 1] = 0;

		switch (pos) {
		case 0:
			getIntent().putExtra(str, "X");

			break;

		case 1:
			getIntent().putExtra(str, "B");

			break;
		case 2:
			getIntent().putExtra(str, "C");

			break;
		case 3:
			getIntent().putExtra(str, "D");

			break;
		case 4:
			getIntent().putExtra(str, "E");

			break;
		case 5:
			getIntent().putExtra(str, "F");

			break;
		case 6:
			getIntent().putExtra(str, "G");

			break;
		case 7:
			getIntent().putExtra(str, "H");

			break;
		case 8:
			getIntent().putExtra(str, "K");

			break;
		case 9:
			getIntent().putExtra(str, "L");

			break;
		case 10:
			getIntent().putExtra(str, "M");

			break;
		case 11:
			getIntent().putExtra(str, "N");

			break;
		case 12:
			getIntent().putExtra(str, "P");

			break;
		case 13:
			getIntent().putExtra(str, "U");

			break;
		case 14:
			getIntent().putExtra(str, "V");

			break;
		case 15:
			getIntent().putExtra(str, "W");

			break;
		case 16:
			getIntent().putExtra(str, "Y");

			break;
		case 17:
			getIntent().putExtra(str, "S");

			break;
		case 18:
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
		intent.setClass(this, Hardware_page6v2.class);
		startActivity(intent);

	}
}
