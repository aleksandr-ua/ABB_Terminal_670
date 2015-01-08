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

public class Hardware_page6v1 extends Activity implements OnClickListener,
		OnItemSelectedListener {
	TextView resultText;
	Button btnNext;
	String body;
	int[] countA = { 0, 0, 0 };
	String[] dataCLEP, dataCLEPxag, dataCLEPxa, dataCLEPx, dataCLEPxaf,
			dataCLEPxf;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hardware_page6v1);

		resultText = (TextView) findViewById(R.id.resultText);
		btnNext = (Button) findViewById(R.id.btnNext);
		btnNext.setOnClickListener(this);
		body = getIntent().getStringExtra("body");

		dataCLEP = getResources().getStringArray(R.array.CLEPREB);
		dataCLEPxag = new String[3];
		dataCLEPxag[0] = dataCLEP[0];
		dataCLEPxag[1] = dataCLEP[1];
		dataCLEPxag[2] = dataCLEP[3];
		dataCLEPxa = new String[2];
		dataCLEPxa[0] = dataCLEP[0];
		dataCLEPxa[1] = dataCLEP[1];
		dataCLEPx = new String[1];
		dataCLEPx[0] = dataCLEP[0];
		dataCLEPxaf = new String[3];
		dataCLEPxaf[0] = dataCLEP[0];
		dataCLEPxaf[1] = dataCLEP[1];
		dataCLEPxaf[2] = dataCLEP[2];
		dataCLEPxf = new String[2];
		dataCLEPxf[0] = dataCLEP[0];
		dataCLEPxf[1] = dataCLEP[2];

		// адаптер
		ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, dataCLEPxag);
		adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		Spinner spinner1 = (Spinner) findViewById(R.id.spCLEP1);
		spinner1.setAdapter(adapter1);
		spinner1.setOnItemSelectedListener(this);

	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		int pos = parent.getSelectedItemPosition();

		switch (parent.getId()) {
		case R.id.spCLEP1:
			countA[0] = 0;
			countA[1] = 0;
			countA[2] = 0;
			setCLEPxag(pos, 1);
			// адаптер
			ArrayAdapter<String> adapter2;
			if (countA[0] + countA[1] + countA[2] > 0) {
				adapter2 = new ArrayAdapter<String>(this,
						android.R.layout.simple_spinner_item, dataCLEPx);
			} else {
				adapter2 = new ArrayAdapter<String>(this,
						android.R.layout.simple_spinner_item, dataCLEPxa);
			}

			adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

			Spinner spinner2 = (Spinner) findViewById(R.id.spCLEP2);
			spinner2.setAdapter(adapter2);
			spinner2.setOnItemSelectedListener(this);

			break;

		case R.id.spCLEP2:
			if (countA[2] == 1) {
				countA[2] = 0;
			}
			if (countA[0] + countA[1] + countA[2] == 0) {
				setCLEPxa(pos, 2);
			} else {
				getIntent().putExtra("CLEP2", "X");
				countA[1] = 0;
			}
			// адаптер
			ArrayAdapter<String> adapter3;
			if (countA[0] + countA[1] + countA[2] > 0) {
				adapter3 = new ArrayAdapter<String>(this,
						android.R.layout.simple_spinner_item, dataCLEPxf);
			} else {
				adapter3 = new ArrayAdapter<String>(this,
						android.R.layout.simple_spinner_item, dataCLEPxaf);
			}

			adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

			Spinner spinner3 = (Spinner) findViewById(R.id.spCLEP3);
			spinner3.setAdapter(adapter3);
			spinner3.setOnItemSelectedListener(this);
			break;

		case R.id.spCLEP3:
			if (countA[0] + countA[1] + countA[2] == 0) {
				setCLEPxaf(pos, 3);
			} else {
				setCLEPxf(pos, 3);
			}
			break;
		}
		for (int i = 4; i < 7; i++) {
			String s = "CLEP";
			s = s + i;
			getIntent().putExtra("s", "");
		}

		String CLEP = "";
		for (int i = 1; i < 7; i++) {
			String str = "CLEP";
			str = str + i;
			if (getIntent().getStringExtra(str) != null) {
				CLEP = CLEP + getIntent().getStringExtra(str);
			}
		}
		getIntent().putExtra("CLEP", CLEP);
		resultText.setText(getIntent().getStringExtra("MODEL") + "*1.1" + "-"
				+ getIntent().getStringExtra("software") + "-"
				+ getIntent().getStringExtra("hardware1") + "-"
				+ getIntent().getStringExtra("OutIn") + "-"
				+ getIntent().getStringExtra("CLEP"));
	}

	void setCLEPxag(int pos, int Rid) {
		if (pos == 1) {
			countA[Rid - 1] = 1;
		} else {
			countA[Rid - 1] = 0;
		}
		switch (pos) {

		case 0:
			getIntent().putExtra("CLEP1", "X");
			break;
		case 1:
			getIntent().putExtra("CLEP1", "A");

			break;
		case 2:
			getIntent().putExtra("CLEP1", "G");
			break;
		}
	}

	void setCLEPxa(int pos, int Rid) {
		String str = "CLEP";
		str = str + Rid;
		if (pos == 1) {
			countA[Rid - 1] = 1;
		} else {
			countA[Rid - 1] = 0;
		}

		switch (pos) {
		case 0:
			getIntent().putExtra(str, "X");

			break;
		case 1:
			getIntent().putExtra(str, "A");

			break;
		}
	}

	void setCLEPxaf(int pos, int Rid) {
		String str = "CLEP";
		str = str + Rid;
		if (pos == 1) {
			countA[Rid - 1] = 1;
		} else {
			countA[Rid - 1] = 0;
		}

		switch (pos) {
		case 0:
			getIntent().putExtra(str, "X");

			break;
		case 1:
			getIntent().putExtra(str, "A");

			break;
		case 2:
			getIntent().putExtra(str, "F");

			break;
		}
	}

	void setCLEPxf(int pos, int Rid) {
		String str = "CLEP";
		str = str + Rid;
		if (pos == 1) {
			countA[Rid - 1] = 1;
		} else {
			countA[Rid - 1] = 0;
		}

		switch (pos) {
		case 0:
			getIntent().putExtra(str, "X");

			break;
		case 1:
			getIntent().putExtra(str, "F");

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
		intent.setClass(this, Hardware_page7.class);
		startActivity(intent);

	}
}
