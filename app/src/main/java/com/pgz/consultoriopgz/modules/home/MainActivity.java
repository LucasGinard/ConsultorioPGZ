package com.pgz.consultoriopgz.modules.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.content.Intent;
import android.os.Bundle;
import com.pgz.consultoriopgz.R;
import com.pgz.consultoriopgz.modules.about.AboutActivity;
import com.pgz.consultoriopgz.modules.client.view.ClientActivity;
import com.pgz.consultoriopgz.modules.schedule.view.ScheduleAppointmentActivity;
import com.pgz.consultoriopgz.modules.scheduleList.view.ScheduleListActivity;

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

        cardClient.setOnClickListener(v -> {
            goToClient();
        });

        cardSchedule.setOnClickListener(v -> {
            goToSchedule();
        });

        cardList.setOnClickListener(v -> {
            gotToListSchedule();
        });

    }

    private void goToAbout(){
        Intent intent = new Intent(this, AboutActivity.class);
        startActivity(intent);
    }

    private void goToClient(){
        Intent intent = new Intent(this, ClientActivity.class);
        startActivity(intent);
    }

    private void goToSchedule(){
        Intent intent = new Intent(this, ScheduleAppointmentActivity.class);
        startActivity(intent);
    }
    private void gotToListSchedule(){
        Intent intent = new Intent(this, ScheduleListActivity.class);
        startActivity(intent);
    }

}