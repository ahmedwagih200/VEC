package com.example.vec;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;

import com.toptoche.searchablespinnerlibrary.SearchableSpinner;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.example.vec.R.array.as_found_code;
import static com.example.vec.R.array.work_done_codes;

public class InspectionActivity extends AppCompatActivity {

    private Toolbar supportActionBar;

    SearchableSpinner sp_AsFnd_Inlet,sp_AsFnd_Outlet,sp_AsFnd_HandwheelOrNut,sp_AsFnd_Yoke,sp_AsFnd_StemNutAndHousing,sp_AsFnd_PackingGlandFlange
            , sp_AsFnd_PackingGland,sp_AsFnd_BackSeatBushing,sp_AsFnd_Body,sp_AsFnd_Bonnet,sp_AsFnd_SealRingRetainer,sp_AsFnd_PressureSeal
            ,sp_AsFnd_Gaskets,sp_AsFnd_Packing, sp_AsFnd_BonnetBoltingAndNuts,sp_AsFnd_Stem,sp_AsFnd_GateOrDiscOrBall,sp_AsFnd_Seats
            ,sp_AsFnd_SeatRetainer,sp_AsFnd_ThrustRing,sp_AsFnd_SegmentRing, sp_AsFnd_Hinge,sp_AsFnd_HingePin,sp_AsFnd_Spring,
            sp_WD_Inlet,sp_WD_Outlet,sp_WD_HandwheelOrNut,sp_WD_Yoke,sp_WD_StemNutAndHousing,sp_WD_PackingGlandFlange
            , sp_WD_PackingGland,sp_WD_BackSeatBushing,sp_WD_Body,sp_WD_Bonnet,sp_WD_SealRingRetainer,sp_WD_PressureSeal
            ,sp_WD_Gaskets,sp_WD_Packing, sp_WD_BonnetBoltingAndNuts,sp_WD_Stem,sp_WD_GateOrDiscOrBall,sp_WD_Seats
            ,sp_WD_SeatRetainer,sp_WD_ThrustRing,sp_WD_SegmentRing, sp_WD_Hinge,sp_WD_HingePin,sp_WD_Spring;

    String sp_AsFnd_Inletstr,sp_AsFnd_Outletstr,sp_AsFnd_HandwheelOrNutstr,sp_AsFnd_Yokestr,sp_AsFnd_StemNutAndHousingstr,sp_AsFnd_PackingGlandFlangestr,
            sp_AsFnd_PackingGlandstr,sp_AsFnd_BackSeatBushingstr,sp_AsFnd_Bodystr,sp_AsFnd_Bonnetstr,sp_AsFnd_SealRingRetainerstr
            ,sp_AsFnd_PressureSealstr,sp_AsFnd_Gasketsstr,sp_AsFnd_Packingstr, sp_AsFnd_BonnetBoltingAndNutsstr,sp_AsFnd_Stemstr
            ,sp_AsFnd_GateOrDiscOrBallstr,sp_AsFnd_Seatsstr,sp_AsFnd_SeatRetainerstr,sp_AsFnd_ThrustRingstr,sp_AsFnd_SegmentRingstr,
            sp_AsFnd_Hingestr,sp_AsFnd_HingePinstr,sp_AsFnd_Springstr,sp_WD_Inletstr,sp_WD_Outletstr,sp_WD_HandwheelOrNutstr
            ,sp_WD_Yokestr,sp_WD_StemNutAndHousingstr,sp_WD_PackingGlandFlangestr, sp_WD_PackingGlandstr,sp_WD_BackSeatBushingstr
            ,sp_WD_Bodystr,sp_WD_Bonnetstr,sp_WD_SealRingRetainerstr,sp_WD_PressureSealstr,sp_WD_Gasketsstr,sp_WD_Packingstr
            , sp_WD_BonnetBoltingAndNutsstr,sp_WD_Stemstr,sp_WD_GateOrDiscOrBallstr,sp_WD_Seatsstr,sp_WD_SeatRetainerstr
            ,sp_WD_ThrustRingstr,sp_WD_SegmentRingstr, sp_WD_Hingestr,sp_WD_HingePinstr,sp_WD_Springstr;

    AppCompatImageButton btn_AsFnd_Inlet,btn_AsFnd_Outlet,btn_AsFnd_HandwheelOrNut,btn_AsFnd_Yoke,btn_AsFnd_StemNutAndHousing
            ,btn_AsFnd_PackingGlandFlange, btn_AsFnd_PackingGland,btn_AsFnd_BackSeatBushing,btn_AsFnd_Body,btn_AsFnd_Bonnet
            ,btn_AsFnd_SealRingRetainer,btn_AsFnd_PressureSeal,btn_AsFnd_Gaskets,btn_AsFnd_Packing, btn_AsFnd_BonnetBoltingAndNuts
            ,btn_AsFnd_Stem,btn_AsFnd_GateOrDiscOrBall,btn_AsFnd_Seats,btn_AsFnd_SeatRetainer,btn_AsFnd_ThrustRing,btn_AsFnd_SegmentRing
            ,btn_AsFnd_Hinge,btn_AsFnd_HingePin,btn_AsFnd_Spring, btn_WD_Inlet,btn_WD_Outlet,btn_WD_HandwheelOrNut,btn_WD_Yoke
            ,btn_WD_StemNutAndHousing,btn_WD_PackingGlandFlange,btn_WD_PackingGland,btn_WD_BackSeatBushing,btn_WD_Body,btn_WD_Bonnet
            ,btn_WD_SealRingRetainer,btn_WD_PressureSeal,btn_WD_Gaskets,btn_WD_Packing, btn_WD_BonnetBoltingAndNuts,btn_WD_Stem
            ,btn_WD_GateOrDiscOrBall,btn_WD_Seats,btn_WD_SeatRetainer,btn_WD_ThrustRing,btn_WD_SegmentRing, btn_WD_Hinge
            ,btn_WD_HingePin,btn_WD_Spring;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inspection);

        initViews();
        initEventDriven();

    }




    private void initEventDriven() {


      //**Searchable Spinners**//
        spinners();

        //**Camera**//
        takePhoto();


    }

    private void takePhoto() {

        btn_AsFnd_Inlet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivityForResult(new Intent(MediaStore.ACTION_IMAGE_CAPTURE),1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==1&&requestCode==RESULT_OK)
        {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            saveInVecFile(imageBitmap);
        }
    }

    private void spinners() {

        //**inlet**//

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> sp_AsFnd_InletAdapter = ArrayAdapter.createFromResource(getApplicationContext(),
                as_found_code, R.layout.spinner_text);

        // Specify the layout to use when the list of choices appears
        sp_AsFnd_InletAdapter.setDropDownViewResource(R.layout.my_spinner_dropdown_list_item);

        // Apply the spinnerAdapter to the spinner
        sp_AsFnd_Inlet.setAdapter(sp_AsFnd_InletAdapter);


        sp_AsFnd_Inlet.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    ((TextView)sp_AsFnd_Inlet.getSelectedView()).setError("Please select Which problem found in inlet.");
                }else {
                    sp_AsFnd_Inletstr=parent.getItemAtPosition(position).toString();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

                ((TextView)sp_AsFnd_Inlet.getSelectedView()).setError("Please select Which problem found in inlet.");

            }
        });



        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> sp_WD_InletAdapter = ArrayAdapter.createFromResource(getApplicationContext(),
                work_done_codes, R.layout.spinner_text);

        // Specify the layout to use when the list of choices appears
        sp_WD_InletAdapter.setDropDownViewResource(R.layout.my_spinner_dropdown_list_item);

        // Apply the spinnerAdapter to the spinner
        sp_WD_Inlet.setAdapter(sp_WD_InletAdapter);


        sp_WD_Inlet.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){

                    ((TextView)sp_WD_Inlet.getSelectedView()).setError("Please select Which work done in inlet.");

                    sp_AsFnd_Inletstr=parent.getItemAtPosition(position).toString();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

                ((TextView)sp_WD_Inlet.getSelectedView()).setError("Please select Which work done in inlet.");

            }
        });


        //**outlet**//

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> sp_AsFnd_OutletAdapter = ArrayAdapter.createFromResource(getApplicationContext(),
                as_found_code, R.layout.spinner_text);

        // Specify the layout to use when the list of choices appears
        sp_AsFnd_OutletAdapter.setDropDownViewResource(R.layout.my_spinner_dropdown_list_item);

        // Apply the spinnerAdapter to the spinner
        sp_AsFnd_Outlet.setAdapter(sp_AsFnd_OutletAdapter);


        sp_AsFnd_Outlet.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    ((TextView)sp_AsFnd_Outlet.getSelectedView()).setError("Please select Which problem found in outlet.");
                }else {
                    sp_AsFnd_Outletstr=parent.getItemAtPosition(position).toString();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                ((TextView)sp_AsFnd_Outlet.getSelectedView()).setError("Please select Which problem found in outlet.");

            }
        });



        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> sp_WD_OutletAdapter = ArrayAdapter.createFromResource(getApplicationContext(),
                work_done_codes, R.layout.spinner_text);

        // Specify the layout to use when the list of choices appears
        sp_WD_OutletAdapter.setDropDownViewResource(R.layout.my_spinner_dropdown_list_item);

        // Apply the spinnerAdapter to the spinner
        sp_WD_Outlet.setAdapter(sp_WD_InletAdapter);


        sp_WD_Outlet.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    ((TextView)sp_WD_Outlet.getSelectedView()).setError("Please select Which work done in outlet.");
                }else {
                    sp_WD_Outletstr=parent.getItemAtPosition(position).toString();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                ((TextView)sp_WD_Outlet.getSelectedView()).setError("Please select Which work done in outlet.");
            }
        });



        //**HandwheelOrNut**//

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> sp_AsFnd_HandwheelOrNutAdapter = ArrayAdapter.createFromResource(getApplicationContext(),
                as_found_code, R.layout.spinner_text);

        // Specify the layout to use when the list of choices appears
        sp_AsFnd_HandwheelOrNutAdapter.setDropDownViewResource(R.layout.my_spinner_dropdown_list_item);

        // Apply the spinnerAdapter to the spinner
        sp_AsFnd_HandwheelOrNut.setAdapter(sp_AsFnd_HandwheelOrNutAdapter);


        sp_AsFnd_HandwheelOrNut.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    ((TextView)sp_AsFnd_HandwheelOrNut.getSelectedView()).setError("Please select Which problem found in handwheel/nut.");
                }else {
                    sp_AsFnd_HandwheelOrNutstr=parent.getItemAtPosition(position).toString();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

                ((TextView)sp_AsFnd_HandwheelOrNut.getSelectedView()).setError("Please select Which problem found in handwheel/nut.");

            }
        });



        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> sp_WD_HandwheelOrNutAdapter = ArrayAdapter.createFromResource(getApplicationContext(),
                work_done_codes, R.layout.spinner_text);

        // Specify the layout to use when the list of choices appears
        sp_WD_HandwheelOrNutAdapter.setDropDownViewResource(R.layout.my_spinner_dropdown_list_item);

        // Apply the spinnerAdapter to the spinner
        sp_WD_HandwheelOrNut.setAdapter(sp_WD_InletAdapter);


        sp_WD_HandwheelOrNut.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    ((TextView)sp_WD_HandwheelOrNut.getSelectedView()).setError("Please select Which work done in handwheel/nut.");
                }else {
                    sp_WD_HandwheelOrNutstr=parent.getItemAtPosition(position).toString();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                ((TextView)sp_WD_HandwheelOrNut.getSelectedView()).setError("Please select Which work done in handwheel/nut.");
            }
        });


        //**Yoke**//

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> sp_AsFnd_YokeAdapter = ArrayAdapter.createFromResource(getApplicationContext(),
                as_found_code, R.layout.spinner_text);

        // Specify the layout to use when the list of choices appears
        sp_AsFnd_YokeAdapter.setDropDownViewResource(R.layout.my_spinner_dropdown_list_item);

        // Apply the spinnerAdapter to the spinner
        sp_AsFnd_Yoke.setAdapter(sp_AsFnd_YokeAdapter);


        sp_AsFnd_Yoke.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    ((TextView)sp_AsFnd_Yoke.getSelectedView()).setError("Please select Which problem found at yoke.");
                }else {
                    sp_AsFnd_Yokestr=parent.getItemAtPosition(position).toString();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

                ((TextView)sp_AsFnd_Yoke.getSelectedView()).setError("Please select Which problem found at yoke.");

            }
        });



        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> sp_WD_YokeAdapter = ArrayAdapter.createFromResource(getApplicationContext(),
                work_done_codes, R.layout.spinner_text);

        // Specify the layout to use when the list of choices appears
        sp_WD_YokeAdapter.setDropDownViewResource(R.layout.my_spinner_dropdown_list_item);

        // Apply the spinnerAdapter to the spinner
        sp_WD_Yoke.setAdapter(sp_WD_YokeAdapter);


        sp_WD_Yoke.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    ((TextView)sp_WD_Yoke.getSelectedView()).setError("Please select Which work done at yoke.");
                }else {
                    sp_WD_Yokestr=parent.getItemAtPosition(position).toString();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                ((TextView)sp_WD_Yoke.getSelectedView()).setError("Please select Which work done at yoke.");
            }
        });




        //**Stem Nut And Housing**//

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> sp_AsFnd_StemNutAndHousingAdapter = ArrayAdapter.createFromResource(getApplicationContext(),
                as_found_code, R.layout.spinner_text);

        // Specify the layout to use when the list of choices appears
        sp_AsFnd_StemNutAndHousingAdapter.setDropDownViewResource(R.layout.my_spinner_dropdown_list_item);

        // Apply the spinnerAdapter to the spinner
        sp_AsFnd_StemNutAndHousing.setAdapter(sp_AsFnd_StemNutAndHousingAdapter);


        sp_AsFnd_StemNutAndHousing.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    ((TextView)sp_AsFnd_StemNutAndHousing.getSelectedView()).setError("Please select Which problem found in stem nut and housing.");
                }else {
                    sp_AsFnd_StemNutAndHousingstr=parent.getItemAtPosition(position).toString();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                ((TextView)sp_AsFnd_StemNutAndHousing.getSelectedView()).setError("Please select Which problem found in stem nut and housing.");
            }
        });



        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> sp_WD_StemNutAndHousingAdapter = ArrayAdapter.createFromResource(getApplicationContext(),
                work_done_codes, R.layout.spinner_text);

        // Specify the layout to use when the list of choices appears
        sp_WD_StemNutAndHousingAdapter.setDropDownViewResource(R.layout.my_spinner_dropdown_list_item);

        // Apply the spinnerAdapter to the spinner
        sp_WD_StemNutAndHousing.setAdapter(sp_WD_StemNutAndHousingAdapter);


        sp_WD_StemNutAndHousing.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    ((TextView)sp_WD_StemNutAndHousing.getSelectedView()).setError("Please select Which work done in stem nut and housing.");
                }else {
                    sp_WD_StemNutAndHousingstr=parent.getItemAtPosition(position).toString();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                ((TextView)sp_WD_StemNutAndHousing.getSelectedView()).setError("Please select Which work done in stem nut and housing.");
            }
        });



        //**Packing Gland Flange**//

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> sp_AsFnd_PackingGlandFlangeAdapter = ArrayAdapter.createFromResource(getApplicationContext(),
                as_found_code, R.layout.spinner_text);

        // Specify the layout to use when the list of choices appears
        sp_AsFnd_PackingGlandFlangeAdapter.setDropDownViewResource(R.layout.my_spinner_dropdown_list_item);

        // Apply the spinnerAdapter to the spinner
        sp_AsFnd_PackingGlandFlange.setAdapter(sp_AsFnd_PackingGlandFlangeAdapter);


        sp_AsFnd_PackingGlandFlange.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    ((TextView)sp_AsFnd_PackingGlandFlange.getSelectedView()).setError("Please select Which problem found in packing gland flange.");
                }else {
                    sp_AsFnd_PackingGlandFlangestr=parent.getItemAtPosition(position).toString();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                ((TextView)sp_AsFnd_PackingGlandFlange.getSelectedView()).setError("Please select Which problem found in packing gland flange.");

            }
        });



        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> sp_WD_PackingGlandFlangeAdapter = ArrayAdapter.createFromResource(getApplicationContext(),
                work_done_codes, R.layout.spinner_text);

        // Specify the layout to use when the list of choices appears
        sp_WD_PackingGlandFlangeAdapter.setDropDownViewResource(R.layout.my_spinner_dropdown_list_item);

        // Apply the spinnerAdapter to the spinner
        sp_WD_PackingGlandFlange.setAdapter(sp_WD_PackingGlandFlangeAdapter);


        sp_WD_PackingGlandFlange.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    ((TextView)sp_WD_PackingGlandFlange.getSelectedView()).setError("Please select Which work done in packing gland flange.");

                }else {
                    sp_WD_PackingGlandFlangestr=parent.getItemAtPosition(position).toString();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                ((TextView)sp_WD_PackingGlandFlange.getSelectedView()).setError("Please select Which work done in packing gland flange.");

            }
        });




        //**Packing Gland**//

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> sp_AsFnd_PackingGlandAdapter = ArrayAdapter.createFromResource(getApplicationContext(),
                as_found_code, R.layout.spinner_text);

        // Specify the layout to use when the list of choices appears
        sp_AsFnd_PackingGlandAdapter.setDropDownViewResource(R.layout.my_spinner_dropdown_list_item);

        // Apply the spinnerAdapter to the spinner
        sp_AsFnd_PackingGland.setAdapter(sp_AsFnd_PackingGlandAdapter);


        sp_AsFnd_PackingGland.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    ((TextView)sp_AsFnd_PackingGland.getSelectedView()).setError("Please select Which problem found in packing gland.");
                }else {
                    sp_AsFnd_PackingGlandstr=parent.getItemAtPosition(position).toString();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

                ((TextView)sp_AsFnd_PackingGland.getSelectedView()).setError("Please select Which problem found in packing gland.");
            }
        });



        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> sp_WD_PackingGlandAdapter = ArrayAdapter.createFromResource(getApplicationContext(),
                work_done_codes, R.layout.spinner_text);

        // Specify the layout to use when the list of choices appears
        sp_WD_PackingGlandAdapter.setDropDownViewResource(R.layout.my_spinner_dropdown_list_item);

        // Apply the spinnerAdapter to the spinner
        sp_WD_PackingGland.setAdapter(sp_WD_PackingGlandAdapter);


        sp_WD_PackingGland.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    ((TextView)sp_WD_PackingGland.getSelectedView()).setError("Please select Which work done in packing gland.");
                }else {
                    sp_WD_PackingGlandstr=parent.getItemAtPosition(position).toString();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                ((TextView)sp_WD_PackingGland.getSelectedView()).setError("Please select Which work done in packing gland.");
            }
        });




        //** BackSeatBushing**//

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> sp_AsFnd_BackSeatBushingAdapter = ArrayAdapter.createFromResource(getApplicationContext(),
                as_found_code, R.layout.spinner_text);

        // Specify the layout to use when the list of choices appears
        sp_AsFnd_BackSeatBushingAdapter.setDropDownViewResource(R.layout.my_spinner_dropdown_list_item);

        // Apply the spinnerAdapter to the spinner
        sp_AsFnd_BackSeatBushing.setAdapter(sp_AsFnd_BackSeatBushingAdapter);


        sp_AsFnd_BackSeatBushing.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    ((TextView)sp_AsFnd_BackSeatBushing.getSelectedView()).setError("Please select Which problem found in back seat bushing.");
                }else {
                    sp_AsFnd_BackSeatBushingstr=parent.getItemAtPosition(position).toString();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                ((TextView)sp_AsFnd_BackSeatBushing.getSelectedView()).setError("Please select Which problem found in back seat bushing.");
            }
        });



        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> sp_WD_BackSeatBushingAdapter = ArrayAdapter.createFromResource(getApplicationContext(),
                work_done_codes, R.layout.spinner_text);

        // Specify the layout to use when the list of choices appears
        sp_WD_BackSeatBushingAdapter.setDropDownViewResource(R.layout.my_spinner_dropdown_list_item);

        // Apply the spinnerAdapter to the spinner
        sp_WD_BackSeatBushing.setAdapter(sp_WD_BackSeatBushingAdapter);


        sp_WD_BackSeatBushing.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    ((TextView)sp_WD_BackSeatBushing.getSelectedView()).setError("Please select Which work done in back seat bushing.");
                }else {
                    sp_WD_BackSeatBushingstr=parent.getItemAtPosition(position).toString();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                ((TextView)sp_WD_BackSeatBushing.getSelectedView()).setError("Please select Which work done in back seat bushing.");

            }
        });




        //** Body**//

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> sp_AsFnd_BodyAdapter = ArrayAdapter.createFromResource(getApplicationContext(),
                as_found_code, R.layout.spinner_text);

        // Specify the layout to use when the list of choices appears
        sp_AsFnd_BodyAdapter.setDropDownViewResource(R.layout.my_spinner_dropdown_list_item);

        // Apply the spinnerAdapter to the spinner
        sp_AsFnd_Body.setAdapter(sp_AsFnd_BodyAdapter);


        sp_AsFnd_Body.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    ((TextView)sp_AsFnd_Body.getSelectedView()).setError("Please select Which problem found in body.");
                }else {
                    sp_AsFnd_Bodystr=parent.getItemAtPosition(position).toString();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                ((TextView)sp_AsFnd_Body.getSelectedView()).setError("Please select Which problem found in body.");
            }
        });



        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> sp_WD_BodyAdapter = ArrayAdapter.createFromResource(getApplicationContext(),
                work_done_codes, R.layout.spinner_text);

        // Specify the layout to use when the list of choices appears
        sp_WD_BodyAdapter.setDropDownViewResource(R.layout.my_spinner_dropdown_list_item);

        // Apply the spinnerAdapter to the spinner
        sp_WD_Body.setAdapter(sp_WD_BodyAdapter);


        sp_WD_Body.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    ((TextView)sp_WD_Body.getSelectedView()).setError("Please select Which work done in body.");
                }else {
                    sp_WD_Bodystr=parent.getItemAtPosition(position).toString();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                ((TextView)sp_WD_Body.getSelectedView()).setError("Please select Which work done in body.");
            }
        });





        //** Bonnet**//

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> sp_AsFnd_BonnetAdapter = ArrayAdapter.createFromResource(getApplicationContext(),
                as_found_code, R.layout.spinner_text);

        // Specify the layout to use when the list of choices appears
        sp_AsFnd_BonnetAdapter.setDropDownViewResource(R.layout.my_spinner_dropdown_list_item);

        // Apply the spinnerAdapter to the spinner
        sp_AsFnd_Bonnet.setAdapter(sp_AsFnd_BonnetAdapter);


        sp_AsFnd_Bonnet.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    ((TextView)sp_AsFnd_Bonnet.getSelectedView()).setError("Please select Which problem found in bonnet.");
                }else {
                    sp_AsFnd_Bonnetstr=parent.getItemAtPosition(position).toString();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                ((TextView)sp_AsFnd_Bonnet.getSelectedView()).setError("Please select Which problem found in bonnet.");
            }
        });



        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> sp_WD_BonnetAdapter = ArrayAdapter.createFromResource(getApplicationContext(),
                work_done_codes, R.layout.spinner_text);

        // Specify the layout to use when the list of choices appears
        sp_WD_BonnetAdapter.setDropDownViewResource(R.layout.my_spinner_dropdown_list_item);

        // Apply the spinnerAdapter to the spinner
        sp_WD_Bonnet.setAdapter(sp_WD_BonnetAdapter);


        sp_WD_Body.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    ((TextView)sp_WD_Bonnet.getSelectedView()).setError("Please select Which work done in bonnet.");
                }else {
                    sp_WD_Bonnetstr=parent.getItemAtPosition(position).toString();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                ((TextView)sp_WD_Bonnet.getSelectedView()).setError("Please select Which work done in bonnet.");
            }
        });






        //** SealRingRetainer**//

        // Create an ArrayAdapter using the string array and a default spinner layout

        ArrayAdapter<CharSequence> sp_AsFnd_SealRingRetainerAdapter=ArrayAdapter.createFromResource
                (getApplicationContext(),as_found_code,R.layout.spinner_text);

        // Specify the layout to use when the list of choices appears
        sp_AsFnd_SealRingRetainerAdapter.setDropDownViewResource(R.layout.my_spinner_dropdown_list_item);


        // Apply the spinnerAdapter to the spinner
        sp_AsFnd_SealRingRetainer.setAdapter(sp_AsFnd_SealRingRetainerAdapter);


        sp_AsFnd_SealRingRetainer.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    ((TextView)sp_AsFnd_SealRingRetainer.getSelectedView()).setError("Please select Which problem found in seal ring retainer.");
                }else {
                    sp_AsFnd_SealRingRetainerstr=parent.getItemAtPosition(position).toString();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                ((TextView)sp_AsFnd_SealRingRetainer.getSelectedView()).setError("Please select Which problem found in seal ring retainer.");

            }
        });



        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> sp_WD_SealRingRetainerAdapter = ArrayAdapter.createFromResource(getApplicationContext(),
                work_done_codes, R.layout.spinner_text);

        // Specify the layout to use when the list of choices appears
        sp_WD_SealRingRetainerAdapter.setDropDownViewResource(R.layout.my_spinner_dropdown_list_item);

        // Apply the spinnerAdapter to the spinner
        sp_WD_SealRingRetainer.setAdapter(sp_WD_BodyAdapter);


        sp_WD_SealRingRetainer.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    ((TextView)sp_WD_SealRingRetainer.getSelectedView()).setError("Please select Which work done in seal ring retainer.");
                }else {
                    sp_WD_SealRingRetainerstr=parent.getItemAtPosition(position).toString();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                ((TextView)sp_WD_SealRingRetainer.getSelectedView()).setError("Please select Which work done in seal ring retainer.");
            }
        });






        //** PressureSeal**//

        // Create an ArrayAdapter using the string array and a default spinner layout

        ArrayAdapter<CharSequence> sp_AsFnd_PressureSealAdapter=ArrayAdapter.createFromResource(getApplicationContext(),as_found_code,R.layout.spinner_text);

        // Specify the layout to use when the list of choices appears
        sp_AsFnd_PressureSealAdapter.setDropDownViewResource(R.layout.my_spinner_dropdown_list_item);


        // Apply the spinnerAdapter to the spinner
        sp_AsFnd_PressureSeal.setAdapter(sp_AsFnd_PressureSealAdapter);


        sp_AsFnd_PressureSeal.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    ((TextView)sp_AsFnd_PressureSeal.getSelectedView()).setError("Please select Which problem found in pressure seal.");
                }else {
                    sp_AsFnd_PressureSealstr=parent.getItemAtPosition(position).toString();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                ((TextView)sp_AsFnd_PressureSeal.getSelectedView()).setError("Please select Which problem found in pressure seal.");

            }
        });



        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> sp_WD_PressureSealAdapter = ArrayAdapter.createFromResource(getApplicationContext(),
                work_done_codes, R.layout.spinner_text);

        // Specify the layout to use when the list of choices appears
        sp_WD_PressureSealAdapter.setDropDownViewResource(R.layout.my_spinner_dropdown_list_item);

        // Apply the spinnerAdapter to the spinner
        sp_WD_PressureSeal.setAdapter(sp_WD_PressureSealAdapter);


        sp_WD_PressureSeal.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    ((TextView)sp_WD_PressureSeal.getSelectedView()).setError("Please select Which work done in pressure seal.");
                }else {
                    sp_WD_PressureSealstr=parent.getItemAtPosition(position).toString();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                ((TextView)sp_WD_PressureSeal.getSelectedView()).setError("Please select Which work done in pressure seal.");
            }
        });




        //** Gaskets**//

        // Create an ArrayAdapter using the string array and a default spinner layout

        ArrayAdapter<CharSequence> sp_AsFnd_GasketsAdapter=ArrayAdapter.createFromResource(getApplicationContext(),
                as_found_code,R.layout.spinner_text);

        // Specify the layout to use when the list of choices appears
        sp_AsFnd_GasketsAdapter.setDropDownViewResource(R.layout.my_spinner_dropdown_list_item);


        // Apply the spinnerAdapter to the spinner
        sp_AsFnd_Gaskets.setAdapter(sp_AsFnd_GasketsAdapter);


        sp_AsFnd_Gaskets.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    ((TextView)sp_AsFnd_Gaskets.getSelectedView()).setError("Please select Which problem found in gaskets.");
                }else {
                    sp_AsFnd_Gasketsstr=parent.getItemAtPosition(position).toString();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                ((TextView)sp_AsFnd_Gaskets.getSelectedView()).setError("Please select Which problem found in gaskets.");

            }
        });



        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> sp_WD_GasketsAdapter = ArrayAdapter.createFromResource(getApplicationContext(),
                work_done_codes, R.layout.spinner_text);

        // Specify the layout to use when the list of choices appears
        sp_WD_GasketsAdapter.setDropDownViewResource(R.layout.my_spinner_dropdown_list_item);

        // Apply the spinnerAdapter to the spinner
        sp_WD_Gaskets.setAdapter(sp_WD_GasketsAdapter);


        sp_WD_Gaskets.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    ((TextView)sp_WD_Gaskets.getSelectedView()).setError("Please select Which work done in gaskets.");
                }else {
                    sp_WD_Gasketsstr=parent.getItemAtPosition(position).toString();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                ((TextView)sp_WD_Gaskets.getSelectedView()).setError("Please select Which work done in gaskets.");

            }
        });





        //** Packing**//

        // Create an ArrayAdapter using the string array and a default spinner layout

        ArrayAdapter<CharSequence> sp_AsFnd_PackingAdapter=ArrayAdapter.createFromResource(getApplicationContext(),
                as_found_code,R.layout.spinner_text);

        // Specify the layout to use when the list of choices appears
        sp_AsFnd_PackingAdapter.setDropDownViewResource(R.layout.my_spinner_dropdown_list_item);


        // Apply the spinnerAdapter to the spinner
        sp_AsFnd_Packing.setAdapter(sp_AsFnd_PackingAdapter);


        sp_AsFnd_Packing.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    ((TextView)sp_AsFnd_Packing.getSelectedView()).setError("Please select Which problem found in packing.");
                }else {
                    sp_AsFnd_Packingstr=parent.getItemAtPosition(position).toString();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                ((TextView)sp_AsFnd_Packing.getSelectedView()).setError("Please select Which problem found in packing.");

            }
        });



        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> sp_WD_PackingAdapter = ArrayAdapter.createFromResource(getApplicationContext(),
                work_done_codes, R.layout.spinner_text);

        // Specify the layout to use when the list of choices appears
        sp_WD_PackingAdapter.setDropDownViewResource(R.layout.my_spinner_dropdown_list_item);

        // Apply the spinnerAdapter to the spinner
        sp_WD_Packing.setAdapter(sp_WD_PackingAdapter);


        sp_WD_Packing.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    ((TextView)sp_WD_Packing.getSelectedView()).setError("Please select Which work done in Packing.");
                }else {
                    sp_WD_Packingstr=parent.getItemAtPosition(position).toString();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                ((TextView)sp_WD_Packing.getSelectedView()).setError("Please select Which work done in Packing.");

            }
        });





        //** Bonnet Bolting And Nuts**//

        // Create an ArrayAdapter using the string array and a default spinner layout

        ArrayAdapter<CharSequence> sp_AsFnd_BonnetBoltingAndNutsAdapter=ArrayAdapter.createFromResource(getApplicationContext(),
                as_found_code,R.layout.spinner_text);

        // Specify the layout to use when the list of choices appears
        sp_AsFnd_BonnetBoltingAndNutsAdapter.setDropDownViewResource(R.layout.my_spinner_dropdown_list_item);


        // Apply the spinnerAdapter to the spinner
        sp_AsFnd_BonnetBoltingAndNuts.setAdapter(sp_AsFnd_BonnetBoltingAndNutsAdapter);


        sp_AsFnd_BonnetBoltingAndNuts.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    ((TextView)sp_AsFnd_BonnetBoltingAndNuts.getSelectedView()).setError("Please select Which problem found in Bonnet Bolting And Nuts.");
                }else {
                    sp_AsFnd_BonnetBoltingAndNutsstr=parent.getItemAtPosition(position).toString();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                ((TextView)sp_AsFnd_BonnetBoltingAndNuts.getSelectedView()).setError("Please select Which problem found in Bonnet Bolting And Nuts.");

            }
        });



        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> sp_WD_BonnetBoltingAndNutsAdapter = ArrayAdapter.createFromResource(getApplicationContext(),
                work_done_codes, R.layout.spinner_text);

        // Specify the layout to use when the list of choices appears
        sp_WD_BonnetBoltingAndNutsAdapter.setDropDownViewResource(R.layout.my_spinner_dropdown_list_item);

        // Apply the spinnerAdapter to the spinner
        sp_WD_BonnetBoltingAndNuts.setAdapter(sp_WD_PackingAdapter);


        sp_WD_BonnetBoltingAndNuts.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    ((TextView)sp_WD_BonnetBoltingAndNuts.getSelectedView()).setError("Please select Which work done in Bonnet Bolting And Nuts.");
                }else {
                    sp_WD_BonnetBoltingAndNutsstr=parent.getItemAtPosition(position).toString();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                ((TextView)sp_WD_BonnetBoltingAndNuts.getSelectedView()).setError("Please select Which work done in Bonnet Bolting And Nuts.");

            }
        });



        //** Stem**//

        // Create an ArrayAdapter using the string array and a default spinner layout

        ArrayAdapter<CharSequence> sp_AsFnd_StemAdapter=ArrayAdapter.createFromResource(getApplicationContext(),
                as_found_code,R.layout.spinner_text);

        // Specify the layout to use when the list of choices appears
        sp_AsFnd_StemAdapter.setDropDownViewResource(R.layout.my_spinner_dropdown_list_item);


        // Apply the spinnerAdapter to the spinner
        sp_AsFnd_Stem.setAdapter(sp_AsFnd_StemAdapter);


        sp_AsFnd_Stem.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    ((TextView)sp_AsFnd_Stem.getSelectedView()).setError("Please select Which problem found in Stem.");
                }else {
                    sp_AsFnd_Stemstr=parent.getItemAtPosition(position).toString();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                ((TextView)sp_AsFnd_Stem.getSelectedView()).setError("Please select Which problem found in Stem.");

            }
        });



        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> sp_WD_StemAdapter = ArrayAdapter.createFromResource(getApplicationContext(),
                work_done_codes, R.layout.spinner_text);

        // Specify the layout to use when the list of choices appears
        sp_WD_StemAdapter.setDropDownViewResource(R.layout.my_spinner_dropdown_list_item);

        // Apply the spinnerAdapter to the spinner
        sp_WD_Stem.setAdapter(sp_WD_StemAdapter);


        sp_WD_Stem.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    ((TextView)sp_WD_Stem.getSelectedView()).setError("Please select Which work done in Stem.");
                }else {
                    sp_WD_Stemstr=parent.getItemAtPosition(position).toString();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                ((TextView)sp_WD_Stem.getSelectedView()).setError("Please select Which work done in Stem.");

            }
        });



        //** Gate Or Disc Or Ball**//

        // Create an ArrayAdapter using the string array and a default spinner layout

        ArrayAdapter<CharSequence> sp_AsFnd_GateOrDiscOrBallAdapter=ArrayAdapter.createFromResource(getApplicationContext(),
                as_found_code,R.layout.spinner_text);

        // Specify the layout to use when the list of choices appears
        sp_AsFnd_GateOrDiscOrBallAdapter.setDropDownViewResource(R.layout.my_spinner_dropdown_list_item);


        // Apply the spinnerAdapter to the spinner
        sp_AsFnd_GateOrDiscOrBall.setAdapter(sp_AsFnd_GateOrDiscOrBallAdapter);


        sp_AsFnd_GateOrDiscOrBall.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    ((TextView)sp_AsFnd_GateOrDiscOrBall.getSelectedView()).setError("Please select Which problem found in Gate O rDisc Or Ball.");
                }else {
                    sp_AsFnd_GateOrDiscOrBallstr=parent.getItemAtPosition(position).toString();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                ((TextView)sp_AsFnd_GateOrDiscOrBall.getSelectedView()).setError("Please select Which problem found in Gate Or Disc Or Ball.");

            }
        });



        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> sp_WD_GateOrDiscOrBallAdapter = ArrayAdapter.createFromResource(getApplicationContext(),
                work_done_codes, R.layout.spinner_text);

        // Specify the layout to use when the list of choices appears
        sp_WD_GateOrDiscOrBallAdapter.setDropDownViewResource(R.layout.my_spinner_dropdown_list_item);

        // Apply the spinnerAdapter to the spinner
        sp_WD_GateOrDiscOrBall.setAdapter(sp_WD_GateOrDiscOrBallAdapter);


        sp_WD_GateOrDiscOrBall.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    ((TextView)sp_WD_GateOrDiscOrBall.getSelectedView()).setError("Please select Which work done in Gate Or Disc Or Ball.");
                }else {
                    sp_WD_GateOrDiscOrBallstr=parent.getItemAtPosition(position).toString();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                ((TextView)sp_WD_GateOrDiscOrBall.getSelectedView()).setError("Please select Which work done in Gate Or Disc Or Ball.");

            }
        });




        //** Seats**//

        // Create an ArrayAdapter using the string array and a default spinner layout

        ArrayAdapter<CharSequence> sp_AsFnd_SeatsAdapter=ArrayAdapter.createFromResource(getApplicationContext(),
                as_found_code,R.layout.spinner_text);

        // Specify the layout to use when the list of choices appears
        sp_AsFnd_SeatsAdapter.setDropDownViewResource(R.layout.my_spinner_dropdown_list_item);


        // Apply the spinnerAdapter to the spinner
        sp_AsFnd_Seats.setAdapter(sp_AsFnd_SeatsAdapter);


        sp_AsFnd_Seats.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    ((TextView)sp_AsFnd_Seats.getSelectedView()).setError("Please select Which problem found in Seats.");
                }else {
                    sp_AsFnd_Seatsstr=parent.getItemAtPosition(position).toString();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                ((TextView)sp_AsFnd_Seats.getSelectedView()).setError("Please select Which problem found in Seats.");

            }
        });



        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> sp_WD_SeatsAdapter = ArrayAdapter.createFromResource(getApplicationContext(),
                work_done_codes, R.layout.spinner_text);

        // Specify the layout to use when the list of choices appears
        sp_WD_SeatsAdapter.setDropDownViewResource(R.layout.my_spinner_dropdown_list_item);

        // Apply the spinnerAdapter to the spinner
        sp_WD_Seats.setAdapter(sp_WD_SeatsAdapter);


        sp_WD_Seats.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    ((TextView)sp_WD_Seats.getSelectedView()).setError("Please select Which work done in Seats.");
                }else {
                    sp_WD_Seatsstr=parent.getItemAtPosition(position).toString();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                ((TextView)sp_WD_Seats.getSelectedView()).setError("Please select Which work done in Seats.");

            }
        });




        //** Seat Retainer**//

        // Create an ArrayAdapter using the string array and a default spinner layout

        ArrayAdapter<CharSequence> sp_AsFnd_SeatRetainerAdapter=ArrayAdapter.createFromResource(getApplicationContext(),
                as_found_code,R.layout.spinner_text);

        // Specify the layout to use when the list of choices appears
        sp_AsFnd_SeatRetainerAdapter.setDropDownViewResource(R.layout.my_spinner_dropdown_list_item);


        // Apply the spinnerAdapter to the spinner
        sp_AsFnd_SeatRetainer.setAdapter(sp_AsFnd_SeatRetainerAdapter);


        sp_AsFnd_SeatRetainer.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    ((TextView)sp_AsFnd_SeatRetainer.getSelectedView()).setError("Please select Which problem found in Seat Retainer.");
                }else {
                    sp_AsFnd_SeatRetainerstr=parent.getItemAtPosition(position).toString();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                ((TextView)sp_AsFnd_SeatRetainer.getSelectedView()).setError("Please select Which problem found in Seat Retainer.");

            }
        });



        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> sp_WD_SeatRetainerAdapter = ArrayAdapter.createFromResource(getApplicationContext(),
                work_done_codes, R.layout.spinner_text);

        // Specify the layout to use when the list of choices appears
        sp_WD_SeatRetainerAdapter.setDropDownViewResource(R.layout.my_spinner_dropdown_list_item);

        // Apply the spinnerAdapter to the spinner
        sp_WD_SeatRetainer.setAdapter(sp_WD_SeatRetainerAdapter);


        sp_WD_SeatRetainer.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    ((TextView)sp_WD_SeatRetainer.getSelectedView()).setError("Please select Which work done in Seat Retainer.");
                }else {
                    sp_WD_SeatRetainerstr=parent.getItemAtPosition(position).toString();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                ((TextView)sp_WD_SeatRetainer.getSelectedView()).setError("Please select Which work done in Seat Retainer.");

            }
        });




        //** Thrust Ring**//

        // Create an ArrayAdapter using the string array and a default spinner layout

        ArrayAdapter<CharSequence> sp_AsFnd_ThrustRingAdapter=ArrayAdapter.createFromResource(getApplicationContext(),
                as_found_code,R.layout.spinner_text);

        // Specify the layout to use when the list of choices appears
        sp_AsFnd_ThrustRingAdapter.setDropDownViewResource(R.layout.my_spinner_dropdown_list_item);


        // Apply the spinnerAdapter to the spinner
        sp_AsFnd_ThrustRing.setAdapter(sp_AsFnd_ThrustRingAdapter);


        sp_AsFnd_ThrustRing.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    ((TextView)sp_AsFnd_ThrustRing.getSelectedView()).setError("Please select Which problem found in Thrust Ring.");
                }else {
                    sp_AsFnd_ThrustRingstr=parent.getItemAtPosition(position).toString();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                ((TextView)sp_AsFnd_ThrustRing.getSelectedView()).setError("Please select Which problem found in Thrust Ring.");

            }
        });



        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> sp_WD_ThrustRingAdapter = ArrayAdapter.createFromResource(getApplicationContext(),
                work_done_codes, R.layout.spinner_text);

        // Specify the layout to use when the list of choices appears
        sp_WD_ThrustRingAdapter.setDropDownViewResource(R.layout.my_spinner_dropdown_list_item);

        // Apply the spinnerAdapter to the spinner
        sp_WD_ThrustRing.setAdapter(sp_WD_ThrustRingAdapter);


        sp_WD_ThrustRing.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    ((TextView)sp_WD_ThrustRing.getSelectedView()).setError("Please select Which work done in ThrustRing.");
                }else {
                    sp_WD_ThrustRingstr=parent.getItemAtPosition(position).toString();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                ((TextView)sp_WD_ThrustRing.getSelectedView()).setError("Please select Which work done in ThrustRing.");

            }
        });




        //** Segment Ring**//

        // Create an ArrayAdapter using the string array and a default spinner layout

        ArrayAdapter<CharSequence> sp_AsFnd_SegmentRingAdapter=ArrayAdapter.createFromResource(getApplicationContext(),
                as_found_code,R.layout.spinner_text);

        // Specify the layout to use when the list of choices appears
        sp_AsFnd_SegmentRingAdapter.setDropDownViewResource(R.layout.my_spinner_dropdown_list_item);


        // Apply the spinnerAdapter to the spinner
        sp_AsFnd_SegmentRing.setAdapter(sp_AsFnd_SegmentRingAdapter);


        sp_AsFnd_SegmentRing.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    ((TextView)sp_AsFnd_SegmentRing.getSelectedView()).setError("Please select Which problem found in Segment Ring.");
                }else {
                    sp_AsFnd_SegmentRingstr=parent.getItemAtPosition(position).toString();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                ((TextView)sp_AsFnd_SegmentRing.getSelectedView()).setError("Please select Which problem found in Segment Ring.");

            }
        });



        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> sp_WD_SegmentRingAdapter = ArrayAdapter.createFromResource(getApplicationContext(),
                work_done_codes, R.layout.spinner_text);

        // Specify the layout to use when the list of choices appears
        sp_WD_SegmentRingAdapter.setDropDownViewResource(R.layout.my_spinner_dropdown_list_item);

        // Apply the spinnerAdapter to the spinner
        sp_WD_SegmentRing.setAdapter(sp_WD_SegmentRingAdapter);


        sp_WD_SegmentRing.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    ((TextView)sp_WD_SegmentRing.getSelectedView()).setError("Please select Which work done in Segment Ring.");
                }else {
                    sp_WD_SegmentRingstr=parent.getItemAtPosition(position).toString();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                ((TextView)sp_WD_SegmentRing.getSelectedView()).setError("Please select Which work done in Segment Ring.");

            }
        });



        //** Hinge**//

        // Create an ArrayAdapter using the string array and a default spinner layout

        ArrayAdapter<CharSequence> sp_AsFnd_HingeAdapter=ArrayAdapter.createFromResource(getApplicationContext(),
                as_found_code,R.layout.spinner_text);

        // Specify the layout to use when the list of choices appears
        sp_AsFnd_HingeAdapter.setDropDownViewResource(R.layout.my_spinner_dropdown_list_item);


        // Apply the spinnerAdapter to the spinner
        sp_AsFnd_Hinge.setAdapter(sp_AsFnd_HingeAdapter);


        sp_AsFnd_Hinge.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    ((TextView)sp_AsFnd_Hinge.getSelectedView()).setError("Please select Which problem found in Hinge.");
                }else {
                    sp_AsFnd_Hingestr=parent.getItemAtPosition(position).toString();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                ((TextView)sp_AsFnd_Hinge.getSelectedView()).setError("Please select Which problem found in Hinge.");

            }
        });



        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> sp_WD_HingeAdapter = ArrayAdapter.createFromResource(getApplicationContext(),
                work_done_codes, R.layout.spinner_text);

        // Specify the layout to use when the list of choices appears
        sp_WD_HingeAdapter.setDropDownViewResource(R.layout.my_spinner_dropdown_list_item);

        // Apply the spinnerAdapter to the spinner
        sp_WD_Hinge.setAdapter(sp_WD_HingeAdapter);


        sp_WD_Hinge.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    ((TextView)sp_WD_Hinge.getSelectedView()).setError("Please select Which work done in Hinge.");
                }else {
                    sp_WD_Hingestr=parent.getItemAtPosition(position).toString();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                ((TextView)sp_WD_Hinge.getSelectedView()).setError("Please select Which work done in Hinge.");

            }
        });





        //** Hinge Pin**//

        // Create an ArrayAdapter using the string array and a default spinner layout

        ArrayAdapter<CharSequence> sp_AsFnd_HingePinAdapter=ArrayAdapter.createFromResource(getApplicationContext(),
                as_found_code,R.layout.spinner_text);

        // Specify the layout to use when the list of choices appears
        sp_AsFnd_HingePinAdapter.setDropDownViewResource(R.layout.my_spinner_dropdown_list_item);


        // Apply the spinnerAdapter to the spinner
        sp_AsFnd_HingePin.setAdapter(sp_AsFnd_HingeAdapter);


        sp_AsFnd_HingePin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    ((TextView)sp_AsFnd_HingePin.getSelectedView()).setError("Please select Which problem found in Hinge Pin.");
                }else {
                    sp_AsFnd_HingePinstr=parent.getItemAtPosition(position).toString();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                ((TextView)sp_AsFnd_HingePin.getSelectedView()).setError("Please select Which problem found in Hinge Pin.");

            }
        });



        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> sp_WD_HingePinAdapter = ArrayAdapter.createFromResource(getApplicationContext(),
                work_done_codes, R.layout.spinner_text);

        // Specify the layout to use when the list of choices appears
        sp_WD_HingePinAdapter.setDropDownViewResource(R.layout.my_spinner_dropdown_list_item);

        // Apply the spinnerAdapter to the spinner
        sp_WD_HingePin.setAdapter(sp_WD_HingeAdapter);


        sp_WD_HingePin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    ((TextView)sp_WD_HingePin.getSelectedView()).setError("Please select Which work done in Hinge Pin.");
                }else {
                    sp_WD_HingePinstr=parent.getItemAtPosition(position).toString();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                ((TextView)sp_WD_HingePin.getSelectedView()).setError("Please select Which work done in Hinge Pin.");

            }
        });



        //** Spring**//

        // Create an ArrayAdapter using the string array and a default spinner layout

        ArrayAdapter<CharSequence> sp_AsFnd_SpringAdapter=ArrayAdapter.createFromResource(getApplicationContext(),
                as_found_code,R.layout.spinner_text);

        // Specify the layout to use when the list of choices appears
        sp_AsFnd_SpringAdapter.setDropDownViewResource(R.layout.my_spinner_dropdown_list_item);


        // Apply the spinnerAdapter to the spinner
        sp_AsFnd_Spring.setAdapter(sp_AsFnd_SpringAdapter);


        sp_AsFnd_Spring.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    ((TextView)sp_AsFnd_Spring.getSelectedView()).setError("Please select Which problem found in Spring.");
                }else {
                    sp_AsFnd_Springstr=parent.getItemAtPosition(position).toString();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                ((TextView)sp_AsFnd_Spring.getSelectedView()).setError("Please select Which problem found in Spring.");

            }
        });



        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> sp_WD_SpringAdapter = ArrayAdapter.createFromResource(getApplicationContext(),
                work_done_codes, R.layout.spinner_text);

        // Specify the layout to use when the list of choices appears
        sp_WD_SpringAdapter.setDropDownViewResource(R.layout.my_spinner_dropdown_list_item);

        // Apply the spinnerAdapter to the spinner
        sp_WD_Spring.setAdapter(sp_WD_SpringAdapter);


        sp_WD_Spring.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    ((TextView)sp_WD_Spring.getSelectedView()).setError("Please select Which work done in Spring.");
                }else {
                    sp_WD_Springstr=parent.getItemAtPosition(position).toString();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                ((TextView)sp_WD_Spring.getSelectedView()).setError("Please select Which work done in Spring.");

            }
        });
    }

    private void initViews() {

        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



               sp_AsFnd_Inlet=(SearchableSpinner)findViewById(R.id.sp_asfnd_inlet);
               sp_AsFnd_Outlet =(SearchableSpinner)findViewById(R.id.sp_asfnd_outlet);
               sp_AsFnd_HandwheelOrNut=(SearchableSpinner)findViewById(R.id.sp_asfnd_handwheelOrnut);
               sp_AsFnd_Yoke=(SearchableSpinner)findViewById(R.id.sp_asfnd_yoke);
               sp_AsFnd_StemNutAndHousing=(SearchableSpinner)findViewById(R.id.sp_asfnd_stemnutAndhousing);
               sp_AsFnd_PackingGlandFlange=(SearchableSpinner)findViewById(R.id.sp_asfnd_packingglandflange);
               sp_AsFnd_PackingGland=(SearchableSpinner)findViewById(R.id.sp_asfnd_packinggland);
               sp_AsFnd_BackSeatBushing=(SearchableSpinner)findViewById(R.id.sp_asfnd_backseatbushing);
               sp_AsFnd_Body=(SearchableSpinner)findViewById(R.id.sp_asfnd_body);
               sp_AsFnd_Bonnet=(SearchableSpinner)findViewById(R.id.sp_asfnd_bonnet);
               sp_AsFnd_SealRingRetainer=(SearchableSpinner)findViewById(R.id.sp_asfnd_seatretainer);
               sp_AsFnd_PressureSeal=(SearchableSpinner)findViewById(R.id.sp_asfnd_pressureseal);
                sp_AsFnd_Gaskets=(SearchableSpinner)findViewById(R.id.sp_asfnd_gaskets);
                sp_AsFnd_Packing=(SearchableSpinner)findViewById(R.id.sp_asfnd_packing);
                sp_AsFnd_BonnetBoltingAndNuts=(SearchableSpinner)findViewById(R.id.sp_asfnd_bonnetboltingandnuts);
                sp_AsFnd_Stem=(SearchableSpinner)findViewById(R.id.sp_asfnd_stem);
                sp_AsFnd_GateOrDiscOrBall=(SearchableSpinner)findViewById(R.id.sp_asfnd_gateOrdiskOrball);
                sp_AsFnd_Seats=(SearchableSpinner)findViewById(R.id.sp_asfnd_seats);
                sp_AsFnd_SeatRetainer=(SearchableSpinner)findViewById(R.id.sp_asfnd_seatretainer);
                sp_AsFnd_ThrustRing=(SearchableSpinner)findViewById(R.id.sp_asfnd_thrustring);
                sp_AsFnd_SegmentRing=(SearchableSpinner)findViewById(R.id.sp_asfnd_segmentring);
                sp_AsFnd_Hinge=(SearchableSpinner)findViewById(R.id.sp_asfnd_hinge);
                sp_AsFnd_HingePin=(SearchableSpinner)findViewById(R.id.sp_asfnd_hingepin);
                sp_AsFnd_Spring=(SearchableSpinner)findViewById(R.id.sp_asfnd_spring);
                sp_WD_Inlet=(SearchableSpinner)findViewById(R.id.sp_wd_inlet);
                sp_WD_Outlet=(SearchableSpinner)findViewById(R.id.sp_wd_outlet);
                sp_WD_HandwheelOrNut=(SearchableSpinner)findViewById(R.id.sp_wd_handwwheelOrnut);
                sp_WD_Yoke=(SearchableSpinner)findViewById(R.id.sp_wd_yoke);
                sp_WD_StemNutAndHousing=(SearchableSpinner)findViewById(R.id.sp_wd_stemnutAndhousing);
                sp_WD_PackingGlandFlange=(SearchableSpinner)findViewById(R.id.sp_wd_packingglandflange);
                sp_WD_PackingGland=(SearchableSpinner)findViewById(R.id.sp_wd_packinggland);
                sp_WD_BackSeatBushing=(SearchableSpinner)findViewById(R.id.sp_wd_backseatbushing);
                sp_WD_Body=(SearchableSpinner)findViewById(R.id.sp_wd_body);
                sp_WD_Bonnet=(SearchableSpinner)findViewById(R.id.sp_wd_bonnet);
                sp_WD_SealRingRetainer=(SearchableSpinner)findViewById(R.id.sp_wd_sealringretainer);
                sp_WD_PressureSeal=(SearchableSpinner)findViewById(R.id.sp_wd_pressureseal);
                sp_WD_Gaskets=(SearchableSpinner)findViewById(R.id.sp_wd_gaskets);
                sp_WD_Packing=(SearchableSpinner)findViewById(R.id.sp_wd_packing);
                sp_WD_BonnetBoltingAndNuts=(SearchableSpinner)findViewById(R.id.sp_wd_bonnetboltingandnuts);
                sp_WD_Stem=(SearchableSpinner)findViewById(R.id.sp_wd_stem);
                sp_WD_GateOrDiscOrBall=(SearchableSpinner)findViewById(R.id.sp_wd_gatOrdiskOrball);
                sp_WD_Seats=(SearchableSpinner)findViewById(R.id.sp_wd_seats);
                sp_WD_SeatRetainer=(SearchableSpinner)findViewById(R.id.sp_wd_seatretainer);
                sp_WD_ThrustRing=(SearchableSpinner)findViewById(R.id.sp_wd_thrustring);
                sp_WD_SegmentRing=(SearchableSpinner)findViewById(R.id.sp_wd_segmentring);
                sp_WD_Hinge=(SearchableSpinner)findViewById(R.id.sp_wd_hinge);
                sp_WD_HingePin=(SearchableSpinner)findViewById(R.id.sp_wd_hingepin);
                sp_WD_Spring=(SearchableSpinner)findViewById(R.id.sp_wd_spring);




        btn_AsFnd_Inlet=(AppCompatImageButton)findViewById(R.id.btn_asfnd_inlet);
        btn_AsFnd_Outlet =(AppCompatImageButton)findViewById(R.id.btn_asfnd_outlet);
        btn_AsFnd_HandwheelOrNut=(AppCompatImageButton)findViewById(R.id.btn_asfnd_handwheelOrnut);
        btn_AsFnd_Yoke=(AppCompatImageButton)findViewById(R.id.btn_asfnd_yoke);
        btn_AsFnd_StemNutAndHousing=(AppCompatImageButton)findViewById(R.id.btn_asfnd_stemnutAndhousing);
        btn_AsFnd_PackingGlandFlange=(AppCompatImageButton)findViewById(R.id.btn_asfnd_packingglandflange);
        btn_AsFnd_PackingGland=(AppCompatImageButton)findViewById(R.id.btn_asfnd_packinggland);
        btn_AsFnd_BackSeatBushing=(AppCompatImageButton)findViewById(R.id.btn_asfnd_backseatbushing);
        btn_AsFnd_Body=(AppCompatImageButton)findViewById(R.id.btn_asfnd_body);
        btn_AsFnd_Bonnet=(AppCompatImageButton)findViewById(R.id.btn_asfnd_bonnet);
        btn_AsFnd_SealRingRetainer=(AppCompatImageButton)findViewById(R.id.btn_asfnd_seatretainer);
        btn_AsFnd_PressureSeal=(AppCompatImageButton)findViewById(R.id.btn_asfnd_pressureseal);
        btn_AsFnd_Gaskets=(AppCompatImageButton)findViewById(R.id.btn_asfnd_gaskets);
        btn_AsFnd_Packing=(AppCompatImageButton)findViewById(R.id.btn_asfnd_packing);
        btn_AsFnd_BonnetBoltingAndNuts=(AppCompatImageButton)findViewById(R.id.btn_asfnd_bonnetboltingandnuts);
        btn_AsFnd_Stem=(AppCompatImageButton)findViewById(R.id.btn_asfnd_stem);
        btn_AsFnd_GateOrDiscOrBall=(AppCompatImageButton)findViewById(R.id.btn_asfnd_gateOrdiskOrball);
        btn_AsFnd_Seats=(AppCompatImageButton)findViewById(R.id.btn_asfnd_seats);
        btn_AsFnd_SeatRetainer=(AppCompatImageButton)findViewById(R.id.btn_asfnd_seatretainer);
        btn_AsFnd_ThrustRing=(AppCompatImageButton)findViewById(R.id.btn_asfnd_thrustring);
        btn_AsFnd_SegmentRing=(AppCompatImageButton)findViewById(R.id.btn_asfnd_segmentring);
        btn_AsFnd_Hinge=(AppCompatImageButton)findViewById(R.id.btn_asfnd_hinge);
        btn_AsFnd_HingePin=(AppCompatImageButton)findViewById(R.id.btn_asfnd_hingepin);
        btn_AsFnd_Spring=(AppCompatImageButton)findViewById(R.id.btn_asfnd_spring);
        btn_WD_Inlet=(AppCompatImageButton)findViewById(R.id.btn_wd_inlet);
        btn_WD_Outlet=(AppCompatImageButton)findViewById(R.id.btn_wd_outlet);
        btn_WD_HandwheelOrNut=(AppCompatImageButton)findViewById(R.id.btn_wd_handwheelOrnut);
        btn_WD_Yoke=(AppCompatImageButton)findViewById(R.id.btn_wd_yoke);
        btn_WD_StemNutAndHousing=(AppCompatImageButton)findViewById(R.id.btn_wd_stemnutAndhousing);
        btn_WD_PackingGlandFlange=(AppCompatImageButton)findViewById(R.id.btn_wd_packingglandflange);
        btn_WD_PackingGland=(AppCompatImageButton)findViewById(R.id.btn_wd_packinggland);
        btn_WD_BackSeatBushing=(AppCompatImageButton)findViewById(R.id.btn_wd_backseatbushing);
        btn_WD_Body=(AppCompatImageButton)findViewById(R.id.btn_wd_body);
        btn_WD_Bonnet=(AppCompatImageButton)findViewById(R.id.btn_wd_bonnet);
        btn_WD_SealRingRetainer=(AppCompatImageButton)findViewById(R.id.btn_wd_sealringretainer);
        btn_WD_PressureSeal=(AppCompatImageButton)findViewById(R.id.btn_wd_pressureseal);
        btn_WD_Gaskets=(AppCompatImageButton)findViewById(R.id.btn_wd_gaskets);
        btn_WD_Packing=(AppCompatImageButton)findViewById(R.id.btn_wd_packing);
        btn_WD_BonnetBoltingAndNuts=(AppCompatImageButton)findViewById(R.id.btn_wd_bonnetboltingandnuts);
        btn_WD_Stem=(AppCompatImageButton)findViewById(R.id.btn_wd_stem);
        btn_WD_GateOrDiscOrBall=(AppCompatImageButton)findViewById(R.id.btn_wd_gateOrdiskOrball);
        btn_WD_Seats=(AppCompatImageButton)findViewById(R.id.btn_wd_seats);
        btn_WD_SeatRetainer=(AppCompatImageButton)findViewById(R.id.btn_wd_seatretainer);
        btn_WD_ThrustRing=(AppCompatImageButton)findViewById(R.id.btn_wd_thrustring);
        btn_WD_SegmentRing=(AppCompatImageButton)findViewById(R.id.btn_wd_segmentring);
        btn_WD_Hinge=(AppCompatImageButton)findViewById(R.id.btn_wd_hinge);
        btn_WD_HingePin=(AppCompatImageButton)findViewById(R.id.btn_wd_hingepin);
        btn_WD_Spring=(AppCompatImageButton)findViewById(R.id.btn_wd_spring);



    }


    public void permissionCheck() {
        if (ActivityCompat.checkSelfPermission(this
                , Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);
                return;
            }
        }

       // saveInVecFile();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults)
    { super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==100 && grantResults[0]==PackageManager.PERMISSION_GRANTED)
        {} //saveInVecFile();// }
        else
            { permissionCheck(); }
    }



        String currentPhotoPath;

        private File createImageFile(){
            // Create an image file name
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String imageFileName = "JPEG_" + timeStamp + "_";
            File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
            File image = null;
            try {
                image = File.createTempFile(
                        imageFileName,  /* prefix */
                        ".jpg",         /* suffix */
                        storageDir      /* directory */
                );
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Save a file: path for use with ACTION_VIEW intents
            currentPhotoPath = image.getAbsolutePath();
            return image;
        }



    private void saveInVecFile(Bitmap bitmap)
        {
           // BitmapDrawable drawable=(BitmapDrawable)imag



        }

    public void setSupportActionBar(Toolbar supportActionBar) {
        this.supportActionBar = supportActionBar;
    }
}