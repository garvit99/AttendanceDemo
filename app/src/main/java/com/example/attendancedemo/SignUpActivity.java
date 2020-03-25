package com.example.attendancedemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SignUpActivity extends AppCompatActivity {

    Button btnSignup;
    EditText etName,etPhone,etPassword;
    String name,phone,password;
    TextView tvSkip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sign_up);
        init();
        //validate();
        //getValues();
        final FirebaseDatabase database = FirebaseDatabase.getInstance();

        DatabaseReference myRef = database.getReference("message");
        myRef.setValue("Hello, World!");

        final DatabaseReference ref = database.getReference().child("registration");
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getValues();
                if(validate())
                {
                    final Registration registration=new Registration();
                    registration.setName(name);
                    registration.setPhone(phone);
                    registration.setPassword(password);
                    ref.orderByChild("phone").equalTo(phone).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                               if(dataSnapshot.exists())
                               {
                                    Toast.makeText(SignUpActivity.this,"Already Exist",Toast.LENGTH_LONG).show();

                               }
                               else
                               {
                                   ref.push().setValue(registration);
                                   SharedPreferences sharedPreferences=getSharedPreferences("My Pref",0);
                                   SharedPreferences.Editor editor=sharedPreferences.edit();
                                   editor.putString("name",name);
                                   editor.putString("phone",phone);
                                   editor.putString("password",password);
                                   Toast.makeText(SignUpActivity.this,"Success",Toast.LENGTH_LONG).show();
                                   Intent intent=new Intent(SignUpActivity.this,AttendanceActivity.class);
                                   finish();
                                   startActivity(intent);
                               }

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });

                }
            }
        });
        tvSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SignUpActivity.this,SignInActivity.class);
                finish();
                startActivity(intent);
            }
        });
    }
    public boolean validate()
    {
        if(TextUtils.isEmpty(name))
        {
            Toast.makeText(SignUpActivity.this,"Enter Name",Toast.LENGTH_LONG).show();
            return false;
        }
        else if(TextUtils.isEmpty(phone))
        {
            Toast.makeText(SignUpActivity.this,"Enter Phone",Toast.LENGTH_LONG).show();
            return false;
        }
        else if(TextUtils.isEmpty(password))
        {
            Toast.makeText(SignUpActivity.this,"Enter Password",Toast.LENGTH_LONG).show();
            return false;
        }
        return  true;
    }
    public void init()
    {
        etName=findViewById(R.id.editTextName);
        etPhone=findViewById(R.id.editTextPhone);
        etPassword=findViewById(R.id.editTextPassword);
        btnSignup=findViewById(R.id.btnSignup);
        tvSkip=findViewById(R.id.tvSkip);
    }




    public void getValues()
    {
        name=etName.getText().toString();
        phone=etPhone.getText().toString();
        password=etPassword.getText().toString();
    }
}

