package ca.mcgill.ecse321.urlms;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import ca.mcgill.ecse321.labmanagementsystem.controller.*;
import ca.mcgill.ecse321.labmanagementsystem.model.*;

public class Equipment extends AppCompatActivity {
    private URLMS urlms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipment);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //Find how to redirect to where it came from, not from hierarchy
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Set variables
        final EquipmentController uc = new EquipmentController(urlms);
        final EditText name = (EditText) findViewById(R.id.eqName);
        final EditText quantity = (EditText) findViewById(R.id.eqQuantity);

        //Set buttons
        Button addButton = (Button) findViewById(R.id.addEqBn);
        Button removeButton = (Button) findViewById(R.id.removeEqBtn);
        Button viewButton = (Button) findViewById(R.id.viewEqBtn);

        addButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
               try {
                    uc.addEquipment(name.getText().toString(), quantity.getText().toString());

                    //Display success
                    Snackbar.make(v, "Successfully Added!", Snackbar.LENGTH_LONG).setAction("Action", null).show();

                    // Refresh text fields
                    name.setText("");
                    quantity.setText("");


                } catch (InvalidInputException e) {
                    String error = e.getMessage();

                    //Display input error
                    Snackbar.make(v, error, Snackbar.LENGTH_LONG).setAction("Action", null).show();
                }

            }
        });

        removeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                try {
                    uc.removeEquipment(name.getText().toString(), quantity.getText().toString());

                    //Display success
                    Snackbar.make(v, "Successfully removed!", Snackbar.LENGTH_LONG).setAction("Action", null).show();

                    // Refresh text fields
                    name.setText("");
                    quantity.setText("");


                } catch (InvalidInputException e) {
                    String error = e.getMessage();

                    //Display input error
                    Snackbar.make(v, error, Snackbar.LENGTH_LONG).setAction("Action", null).show();
                }

            }
        });

        viewButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                uc.listEquipment();
            }
        });

    }

}
