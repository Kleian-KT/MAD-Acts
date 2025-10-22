package com.example.loginpractice;

import static android.widget.Toast.LENGTH_LONG;
import static android.widget.Toast.LENGTH_SHORT;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.sql.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Context c =  this;
    LinearLayout loginPage;

    String acc = "Not Found";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();

    }

    @SuppressLint("SetTextI18n")
    public void initialize(){

        loginPage = findViewById(R.id.loginPage);
        loginPage.setPadding(50,0,50,0);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        TextView pageTitle = new TextView(c);
        int ptiD = pageTitle.generateViewId();
        pageTitle.setId(ptiD);
        pageTitle.setText("SIMPLE LOGIN APP");
        pageTitle.setTextSize(25);
        pageTitle.setTypeface(pageTitle.getTypeface(), Typeface.BOLD);
        pageTitle.setGravity(Gravity.CENTER);
        pageTitle.setPadding(0,100,0,100);
        pageTitle.setLayoutParams(params);
        loginPage.addView(pageTitle);

        TextView tvUsername = new TextView(c);
        int tvUiD = tvUsername.generateViewId();
        tvUsername.setId(tvUiD);
        tvUsername.setText("Username");
        tvUsername.setPadding(0,50,0,20);
        tvUsername.setLayoutParams(params);
        loginPage.addView(tvUsername);

        EditText etUsername = new EditText(c);
        int etUiD = etUsername.generateViewId();
        etUsername.setId(etUiD);
        etUsername.setPadding(25,25,0,25);
        etUsername.setBackgroundResource(R.drawable.edit_text);
        etUsername.setHint("Enter Your Username");
        etUsername.setLayoutParams(params);
        loginPage.addView(etUsername);

        TextView tvPassword = new TextView(c);
        int tvPiD = tvPassword.generateViewId();
        tvPassword.setId(tvPiD);
        tvPassword.setText("Password");
        tvPassword.setPadding(0,50,0,20);
        tvPassword.setLayoutParams(params);
        loginPage.addView(tvPassword);

        EditText etPassword = new EditText(c);
        int etPiD = etPassword.generateViewId();
        etPassword.setId(etPiD);
        etPassword.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
        etPassword.setPadding(25,25,0,25);
        etPassword.setBackgroundResource(R.drawable.edit_text);
        etPassword.setHint("Enter Your Password");
        etPassword.setLayoutParams(params);
        loginPage.addView(etPassword);

        LinearLayout btnCon = new LinearLayout(c);
        btnCon.setOrientation(LinearLayout.VERTICAL);
        btnCon.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        btnCon.setPadding(0,100,0,0);

        Button btnLogin = new Button(c);
        int btnLiD = btnLogin.generateViewId();
        btnLogin.setId(btnLiD);
        btnLogin.setText("Log In");
        btnLogin.setBackgroundColor(Color.parseColor("#FF000000"));
        btnLogin.setTextColor(Color.parseColor("#FFFFFF"));
        btnLogin.setLayoutParams(params);
        btnCon.addView(btnLogin);

        loginPage.addView(btnCon);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String[][] userInfo = {
                        {"Jeff","12345"},
                        {"Joan","567890"},
                        {"Dani", "ASDFGH"}
                };

                String inUsername = etUsername.getText().toString();
                String inPassword = etPassword.getText().toString();


                for (int i=0; i<userInfo.length; i++){
                    acc = "Not Found";
                    if(inUsername.equalsIgnoreCase(userInfo[i][0])){
                        if (inPassword.equals(userInfo[i][1])){
                            Toast.makeText(c, "Succesfully Logged In",LENGTH_SHORT).show();
                            acc = "Found";
                            return;
                        }
                    }
                }

                if (acc.equals("Not Found")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(c);
                    builder.setTitle("ACCOUNT NOT FOUND")
                            .setMessage("Account doesn't exist please register Fisrt")
                            .setCancelable(true)
                            .show();

                }
                etPassword.setText("");
                etUsername.setText("");

            }
        });


        TextView tvRegister = new TextView(c);
        int tvRiD = tvRegister.generateViewId();
        tvRegister.setId(tvRiD);
        tvRegister.setText("Not yet registered? Click Here");
        tvRegister.setGravity(Gravity.CENTER);
        tvRegister.setTextColor(Color.parseColor("#0077FF"));
        tvRegister.setPadding(0,50,0,0);
        tvRegister.setLayoutParams(params);
        loginPage.addView(tvRegister);

        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(c);
                builder.setTitle("REGISTER")
                        .setMessage("Redirecting....")
                        .setCancelable(true).show();
                etPassword.setText("");
                etUsername.setText("");
            }
        });


    }

}