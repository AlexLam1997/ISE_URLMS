package ca.mcgill.ecse321.urlms;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class ManageStaff extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_staff);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Buttons
        Button addButton = (Button) findViewById(R.id.mAddStaffBtn);
        Button removeButton = (Button) findViewById(R.id.mRemoveStaffBtn);
        Button viewButton = (Button) findViewById(R.id.mViewStaffBtn);

        //Actions when the button is clicked
        addButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(ManageStaff.this, AddStaff.class);
                startActivity(intent);
            }
        });

        removeButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(ManageStaff.this, RemoveStaff.class);
                startActivity(intent);
            }
        });

        viewButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(ManageStaff.this, ViewStaff.class);
                startActivity(intent);
            }
        });

    }

}
