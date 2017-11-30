package ca.mcgill.ecse321.urlms;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class StaffMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //buttons
        Button eqButton = (Button) findViewById(R.id.sEqBtn);
        Button supplyButton = (Button) findViewById(R.id.sSupplyBtn);
        Button updateButton = (Button) findViewById(R.id.sUpdateBtn);

        //actions of respective buttons
        eqButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(StaffMenu.this, Equipment.class);
                startActivity(intent);
            }
        });

        supplyButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(StaffMenu.this, Supply.class);
                startActivity(intent);
            }
        });

        updateButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(StaffMenu.this, WeeklyUpdate.class);
                startActivity(intent);
            }
        });

    }

}
