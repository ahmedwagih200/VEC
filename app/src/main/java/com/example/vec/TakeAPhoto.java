package com.example.vec;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Environment;
import android.provider.MediaStore;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Calendar;

public class TakeAPhoto {


    Activity takeAPhptoActivity;

    TakeAPhoto(Activity takeAPhptoActivity) {
        this.takeAPhptoActivity = takeAPhptoActivity;
    }


    public void startTakeAPhoto() {
        int requestCodePhoto = 1;

        Intent takeAPhotoIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        takeAPhptoActivity.startActivityForResult(takeAPhotoIntent, requestCodePhoto);


    }




      public void  savingPhoto(Bitmap bitmap){


        try{


          ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
          bitmap.compress(Bitmap.CompressFormat.JPEG ,100,byteArrayOutputStream);

          Calendar calendar=Calendar.getInstance();
          String strFileName = "vec_"
                            + String.valueOf(calendar.YEAR)+String.valueOf(calendar.MONTH)
                            +String.valueOf(calendar.DAY_OF_MONTH)+String.valueOf(calendar.getTimeInMillis())+".jpg";


          File vecPicturesdir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
          new File(vecPicturesdir + "/VEC Pictures").mkdirs();

          File outputFile =new File(vecPicturesdir+"/VEC Pictures/",strFileName);
          FileOutputStream fileOutputStream=new FileOutputStream(outputFile);
          fileOutputStream.write(byteArrayOutputStream.toByteArray());
          fileOutputStream.close();


    }catch (Exception e){
        }
      }



}