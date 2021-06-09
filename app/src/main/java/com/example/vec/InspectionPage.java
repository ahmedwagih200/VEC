package com.example.vec;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.FileProvider;
import androidx.databinding.DataBindingUtil;

import com.example.vec.adpaters.InspectionAdapter;
import com.example.vec.adpaters.TakePhotoAtMainActivity;
import com.example.vec.databinding.ActivityInspectionPageBinding;
import com.example.vec.models.InspectionModel;
import com.nabinbhandari.android.permissions.PermissionHandler;
import com.nabinbhandari.android.permissions.Permissions;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class InspectionPage extends AppCompatActivity implements TakePhotoAtMainActivity {

    public static final int MEDIA_TYPE_IMAGE = 1;
    public static final int MEDIA_TYPE_VIDEO = 2;
    static final int REQUEST_IMAGE_CAPTURE = 1;
    ActivityInspectionPageBinding binding;
    InspectionAdapter inspectionAdapter;
    String currentPhotoPath;
    int Code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inspection_page);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_inspection_page);

        inspectionAdapter = new InspectionAdapter(this, this);
        binding.inspectionRecyclerView.setAdapter(inspectionAdapter);
        inspectionAdapter.setList(getInspectionObject());

        binding.button.setOnClickListener(view -> {

            Observable<Integer> observable = Observable
                    .range(0,1)
                    .subscribeOn(Schedulers.io())
                    .map((Function<Integer, Integer>) integer -> {
                        System.out.println("here"+Thread.currentThread().getName());
                        createPdf(inspectionAdapter.inspectionList);
                        return null;
                    })
                    .observeOn(AndroidSchedulers.mainThread());
            observable.subscribe(new Observer<Integer>() {
                @Override
                public void onSubscribe(@NonNull Disposable d) {

                }

                @Override
                public void onNext(@NonNull Integer integer) {

                }

                @Override
                public void onError(@NonNull Throwable e) {

                }

                @Override
                public void onComplete() {

                }
            });
            });
        }

    ArrayList<InspectionModel> getInspectionObject() {
        ArrayList<InspectionModel> list = new ArrayList<>();
        list.add(new InspectionModel("InLet", "", "", problemSpinner(), solutionSpinner()));
        list.add(new InspectionModel("OutLet", "", "", problemSpinner(), solutionSpinner()));
        list.add(new InspectionModel("HandWheel/nut", "", "", problemSpinner(), solutionSpinner()));
//        list.add(new InspectionModel("Yoke","","",problemSpinner(),solutionSpinner()));
//        list.add(new InspectionModel("Stem nut and Housing","","",problemSpinner(),solutionSpinner()));
//        list.add(new InspectionModel("Packing gland flange","","",problemSpinner(),solutionSpinner()));
//        list.add(new InspectionModel("Packing gland","","",problemSpinner(),solutionSpinner()));
//        list.add(new InspectionModel("Back seat bushing","","",problemSpinner(),solutionSpinner()));
//        list.add(new InspectionModel("Body","","",problemSpinner(),solutionSpinner()));
//        list.add(new InspectionModel("Bonnet","","",problemSpinner(),solutionSpinner()));
//        list.add(new InspectionModel("Seal ring retainer","","",problemSpinner(),solutionSpinner()));
//        list.add(new InspectionModel("Pressure seal","","",problemSpinner(),solutionSpinner()));
//        list.add(new InspectionModel("Gaskets","","",problemSpinner(),solutionSpinner()));
//        list.add(new InspectionModel("Packing","","",problemSpinner(),solutionSpinner()));
//        list.add(new InspectionModel("Bonnet bolting and nuts","","",problemSpinner(),solutionSpinner()));
//        list.add(new InspectionModel("Stem","","",problemSpinner(),solutionSpinner()));
//        list.add(new InspectionModel("Gate/Disk/Ball/Plug","","",problemSpinner(),solutionSpinner()));
//        list.add(new InspectionModel("Seats","","",problemSpinner(),solutionSpinner()));
//        list.add(new InspectionModel("Seat retainer","","",problemSpinner(),solutionSpinner()));
//        list.add(new InspectionModel("Thrust ring","","",problemSpinner(),solutionSpinner()));
//        list.add(new InspectionModel("Segment ring","","",problemSpinner(),solutionSpinner()));
//        list.add(new InspectionModel("Hinge","","",problemSpinner(),solutionSpinner()));
//        list.add(new InspectionModel("Hinge pin","","",problemSpinner(),solutionSpinner()));
//        list.add(new InspectionModel("Spring","","",problemSpinner(),solutionSpinner()));
        return list;
    }

    ArrayList<String> solutionSpinner() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Clean");
        arrayList.add("Clean and paint");
        arrayList.add("Lapped");
        arrayList.add("Machine");
        arrayList.add("Machine and lap");
        arrayList.add("Replace");
        arrayList.add("Replace gasket");
        arrayList.add("Weld and Machine");
        arrayList.add("Not included");
        return arrayList;
    }

    ArrayList<String> problemSpinner() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Bent");
        arrayList.add("Broken");
        arrayList.add("Collapsed");
        arrayList.add("Corroded");
        arrayList.add("Cracked");
        arrayList.add("Cut");
        arrayList.add("Frozen");
        arrayList.add("Galled");
        arrayList.add("Incorrect");
        arrayList.add("Missing");
        arrayList.add("Acceptable");
        arrayList.add("Out of tolerance");
        arrayList.add("Pitted");
        arrayList.add("Plugged");
        arrayList.add("Stripped");
        arrayList.add("Worn");
        arrayList.add("Not included");
        return arrayList;
    }

    @Override
    public void whenUserClick(int CODE) {
        Permissions.check(this, Manifest.permission.WRITE_EXTERNAL_STORAGE, null, new PermissionHandler() {
            @Override
            public void onGranted() {
                Code= CODE;
                dispatchTakePictureIntent();
            }
        });
    }

    @SuppressLint("QueryPermissionsNeeded")
    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Ensure that there's a camera activity to handle the intent
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            // Create the File where the photo should go
            File photoFile;
            photoFile = getOutputMediaFile();
            // Continue only if the File was successfully created
            if (photoFile != null) {
                Uri photoURI = FileProvider.getUriForFile(this,
                        "com.example.vec.fileprovider",
                        photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
            }
        }
    }

    File getOutputMediaFile() {
        // To be safe, you should check that the SDCard is mounted
        // using Environment.getExternalStorageState() before doing this.
        @SuppressWarnings("deprecation") File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), "MyCameraApp");
        // This location works best if you want the created images to be shared
        // between applications and persist after your app has been uninstalled.
        // Create the storage directory if it does not exist
        if (!mediaStorageDir.exists()) {
            if (!mediaStorageDir.mkdirs()) {
                Log.d("MyCameraApp", "failed to create directory");
                return null;
            }
        }
        // Create a media file name
        @SuppressLint("SimpleDateFormat") String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File mediaFile;
        if (1 == MEDIA_TYPE_IMAGE) {
            mediaFile = new File(mediaStorageDir.getPath() + File.separator +
                    "IMG_" + timeStamp + ".jpg");
        } else if (1 == MEDIA_TYPE_VIDEO) {
            mediaFile = new File(mediaStorageDir.getPath() + File.separator +
                    "VID_" + timeStamp + ".mp4");
        } else {
            return null;
        }
        currentPhotoPath = mediaFile.getAbsolutePath();
        return mediaFile;
    }

    private void galleryAddPic() {
        @SuppressWarnings("deprecation") Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        File f = new File(currentPhotoPath);
        Uri contentUri = Uri.fromFile(f);
        mediaScanIntent.setData(contentUri);
        this.sendBroadcast(mediaScanIntent);

        if(Code == 1 ){
            inspectionAdapter.setImageDataProblem(currentPhotoPath);

        }else{
            inspectionAdapter.setImageDataSol(currentPhotoPath);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        galleryAddPic();
        //Bitmap imageBitmap = BitmapFactory.decodeFile(currentPhotoPath);
        //inspectionAdapter.setImageData(currentPhotoPath);
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void createPdf(ArrayList<InspectionModel> inspectionList) {
        // create a new document
        PdfDocument document = new PdfDocument();
        // crate a page description
        PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder(300, 800, 1).create();
        // start a page
        PdfDocument.Page page = document.startPage(pageInfo);
        Canvas canvas = page.getCanvas();
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setTextSize(22f);

        Bitmap bitmap, scaledBitmap;

        int y = 20;
        for (InspectionModel list : inspectionList) {
            canvas.drawText(list.getProblemSpinnerData(), 20, y, paint);

            bitmap = BitmapFactory.decodeFile(list.getProblemImagePath());
            scaledBitmap = Bitmap.createScaledBitmap(bitmap, 200, 200, false);
            canvas.drawBitmap(scaledBitmap, 20, y, paint);
            y = y + 220;
        }
        // finish the page
        document.finishPage(page);
        // Create Page 2
        pageInfo = new PdfDocument.PageInfo.Builder(300, 600, 2).create();
        page = document.startPage(pageInfo);
        canvas = page.getCanvas();
        paint = new Paint();
        paint.setColor(Color.BLUE);
        canvas.drawCircle(100, 100, 100, paint);
        document.finishPage(page);

        // write the document content
        @SuppressWarnings("deprecation") String directory_path = Environment.getExternalStorageDirectory().getPath() + "/myPDF/";
        File file = new File(directory_path);
        if (!file.exists()) {
            //noinspection ResultOfMethodCallIgnored
            file.mkdirs();
        }
        String targetPdf = directory_path + "NewPDF.pdf";
        File filePath = new File(targetPdf);
        try {
            document.writeTo(new FileOutputStream(filePath));
            Toast.makeText(this, "Done", Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            Log.e("main", "error " + e.toString());
            Toast.makeText(this, "Something wrong: " + e.toString(), Toast.LENGTH_LONG).show();
        }
        // close the document
        document.close();
    }

}
