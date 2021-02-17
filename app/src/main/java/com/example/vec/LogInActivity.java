package com.example.vec;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class LogInActivity extends AppCompatActivity {


    private EditText etLogInEmail, etLogInPassword;
    Button btnLogIn;
    TextView tvToRegisterActivity, tvForgotPassword;
    CheckBox checkedStatus;

    private String User_Email = "", User_Password = "";
    private Toolbar supportActionBar;


    private ProgressBar progressBar;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initViews();
        initEventDriven();

    }

    private void initEventDriven() {

        progressBar.setVisibility(View.GONE);
        btnLogIn.setOnClickListener(v -> {
            User_Email = etLogInEmail.getText().toString().trim();
            User_Password = etLogInPassword.getText().toString().trim();


            if (TextUtils.isEmpty(User_Email) )
            {
                etLogInEmail.setError("Email is required.");
                return;
            }
            if(TextUtils.isEmpty(User_Password))
            {
                etLogInPassword.setError("Password is required.");
                return;
            }
            else {

                progressBar.setVisibility(View.VISIBLE);

                //log in user

                mAuth.signInWithEmailAndPassword(User_Email, User_Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(LogInActivity.this, "Logged in successfully", Toast.LENGTH_LONG).show();
                            startActivity(new Intent(getApplicationContext(), WelcomeActivity.class));
                        } else {
                            Toast.makeText(LogInActivity.this, "Error !" + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });

            } });
        tvToRegisterActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),RegisterActivity.class));
            }
        });
        tvForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText resetMail= new EditText(v.getContext());
                final AlertDialog.Builder passwordResetDialog=new AlertDialog.Builder(v.getContext());
                passwordResetDialog.setTitle("Reset Password ?");
                passwordResetDialog.setMessage("Enter your Email to receive restore link.");
                passwordResetDialog.setView(resetMail);
                passwordResetDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //extract the mail and send resetore link

                        String mail=resetMail.getText().toString();
                        mAuth.sendPasswordResetEmail(mail).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(LogInActivity.this,"Reset Link sent to your Email.",Toast.LENGTH_LONG).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(LogInActivity.this,"Error ! Reset Link is not sent"+e.getMessage(),Toast.LENGTH_LONG).show();
                            }
                        });
                    }
                });

                passwordResetDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //close the dialog
                    }
                });
                passwordResetDialog.create().show();
            }
        });


    }

    private void initViews() {

       btnLogIn=findViewById(R.id.btn_login);
       tvToRegisterActivity=findViewById(R.id.tv_toregisterActivty);
       etLogInEmail=findViewById(R.id.et_loginemail);
        etLogInPassword = findViewById(R.id.et_loginpassword);
        checkedStatus = findViewById(R.id.checkbox);
        progressBar = findViewById(R.id.progressBar);
        tvForgotPassword=findViewById(R.id.tv_forgotpassword);
        mAuth = FirebaseAuth.getInstance();

    }

    public void setSupportActionBar(Toolbar supportActionBar) {
        this.supportActionBar = supportActionBar;
    }

}

