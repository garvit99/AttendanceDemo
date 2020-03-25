package com.example.attendancedemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SignInActivity extends AppCompatActivity {

    Button btnSignIn;
    EditText etPhone, etPassword;
    String phone, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        init();
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference ref = database.getReference().child("registration");
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getValue();
                if(validate())
                {
                    ref.orderByChild("phone").equalTo(phone).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot){
                            if(dataSnapshot.exists()) {
                                for (DataSnapshot data : dataSnapshot.getChildren()) {

                                    String fphone = data.child("phone").getValue().toString();
                                    String fpassword = data.child("password").getValue().toString();
                                    if (phone.equals(fphone) && password.equals(fpassword))
                                    {
                                        Toast.makeText(SignInActivity.this, "Success", Toast.LENGTH_LONG).show();
                                        SharedPreferences sharedPreferences=getSharedPreferences("My Pref",0);
                                        SharedPreferences.Editor editor=sharedPreferences.edit();
                                        editor.putString("phone",phone);
                                        editor.putString("password",password);
                                        editor.apply();
                                        Intent intent=new Intent(SignInActivity.this,AttendanceActivity.class);
                                        finish();
                                        startActivity(intent);
                                    }
                                    else
                                    {
                                        Toast.makeText(SignInActivity.this, "Failure"+phone+password+fphone+fpassword, Toast.LENGTH_LONG).show();
                                    }
                                }
                            }


                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });

                }
            }
        });

    }
    public boolean validate()
    {

        if(TextUtils.isEmpty(phone))
        {
            Toast.makeText(SignInActivity.this,"Enter Phone",Toast.LENGTH_LONG).show();
            return false;
        }
        else if(TextUtils.isEmpty(password))
        {
            Toast.makeText(SignInActivity.this,"Enter Password",Toast.LENGTH_LONG).show();
            return false;
        }
        return  true;
    }
    public void init()
    {
        btnSignIn=findViewById(R.id.btnSignIn);
        etPhone=findViewById(R.id.etPhone);
        etPassword=findViewById(R.id.etPassword);
    }
    public void getValue()
    {
        phone=etPhone.getText().toString();
        password=etPassword.getText().toString();
    }

}

