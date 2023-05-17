package com.pgz.consultoriopgz.modules;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.pgz.consultoriopgz.R;
import com.pgz.consultoriopgz.modules.about.AboutActivity;

public class MainActivity extends AppCompatActivity {

    CardView cardClient,cardAbout,cardList,cardSchedule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configureUI();
        configureOnClickListeners();
    }

    private void configureUI(){
        cardAbout = findViewById(R.id.cardAbout);
        cardClient = findViewById(R.id.cardAddClient);
        cardList = findViewById(R.id.cardList);
        cardSchedule = findViewById(R.id.cardNewSchule);
    }

    private void configureOnClickListeners(){
        cardAbout.setOnClickListener(v -> {
            goToAbout();
        });
    }

    private void goToAbout(){
        Intent intent = new Intent(this, AboutActivity.class);
        startActivity(intent);
    }
}