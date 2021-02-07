package com.andatra.loftmoney;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AddItemActivity extends AppCompatActivity {
    private EditText TitleEditText;
    private EditText CostEditText;


    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        TitleEditText = findViewById(R.id.titleText);
        CostEditText = findViewById(R.id.costText);

        Button addButton = findViewById(R.id.button1);
        addButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View v) {
                String name = TitleEditText.getText().toString();
                String price = CostEditText.getText().toString();

                if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(price)) {
                    setResult(
                            RESULT_OK,
                            new Intent().putExtra("name", name).putExtra("price", price));
                    finish();
                }
            }
        });
    }
}