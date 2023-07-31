package jp.suntech.s22013.bmicalculators013;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButtonClickListener listener = new ButtonClickListener();

        Button btSum = findViewById(R.id.btSum);
        Button btClear = findViewById(R.id.btClear);



        btSum.setOnClickListener(listener);
        btClear.setOnClickListener(listener);

    }

    protected class ButtonClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            EditText input = findViewById(R.id.etAge);
            EditText input1 = findViewById(R.id.etHeight);
            EditText input2 = findViewById(R.id.etWeight);
            TextView input3 = findViewById(R.id.tvText);
            TextView input4 = findViewById(R.id.tvObesity);
            TextView input5 = findViewById(R.id.tvText_weight);
            TextView input6 = findViewById(R.id.tvText_kg);
            TextView input7 = findViewById(R.id.tvKk);

            int id = v.getId();
            String a = input.getText().toString();
            int nenrei = Integer.parseInt(a);
            if(id == R.id.btSum){
                String str1 = input1.getText().toString();
                String str2 = input2.getText().toString();
                input3.setText("あなたの肥満度は");
                double cm = Double.parseDouble(str1);
                double kg = Double.parseDouble(str2);
                double m = cm / 100;
                double bmi = kg / (m * m);
                String himan;
                if(bmi < 18.5){
                    himan = "低体重";
                }else if(18.5 <= bmi && 25 > bmi){
                    himan = "普通体重";
                }else if(25 <= bmi && 30 > bmi){
                    himan = "肥満(1)";
                }else if(30 <= bmi && 35 > bmi){
                    himan = "肥満(2)";
                }else if(35 <= bmi && 40 > bmi){
                    himan = "肥満(3)";
                }else{
                    himan = "肥満(4)";
                }
                input4.setText(himan);
                input5.setText("あなたの適正体重は");
                double heikin = (m * m) * 22;
                String aaa = String.format("%.2f",heikin);
                input6.setText(String.valueOf(aaa));
                input7.setText("kg");

            }else if(id == R.id.btClear){
                input.setText("");
                input1.setText("");
                input2.setText("");
                input3.setText("");
                input4.setText("");
                input5.setText("");
                input6.setText("");
                input7.setText("");
            }if(nenrei < 16){
                onAgeClick();
            }

        }


           private void onAgeClick() {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("警告")
                        .setMessage("適切な肥満度を求めるには、６歳未満の場合はカウプ指数が、６歳から１５歳まではローレル指数が使われます。本アプリはBMIのみに対応しています。")
                        .setPositiveButton("確認", null);
                AlertDialog dialog = builder.create();
                dialog.show();

            }

        }
    }


