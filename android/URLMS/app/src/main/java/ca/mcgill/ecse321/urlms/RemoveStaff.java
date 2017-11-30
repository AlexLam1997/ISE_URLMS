package ca.mcgill.ecse321.urlms;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import ca.mcgill.ecse321.labmanagementsystem.controller.InvalidInputException;
import ca.mcgill.ecse321.labmanagementsystem.controller.StaffController;
import ca.mcgill.ecse321.labmanagementsystem.model.URLMS;

public class RemoveStaff extends AppCompatActivity {
    private URLMS urlms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_staff);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Set variables
        final StaffController uc = new StaffController(urlms);
        final EditText name = (EditText) findViewById(R.id.rStaffName);
        final EditText idNumber = (EditText) findViewById(R.id.rStaffID);

        //Set buttons
        Button removeButton = (Button) findViewById(R.id.removeStaffBtn);

        //Add Staff
        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    uc.removeStaff(name.getText().toString(), idNumber.getText().toString());

                    //Display success
                    Snackbar.make(v, "Successfully removed!", Snackbar.LENGTH_LONG).setAction("Action", null).show();

                    // Refresh text fields
                    name.setText("");
                    idNumber.setText("");

                } catch (InvalidInputException e) {
                    String error = e.getMessage();

                    //Display errors
                    Snackbar.make(v, error, Snackbar.LENGTH_LONG).setAction("Action", null).show();
                }
            }
        });


    }

}