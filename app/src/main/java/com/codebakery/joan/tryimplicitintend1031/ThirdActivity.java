package com.codebakery.joan.tryimplicitintend1031;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ThirdActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText editTextValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Bundle bundle = getIntent().getExtras();
        editTextValue = (EditText) findViewById(R.id.editTextValue);
        editTextValue.setText(bundle.getString("result"));

        ((Button)findViewById(R.id.button)).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

    }

    @Override
    public void finish() {
        Bundle bundle = new Bundle();
        bundle.putString("result", editTextValue.getText().toString());
        Intent intent = new Intent().putExtras(bundle);
        setResult(Activity.RESULT_FIRST_USER,intent);
        super.finish();
    }
}
