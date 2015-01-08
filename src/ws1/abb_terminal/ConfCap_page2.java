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
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class ConfCap_page2 extends Activity implements OnClickListener {

	TextView SoftNameP2, SoftCapName, SoftCapNameShow, resultText;
	Button btnNext;
	String[] dataCapConf, dataCapConf2;
	String confVar, confCap;
	int var = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.softcap_page2);

		SoftNameP2 = (TextView) findViewById(R.id.SoftNameP2);
		SoftCapName = (TextView) findViewById(R.id.SoftCapName);
		btnNext = (Button) findViewById(R.id.btnNext);
		btnNext.setOnClickListener(this);
		// массив значений для адаптора
		dataCapConf = getResources().getStringArray(R.array.ConfCAPREB);
		if (getIntent().getStringExtra("confV").equals("A20")) {

			dataCapConf2 = new String[1];
			dataCapConf2[0] = dataCapConf[0];
			var = 0;
		} else {
			dataCapConf2 = new String[2];
			dataCapConf2[0] = dataCapConf[1];
			dataCapConf2[1] = dataCapConf[2];
			var = 1;
		}


		// адаптер
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, dataCapConf2);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		Spinner spinner = (Spinner) findViewById(R.id.confCAP);
		spinner.setAdapter(adapter);

		// устанавливаем обработчик нажатия
		spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {

				int pos = parent.getSelectedItemPosition();
				pos = pos + var;

				switch (pos) {
				case 0:
					getIntent().putExtra("confCap", "X01");

					break;
				case 1:
					getIntent().putExtra("confCap", "X02");

					break;
				case 2:
					getIntent().putExtra("confCap", "X03");

					break;

				}
				// показываем позиция нажатого элемента
				Toast.makeText(
						getBaseContext(),
						"Варіант конфігурації: "
								+ getIntent().getStringExtra("confCap"),
						Toast.LENGTH_SHORT).show();

				resultText = (TextView) findViewById(R.id.resultText);
				resultText.setText(getIntent().getStringExtra("MODEL") + "*1.1"
						+ "-" + getIntent().getStringExtra("confV")
						+ getIntent().getStringExtra("confCap"));

				SoftCapNameShow = (TextView) findViewById(R.id.SoftCapNameShow);
				SoftCapNameShow.setText(dataCapConf[pos]);

			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent = getIntent();
		intent.setClass(this, Opt_page3.class);
		startActivity(intent);

	}

}
