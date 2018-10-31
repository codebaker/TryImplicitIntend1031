package com.codebakery.joan.tryimplicitintend1031;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FirstActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        ((Button)findViewById(R.id.button)).setOnClickListener(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(data.hasExtra("result")) {
            ((TextView)findViewById(R.id.textViewResult)).setText(data.getStringExtra("result"));
        }
    }

    @Override
    public void onClick(View v) {
        EditText editTextValue = findViewById(R.id.editTextValue);

        Bundle bundle = new Bundle();
        bundle.putString("result", editTextValue.getText().toString());
        Intent intent = new Intent(this,SecondActivity.class)
                .putExtras(bundle);
        startActivityForResult(intent,Activity.RESULT_FIRST_USER);
    }

}
