package com.maslianah.my.androidquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


public class signUpTab extends Fragment implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    public final static String EXTRA_USER = "com.maslianah.my.androidquiz.USER";
    public final static String EXTRA_PHONE_NUMBER = "com.maslianah.my.androidquiz.PHONE_NUMBER";

    Button btnSubmit;
    EditText editMail,editPassword,editFirstName,editLastName,editMobile;
    Spinner userType;
    private static final String TAG = "SignUpFragment";
    ArrayAdapter<CharSequence> adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_sign_up_tab, container, false);// Inflate the layout for this fragment

        btnSubmit = (Button) rootView.findViewById(R.id.signIn);
        userType = (Spinner)rootView.findViewById(R.id.userType);
        editFirstName = (EditText) rootView.findViewById(R.id.fName) ;
        editLastName = (EditText) rootView.findViewById(R.id.lName) ;
        editMail = (EditText) rootView.findViewById(R.id.email) ;
        editPassword = (EditText) rootView.findViewById(R.id.password) ;
        editMobile = (EditText) rootView.findViewById(R.id.mobile) ;
        btnSubmit.setOnClickListener(this);
        // When we select this spinner item, a Toast message will be displayed
        userType.setOnItemSelectedListener(this);
        // Create an ArrayAdapter using the string array and a default spinner layout
        adapter = ArrayAdapter.createFromResource(getActivity().getApplicationContext(),R.array.user_Type,android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        userType.setAdapter(adapter);

        return rootView;

    }
   @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {
        String selected = adapterView.getItemAtPosition(pos).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
       /* AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Please Select User Type:")
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();*/
        // Toast.makeText(getActivity(), "Please select user type " , Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View view) {

        String Expn = "[a-zA-Z0-9._-]+@[a-z]+.[a-z]+";
        if (editMail.getText().toString().matches(Expn));
        else
            Toast.makeText(getActivity(),"Email is not valid", Toast.LENGTH_SHORT).show();

        if (editPassword.getText().toString().matches("^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$"));
        else
            Toast.makeText(getActivity(),"Password should contain one special character and minimum 8 character required", Toast.LENGTH_SHORT).show();

        if(editMail.getText().toString().equals("") || editPassword.getText().toString().equals("") || editMobile.getText().toString().equals("") || userType.getSelectedItem().toString().equals("Choose one:"))
            Toast.makeText(getActivity(),"Please complete the form", Toast.LENGTH_SHORT).show();

        // ^[0-9]{10,10}$
        else
        {Intent intent = new Intent(getContext(),MainScreen.class);
            intent.putExtra(EXTRA_USER, editFirstName.getText().toString()+ editLastName.getText().toString());
            intent.putExtra(EXTRA_PHONE_NUMBER, editMobile.getText().toString());
            intent.putExtra("SelectedItem", userType.getSelectedItem().toString());

            startActivity(intent);
        }


    }

}
