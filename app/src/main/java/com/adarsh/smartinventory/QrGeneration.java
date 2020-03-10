package com.adarsh.smartinventory;

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

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

public class QrGeneration extends AppCompatActivity implements View.OnClickListener {

    public final static int QRcodeWidth = 500 ;
    private static final String IMAGE_DIRECTORY = "/QRcodeDemonuts";
    Bitmap bitmap ;
    private EditText etqr;
    private ImageView iv;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr);

        iv = (ImageView) findViewById(R.id.iv);
        etqr = (EditText) findViewById(R.id.etqr);


        Button blue = (Button) findViewById(R.id.blue);
        blue.setOnClickListener(this); // calling onClick() method
        Button red = (Button) findViewById(R.id.red);
        red.setOnClickListener(this);
        Button green = (Button) findViewById(R.id.green);
        green.setOnClickListener(this);
        Button pink = (Button) findViewById(R.id.pink);
        pink.setOnClickListener(this); // calling onClick() method
        Button violet = (Button) findViewById(R.id.violet);
        violet.setOnClickListener(this);
        Button yellow = (Button) findViewById(R.id.yellow);
        yellow.setOnClickListener(this);




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
                    } catch (WriterException e) {
                        e.printStackTrace();
                    }

                }
                break;

        }
    }
}