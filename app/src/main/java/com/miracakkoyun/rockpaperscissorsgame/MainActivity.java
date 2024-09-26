package com.miracakkoyun.rockpaperscissorsgame;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    ImageView imageOyuncu,imageBilgi;
    TextView textOyuncu,textBilgi;
    Button btnTas,btnKagit,btnMakas;
    int[] resimler={R.drawable.tas,R.drawable.paper,R.drawable.makas};
    int oyuncuPuan,bilgisayarPuan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        imageOyuncu=findViewById(R.id.imageOyuncu);
        imageBilgi=findViewById(R.id.imageBilgi);
        textOyuncu=findViewById(R.id.skorOyuncu);
        textBilgi=findViewById(R.id.skorBilgi);
        btnTas=findViewById(R.id.btnTas);
        btnMakas=findViewById(R.id.btnMakas);
        btnKagit=findViewById(R.id.btnKagit);
        oyuncuPuan=0;
        bilgisayarPuan=0;
        btnTas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                oyna(0);
            }
        });
        btnKagit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                oyna(1);
            }
        });
        btnMakas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                oyna(2);
            }
        });
    }

    private void oyna(int oyuncuSecim) {
        int bilgisayarSeicm=(int)(Math.random()*3);
        imageOyuncu.setImageResource(resimler[oyuncuSecim]);
        imageBilgi.setImageResource(resimler[bilgisayarSeicm]);
        if(oyuncuSecim==bilgisayarSeicm ){
            Toast.makeText(this,"berabere",Toast.LENGTH_SHORT).show();
        }else if(oyuncuSecim==0 && bilgisayarSeicm==2 ||
        oyuncuSecim==1 && bilgisayarSeicm==0 ||
        oyuncuSecim==2 && bilgisayarSeicm==1){
            oyuncuPuan++;

        } else {
            bilgisayarPuan++;
        }
        textOyuncu.setText("Oyuncu: "+oyuncuPuan);
        textBilgi.setText("Bilgisayar: "+bilgisayarPuan);
    }
}