package ca.mcgill.ecse321.urlms;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import ca.mcgill.ecse321.labmanagementsystem.controller.*;
import ca.mcgill.ecse321.labmanagementsystem.model.URLMS;

public class Supply extends AppCompatActivity {
    private URLMS urlms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supply);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Button addButton = (Button) findViewById(R.id.addSupplyBtn);
        Button removeButton = (Button) findViewById(R.id.removeSupplyBtn);
        Button viewButton = (Button) findViewById(R.id.viewSupplyBtn);

        final EditText supplyName = (EditText) findViewById(R.id.supName);
        final EditText quantity = (EditText) findViewById(R.id.supQuantity);
        final SupplyController uc = new SupplyController(urlms);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    uc.addSupply(supplyName.getText().toString(), quantity.getText().toString());

                    //Display success
                    Snackbar.make(v, "Successfully Added", Snackbar.LENGTH_LONG).setAction("Action", null).show();

                    // Refresh text fields
                    supplyName.setText("");
                    quantity.setText("");

                } catch (InvalidInputException e) {
                    String error = e.getMessage();
                    //Display input error
                    Snackbar.make(v, error, Snackbar.LENGTH_LONG).setAction("Action", null).show();
                }
            }

        });

        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    uc.addSupply(supplyName.getText().toString(), quantity.getText().toString()); //adapt this to remove

                    //Display success
                    Snackbar.make(v, "Successfully Added", Snackbar.LENGTH_LONG).setAction("Action", null).show();

                    // Refresh text fields
                    supplyName.setText("");
                    quantity.setText("");

                } catch (InvalidInputException e) {
                    String error = e.getMessage();
                    //Display input error
                    Snackbar.make(v, error, Snackbar.LENGTH_LONG).setAction("Action", null).show();
                }
            }
        });

        viewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uc.listSupply();
            }
        });

    }
}
