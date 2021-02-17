package com.example.vec;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class RegisterActivity extends AppCompatActivity {

    public static final String TAG = "TAG";

    EditText etFullName;
    EditText etEmail;
    EditText etPassword;
    EditText etPhone;
    EditText etConfirmPassword;

    Button btnCreateAccount;
    TextView tvToLogInActivity;
    FirebaseFirestore fStore;

    private String User_FullName="",User_Email="",User_Phone="",User_Password="",User_ConfirmPassword="";

    private ProgressBar progressBar;
    private FirebaseAuth mAuth;
    private Toolbar supportActionBar;
    String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
       initViews();
       initEventDriven();

    }

    private void initEventDriven()
    {
        btnCreateAccount.setOnClickListener(v -> {

            User_FullName = etFullName.getText().toString().trim();
            User_Password = etPassword.getText().toString().trim();
            User_ConfirmPassword = etConfirmPassword.getText().toString().trim();
            User_Phone = etPhone.getText().toString().trim();
            User_Email = etEmail.getText().toString().trim();



            if (TextUtils.isEmpty(User_FullName))
            {
                etFullName.setError("Full name is required.");

            }
            if (TextUtils.isEmpty(User_Email))
            {
                etEmail.setError("Email is required.");

            }
            if(TextUtils.isEmpty(User_Password))
            {
                etPassword.setError("Password name is required.");

            }
            if(TextUtils.isEmpty(User_ConfirmPassword))
            {
                etConfirmPassword.setError("Password is required.");

            }
            if(TextUtils.isEmpty(User_Phone))
            {
                etPhone.setError("Phone is required.");

            }
            if (!TextUtils.equals(User_Password,User_ConfirmPassword))
            {
                Toast.makeText(RegisterActivity.this, "Passwords are different", Toast.LENGTH_LONG).show();
            }
            else if (etPassword.length() <7)
            {
                etPassword.setError("Password must be >= 7 characters");
            }

            progressBar.setVisibility(View.VISIBLE);

            //register the user in firebase

            mAuth.createUserWithEmailAndPassword(User_Email,User_Password).addOnCompleteListener(task -> {
                if (task.isSuccessful())
                {
                    FirebaseUser fuser =mAuth.getCurrentUser();
                    fuser.sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(RegisterActivity.this,"Verification Email has been sent.",Toast.LENGTH_LONG).show();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.d(TAG,"onFailure : Email not sent "+e.getMessage());
                        }
                    });
                    Toast.makeText(RegisterActivity.this,"Your account created.",Toast.LENGTH_LONG).show();
                    userID = mAuth.getCurrentUser().getUid();
                    DocumentReference documentReference=fStore.collection("users").document(userID);
                    Map<String,Object> user = new HashMap<>();
                    user.put("Full-Name",User_FullName);
                    user.put("Email",User_Email);
                    user.put("Phone",User_Phone);
                    documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Log.d(TAG,"OnSuccess : user profile is created for "+userID);
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.d(TAG,"OnFailure : "+e.toString());
                        }
                    });
                    startActivity(new Intent(getApplicationContext(),LogInActivity.class));
                }else {
                    Toast.makeText(RegisterActivity.this,"Error! "+task.getException(),Toast.LENGTH_LONG).show();
                    progressBar.setVisibility(View.GONE);
                }
            });
        });
        tvToLogInActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),LogInActivity.class));
            }
        });

    }


      void   initViews()
      {
          etFullName=findViewById(R.id.et_fullname);
          etEmail = findViewById(R.id.et_email);
          etPassword = findViewById(R.id.et_password);
          etConfirmPassword = findViewById(R.id.et_confirmPassword);
          etPhone = findViewById(R.id.et_phone);

          btnCreateAccount = findViewById(R.id.btn_createAccount);
          tvToLogInActivity=findViewById(R.id.tv_tologinActivty);
          progressBar=findViewById(R.id.progressBar);
          mAuth=FirebaseAuth.getInstance();
          FirebaseFirestore fStore = FirebaseFirestore.getInstance();

          if(mAuth.getCurrentUser()!=null)
            {
             startActivity(new Intent(getApplicationContext(),RegisterActivity.class));
             finish();
            }

      }
    public void setSupportActionBar(Toolbar supportActionBar) {
        this.supportActionBar = supportActionBar;
    }
    }
























