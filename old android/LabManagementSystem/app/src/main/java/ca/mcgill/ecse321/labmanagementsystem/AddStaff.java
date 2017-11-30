package ca.mcgill.ecse321.labmanagementsystem;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.io.File;

import ca.mcgill.ecse321.labmanagementsystem.controller.InvalidInputException;
import ca.mcgill.ecse321.labmanagementsystem.controller.URLMSController;
import ca.mcgill.ecse321.labmanagementsystem.model.URLMS;
import ca.mcgill.ecse321.labmanagementsystem.persistence.PersistenceXStream;

public class AddStaff extends AppCompatActivity {

    private URLMS urlms = null;
    private String fileName;
    String error = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_staff);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        fileName = getFilesDir().getAbsolutePath() + "/urlms.xml";
        urlms = PersistenceXStream.initializeModelManager(fileName);
        refreshData();
    }

    public void refreshData() {
        TextView tv1 = (TextView)findViewById(R.id.newstaff_name);
        TextView tv2 = (TextView)findViewById(R.id.newstaff_idnumber);
        TextView tv3 = (TextView)findViewById(R.id.newstaff_role);
        tv1.setText("");
        tv2.setText("");
        tv3.setText("");
    }

    public void addStaff(View v) {
        TextView tv1 = (TextView)findViewById(R.id.newstaff_name);
        TextView tv2 = (TextView)findViewById(R.id.newstaff_idnumber);
        TextView tv3 = (TextView)findViewById(R.id.newstaff_role);
        URLMSController uc = new URLMSController(urlms);
        try {
            uc.createStaff(tv1.getText().toString(), tv2.getText().toString(), tv3.getText().toString());
        } catch (InvalidInputException e) {
            error = e.getMessage();
        }
        refreshData();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_staff, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
