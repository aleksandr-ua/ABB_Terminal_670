package ws1.abb_terminal;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class Hardware_page7 extends Activity implements OnClickListener {

	TextView resultText, firstContNameShow, secondContNameShow;
	EditText editResultText;
	Button btnResult;
	String[] dataCon1, dataCon2;

	// Intent intent = new Intent(this, MainActivity.class);
	// startActivity(intent);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hardware_page7);

		resultText = (TextView) findViewById(R.id.resultText);
		firstContNameShow = (TextView) findViewById(R.id.firstContNameShow);
		secondContNameShow = (TextView) findViewById(R.id.secondContNameShow);
		btnResult = (Button) findViewById(R.id.btnResult);
		btnResult.setOnClickListener(this);
		editResultText = (EditText) findViewById(R.id.editResultText);

		// массив значений для адаптора

		dataCon1 = getResources().getStringArray(R.array.connectionObj1);

		dataCon2 = getResources().getStringArray(R.array.connectionObj2);

		// адаптер
		ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, dataCon1);
		adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		Spinner spinner1 = (Spinner) findViewById(R.id.spCont1);
		spinner1.setAdapter(adapter1);

		// устанавливаем обработчик нажатия
		spinner1.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {

				int pos = parent.getSelectedItemPosition();

				switch (pos) {
				case 0:
					getIntent().putExtra("connect1", "X");

					break;
				case 1:
					getIntent().putExtra("connect1", "A");

					break;
				case 2:
					getIntent().putExtra("connect1", "B");

					break;
				case 3:
					getIntent().putExtra("connect1", "C");

					break;

				}
				// показываем позиция нажатого элемента
				Toast.makeText(
						getBaseContext(),
						"Варіант конфігурації: "
								+ getIntent().getStringExtra("connect1"),
						Toast.LENGTH_SHORT).show();
				firstContNameShow.setText(dataCon1[pos]);

				resultText.setText(getIntent().getStringExtra("MODEL") + "*1.1"
						+ "-" + getIntent().getStringExtra("software") + "-"
						+ getIntent().getStringExtra("hardware1") + "-"
						+ getIntent().getStringExtra("OutIn") + "-"
						+ getIntent().getStringExtra("CLEP") + "-"
						+ getIntent().getStringExtra("connect1")
						+ getIntent().getStringExtra("connect2"));

				getIntent().putExtra(
						"TERMINAL",
						getIntent().getStringExtra("MODEL") + "*1.1" + "-"
								+ getIntent().getStringExtra("software") + "-"
								+ getIntent().getStringExtra("hardware1") + "-"
								+ getIntent().getStringExtra("OutIn") + "-"
								+ getIntent().getStringExtra("CLEP") + "-"
								+ getIntent().getStringExtra("connect1")
								+ getIntent().getStringExtra("connect2"));
				editResultText.setText("");
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});

		// адаптер
		ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, dataCon2);
		adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		Spinner spinner2 = (Spinner) findViewById(R.id.spCont2);
		spinner2.setAdapter(adapter2);

		// устанавливаем обработчик нажатия
		spinner2.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {

				int pos = parent.getSelectedItemPosition();

				switch (pos) {
				case 0:
					getIntent().putExtra("connect2", "X");

					break;
				case 1:
					getIntent().putExtra("connect2", "D");

					break;
				case 2:
					getIntent().putExtra("connect2", "E");

					break;

				}
				// показываем позиция нажатого элемента
				Toast.makeText(
						getBaseContext(),
						"Варіант конфігурації: "
								+ getIntent().getStringExtra("connect2"),
						Toast.LENGTH_SHORT).show();

				secondContNameShow.setText(dataCon2[pos]);

				resultText.setText(getResources().getString(R.string.model)
						+ "*1.1" + "-" + getIntent().getStringExtra("software")
						+ "-" + getIntent().getStringExtra("hardware1") + "-"
						+ getIntent().getStringExtra("OutIn") + "-"
						+ getIntent().getStringExtra("CLEP") + "-"
						+ getIntent().getStringExtra("connect1")
						+ getIntent().getStringExtra("connect2"));
				getIntent().putExtra(
						"TERMINAL",
						getIntent().getStringExtra("MODEL") + "*1.1" + "-"
								+ getIntent().getStringExtra("software") + "-"
								+ getIntent().getStringExtra("hardware1") + "-"
								+ getIntent().getStringExtra("OutIn") + "-"
								+ getIntent().getStringExtra("CLEP") + "-"
								+ getIntent().getStringExtra("connect1")
								+ getIntent().getStringExtra("connect2"));
				editResultText.setText("");

			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		editResultText.setText(getIntent().getStringExtra("TERMINAL"));

	}

}
