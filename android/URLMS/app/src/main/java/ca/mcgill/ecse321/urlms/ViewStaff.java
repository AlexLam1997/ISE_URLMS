package ca.mcgill.ecse321.urlms;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import ca.mcgill.ecse321.labmanagementsystem.controller.StaffController;
import ca.mcgill.ecse321.labmanagementsystem.model.URLMS;

public class ViewStaff extends AppCompatActivity {
    private URLMS urlms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_staff);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final StaffController uc = new StaffController(urlms);



    }

}
