package com.example.shinc.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    EditText editText;
    Button click;
    RadioGroup radioGroup;
    CheckBox checkbox;


    String selectSex = "Male";
    String name = "";
    String sex = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
        editText = (EditText)findViewById(R.id.editText);
        radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        checkbox = (CheckBox)findViewById(R.id.checkBox);


        editText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN)

                {
                    click(v);
                    return true;

                }

                return false;
            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.maleRadioButton)
                {
                    selectSex = "Male";
                }
                else if (checkedId == R.id.femaleRadioButton)
                {
                    selectSex = "Female";
                }

            }
        });

        checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        changeTextView();
    }
});
    }


    public void click(View view)
    {
        name = editText.getText().toString();
        sex = selectSex;

        editText.setText("");
    }

    public void  changeTextView()
    {
        if (checkbox.isChecked())
        {
            textView.setText(name);
        }
        else
            textView.setText(name + "sex:" + sex);
    }

}
