package com.tqc.gdd01;

import android.app.Activity;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

public class GDD01 extends Activity
{

  EditText mEditTextAccount, mEditTextPassword;
  CheckBox mCheckBox;                             //虛擬物件設定
  @Override
  public void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
   // TO DO
    mEditTextAccount = findViewById(R.id.mAccount);
    mEditTextPassword = findViewById(R.id.mPassword);
    mCheckBox = findViewById(R.id.mCheck);                //物件實體化

    mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if(b){
          mEditTextPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        }else{
          mEditTextPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
      }
    });

  }
}
