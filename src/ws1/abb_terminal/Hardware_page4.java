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
import android.widget.AdapterView.OnItemSelectedListener;

public class Hardware_page4 extends Activity implements OnClickListener,
		OnItemSelectedListener {
	TextView hardware, body, kit, connection, connection2, supply, MMI, inputs,
			resultText, tvBodyName, tvKitName, tvSupplyName, tvMMIName;
	Button btnNext;
	String confVar;
	String hardware1;
	String[] dataBody, dataBody1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hardware_page4);

		hardware = (TextView) findViewById(R.id.hardware);
		body = (TextView) findViewById(R.id.body);
		tvBodyName = (TextView) findViewById(R.id.tvBodyName);
		kit = (TextView) findViewById(R.id.kit);
		tvKitName = (TextView) findViewById(R.id.tvKitName);
		connection = (TextView) findViewById(R.id.connection);
		connection2 = (TextView) findViewById(R.id.connection2);
		supply = (TextView) findViewById(R.id.supply);
		tvSupplyName = (TextView) findViewById(R.id.tvSupplyName);
		MMI = (TextView) findViewById(R.id.MMI);
		tvMMIName = (TextView) findViewById(R.id.tvMMIName);
		inputs = (TextView) findViewById(R.id.inputs);
		resultText = (TextView) findViewById(R.id.resultText);
		btnNext = (Button) findViewById(R.id.btnNext);
		btnNext.setOnClickListener(this);
		confVar = getIntent().getStringExtra("confV");
		// задаем массив для spinner1
		dataBody = getResources().getStringArray(R.array.bodyREB);
		if (confVar.equals("A20") || confVar.equals("B20")) {
			dataBody1 = new String[2];
			dataBody1[0] = dataBody[0];
			dataBody1[1] = dataBody[1];
		} else {
			dataBody1 = new String[1];
			dataBody1[0] = dataBody[2];

		}
		ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, dataBody1);
		adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		Spinner spinner1 = (Spinner) findViewById(R.id.spBody);
		spinner1.setAdapter(adapter1);
		spinner1.setOnItemSelectedListener(this);

		// адаптер

		ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, getResources()
						.getStringArray(R.array.kit));
		adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		Spinner spinner2 = (Spinner) findViewById(R.id.spKit);
		spinner2.setAdapter(adapter2);
		spinner2.setOnItemSelectedListener(this);

		getIntent().putExtra("connect", "K");

		// адаптер

		ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, getResources()
						.getStringArray(R.array.supply));
		adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		Spinner spinner3 = (Spinner) findViewById(R.id.spSupply);
		spinner3.setAdapter(adapter3);
		spinner3.setOnItemSelectedListener(this);

		// адаптер

		ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, getResources()
						.getStringArray(R.array.MMI));
		adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		Spinner spinner4 = (Spinner) findViewById(R.id.spMMI);
		spinner4.setAdapter(adapter4);
		spinner4.setOnItemSelectedListener(this);

		// адаптер

		ArrayAdapter<String> adapter5 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, getResources()
						.getStringArray(R.array.inputs1));
		adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		Spinner spinner5 = (Spinner) findViewById(R.id.spInput1);
		spinner5.setAdapter(adapter5);
		spinner5.setOnItemSelectedListener(this);
		// адаптер

		ArrayAdapter<String> adapter6 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, getResources()
						.getStringArray(R.array.inputs2REB));
		adapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		Spinner spinner6 = (Spinner) findViewById(R.id.spInput2);
		spinner6.setAdapter(adapter6);
		spinner6.setOnItemSelectedListener(this);

		// адаптер
		if (confVar.equals("A31") || confVar.equals("B31")) {
			ArrayAdapter<String> adapter7 = new ArrayAdapter<String>(this,
					android.R.layout.simple_spinner_item, getResources()
							.getStringArray(R.array.inputs3_1REB));
			adapter7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

			Spinner spinner7 = (Spinner) findViewById(R.id.spInput3);
			spinner7.setAdapter(adapter7);
			spinner7.setOnItemSelectedListener(this);

			ArrayAdapter<String> adapter9 = new ArrayAdapter<String>(this,
					android.R.layout.simple_spinner_item, getResources()
							.getStringArray(R.array.inputs4REB));
			adapter9.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

			Spinner spinner9 = (Spinner) findViewById(R.id.spInput4);
			spinner9.setAdapter(adapter9);
			spinner9.setOnItemSelectedListener(this);

		} else if (confVar.equals("B21")) {
			ArrayAdapter<String> adapter8 = new ArrayAdapter<String>(this,
					android.R.layout.simple_spinner_item, getResources()
							.getStringArray(R.array.inputs3_2));
			adapter8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

			Spinner spinner8 = (Spinner) findViewById(R.id.spInput3);
			spinner8.setAdapter(adapter8);
			spinner8.setOnItemSelectedListener(this);
		} else {
			getIntent().putExtra("inp3", "");
			getIntent().putExtra("inp4", "");
		}
	}

	@Override
	public void onClick(View v) {
		if (getIntent().getStringExtra("body").equals("A")) {
			Intent intent = getIntent();
			intent.setClass(this, Hardware_page5v1.class);
			startActivity(intent);
		} else if (getIntent().getStringExtra("body").equals("B")) {
			Intent intent = getIntent();
			intent.setClass(this, Hardware_page5v2.class);
			startActivity(intent);
		}

		else {
			Intent intent = getIntent();
			intent.setClass(this, Hardware_page5v3.class);
			startActivity(intent);
		}

	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		int pos = parent.getSelectedItemPosition();

		switch (parent.getId()) {
		case R.id.spBody:

			if (confVar.equals("A20") || confVar.equals("B20")) {
				// int pos = parent.getSelectedItemPosition();

				switch (pos) {
				case 0:
					getIntent().putExtra("body", "A");

					break;
				case 1:

					getIntent().putExtra("body", "B");

					break;

				} // показываем позиция нажатого элемента
				/*
				 * Toast.makeText( getBaseContext(), "Варіант конфігурації: " +
				 * getIntent().getStringExtra("body"),
				 * Toast.LENGTH_SHORT).show();
				 */				

			} else {
				getIntent().putExtra("body", "E");
				// показываем позиция нажатого элемента
				/*
				 * Toast.makeText( getBaseContext(), "Варіант конфігурації: " +
				 * getIntent().getStringExtra("body"),
				 * Toast.LENGTH_SHORT).show();
				 */

			}
			tvBodyName.setText(dataBody1[pos]);

			break;
		case R.id.spKit:

			switch (pos) {
			case 0:
				getIntent().putExtra("kit", "A");
				break;
			case 1:
				getIntent().putExtra("kit", "B");
				break;
			case 2:
				getIntent().putExtra("kit", "C");
				break;
			case 3:
				getIntent().putExtra("kit", "D");
				break;
			case 4:
				getIntent().putExtra("kit", "E");
				break;
			case 5:
				getIntent().putExtra("kit", "F");
				break;

			} // показываем позиция нажатого элемента
			/*
			 * Toast.makeText( getBaseContext(), "Варіант конфігурації: " +
			 * getIntent().getStringExtra("kit"), Toast.LENGTH_SHORT).show();
			 */
			tvKitName.setText(getResources().getStringArray(R.array.kit)[pos]);

			break;

		case R.id.spSupply:

			switch (pos) {
			case 0:
				getIntent().putExtra("supply", "A");

				break;
			case 1:
				getIntent().putExtra("supply", "B");

				break;

			} // показываем позиция нажатого элемента
			/*
			 * Toast.makeText( getBaseContext(), "Варіант конфігурації: " +
			 * getIntent().getStringExtra("supply"), Toast.LENGTH_SHORT).show();
			 */
			tvSupplyName.setText(getResources().getStringArray(R.array.supply)[pos]);
			break;

		case R.id.spMMI:
			switch (pos) {
			case 0:
				getIntent().putExtra("MMI", "A");

				break;
			case 1:
				getIntent().putExtra("MMI", "B");

				break;
			case 2:
				getIntent().putExtra("MMI", "C");

				break;

			} // показываем позиция нажатого элемента
			/*
			 * Toast.makeText( getBaseContext(), "Варіант конфігурації: " +
			 * getIntent().getStringExtra("MMI"), Toast.LENGTH_SHORT).show();
			 */
			tvMMIName.setText(getResources().getStringArray(R.array.MMI)[pos]);
			break;

		case R.id.spInput1:
			switch (pos) {
			case 0:
				getIntent().putExtra("inp1", "A");

				break;
			case 1:
				getIntent().putExtra("inp1", "B");

				break;

			} // показываем позиция нажатого элемента
			/*
			 * Toast.makeText( getBaseContext(), "Варіант конфігурації: " +
			 * getIntent().getStringExtra("inp1"), Toast.LENGTH_SHORT).show();
			 */
			break;
		case R.id.spInput2:
			switch (pos) {
			case 0:
				getIntent().putExtra("inp2", "1");

				break;
			case 1:
				getIntent().putExtra("inp2", "2");

				break;

			} // показываем позиция нажатого элемента
			/*
			 * Toast.makeText( getBaseContext(), "Варіант конфігурації: " +
			 * getIntent().getStringExtra("inp2"), Toast.LENGTH_SHORT).show();
			 */
			break;

		case R.id.spInput3:
			if (confVar.equals("A31") || confVar.equals("B31")) {
				switch (pos) {
				case 0:
					getIntent().putExtra("inp3", "-A");

					break;
				case 1:
					getIntent().putExtra("inp3", "-B");

					break;

				}
			} else if (confVar.equals("B21")) {
				switch (pos) {
				case 0:
					getIntent().putExtra("inp3", "-X0");

					Spinner spinner12 = (Spinner) findViewById(R.id.spInput4);
					;
					spinner12.setAdapter(null);
					break;
				case 1:
					getIntent().putExtra("inp3", "-A");
					// адаптер
					ArrayAdapter<String> adapter10 = new ArrayAdapter<String>(
							this, android.R.layout.simple_spinner_item,
							getResources().getStringArray(R.array.inputs4REB));
					adapter10
							.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

					Spinner spinner10 = (Spinner) findViewById(R.id.spInput4);
					spinner10.setAdapter(adapter10);
					spinner10.setOnItemSelectedListener(this);

					break;
				case 2:
					getIntent().putExtra("inp3", "-B");
					// адаптер
					ArrayAdapter<String> adapter11 = new ArrayAdapter<String>(
							this, android.R.layout.simple_spinner_item,
							getResources().getStringArray(R.array.inputs4REB));
					adapter11
							.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

					Spinner spinner11 = (Spinner) findViewById(R.id.spInput4);
					spinner11.setAdapter(adapter11);
					spinner11.setOnItemSelectedListener(this);
					break;

				}
			}
			// показываем позиция нажатого элемента
			/*
			 * Toast.makeText( getBaseContext(), "Варіант конфігурації: " +
			 * getIntent().getStringExtra("inp3"), Toast.LENGTH_SHORT).show();
			 */
		case R.id.spInput4:
			if (confVar.equals("A31")
					|| confVar.equals("B31")
					|| (confVar.equals("B21") && !getIntent().getStringExtra(
							"inp3").equals("X0"))) {
				switch (pos) {
				case 0:
					if (getIntent().getStringExtra("inp3").equals("-A")
							|| getIntent().getStringExtra("inp3").equals("-B")) {
						getIntent().putExtra("inp4", "1");
					} else {
						getIntent().putExtra("inp4", "");
					}

					break;
				case 1:
					getIntent().putExtra("inp4", "2");

					break;

				}
			} else {
				getIntent().putExtra("inp4", "");
			}
			// показываем позиция нажатого элемента
			/*
			 * Toast.makeText( getBaseContext(), "Варіант конфігурації: " +
			 * getIntent().getStringExtra("inp4"), Toast.LENGTH_SHORT).show();
			 */
			break;

		}

		hardware1 = getIntent().getStringExtra("body") + "-"
				+ getIntent().getStringExtra("kit") + "-"
				+ getIntent().getStringExtra("connect")
				+ getIntent().getStringExtra("supply") + "-"
				+ getIntent().getStringExtra("MMI") + "-"
				+ getIntent().getStringExtra("inp1")
				+ getIntent().getStringExtra("inp2");
		if (getIntent().getStringExtra("inp3") != null
				&& getIntent().getStringExtra("inp4") != null) {
			hardware1 = hardware1 + getIntent().getStringExtra("inp3")
					+ getIntent().getStringExtra("inp4");
		}
		if (getIntent().getStringExtra("inp3") != null
				&& getIntent().getStringExtra("inp4") == null) {
			hardware1 = hardware1 + getIntent().getStringExtra("inp3");
		}

		getIntent().putExtra("hardware1", hardware1);

		resultText.setText(getIntent().getStringExtra("MODEL") + "*1.1" + "-"
				+ getIntent().getStringExtra("software") + "-"
				+ getIntent().getStringExtra("hardware1"));
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub

	}

}
