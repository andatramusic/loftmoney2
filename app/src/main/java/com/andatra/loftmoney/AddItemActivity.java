package com.andatra.loftmoney;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class AddItemActivity extends AppCompatActivity {

    private EditText mTitleEditText;
    private EditText mCostEditText;
    private Button mAddButton;

    private String mTitle;
    private String mCost;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        mTitleEditText = findViewById(R.id.titleText);
        mTitleEditText.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(
                    final CharSequence charSequence,
                    final int i,
                    final int i1,
                    final int i2
            ) {

            }

            @Override
            public void onTextChanged(
                    final CharSequence charSequence,
                    final int i,
                    final int i1,
                    final int i2
            ) {

            }

            @Override
            public void afterTextChanged(final Editable editable) {
                mTitle = editable.toString();
                checkEditTextHasText();
            }
        });
        mCostEditText = findViewById(R.id.costText);
        mCostEditText.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(
                    final CharSequence charSequence,
                    final int i,
                    final int i1,
                    final int i2
            ) {

            }

            @Override
            public void onTextChanged(
                    final CharSequence charSequence,
                    final int i,
                    final int i1,
                    final int i2
            ) {

            }

            @Override
            public void afterTextChanged(final Editable editable) {
                mCost = editable.toString();
                checkEditTextHasText();
            }
        });

        mAddButton = findViewById(R.id.button1);
        mAddButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View v) {

                if (!TextUtils.isEmpty(mTitle) && !TextUtils.isEmpty(mCost)) {
                    setResult(
                            RESULT_OK,
                            new Intent().putExtra("title", mTitle).putExtra("cost", mCost));
                    finish();
                }
            }
        });
    }

    public void checkEditTextHasText() {
        mAddButton.setEnabled(!TextUtils.isEmpty(mTitle) && !TextUtils.isEmpty(mCost));
    }
}