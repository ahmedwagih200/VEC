package com.example.vec;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.toptoche.searchablespinnerlibrary.SearchableSpinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import static com.example.vec.R.array.rating;
import static com.example.vec.R.array.size;
import static com.example.vec.R.array.valve_type;

public class ManufacturerInformationActivity extends AppCompatActivity {

    private Toolbar supportActionBar;
    EditText etManufacturer,etSerialNo,etBodyDesign,etBodyMaterial,etBonnetMaterial
            ,etPackingMaterial,etPackingStyle,etPlugOrDiscMaterial,etSeatMaterial
            , etRetainerMaterial,etGuidesMaterial,etStemMaterial,etSeatStyle;

   Spinner spValveType,spSize,spRating;
   
   Button btnNextMI;

    String etManufacturerstr="",etSerialNostr="",etBodyDesignstr="",etBodyMaterialstr="",etBonnetMaterialstr=""
            ,etPackingMaterialstr="",etPackingStylestr="",etPlugOrDiscMaterialstr="",etSeatMaterialstr=""
            , etRetainerMaterialstr="",etGuidesMaterialstr="",etStemMaterialstr="",etSeatStylestr="",
              spValveTypestr="",spSizestr="",spRatingstr="";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manufacturer_information);


        initViews();
        initEventDriven();


   



        }

    private void initEventDriven() {
        
        btnNextMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                getDataFromUser();
                if(TextUtils.isEmpty(etBodyDesignstr)){etBodyDesign.setError("Body design is required.");}
                else if(TextUtils.isEmpty(etBodyMaterialstr)){etBodyMaterial.setError("Body material is required.");}
                else if(TextUtils.isEmpty(etSeatMaterialstr)){etSeatMaterial.setError("Seat material is required.");}
                else if(TextUtils.isEmpty(etSeatStylestr)){etSeatStyle.setError("Seat style is required.");}
                else if(TextUtils.isEmpty(etBonnetMaterialstr)){etBonnetMaterial.setError("Bonnet material is required.");}
                else if(TextUtils.isEmpty(etStemMaterialstr)){etStemMaterial.setError("Stem material is required.");}
                else if(TextUtils.isEmpty(etPlugOrDiscMaterialstr)){etPlugOrDiscMaterial.setError("Plug Or disc material is required.");}
                else if(TextUtils.isEmpty(etSerialNostr)){etSerialNo.setError("Serial no. is required.");}
                else if(TextUtils.isEmpty(etManufacturerstr)){etManufacturer.setError("Manufacturer is required.");}
                else if(TextUtils.isEmpty(etPackingMaterialstr)){etPackingMaterial.setError("Packing material is required.");}
                else if(TextUtils.isEmpty(etPackingStylestr)){etPackingStyle.setError("Packing style is required.");}
                else if(TextUtils.isEmpty(etGuidesMaterialstr)){etGuidesMaterial.setError("Guides material is required.");}
                else if(TextUtils.isEmpty(etRetainerMaterialstr)){etRetainerMaterial.setError("Retainer material is required.");}
                else if(TextUtils.isEmpty(spValveTypestr)){Toast.makeText(getApplicationContext(),"Please select valve type",Toast.LENGTH_LONG).show();}
                else if(TextUtils.isEmpty(spSizestr)){Toast.makeText(getApplicationContext(),"Please select valve size in * out .",Toast.LENGTH_LONG).show();}
                else if(TextUtils.isEmpty(spRatingstr)){Toast.makeText(getApplicationContext(),"Please select valve rating in * out .",Toast.LENGTH_LONG).show();}
                else
                { startActivity(new Intent(ManufacturerInformationActivity.this,InspectionActivity.class));}
                
            }

            private void getDataFromUser() {

                etBodyDesignstr=etBodyDesign.getText().toString().trim();
                etBodyMaterialstr=etBodyMaterial.getText().toString().trim();
                etSeatMaterialstr=etSeatMaterial.getText().toString().trim();
                etSeatStylestr=etSeatStyle.getText().toString().trim();
                etBonnetMaterialstr=etBonnetMaterial.getText().toString().trim();
                etStemMaterialstr=etStemMaterial.getText().toString().trim();
                etPlugOrDiscMaterialstr=etPlugOrDiscMaterial.getText().toString().trim();
                etSerialNostr=etSerialNo.getText().toString().trim();
                etManufacturerstr=etManufacturer.getText().toString().trim();
                etPackingMaterialstr=etPackingMaterial.getText().toString().trim();
                etPackingStylestr=etPackingStyle.getText().toString().trim();
                etGuidesMaterialstr=etGuidesMaterial.getText().toString().trim();
                etRetainerMaterialstr=etRetainerMaterial.getText().toString().trim();

                //**Valve type**//

                // Create an ArrayAdapter using the string array and a default spinner layout
                ArrayAdapter<CharSequence> spValveTypeAdapter = ArrayAdapter.createFromResource(getApplicationContext(),
                        valve_type, R.layout.spinner_text);

                // Specify the layout to use when the list of choices appears
                spValveTypeAdapter.setDropDownViewResource(R.layout.my_spinner_dropdown_list_item);

                // Apply the spinnerAdapter to the spinner
                spValveType.setAdapter(spValveTypeAdapter);


                spValveType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        if(position==0){
                            ((TextView)spValveType.getSelectedView()).setError("Please select valve type");
                        }else {
                            spValveTypestr=parent.getItemAtPosition(position).toString();
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        ((TextView)spValveType.getSelectedView()).setError("Select plant.");
                    }
                });



                //**Valve size**//

                // Create an ArrayAdapter using the string array and a default spinner layout


                ArrayAdapter<CharSequence> spSizeAdapter = ArrayAdapter.createFromResource(getApplicationContext(),
                        size, R.layout.spinner_text);

                // Specify the layout to use when the list of choices appears
                spSizeAdapter.setDropDownViewResource(R.layout.my_spinner_dropdown_list_item);

                // Apply the spinnerAdapter to the spinner
                spSize.setAdapter(spSizeAdapter);


                spSize.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        if(position==0){
                            ((TextView)spSize.getSelectedView()).setError("Please select valve size in * out ");
                        }else {
                            spSizestr=parent.getItemAtPosition(position).toString();
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        ((TextView)spSize.getSelectedView()).setError("Please select valve size in * out ");

                    }
                });



                // ** Valve rating**//


                // Create an ArrayAdapter using the string array and a default spinner layout

                ArrayAdapter<CharSequence> spRatingAdapter = ArrayAdapter.createFromResource(getApplicationContext(),
                        rating, R.layout.spinner_text);

// Specify the layout to use when the list of choices appears
                spRatingAdapter.setDropDownViewResource(R.layout.my_spinner_dropdown_list_item);

                // Apply the spinnerAdapter to the spinner

                spRating.setAdapter(spRatingAdapter);


                spRating.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        if(position==0){
                            ((TextView)spRating.getSelectedView()).setError("Please select valve rating in * out .");
                        }else {
                            spRatingstr=parent.getItemAtPosition(position).toString();
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        ((TextView)spRating.getSelectedView()).setError("Please select valve rating in * out .");

                    }
                });




            }
        });
    }


    private void initViews() {

        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        etBodyDesign=(EditText) findViewById(R.id.et_bodydesign);
        etBodyMaterial=(EditText) findViewById(R.id.et_bodymaterial);
        etSeatMaterial=(EditText)findViewById(R.id.et_seatmaterial);
        etSeatStyle=(EditText)findViewById(R.id.et_seatstyle);
        etBonnetMaterial=(EditText)findViewById(R.id.et_bonnetmaterial);
        etStemMaterial=(EditText)findViewById(R.id.et_stemmaterial);
        etPlugOrDiscMaterial=(EditText)findViewById(R.id.et_plugordiskmaterial);
        etSerialNo=(EditText)findViewById(R.id.et_serialno);
        etManufacturer=(EditText)findViewById(R.id.et_manufacturer);
        etPackingMaterial=(EditText)findViewById(R.id.et_packingmaterial);
        etPackingStyle=(EditText)findViewById(R.id.et_packingstyle);
        etGuidesMaterial=(EditText)findViewById(R.id.et_guidesmaterial);
        etRetainerMaterial=(EditText)findViewById(R.id.et_retainermaterial);
        spValveType=(SearchableSpinner) findViewById(R.id.sp_valvetype);
        spRating=(SearchableSpinner)findViewById(R.id.sp_rating);
        spSize=(SearchableSpinner)findViewById(R.id.sp_size);
        btnNextMI=(Button)findViewById(R.id.btn_nextMI);



    }


    public void setSupportActionBar(Toolbar supportActionBar) {
        this.supportActionBar = supportActionBar;
    }


}