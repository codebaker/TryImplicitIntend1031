package com.codebakery.joan.tryimplicitintend1031;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText editTextValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Bundle bundle = getIntent().getExtras();
        editTextValue = (EditText) findViewById(R.id.editTextValue);
        editTextValue.setText(bundle.getString("result"));
    }

    @Override
    public void onClick(View v) {
        Bundle bundle = new Bundle();
        bundle.putString("result", editTextValue.getText().toString());
        Intent intent = new Intent(this,ThirdActivity.class)
                            .putExtras(bundle);
        startActivityForResult(intent,Activity.RESULT_FIRST_USER);
    }
}
