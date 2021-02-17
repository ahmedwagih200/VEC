package com.example.vec;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.toptoche.searchablespinnerlibrary.SearchableSpinner;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class GeneralInformationActivity extends AppCompatActivity
      {

    EditText etCustomer,etReportNo,etWorkNo,etTagNo,etDate;
    TextView tvCustomer,tvReportNo,tvWorkNo,tvTagNo,tvDate,tvPlanit,tvDatePicker;
    SearchableSpinner spPlant;
    Button btnNextGI ,btnGetDate,btnCloseDate,btnSelectDate;
    String etCustomerstr="",etReportNostr="",etWorkNostr="",etTagNostr="",finalDatestr="",spPlantstr="",btnNextGIstr="";
    Calendar calendar;
    DatePicker dpDate;
    Dialog D_DatePicker;
    SimpleDateFormat sdf;


    private Toolbar supportActionBar;
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_information);

        initViews();

        btnNextGI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                initEventDriven();


                if(TextUtils.isEmpty(etCustomerstr)){etCustomer.setError("Customer is required.");}
                else if(TextUtils.isEmpty(etReportNostr)){etReportNo.setError("Report No. is required.");}
                else if(TextUtils.isEmpty(etTagNostr)){etTagNo.setError("Tag No. is required.");}
                else if(TextUtils.isEmpty(finalDatestr)){tvDatePicker.setError("Date is required.");}
                else if(TextUtils.isEmpty(etWorkNostr)){etWorkNo.setError("Work No. is required.");}
                else if (TextUtils.isEmpty(spPlantstr)){Toast.makeText(getApplicationContext(),"select plant",Toast.LENGTH_LONG).show();}
                else
                { startActivity(new Intent(GeneralInformationActivity.this,ManufacturerInformationActivity.class));}
            }
        });
    }

          private void initViews() {

              Toolbar toolbar=findViewById(R.id.toolbar);
              setSupportActionBar(toolbar);

              etCustomer=(EditText) findViewById(R.id.et_customer);
              etReportNo=(EditText) findViewById(R.id.et_reportno);
              etTagNo=(EditText) findViewById(R.id.et_tagno);
              etWorkNo=(EditText) findViewById(R.id.et_wono);
              // etDate=(EditText) findViewById(R.id.et_date);
              //cpDate=(DatePicker) findViewById(R.id.et_date);
              spPlant=(SearchableSpinner) findViewById(R.id.sp_plant);
              btnNextGI=(Button)findViewById(R.id.btn_nextGI);
              tvDatePicker=(TextView)findViewById(R.id.tv_datepicker) ;
              btnSelectDate=(Button)findViewById(R.id.btn_selectdate);

              sdf= new SimpleDateFormat("dd/mm/yyyy (EEEE)", Locale.getDefault());
          }

          private void initEventDriven() {

        etCustomerstr=etCustomer.getText().toString().trim();
        etReportNostr=etReportNo.getText().toString().trim();
        etTagNostr=etTagNo.getText().toString().trim();
        etWorkNostr=etWorkNo.getText().toString().trim();

        btnSelectDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showDatePicker();
            }
        });

                              ////////////********spinners*********///////////

                // Create an ArrayAdapter using the string array and a default spinner layout
                ArrayAdapter<CharSequence> spPlantAdapter = ArrayAdapter.createFromResource(getApplicationContext(),
                        R.array.plant, R.layout.spinner_text);

                // Specify the layout to use when the list of choices appears
                spPlantAdapter.setDropDownViewResource(R.layout.my_spinner_dropdown_list_item);

                // Apply the spinnerAdapter to the spinner
                spPlant.setAdapter(spPlantAdapter);


                spPlant.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        if (position == 0) {
                            ( (TextView) spPlant.getSelectedView()).setError("Select plant.");
                            // Toast.makeText(getApplicationContext(), "Please select plant", Toast.LENGTH_LONG).show();
                        } else {
                            spPlantstr = parent.getItemAtPosition(position).toString();
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                        ((TextView) spPlant.getSelectedView()).setError("Select plant.");

                    }
                });
                          ////////////********end of spinners*********///////////
            }

    private void showDatePicker() {

        D_DatePicker=new Dialog(this);
        D_DatePicker.setContentView(R.layout.dialog_date_picker);
        D_DatePicker.show();
        dpDate=(DatePicker)D_DatePicker.findViewById(R.id.dp_datepicker);
        btnGetDate=(Button)D_DatePicker.findViewById(R.id.btn_getDate);
        btnCloseDate=(Button)D_DatePicker.findViewById(R.id.btn_closeDate);

        int year=Calendar.getInstance().get(Calendar.YEAR);
        int dayOfMonth=Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        int month=Calendar.getInstance().get(Calendar.MONTH);

        dpDate.updateDate(year,month,dayOfMonth);

        btnGetDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                calendar=Calendar.getInstance();
                calendar.set(dpDate.getYear(),dpDate.getMonth(),dpDate.getDayOfMonth());
                finalDatestr=sdf.format(calendar.getTime());
                tvDatePicker.setText(finalDatestr);
                D_DatePicker.dismiss();
            }
        });

        btnCloseDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                D_DatePicker.dismiss();
            }
        });
    }




    public void setSupportActionBar(Toolbar supportActionBar) {
        this.supportActionBar = supportActionBar;
    }
}