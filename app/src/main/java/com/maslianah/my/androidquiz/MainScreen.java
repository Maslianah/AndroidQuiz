package com.maslianah.my.androidquiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainScreen extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        getSupportActionBar().setTitle("XYZ COMPANY");

        Intent intent = getIntent();
        String Name = intent.getStringExtra(signUpTab.EXTRA_USER);
        String Number = intent.getStringExtra(signUpTab.EXTRA_PHONE_NUMBER);

        // Capture the layout's TextView and set the string as its text
        TextView nameView = findViewById(R.id.name);
        TextView numberView = findViewById(R.id.number);
        Button btnUserView = findViewById(R.id.userType);
        Button btnLogOut = findViewById(R.id.logOut);
        Button btnEditNumber = findViewById(R.id.editNumber);

        btnUserView.setOnClickListener(this);
        btnLogOut.setOnClickListener(this);
        btnEditNumber.setOnClickListener(this);

        nameView.setText(Name);
        numberView.setText(Number);
    }
    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.userType:
                String value= getIntent().getStringExtra("SelectedItem");
                Toast.makeText(this,"Your account type is " + value, Toast.LENGTH_SHORT).show();
                break;

            case R.id.logOut:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Are you sure you want to exit?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent intent = new Intent(MainScreen.this, splashScreen.class);
                                startActivity(intent);
                                finish();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
                break;

            case R.id.editNumber:

                // get activity_prompt.xml view
                LayoutInflater li = LayoutInflater.from(getApplicationContext());
                View promptsView = li.inflate(R.layout.activity_prompt, null);

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

                // set activity_prompt.xml to alert dialog builder
                alertDialogBuilder.setView(promptsView);

                final EditText userInput = (EditText) promptsView.findViewById(R.id.editTextDialogUserInput);

                // set dialog message
                alertDialogBuilder
                        .setCancelable(false)
                        .setPositiveButton("OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,int id) {
                                        TextView numberView = findViewById(R.id.number);
                                        numberView.setText(userInput.getText());
                                    }
                                })
                        .setNegativeButton("Cancel",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,int id) {
                                        dialog.cancel();
                                    }
                                });

                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();
                Toast.makeText(getApplication(),"Number edit succesfully",Toast.LENGTH_LONG).show();
                break;

            default:
                break;
        }
    }
}
