package ws1.abb_terminal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Opt_page3 extends Activity implements OnClickListener,
		OnItemSelectedListener {

	TextView OptionNameP3, OptionSoft, firstLanguage, secondLanguage,
			Instruction, resultText;
	Button btnNext, btnRes;
	ListView programOptions;
	String[] dataOptSoft, dataOptSoft1;	
	String[] confOptNameArr = new String[4];
	int set, iOptId;
	String confVar, strOptName, softOpt;
	String software;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.option_page3);

		OptionNameP3 = (TextView) findViewById(R.id.OptionNameP3);
		OptionSoft = (TextView) findViewById(R.id.OptionSoft);		
		firstLanguage = (TextView) findViewById(R.id.firstLanguage);
		secondLanguage = (TextView) findViewById(R.id.secondLanguage);
		Instruction = (TextView) findViewById(R.id.Instruction);
		resultText = (TextView) findViewById(R.id.resultText);
		btnRes = (Button) findViewById(R.id.btnRes);
		btnRes.setOnClickListener(this);
		btnNext = (Button) findViewById(R.id.btnNext);
		btnNext.setOnClickListener(this);

		getIntent().putExtra("softOpt", "X00");
		confVar = getIntent().getStringExtra("confV");
		//задаем массив для multiple_choice
		dataOptSoft=getResources().getStringArray(R.array.SoftOptionREB);		
		if (confVar.equals("A20")) {
			set = 0;
			
			confOptNameArr[0] = "X00";
			confOptNameArr[1] = "C06";
			confOptNameArr[2] = "C10";
			confOptNameArr[3] = "H05";
		}
		if (confVar.equals("A31")) {
			set = 1;
			confOptNameArr[0] = "X00";
			confOptNameArr[1] = "C07";
			confOptNameArr[2] = "C11";
			confOptNameArr[3] = "H05";
		}
		if (confVar.equals("B20") || confVar.equals("B21")) {			
			set = 2;
			confOptNameArr[0] = "X00";
			confOptNameArr[1] = "C08";
			confOptNameArr[2] = "C12";
			confOptNameArr[3] = "H05";
		}
		if (confVar.equals("B31")) {			
			set = 3;
			confOptNameArr[0] = "X00";
			confOptNameArr[1] = "C09";
			confOptNameArr[2] = "C13";
			confOptNameArr[3] = "H05";
		}
				
		dataOptSoft1=new String[4];
		dataOptSoft1[0]=dataOptSoft[0];
		dataOptSoft1[1]=dataOptSoft[1+set];
		dataOptSoft1[2]=dataOptSoft[5+set];
		dataOptSoft1[3]=dataOptSoft[9];

		programOptions = (ListView) findViewById(R.id.programOptions);
		// устанавливаем режим выбора пунктов списка
		programOptions.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
		// Создаем адаптер multiple_choice		
		ArrayAdapter<CharSequence> adapter = new ArrayAdapter<CharSequence>(this,android.R.layout.simple_list_item_multiple_choice, dataOptSoft1);
		programOptions.setAdapter(adapter);

		// адаптер spinner
		getIntent().putExtra("Language2", "X0");
		ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, getResources()
						.getStringArray(R.array.SoftOptionLang1));
		adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		Spinner spinner1 = (Spinner) findViewById(R.id.firstLang);
		spinner1.setAdapter(adapter1);
		spinner1.setOnItemSelectedListener(this);

		// адаптер spinner
		ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, getResources()
						.getStringArray(R.array.SoftOptionLang2));		
		adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		Spinner spinner2 = (Spinner) findViewById(R.id.secondLang);
		spinner2.setAdapter(adapter2);
		spinner2.setOnItemSelectedListener(this);

	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.btnNext:
			Intent intent = getIntent();
			intent.setClass(this, Hardware_page4.class);
			startActivity(intent);
			break;

		case R.id.btnRes:
			strOptName = "";
			//отображаемый выбранный вариант конфигурации пунктов списка multiple_choice
			SparseBooleanArray sbArray = programOptions
					.getCheckedItemPositions();
			for (int i = 0; i < sbArray.size(); i++) {
				int key = sbArray.keyAt(i);
				if (sbArray.get(key)) {
					strOptName = strOptName + confOptNameArr[key];

				}
			}

			if (strOptName.equals("")) {
				softOpt = "X00";

			} else if (strOptName.length() > 3 && strOptName.contains("X00")) {
				softOpt = strOptName.substring(3);

			} else {
				softOpt = strOptName;
			}
			getIntent().putExtra("softOpt", softOpt);
			software = getIntent().getStringExtra("confV")
					+ getIntent().getStringExtra("confCap") + "-"
					+ getIntent().getStringExtra("softOpt") + "-"
					+ getIntent().getStringExtra("Language1")
					+ getIntent().getStringExtra("Language2");
			getIntent().putExtra("software", software);
			//отображаем выбранную конфигурацию 
			resultText.setText(getIntent().getStringExtra("MODEL") + "*1.1"
					+ "-" + getIntent().getStringExtra("software"));
			break;

		default:
			break;
		}
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		int pos = parent.getSelectedItemPosition();

		
		switch (parent.getId()) {
		case R.id.firstLang:

			switch (pos) {
			case 0:
				getIntent().putExtra("Language1", "B1");

				break;
			case 1:
				getIntent().putExtra("Language1", "B2");

				break;

			}
			// показываем позицию нажатого элемента
			Toast.makeText(
					getBaseContext(),
					"Варіант конфігурації: "
							+ getIntent().getStringExtra("Language1"),
					Toast.LENGTH_SHORT).show();
			break;

		case R.id.secondLang:
			switch (pos) {
			case 0:
				getIntent().putExtra("Language2", "X0");

				break;
			case 1:
				getIntent().putExtra("Language2", "A1");

				break;
			case 2:
				getIntent().putExtra("Language2", "A2");

				break;
			case 3:
				getIntent().putExtra("Language2", "A3");

				break;
			case 4:
				getIntent().putExtra("Language2", "A4");

				break;
			case 5:
				getIntent().putExtra("Language2", "A5");

				break;
			case 6:
				getIntent().putExtra("Language2", "A6");

				break;
			case 7:
				getIntent().putExtra("Language2", "A7");

				break;
			case 8:
				getIntent().putExtra("Language2", "A8");

				break;
			case 9:
				getIntent().putExtra("Language2", "A9");

				break;

			}
			// показываем позицию нажатого элемента
			Toast.makeText(
					getBaseContext(),
					"Варіант конфігурації: "
							+ getIntent().getStringExtra("Language2"),
					Toast.LENGTH_SHORT).show();
			break;
		}
		software = getIntent().getStringExtra("confV")
				+ getIntent().getStringExtra("confCap") + "-"
				+ getIntent().getStringExtra("softOpt") + "-"
				+ getIntent().getStringExtra("Language1")
				+ getIntent().getStringExtra("Language2");
		getIntent().putExtra("software", software);
		//отображаем выбранную конфигурацию 
		resultText.setText(getResources().getString(R.string.model) + "*1.1"
				+ "-" + getIntent().getStringExtra("software"));

	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub

	}

}
