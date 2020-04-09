package com.adarsh.smartinventory;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.adarsh.smartinventory.Model.QrRequestModel;
import com.adarsh.smartinventory.Model.QrResponseModel;
import com.adarsh.smartinventory.Model.ShopRegResponse;
import com.adarsh.smartinventory.Model.ShopRegistrationRequest;
import com.adarsh.smartinventory.Retro.Api;
import com.adarsh.smartinventory.Retro.Api_client;
import com.google.android.material.button.MaterialButton;
import com.google.gson.Gson;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QrGeneration extends AppCompatActivity implements View.OnClickListener {

    public final static int QRcodeWidth = 500 ;
    private static final String IMAGE_DIRECTORY = "/QRcodeDemonuts";
    Bitmap bitmap ;
    private EditText etqr;
    private ImageView iv;
    private Button btn;
    int staffid;
    String product,cuscode;
    String Json;
    RequestBody requestBody=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr);

        iv = (ImageView) findViewById(R.id.iv);
        etqr = (EditText) findViewById(R.id.etqr);
        SharedPreferences sp=getApplicationContext().getSharedPreferences("pref",MODE_PRIVATE);
        product=sp.getString("pro_name",null);
        SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("customer", Context.MODE_PRIVATE);
        cuscode=sharedPreferences.getString("customer_code",null);
        SharedPreferences sPreferences=getApplicationContext().getSharedPreferences("staffpref",MODE_PRIVATE);
        staffid=sPreferences.getInt("staffid",0);

        MaterialButton blue = findViewById(R.id.blue);
        blue.setOnClickListener(this); // calling onClick() method
        MaterialButton red = findViewById(R.id.red);
        red.setOnClickListener(this);
        MaterialButton green =  findViewById(R.id.green);
        green.setOnClickListener(this);
        MaterialButton pink = findViewById(R.id.pink);
        pink.setOnClickListener(this); // calling onClick() method
        MaterialButton violet = findViewById(R.id.violet);
        violet.setOnClickListener(this);
        MaterialButton yellow =  findViewById(R.id.yellow);
        yellow.setOnClickListener(this);
    }
    public void saveQrDetails(String details)
    {
        final Api api = Api_client.SmartInventory().create(Api.class);
        QrRequestModel qrRequestModel = new QrRequestModel();

        qrRequestModel.setCustomer_code(cuscode);
        qrRequestModel.setEmployee_id(staffid);
        qrRequestModel.setProduct_name(product);
        qrRequestModel.setQrcode(details);

        Gson gson = new Gson();
        Json = gson.toJson(qrRequestModel).trim();
        try {
            requestBody = RequestBody.create(MediaType.parse("application/json"), Json.getBytes("UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(QrGeneration.this, "" + e, Toast.LENGTH_SHORT).show();
        }

        api.QR_RESPONSE_MODEL_CALL(requestBody).enqueue(new Callback<QrResponseModel>() {
            @Override
            public void onResponse(Call<QrResponseModel> call, Response<QrResponseModel> response) {
                QrResponseModel qrResponseModel=response.body();
                if(qrResponseModel==null)
                {
                    Toast.makeText(QrGeneration.this, "failed", Toast.LENGTH_SHORT).show();
                }
                else if(qrResponseModel.getStatus().equalsIgnoreCase("success"))
                {
                    Toast.makeText(QrGeneration.this, qrResponseModel.getStatus(), Toast.LENGTH_SHORT).show();

                }
                else
                {
                    Toast.makeText(QrGeneration.this, "Failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<QrResponseModel> call, Throwable t) {
                Toast.makeText(QrGeneration.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    public String saveImage(Bitmap myBitmap) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        myBitmap.compress(Bitmap.CompressFormat.JPEG, 90, bytes);
        File wallpaperDirectory = new File(
                Environment.getExternalStorageDirectory() + IMAGE_DIRECTORY);
        // have the object build the directory structure, if needed.

        if (!wallpaperDirectory.exists()) {
            Log.d("dirrrrrr", "" + wallpaperDirectory.mkdirs());
            wallpaperDirectory.mkdirs();
        }

        try {
            File f = new File(wallpaperDirectory, Calendar.getInstance()
                    .getTimeInMillis() + ".jpg");
            f.createNewFile();   //give read write permission
            FileOutputStream fo = new FileOutputStream(f);
            fo.write(bytes.toByteArray());
            MediaScannerConnection.scanFile(this,
                    new String[]{f.getPath()},
                    new String[]{"image/jpeg"}, null);
            fo.close();
            Log.d("TAG", "File Saved::--->" + f.getAbsolutePath());

            return f.getAbsolutePath();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return "";

    }
    private Bitmap TextToImageEncode(String Value,int color) throws WriterException {
        BitMatrix bitMatrix;
        try {
            bitMatrix = new MultiFormatWriter().encode(
                    Value,
                    BarcodeFormat.DATA_MATRIX.QR_CODE,
                    QRcodeWidth, QRcodeWidth, null
            );

        } catch (IllegalArgumentException Illegalargumentexception) {

            return null;
        }
        int bitMatrixWidth = bitMatrix.getWidth();

        int bitMatrixHeight = bitMatrix.getHeight();

        int[] pixels = new int[bitMatrixWidth * bitMatrixHeight];

        for (int y = 0; y < bitMatrixHeight; y++) {
            int offset = y * bitMatrixWidth;

            for (int x = 0; x < bitMatrixWidth; x++) {

                pixels[offset + x] = bitMatrix.get(x, y) ?
                        getResources().getColor(color):getResources().getColor(R.color.white);
            }
        }
        Bitmap bitmap = Bitmap.createBitmap(bitMatrixWidth, bitMatrixHeight, Bitmap.Config.ARGB_4444);

        bitmap.setPixels(pixels, 0, 500, 0, 0, bitMatrixWidth, bitMatrixHeight);
        return bitmap;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.blue:
                int blue=R.color.blue;
                if(etqr.getText().toString().trim().length() == 0){
                    Toast.makeText(QrGeneration.this, "Enter String!", Toast.LENGTH_SHORT).show();
                }else {
                    try {
                        bitmap = TextToImageEncode(etqr.getText().toString(),blue);
                        iv.setImageBitmap(bitmap);
                        String path = saveImage(bitmap);  //give read write permission
                        Toast.makeText(QrGeneration.this, "QRCode saved to -> "+path, Toast.LENGTH_SHORT).show();
                        saveQrDetails(etqr.getText().toString());
                    } catch (WriterException e) {
                        e.printStackTrace();
                    }

                }
                break;

            case R.id.red:
                // do your code
                int red=R.color.red;
                if(etqr.getText().toString().trim().length() == 0){
                    Toast.makeText(QrGeneration.this, "Enter String!", Toast.LENGTH_SHORT).show();
                }else {
                    try {
                        bitmap = TextToImageEncode(etqr.getText().toString(),red);
                        iv.setImageBitmap(bitmap);
                        String path = saveImage(bitmap);  //give read write permission
                        Toast.makeText(QrGeneration.this, "QRCode saved to -> "+path, Toast.LENGTH_SHORT).show();
                        saveQrDetails(etqr.getText().toString());
                    } catch (WriterException e) {
                        e.printStackTrace();
                    }

                }
                break;

            case R.id.green:
                // do your code
                int green=R.color.green;
                if(etqr.getText().toString().trim().length() == 0){
                    Toast.makeText(QrGeneration.this, "Enter String!", Toast.LENGTH_SHORT).show();
                }else {
                    try {
                        bitmap = TextToImageEncode(etqr.getText().toString(),green);
                        iv.setImageBitmap(bitmap);
                        String path = saveImage(bitmap);  //give read write permission
                        Toast.makeText(QrGeneration.this, "QRCode saved to -> "+path, Toast.LENGTH_SHORT).show();
                        saveQrDetails(etqr.getText().toString());
                    } catch (WriterException e) {
                        e.printStackTrace();
                    }

                }
                break;
            case R.id.pink:
                // do your code
                int pink=R.color.pink;
                if(etqr.getText().toString().trim().length() == 0){
                    Toast.makeText(QrGeneration.this, "Enter String!", Toast.LENGTH_SHORT).show();
                }else {
                    try {
                        bitmap = TextToImageEncode(etqr.getText().toString(),pink);
                        iv.setImageBitmap(bitmap);
                        String path = saveImage(bitmap);  //give read write permission
                        Toast.makeText(QrGeneration.this, "QRCode saved to -> "+path, Toast.LENGTH_SHORT).show();
                        saveQrDetails(etqr.getText().toString());
                    } catch (WriterException e) {
                        e.printStackTrace();
                    }

                }
                break;

            case R.id.violet:
                // do your code
                int violet=R.color.violet;
                if(etqr.getText().toString().trim().length() == 0){
                    Toast.makeText(QrGeneration.this, "Enter String!", Toast.LENGTH_SHORT).show();
                }else {
                    try {
                        bitmap = TextToImageEncode(etqr.getText().toString(),violet);
                        iv.setImageBitmap(bitmap);
                        String path = saveImage(bitmap);  //give read write permission
                        Toast.makeText(QrGeneration.this, "QRCode saved to -> "+path, Toast.LENGTH_SHORT).show();
                        saveQrDetails(etqr.getText().toString());
                    } catch (WriterException e) {
                        e.printStackTrace();
                    }

                }
                break;

            case R.id.yellow:
                // do your code
                int yellow=R.color.yellow;
                if(etqr.getText().toString().trim().length() == 0){
                    Toast.makeText(QrGeneration.this, "Enter String!", Toast.LENGTH_SHORT).show();
                }else {
                    try {
                        bitmap = TextToImageEncode(etqr.getText().toString(),yellow);
                        iv.setImageBitmap(bitmap);
                        String path = saveImage(bitmap);  //give read write permission
                        Toast.makeText(QrGeneration.this, "QRCode saved to -> "+path, Toast.LENGTH_SHORT).show();
                        saveQrDetails(etqr.getText().toString());
                    } catch (WriterException e) {
                        e.printStackTrace();
                    }

                }
                break;

        }
    }
    @Override
    public void onBackPressed() {
        Intent intent=new Intent(getApplicationContext(),InvoiceGeneration.class);
        startActivity(intent);
    }
}