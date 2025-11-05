package com.example.loginpractice;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegisterActivity extends AppCompatActivity {

    EditText username, password, confirmPassword, fName, lName, email, address, conNum;
    TextView bday;
    RadioButton male, female, others;
    CheckBox hob1, hob2, hob3, hob4, hob5, hob6, hob7, hob8, hob9,hob10;
    Spinner ques1, ques2, ques3;

    Button register;

    String usernameTemp, passwordTemp, confirmPasswordTemp, fNameTemp, lNameTemp, emailTemp, addressTemp, conNumTemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        initialize();



        //---------------------------------------------------------------------------------------------------------------------
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void initialize(){
        LinearLayout layout = findViewById(R.id.registerPage);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        confirmPassword = findViewById(R.id.confirmPassword);
        fName = findViewById(R.id.fName);
        lName = findViewById(R.id.lName);
        email = findViewById(R.id.email);
        bday = findViewById(R.id.bday);
        others = findViewById(R.id.others);
        male = findViewById(R.id.male);
        female = findViewById(R.id.female);
        address = findViewById(R.id.address);
        conNum = findViewById(R.id.conNum);
        hob1 = findViewById(R.id.hob1);
        hob2 = findViewById(R.id.hob2);
        hob3 = findViewById(R.id.hob3);
        hob4 = findViewById(R.id.hob4);
        hob5 = findViewById(R.id.hob5);
        hob6 = findViewById(R.id.hob6);
        hob7 = findViewById(R.id.hob7);
        hob8 = findViewById(R.id.hob8);
        hob9 = findViewById(R.id.hob9);
        hob10 = findViewById(R.id.hob10);
        ques1 = findViewById(R.id.ques1);
        ques2 = findViewById(R.id.ques2);
        ques3 = findViewById(R.id.ques3);
        register = findViewById(R.id.register);

    }

    public void validate(){
        usernameTemp = username.getText().toString().trim();
        passwordTemp = password.getText().toString().trim();
        confirmPasswordTemp = confirmPassword.getText().toString().trim();
        fNameTemp = fName.getText().toString().trim();
        lNameTemp = lName.getText().toString().trim();
        emailTemp = email.getText().toString().trim();
        addressTemp = address.getText().toString().trim();
        conNumTemp = conNum.getText().toString().trim();


        register.setOnClickListener(v -> {
            if (usernameTemp.isEmpty() ||
                    passwordTemp.isEmpty() ||
                    confirmPasswordTemp.isEmpty() ||
                    fNameTemp.isEmpty() ||
                    lNameTemp.isEmpty() ||
                    emailTemp.isEmpty() ||
                    addressTemp.isEmpty() ||
                    conNumTemp.isEmpty()) {

                AlertDialog.Builder builder = new AlertDialog.Builder(c);
                builder.setTitle("ATTENTION")
                        .setMessage("Bawal walang laman hindi yan utak mo!")
                        .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
                        .setCancelable(true)
                        .show();

            }

            if(!passwordTemp.equals(confirmPasswordTemp)){
                AlertDialog.Builder builder = new AlertDialog.Builder(c);
                builder.setTitle("ATTENTION")
                        .setMessage("Oughhh ulul! Password did not Match")
                        .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
                        .setCancelable(true)
                        .show();
            }


        });

        Spinner spnr1 = new Spinner(c);
        int spnr1ID = spnr1.generateViewId();
        spnr1.setId(spnr1ID);
        spnr1.setLayoutParams(params);
        spnr1.setPadding(50,50,50,50);

        String colors[] = {"Red", "Blue"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(c, android.R.layout.simple_spinner_item, colors);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spnr1.setAdapter(adapter);
        mainLL.addView(spnr1);





    }





}