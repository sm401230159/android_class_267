package com.example.shinc.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    EditText editText;
    Button click;
    RadioGroup radioGroup;
    CheckBox checkbox;
    ListView listView;

    ArrayList<Order> orders = new ArrayList<>();

//    String selectSex = "Male";
//    String name = "";
//    String sex = "";
    String drinkName = "Black Tea";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
        editText = (EditText)findViewById(R.id.editText);
        radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        checkbox = (CheckBox)findViewById(R.id.checkBox);
        listView = (ListView)findViewById(R.id.listView);

        setupListView();

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
//                if(checkedId == R.id.maleRadioButton)
//                {
//                    selectSex = "Male";
//                }
//                else if (checkedId == R.id.femaleRadioButton)
//                {
//                    selectSex = "Female";
//                }

                RadioButton radioButton = (RadioButton)findViewById(checkedId);
                drinkName = radioButton.getText().toString();

            }
        });

//        checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//    @Override
//    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//
//        changeTextView();
//    }
//});
    }

    void setupListView()
    {
//        String[]data = new String[] {"123","456","789","Hello","ListView","Hi"};
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, drinks);

//        List<Map<String,String>> data = new ArrayList<>();
//
//        for(int i = 0; i < orders.size(); i++)
//        {
//            Order order = orders.get(i);
//            Map<String,String> item = new HashMap<>();
//
//            item.put("note", order.note);
//            item.put("drinkName", order.drinkName);
//
//            data.add(item);
//
//        }
//
//        String[] from = {"note","drinkName"};
//        int[] to = {R.id.noteTextView, R.id.drinkNameTextView};
//
//        SimpleAdapter adapter = new SimpleAdapter(this, data, R.layout.listview_order_item, from, to);
//
    OrderAdapter adapter = new OrderAdapter(this,orders);
        listView.setAdapter(adapter);

    }

    public void click(View view)
   {
       String note = editText.getText().toString();
////        sex = selectSex;
//

       Order order = new Order();
       order.note = note;
       order.drinkName = drinkName;
       orders.add(order);

       setupListView();
       textView.setText(drinkName);
       editText.setText("");
   }
//
//    public void  changeTextView()
//    {
//        if (checkbox.isChecked())
//        {
//            textView.setText(name);
//        }
//        else
//            textView.setText(name + "sex:" + sex);
//    }
//


}
