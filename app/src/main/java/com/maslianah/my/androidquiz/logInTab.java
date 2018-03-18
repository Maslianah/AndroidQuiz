package com.maslianah.my.androidquiz;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class logInTab extends Fragment implements View.OnClickListener{

    Button btnSubmit;

    private EditText editMail,editPassword;
    private static final String TAG = "LogInFragment";
    public final static String EXTRA_TO = "com.maslianah.my.androidquiz.TO";
    public final static String EXTRA_SUBJECT = "com.maslianah.my.androidquiz.SUBJECT";
    public final static String EXTRA_MESSAGE = "com.maslianah.my.androidquiz.MESSAGE";
   @Nullable
   @Override
   public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_log_in_tab, container, false);// Inflate the layout for this fragment

       btnSubmit = (Button) view.findViewById(R.id.submit);
       editMail = (EditText) view.findViewById(R.id.email) ;
       editPassword = (EditText) view.findViewById(R.id.password) ;
       btnSubmit.setOnClickListener(this);

       return view;
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

        if(editMail.getText().toString().equals("") || editPassword.getText().toString().equals(""))
               Toast.makeText(getActivity(),"Please complete the form", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(getActivity(),"Didn't proceed because no database.",Toast.LENGTH_LONG).show();
        }

    }