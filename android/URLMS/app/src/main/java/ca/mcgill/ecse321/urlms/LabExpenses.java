package ca.mcgill.ecse321.urlms;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import ca.mcgill.ecse321.labmanagementsystem.controller.InvalidInputException;
import ca.mcgill.ecse321.labmanagementsystem.controller.*;
import ca.mcgill.ecse321.labmanagementsystem.model.URLMS;

public class LabExpenses extends AppCompatActivity {
    private URLMS urlms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_expenses);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final EditText expense = (EditText) findViewById(R.id.expName);
        final EditText amount = (EditText) findViewById(R.id.expAmount);
        final ExpenseController uc = new ExpenseController(urlms);

        Button addButton = (Button) findViewById(R.id.addExpBtn);
        Button reportButton = (Button) findViewById(R.id.expReportBtn);

        addButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
/*                try {
 //                   uc.addExpense(expense.getText().toString(), amount.getText().toString());

                    //Display success
                    Snackbar.make(v, "Successfully Added!", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();

                    // Refresh text fields
                    expense.setText("");
                    amount.setText("");

                } catch (InvalidInputException e) {
                    String error = e.getMessage();
                    //Display input error
                    Snackbar.make(v, error, Snackbar.LENGTH_LONG).setAction("Action", null).show();
                } */
            }

        });

        reportButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
            // redirects?
            }
        });

    }



}