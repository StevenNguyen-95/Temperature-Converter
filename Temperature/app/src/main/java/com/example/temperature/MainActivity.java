package com.example.temperature;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    Button submit;
    EditText temp;
    ToggleButton convert;
    double a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DecimalFormat fmt = new DecimalFormat("#.##");

        setContentView(R.layout.activity_main);
        temp=(EditText) findViewById(R.id.editTextNumber);
        submit=(Button) findViewById(R.id.button);
        convert=(ToggleButton) findViewById(R.id.toggleButton);

        submit.setOnClickListener(new View.OnClickListener()  {

            @Override
            public void onClick(View v) {
                if(temp.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter the Temperature", Toast.LENGTH_LONG).show();
                }
                else if(convert.isChecked()){
                    a=Double.parseDouble(String.valueOf(temp.getText()));
                    Double b=a*9/5+32;

                    Toast.makeText(MainActivity.this,fmt.format(b)+"°F",Toast.LENGTH_SHORT).show();
                }
                else{
                    a=Double.parseDouble(String.valueOf(temp.getText()));
                    Double b=a-32;
                    Double c=b*5/9;
                    Toast.makeText(MainActivity.this,fmt.format(c)+"°C",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}