package com.smartron.registrationactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {

    private EditText firstNameEt, lastNameEt, emailEt, passwordEt;
    RadioButton malerb, femalerb;
    RadioGroup radioGroup;
    Button submitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        firstNameEt = findViewById(R.id.firstNameEt);
        lastNameEt = findViewById(R.id.lastNameEt);
        emailEt = findViewById(R.id.emailEt);
        passwordEt = findViewById(R.id.passwordEt);
        submitBtn = findViewById(R.id.submitBtn);
        radioGroup = findViewById(R.id.genderrg);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.malerb) {
                    Toast.makeText(RegistrationActivity.this, "selected male" , Toast.LENGTH_SHORT).show();
                }

                if (checkedId == R.id.femalerb) {
                    Toast.makeText(RegistrationActivity.this, "Selected female", Toast.LENGTH_SHORT).show();
                }
            }
        });
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isValidRegistration(firstNameEt, lastNameEt, emailEt, passwordEt)) {
                    Toast.makeText(RegistrationActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public boolean isValidRegistration(EditText firstNameEt, EditText lastNameEt, EditText emailEt, EditText passwordEt) {
        if (firstNameEt.getText().toString().matches("") || lastNameEt.getText().toString().matches("")) {
            Toast.makeText(this, "your first name or last name is empty", Toast.LENGTH_SHORT).show();
        } else if (emailEt.getText().toString().matches("")) {
            Toast.makeText(this, "please enter emailId", Toast.LENGTH_SHORT).show();
        } else if (emailEt.length() < 6) {
            Toast.makeText(this, "please enter minimum 6 characters emailId", Toast.LENGTH_SHORT).show();
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailEt.getText().toString()).matches()) {
            Toast.makeText(getApplicationContext(), "please enter domain specified emailId", Toast.LENGTH_SHORT).show();
        } else if (passwordEt.getText().toString().matches("")) {
            Toast.makeText(getApplicationContext(), "please enter valid password", Toast.LENGTH_SHORT).show();
        } else if (passwordEt.length() < 6) {
            Toast.makeText(getApplicationContext(), "please enter minimum 6 characters password", Toast.LENGTH_SHORT).show();
        }
        else if (radioGroup.getCheckedRadioButtonId() == -1) {
            Toast.makeText(RegistrationActivity.this, "Please select Gender", Toast.LENGTH_SHORT).show();
        }else {
            return true;
        }
        return false;
    }
}
