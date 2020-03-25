package com.example.attendancedemo;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
public class AttendanceInfoActivity extends AppCompatActivity {
    private String TAG= "dAttendanceInfoActivity";
    String date,intime,outtime;
    ArrayList<ReceivedDataModel> data= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance_info);
        SharedPreferences sharedPreferences=getSharedPreferences("My Pref",0);
        final String phone=sharedPreferences.getString("phone","");
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference userrefinfo = database.getReference().child("userInfo").child(phone);
        userrefinfo.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                Object object = dataSnapshot.getValue(Object.class);
                String result = new Gson().toJson(object);
                try {
                    JSONObject joResult =new JSONObject(result);
                    //JSONObject joResult1=new JSONObject(joResult.getString(userrefinfo.getKey()));
                    Log.d(TAG,joResult.toString());
                    //Log.d(TAG,joResult1.toString());
                    //date=joResult.getString("loginDate");
                    //intime=joResult.getString("loginTime");
                    //outtime=joResult.getString("logoutTime");

                    /*data.add(new ReceivedDataModel(joResult.getString("loginDate"),joResult.getString("loginTime"),joResult.getString("loginLatitude"),
                            joResult.getString("loginLongitude"),joResult.getString("logoutDate"),joResult.getString("logoutTime"),
                            joResult.getString("logoutLatitude"),joResult.getString("logoutLongitude")));*/
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                AttendanceInfo[] attendanceInfos=new AttendanceInfo[]
                        {
                                new AttendanceInfo(date,intime,outtime)
                        };
                RecyclerView recyclerView = findViewById(R.id.card_recycler_view);
                CustomAdapter adapter = new CustomAdapter(attendanceInfos);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                recyclerView.setAdapter(adapter);

            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
