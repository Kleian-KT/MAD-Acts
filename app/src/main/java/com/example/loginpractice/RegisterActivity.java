package com.example.loginpractice;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

public class RegisterActivity extends AppCompatActivity {

    Context c = this;
    EditText username, password, confirmPassword, fName, lName, email, address, conNum;
    TextView bday;
    RadioButton male, female, others;
    CheckBox hob1, hob2, hob3, hob4, hob5, hob6, hob7, hob8, hob9,hob10;
    Spinner ques1, ques2, ques3;
    String birthday = "";

    Button register;

    String usernameTemp, passwordTemp, confirmPasswordTemp, fNameTemp, lNameTemp, emailTemp, addressTemp, conNumTemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        initialize();
        validate();



        //---------------------------------------------------------------------------------------------------------------------
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.registerPage), (v, insets) -> {
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


        bday.setOnClickListener(v -> {
            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePicker = new DatePickerDialog(this, (view, y, m, d) -> {
                birthday = (m + 1) + "/" + d + "/" + y;
                bday.setText(birthday);
            }, year, month, day);
            datePicker.show();
        });


        String questions[] = {
                "What was the name of your first pet?",
                "What is your mother's maiden name?",
                "What was the make and model of your first car?",
                "What city were you born in?",
                "What is the name of your favorite teacher?"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<>(c, android.R.layout.simple_spinner_item, questions);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        ques1.setAdapter(adapter);
        ques2.setAdapter(adapter);
        ques3.setAdapter(adapter);

    }

    public void validate(){



        register.setOnClickListener(v -> {

            usernameTemp = username.getText().toString().trim();
            passwordTemp = password.getText().toString().trim();
            confirmPasswordTemp = confirmPassword.getText().toString().trim();
            fNameTemp = fName.getText().toString().trim();
            lNameTemp = lName.getText().toString().trim();
            emailTemp = email.getText().toString().trim();

            addressTemp = address.getText().toString().trim();
            conNumTemp = conNum.getText().toString().trim();
            usernameTemp = username.getText().toString().trim();
            passwordTemp = password.getText().toString().trim();
            confirmPasswordTemp = confirmPassword.getText().toString().trim();



            if (usernameTemp.isEmpty() ||
                    passwordTemp.isEmpty() ||
                    confirmPasswordTemp.isEmpty() ||
                    fNameTemp.isEmpty() ||
                    lNameTemp.isEmpty() ||
                    emailTemp.isEmpty() ||
                    addressTemp.isEmpty() ||
                    birthday.isEmpty() ||
                    conNumTemp.isEmpty()) {

                AlertDialog.Builder builder = new AlertDialog.Builder(c);
                builder.setTitle("ATTENTION")
                        .setMessage("Bawal walang laman hindi yan utak mo!")
                        .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
                        .setCancelable(true)
                        .show();

                return;

            }



            if(!passwordTemp.equals(confirmPasswordTemp)){
                AlertDialog.Builder builder = new AlertDialog.Builder(c);
                builder.setTitle("ATTENTION")
                        .setMessage("Oughhh ulul! Password did not Match")
                        .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
                        .setCancelable(true)
                        .show();
                return;
            }

            if (!male.isChecked() && !female.isChecked() && !others.isChecked()) {
                new AlertDialog.Builder(c)
                        .setTitle("ATTENTION")
                        .setMessage("Please select your gender!")
                        .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
                        .setCancelable(true)
                        .show();
                return;
            }

            String gender = "";
            if (male.isChecked()) gender = "Male";
            else if (female.isChecked()) gender = "Female";
            else if (others.isChecked()) gender = "Others";

            String hobbies = "";
            if(hob1.isChecked()) hobbies += hob1.getText().toString()+" ";
            if(hob2.isChecked()) hobbies += hob2.getText().toString() + " ";
            if(hob3.isChecked()) hobbies += hob3.getText().toString() + " ";
            if(hob4.isChecked()) hobbies += hob4.getText().toString() + " ";
            if(hob5.isChecked()) hobbies += hob5.getText().toString() + " ";
            if(hob6.isChecked()) hobbies += hob6.getText().toString() + " ";
            if(hob7.isChecked()) hobbies += hob7.getText().toString() + " ";
            if(hob8.isChecked()) hobbies += hob8.getText().toString() + " ";
            if(hob9.isChecked()) hobbies += hob9.getText().toString() + " ";
            if(hob10.isChecked()) hobbies += hob10.getText().toString() + " ";

            if(hobbies.equals("")){
                AlertDialog.Builder builder = new AlertDialog.Builder(c);
                builder.setTitle("ATTENTION")
                        .setMessage("Bawal walang hobbies, Ma priso Ka!")
                        .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
                        .setCancelable(true)
                        .show();
                return;

            }

            if(ques1.getSelectedItem().toString()==ques2.getSelectedItem().toString() ||
                    ques1.getSelectedItem().toString()==ques3.getSelectedItem().toString() ||
                    ques3.getSelectedItem().toString()==ques2.getSelectedItem().toString())
            {
                AlertDialog.Builder builder = new AlertDialog.Builder(c);
                builder.setTitle("ATTENTION")
                        .setMessage("Oughhh ulul! Bawal parehas, cuh!")
                        .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
                        .setCancelable(true)
                        .show();
                return;
            }



            String details = "USERNAME: " + username.getText().toString() +
                    "\nPASSWORD: " + password.getText().toString() +
                    "\nNAME: " + fName.getText().toString() + " " + lName.getText().toString() +
                    "\nE-MAIL: " + email.getText().toString() +
                    "\nDATE OF BIRTH: " + birthday +
                    "\nGENDER: " + gender +
                    "\nADDRESS: " + address.getText().toString() +
                    "\nCONTACT: " + conNum.getText().toString() +
                    "\nHOBBIES: " + hobbies;

            AlertDialog.Builder builder = new AlertDialog.Builder(c);
            builder.setTitle("Account Details")
                    .setMessage(details)
                    .setPositiveButton("OK", (dialog, which) -> {
                        Toast.makeText(this, "You have successfully registered!", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(c, Welcome.class);
                        intent.putExtra("fName",fNameTemp);
                        intent.putExtra("lName",lNameTemp);
                        startActivity(intent);

                    })
                    .setCancelable(true)
                    .show();



        });





    }





}