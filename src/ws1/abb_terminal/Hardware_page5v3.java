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

public class Hardware_page5v3 extends Activity implements OnClickListener,
		OnItemSelectedListener {
	TextView resultText;
	Button btnNext;
	String confVar;
	int[] countA = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	int[] countL = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	String[] dataOutIn, dataOutIn1, dataOutIn2, dataOutIn3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hardware_page5v3);

		resultText = (TextView) findViewById(R.id.resultText);
		btnNext = (Button) findViewById(R.id.btnNext);
		btnNext.setOnClickListener(this);
		confVar = getIntent().getStringExtra("confV");

		dataOutIn = getResources().getStringArray(R.array.dataOutInREB);
		dataOutIn1 = new String[4];
		dataOutIn1[0] = dataOutIn[2];
		dataOutIn1[1] = dataOutIn[3];
		dataOutIn1[2] = dataOutIn[4];
		dataOutIn1[3] = dataOutIn[5];
		dataOutIn2 = new String[1];
		dataOutIn2[0] = dataOutIn[1];
		dataOutIn3 = new String[19];
		for (int i = 0; i < 18; i++) {
			dataOutIn3[i] = dataOutIn[i];
		}
		dataOutIn3[18] = dataOutIn[19];

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

		if (confVar.equals("A31")) {
			// адаптер
			ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this,
					android.R.layout.simple_spinner_item, dataOutIn3);
			adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

			Spinner spinner3 = (Spinner) findViewById(R.id.spOI3);
			spinner3.setAdapter(adapter3);
			spinner3.setOnItemSelectedListener(this);

		} else {
			// адаптер
			ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this,
					android.R.layout.simple_spinner_item, dataOutIn1);
			adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

			Spinner spinner3 = (Spinner) findViewById(R.id.spOI3);
			spinner3.setAdapter(adapter3);
			spinner3.setOnItemSelectedListener(this);
		}

	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		int pos = parent.getSelectedItemPosition();
		int sumA, sumL;

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
			if (confVar.equals("B21") || confVar.equals("B31")) {
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
			} else {
				setOutIn(pos, 3, parent.getId());
			}
			// адаптер
			ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(this,
					android.R.layout.simple_spinner_item, dataOutIn3);
			adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

			Spinner spinner4 = (Spinner) findViewById(R.id.spOI4);
			spinner4.setAdapter(adapter4);
			spinner4.setOnItemSelectedListener(this);
			break;
		case R.id.spOI4:
			setOutIn(pos, 4, parent.getId());
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
			setOutIn(pos, 5, parent.getId());
			sumA = sumcountA();
			// адаптер
			ArrayAdapter<String> adapter6;

			if (sumA > 3) {
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
			// адаптер
			for (int i = 6; i < countA.length; i++) {
				if (countA[i] == 1) {
					countA[i] = 0;
				}
			}
			sumA = sumcountA();
			ArrayAdapter<String> adapter7;
			if (sumA > 3) {
				setOutInA(pos, 6, parent.getId());

			} else {
				setOutIn(pos, 6, parent.getId());

			}
			sumA = sumcountA();
			if (sumA > 3) {
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
			// адаптер
			for (int i = 7; i < countA.length; i++) {
				if (countA[i] == 1) {
					countA[i] = 0;
				}
			}
			sumA = sumcountA();
			ArrayAdapter<String> adapter8;
			if (sumA > 3) {
				setOutInA(pos, 7, parent.getId());

			} else {
				setOutIn(pos, 7, parent.getId());

			}
			sumA = sumcountA();
			if (sumA > 3) {
				adapter8 = new ArrayAdapter<String>(this,
						android.R.layout.simple_spinner_item, getResources()
								.getStringArray(R.array.OutIn3_3AREB));
			} else {
				adapter8 = new ArrayAdapter<String>(this,
						android.R.layout.simple_spinner_item, dataOutIn3);
			}
			adapter8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			Spinner spinner8 = (Spinner) findViewById(R.id.spOI8);
			spinner8.setAdapter(adapter8);
			spinner8.setOnItemSelectedListener(this);

			break;

		case R.id.spOI8:
			// адаптер
			for (int i = 8; i < countA.length; i++) {
				if (countA[i] == 1) {
					countA[i] = 0;
				}
			}
			for (int i = 8; i < countL.length; i++) {
				if (countL[i] == 1) {
					countL[i] = 0;
				}
			}
			sumA = sumcountA();
			sumL = sumcountL();
			ArrayAdapter<String> adapter9;
			if (sumA > 3 && sumL > 5) {
				setOutInAL(pos, 8, parent.getId());

			} else if (sumA > 3 && sumL < 6) {
				setOutInA(pos, 8, parent.getId());
			} else if (sumA < 4 && sumL > 5) {
				setOutInL(pos, 8, parent.getId());
			} else {
				setOutIn(pos, 8, parent.getId());

			}
			sumA = sumcountA();
			sumL = sumcountL();
			if (sumA > 3 && sumL > 5) {
				adapter9 = new ArrayAdapter<String>(this,
						android.R.layout.simple_spinner_item, getResources()
								.getStringArray(R.array.OutIn3_3ALREB));
			} else if (sumA > 3 && sumL < 6) {
				adapter9 = new ArrayAdapter<String>(this,
						android.R.layout.simple_spinner_item, getResources()
								.getStringArray(R.array.OutIn3_3AREB));
			} else if (sumA < 4 && sumL > 5) {
				adapter9 = new ArrayAdapter<String>(this,
						android.R.layout.simple_spinner_item, getResources()
								.getStringArray(R.array.OutIn3_3LREB));
			} else {
				adapter9 = new ArrayAdapter<String>(this,
						android.R.layout.simple_spinner_item, dataOutIn3);
			}
			adapter9.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			Spinner spinner9 = (Spinner) findViewById(R.id.spOI9);
			spinner9.setAdapter(adapter9);
			spinner9.setOnItemSelectedListener(this);
			break;

		case R.id.spOI9:
			// адаптер
			for (int i = 9; i < countA.length; i++) {
				if (countA[i] == 1) {
					countA[i] = 0;
				}
			}
			for (int i = 9; i < countL.length; i++) {
				if (countL[i] == 1) {
					countL[i] = 0;
				}
			}
			sumA = sumcountA();
			sumL = sumcountL();
			ArrayAdapter<String> adapter10;
			if (sumA > 3 && sumL > 5) {
				setOutInAL(pos, 9, parent.getId());

			} else if (sumA > 3 && sumL < 6) {
				setOutInA(pos, 9, parent.getId());
			} else if (sumA < 4 && sumL > 5) {
				setOutInL(pos, 9, parent.getId());
			} else {
				setOutIn(pos, 9, parent.getId());

			}
			sumA = sumcountA();
			sumL = sumcountL();
			if (sumA > 3 && sumL > 5) {
				adapter10 = new ArrayAdapter<String>(this,
						android.R.layout.simple_spinner_item, getResources()
								.getStringArray(R.array.OutIn3_3ALREB));
			} else if (sumA > 3 && sumL < 6) {
				adapter10 = new ArrayAdapter<String>(this,
						android.R.layout.simple_spinner_item, getResources()
								.getStringArray(R.array.OutIn3_3AREB));
			} else if (sumA < 4 && sumL > 5) {
				adapter10 = new ArrayAdapter<String>(this,
						android.R.layout.simple_spinner_item, getResources()
								.getStringArray(R.array.OutIn3_3LREB));
			} else {
				adapter10 = new ArrayAdapter<String>(this,
						android.R.layout.simple_spinner_item, dataOutIn3);
			}
			adapter10
					.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			Spinner spinner10 = (Spinner) findViewById(R.id.spOI10);
			spinner10.setAdapter(adapter10);
			spinner10.setOnItemSelectedListener(this);
			break;

		case R.id.spOI10:
			// адаптер
			for (int i = 10; i < countA.length; i++) {
				if (countA[i] == 1) {
					countA[i] = 0;
				}
			}
			for (int i = 10; i < countL.length; i++) {
				if (countL[i] == 1) {
					countL[i] = 0;
				}
			}
			sumA = sumcountA();
			sumL = sumcountL();
			ArrayAdapter<String> adapter11;
			if (sumA > 3 && sumL > 5) {
				setOutInAL(pos, 10, parent.getId());

			} else if (sumA > 3 && sumL < 6) {
				setOutInA(pos, 10, parent.getId());
			} else if (sumA < 4 && sumL > 5) {
				setOutInL(pos, 10, parent.getId());
			} else {
				setOutIn(pos, 10, parent.getId());

			}
			sumA = sumcountA();
			sumL = sumcountL();
			if (sumA > 3 && sumL > 5) {
				adapter11 = new ArrayAdapter<String>(this,
						android.R.layout.simple_spinner_item, getResources()
								.getStringArray(R.array.OutIn3_1ALREB));
			} else if (sumA > 3 && sumL < 6) {
				adapter11 = new ArrayAdapter<String>(this,
						android.R.layout.simple_spinner_item, getResources()
								.getStringArray(R.array.OutIn3_1AREB));
			} else if (sumA < 4 && sumL > 5) {
				adapter11 = new ArrayAdapter<String>(this,
						android.R.layout.simple_spinner_item, getResources()
								.getStringArray(R.array.OutIn3_1LREB));
			} else {
				adapter11 = new ArrayAdapter<String>(this,
						android.R.layout.simple_spinner_item, dataOutIn);
			}
			adapter11
					.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			Spinner spinner11 = (Spinner) findViewById(R.id.spOI11);
			spinner11.setAdapter(adapter11);
			spinner11.setOnItemSelectedListener(this);

			break;

		case R.id.spOI11:
			// адаптер
			sumA = sumcountA();
			sumL = sumcountL();

			if (sumA > 3 && sumL > 5) {
				setOutInAL(pos, 11, parent.getId());

			} else if (sumA > 3 && sumL < 6) {
				setOutInA(pos, 11, parent.getId());
			} else if (sumA < 4 && sumL > 5) {
				setOutInL(pos, 11, parent.getId());
			} else {
				setOutIn(pos, 11, parent.getId());

			}
			break;

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

	int sumcountL() {
		int sum = 0;
		for (int i = 0; i < countL.length; i++) {
			sum = sum + countL[i];
		}
		return sum;
	}

	void setOutIn(int pos, int Rid, int parent) {
		String str = "OutIn";

		str = str + Rid;
		if (pos == 1) {
			countA[Rid - 1] = 1;
		} else {
			countA[Rid - 1] = 0;
		}
		if (pos == 10 || pos == 11 || pos == 12 || pos == 13 || pos == 14
				|| pos == 15 || pos == 16 || pos == 17) {
			countL[Rid - 1] = 1;
		} else {
			countL[Rid - 1] = 0;
		}
		if (parent != R.id.spOI11 && pos == 18) {
			pos = pos + 1;
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

	void setOutInL(int pos, int Rid, int parent) {
		String str = "OutIn";

		str = str + Rid;
		if (pos == 1) {
			countA[Rid - 1] = 1;
		} else {
			countA[Rid - 1] = 0;
		}
		countL[Rid - 1] = 0;
		if (parent != R.id.spOI11 && pos == 10) {
			pos = pos + 1;
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
			getIntent().putExtra(str, "S");

			break;
		case 11:
			getIntent().putExtra(str, "T");

			break;

		}
	}

	void setOutInA(int pos, int Rid, int parent) {
		String str = "OutIn";

		str = str + Rid;

		countA[Rid - 1] = 0;
		if (pos == 10 || pos == 11 || pos == 12 || pos == 13 || pos == 14
				|| pos == 15 || pos == 16 || pos == 17) {
			countL[Rid - 1] = 1;
		} else {
			countL[Rid - 1] = 0;
		}
		if (parent != R.id.spOI11 && pos == 17) {
			pos = pos + 1;
		}

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

	void setOutInAL(int pos, int Rid, int parent) {
		String str = "OutIn";

		str = str + Rid;

		countA[Rid - 1] = 0;

		countL[Rid - 1] = 0;

		if (parent != R.id.spOI11 && pos == 16) {
			pos = pos + 1;
		}

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
			getIntent().putExtra(str, "S");

			break;
		case 10:
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
		intent.setClass(this, Hardware_page6v3.class);
		startActivity(intent);

	}
}
