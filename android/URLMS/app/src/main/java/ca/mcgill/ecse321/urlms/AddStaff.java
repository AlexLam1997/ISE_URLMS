package ca.mcgill.ecse321.urlms;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import ca.mcgill.ecse321.labmanagementsystem.model.*;
import ca.mcgill.ecse321.labmanagementsystem.controller.*;

public class AddStaff extends AppCompatActivity {
    private URLMS urlms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_staff);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Set variables
        final StaffController uc = new StaffController(urlms);
        final EditText name = (EditText) findViewById(R.id.name);
        final EditText idNumber = (EditText) findViewById(R.id.idNumber);
        final RadioGroup roleGroup = (RadioGroup) findViewById(R.id.radioRole);


        //   final RadioButton selectedRole = selected;

        //Set buttons
        Button addButton = (Button) findViewById(R.id.addStaffBtn);

        //Add Staff
        addButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
               try {
                   String role;
                   if (roleGroup.getCheckedRadioButtonId()!=-1) {
                       role = ((RadioButton) findViewById(roleGroup.getCheckedRadioButtonId())).getText().toString();
                   }
                   else {
                       role = "Research Associate";
                   }
                    uc.createStaff(name.getText().toString(), idNumber.getText().toString(), role);

                    //Display success
                    Snackbar.make(v, "Successfully Added!", Snackbar.LENGTH_LONG).setAction("Action", null).show();

                    // Refresh text fields
                    name.setText("");
                    idNumber.setText("");
                    roleGroup.clearCheck();

                } catch (InvalidInputException e) {
                    String error = e.getMessage();
                    //Display errors
                    Snackbar.make(v, error, Snackbar.LENGTH_LONG).setAction("Action", null).show();
                }
            }
        });


    }

}