package com.codebakery.joan.tryimplicitintend1031;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FirstActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        ((Button)findViewById(R.id.button)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        EditText editTextValue = findViewById(R.id.editTextValue);

        Bundle bundle = new Bundle();
        bundle.putString("result", editTextValue.getText().toString());
        Intent intent = new Intent(this,SecondActivity.class)
                .putExtras(bundle);
        startActivity(intent);
    }

}
