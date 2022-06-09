package com.example.cc203_tholfaqar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView LSV ;
    MyDataClimat db ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new MyDataClimat(this);
        LSV = findViewById(R.id.listV);

        ArrayList<Climat> arr = MyDataClimat.getAllClimat(db.getReadableDatabase());

        ArrayList<String> arrS = new ArrayList<>();
        for(Climat c: arr)
            arrS.add(c.getId() + " _ " + c.getNomVille()+"_ " + c.getPays() +"_" +c.getTemprature()+"_"+ c.getTemprature() );

        ArrayAdapter ad = new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrS);

        LSV.setAdapter(ad);


    }
}