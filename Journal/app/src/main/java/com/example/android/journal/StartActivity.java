package com.example.android.journal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.android.journal.userlogin.RegisterActivity;
import com.google.firebase.auth.FirebaseAuth;

public class StartActivity extends AppCompatActivity {

    private FirebaseAuth fAuth;

    private Button btReg, btLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        fAuth = FirebaseAuth.getInstance();

        btReg = (Button) findViewById(R.id.bt_register);
        btLogin = (Button) findViewById(R.id.bt_login);

        updateUI();

        btReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register();
            }
        });

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
    }

    private void register(){
        Intent register = new Intent(StartActivity.this, RegisterActivity.class);
        startActivity(register);
    }

    private void login(){

    }

    private void updateUI() {
        if(fAuth.getCurrentUser() != null){
            Log.i("StartActivity", "fAuth != null");
            Intent startIntent = new Intent(StartActivity.this, StartActivity.class);
            startActivity(startIntent);
            finish();
        } else {
            Log.i("StartActivity", "fAuth == null");
        }
    }
}
