package com.tqc.gdd02;

  import java.text.DecimalFormat;

  import android.app.Activity;
  import android.content.SharedPreferences;
  import android.os.Bundle;
  import android.view.View;
  import android.widget.Button;
  import android.widget.EditText;
  import android.widget.TextView;

public class GDD02 extends Activity
{
  public static final String PREF_ExchangeRate = "Exchange_Rate";
  private Button calcbutton;
  private EditText fieldExchangeRate;
  private EditText fieldNTD;
  private TextView tvResult;

  /**
   * Called when the activity is first created.
   */
  @Override
  public void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

   // TO DO
    fieldExchangeRate = findViewById(R.id.editTextNumberDecimal);
    fieldNTD = findViewById(R.id.editTextNumberDecimal2);
    tvResult = findViewById(R.id.textView3);
    calcbutton = findViewById(R.id.button);

    calcbutton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        double rate = Double.parseDouble(fieldExchangeRate.getText().toString());
        double ntd = Double.parseDouble(fieldNTD.getText().toString());
        String msg = getString(R.string.usd_result) + String.format("%.2f", ntd/rate);
        tvResult.setText(msg);
      }
    });

    SharedPreferences sharedPreferences = getSharedPreferences(PREF_ExchangeRate, 0);
    String strRate = sharedPreferences.getString(PREF_ExchangeRate, "");
    fieldExchangeRate.setText(strRate);

  }

  protected void onPause() {
    super.onPause();
    SharedPreferences settings = getSharedPreferences(PREF_ExchangeRate, 0);
    settings.edit().putString(PREF_ExchangeRate, fieldExchangeRate.getText().toString()).commit();
  }
}
