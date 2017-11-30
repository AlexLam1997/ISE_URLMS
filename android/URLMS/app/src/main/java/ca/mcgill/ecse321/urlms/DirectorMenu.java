package ca.mcgill.ecse321.urlms;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class DirectorMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_director_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Buttons
        Button staffButton = (Button) findViewById(R.id.dStaffBtn);
        Button eqButton = (Button) findViewById(R.id.dEqBtn);
        Button supplyButton = (Button) findViewById(R.id.dSupplyBtn);
        Button labExButton = (Button) findViewById(R.id.dExpBtn);
        Button updateButton = (Button) findViewById(R.id.dUpdateBtn);

        //Actions when the button is clicked
        staffButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(DirectorMenu.this, ManageStaff.class);
                startActivity(intent);
            }
        });

        eqButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(DirectorMenu.this, Equipment.class);
                startActivity(intent);
            }
        });

        supplyButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(DirectorMenu.this, Supply.class);
                startActivity(intent);
            }
        });

        labExButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(DirectorMenu.this, LabExpenses.class);
                startActivity(intent);
            }
        });

        updateButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(DirectorMenu.this, WeekReport.class);
                startActivity(intent);
            }
        });





    }

}
