package cal.rash;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalcActivity extends Activity {

	private Button btBut;
	private TextView txVivod;
	private CalcRegul calculator;
	private EditText edText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calc);
		calculator = CalcRegul.get();
		btBut = (Button) findViewById(R.id.button1);
		edText = (EditText) findViewById(R.id.editText1);
		txVivod = (TextView) findViewById(R.id.textView2);
		btBut.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				try {
					// TODO Auto-generated method stub
					calculator.setText(edText.getText().toString());
					txVivod.setText(calculator.getScob());
				} catch (Exception e) {
					// TODO: handle exception
					txVivod.setText(e.getLocalizedMessage());
				}
				
			}
		}); 
	}
}
