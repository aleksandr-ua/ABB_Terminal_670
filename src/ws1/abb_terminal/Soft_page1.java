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

public class Soft_page1 extends Activity implements OnClickListener {
	TextView SoftName, SoftVarName, SoftVarNameShow, resultText;
	Button btnNext;
	String[] dataVarConf;
	String confVar, confV;

	// Intent intent = new Intent(this, MainActivity.class);
	// startActivity(intent);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.soft_page1);

		SoftName = (TextView) findViewById(R.id.SoftName);
		SoftVarName = (TextView) findViewById(R.id.SoftVarName);
		btnNext = (Button) findViewById(R.id.btnNext);
		btnNext.setOnClickListener(this);
		// массив значений для адаптора
		dataVarConf = getResources().getStringArray(R.array.VarConfREB);
		// адаптер
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, dataVarConf);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		Spinner spinner = (Spinner) findViewById(R.id.confVar);
		spinner.setAdapter(adapter);

		// выделяем элемент
		// spinner.setSelection(0);

		// устанавливаем обработчик нажатия
		spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {

				int pos = parent.getSelectedItemPosition();

				switch (pos) {
				case 0:
					getIntent().putExtra("confV", "A20");

					break;
				case 1:
					getIntent().putExtra("confV", "A31");

					break;
				case 2:
					getIntent().putExtra("confV", "B20");

					break;
				case 3:
					getIntent().putExtra("confV", "B21");

					break;
				case 4:
					getIntent().putExtra("confV", "B31");

					break;

				}
				// показываем позиция нажатого элемента
				Toast.makeText(
						getBaseContext(),
						"Варіант конфігурації: "
								+ getIntent().getStringExtra("confV"),
						Toast.LENGTH_SHORT).show();

				resultText = (TextView) findViewById(R.id.resultText);
				resultText.setText(getIntent().getStringExtra("MODEL") + "*1.1"
						+ "-" + getIntent().getStringExtra("confV"));

				SoftVarNameShow = (TextView) findViewById(R.id.SoftVarNameShow);
				SoftVarNameShow.setText(dataVarConf[pos]);

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
		intent.setClass(this, ConfCap_page2.class);
		startActivity(intent);

	}
}
