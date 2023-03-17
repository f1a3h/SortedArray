package com.example.sortedarray;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private EditText editText;
    private ArrayList<Integer> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        editText = findViewById(R.id.edit_text);
        arrayList = new ArrayList<>();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputText = editText.getText().toString();
                editText.setText("");
                if (!TextUtils.isEmpty(inputText)) {
                    int number = Integer.parseInt(inputText);
                    arrayList.add(number);
                    Collections.sort(arrayList);
                    displayNumbers();
                }
            }
        });
    }

    public void displayNumbers() {
        TextView textView = findViewById(R.id.text_view);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arrayList.size(); ++i) {
            sb.append(arrayList.get(i));
            sb.append('\n');
        }
        textView.setText(sb.toString());
    }
}