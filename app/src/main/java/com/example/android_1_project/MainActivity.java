package com.example.android_1_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.graphics.Color;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    EditText editText1;
    EditText editText2;
    TextView textView;
    CardView buttonDo;


    double firstValue, secondValue;
    float  result;
    boolean operationActive = true;
    int posOperation = 0;

    void funcForOperation(Button button, int a) {
        if (button.getCurrentTextColor() == Color.parseColor("red")) {
            button.setTextColor(Color.parseColor("white"));
            button.setTranslationY(0);
            operationActive = true;
            posOperation = 0;
        } else{
            if(!operationActive) funcForChngOper(posOperation);
            button.setTextColor(Color.parseColor("red"));
            button.setTranslationY(20);
            operationActive = false;
            posOperation = a;
        }
    }

    void funcForChngOper(int posOperation){
        switch (posOperation){
            case 1:button1.setTextColor(Color.parseColor("white"));  button1.setTranslationY(0); break;
            case 2:button2.setTextColor(Color.parseColor("white"));  button2.setTranslationY(0); break;
            case 3:button3.setTextColor(Color.parseColor("white"));  button3.setTranslationY(0); break;
            case 4:button4.setTextColor(Color.parseColor("white"));  button4.setTranslationY(0); break;
        }
        posOperation = 0;
        operationActive = true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        buttonDo = findViewById(R.id.cardView1);
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        textView = findViewById(R.id.textView);



        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                funcForOperation(button1, 1);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                funcForOperation(button2, 2);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                funcForOperation(button3, 3);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                funcForOperation(button4, 4);
            }
        });


        buttonDo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!editText1.getText().toString().equals("") && !editText2.getText().toString().equals("")) {
                    firstValue = Double.parseDouble(editText1.getText().toString());
                    secondValue = Double.parseDouble(editText2.getText().toString());
                    switch (posOperation) {
                        case 1:
                            result = (float) (firstValue + secondValue);

                            /* (float)->Для преобразования типа double к float чтобы не было так длинное число после запитая*/

                            textView.setText(" " + result + " ");
                            break;
                        case 2:
                            result = (float) (firstValue - secondValue);
                            textView.setText(" " + result + " ");
                            break;
                        case 3:
                            result = (float) (firstValue * secondValue);
                            textView.setText(" " + result + " ");
                            break;
                        case 4:
                            if (secondValue != 0) {
                                result = (float) (firstValue / secondValue);
                                textView.setText(" " + result + " ");
                            } else textView.setText("На 0 делить нельзя!");
                            break;
                        default:
                            textView.setText("");
                            break;
                    }
                }else textView.setText("");
            }
        });
    }

}