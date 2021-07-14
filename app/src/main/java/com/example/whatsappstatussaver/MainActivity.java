package com.example.whatsappstatussaver;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

import static android.os.Build.VERSION.SDK_INT;

public class MainActivity extends AppCompatActivity {
    int requestCode=1;
    Adapter adapter;
    File[] files;
    RecyclerView recyclerView;
    SwipeRefreshLayout swipeRefreshLayout;

    ArrayList<ModelClass> filesList = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview);
        swipeRefreshLayout = findViewById(R.id.swipe);
    }

    private void CheckPermission(){
        if(SDK_INT>23){
            if(checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)== PackageManager.PERMISSION_GRANTED)
            {

            }
            else{
                ActivityCompat.requestPermissions(MainActivity.this,new String[]{ Manifest.permission.WRITE_EXTERNAL_STORAGE},requestCode);
            }

        }
        else{
            Toast.makeText(getApplicationContext(),"Already",Toast.LENGTH_SHORT).show();
        }
    }
}