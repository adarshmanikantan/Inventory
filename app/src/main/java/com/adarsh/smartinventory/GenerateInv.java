package com.adarsh.smartinventory;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.harishpadmanabh.apppreferences.AppPreferences;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class GenerateInv extends AppCompatActivity {

    private LinearLayout relativeLayout;
    private TextView productname;
    private TextView quantity;
    private TextView price;
    private TextView subtotal;
    private TextView discountpercnt;
    private TextView discountrate;
    private TextView gst;
    private TextView totalamount;
    Button makepdf;
    Float rate_value,subtotal_value;
    String pro_name;
    int quantitynum;
    String discountpercentage,discountrupee,taxes,totalamountvalue;
    Bitmap  bitmap;
    private AppPreferences appPreferences;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_inv);
        initView();
        appPreferences = AppPreferences.getInstance(getApplicationContext(), getResources().getString(R.string.app_name));

        SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("pref",MODE_PRIVATE);
        quantitynum= sharedPreferences.getInt("quantity_value",0);
        rate_value=sharedPreferences.getFloat("rate_value", (float) 0.00);
        subtotal_value=sharedPreferences.getFloat("subtotal_value", (float) 0.00);
        pro_name=sharedPreferences.getString("pro_name",null);

        SharedPreferences sp=getApplicationContext().getSharedPreferences("Pref",MODE_PRIVATE);
        discountpercentage=sp.getString("key1",null);
        discountrupee=sp.getString("key2",null);
        taxes=sp.getString("key3",null);
        totalamountvalue=sp.getString("key4",null);

        productname.setText(appPreferences.getData("pro_name"));
        quantity.setText(appPreferences.getData("quantitynum"));
        price.setText(appPreferences.getData("rate_value"));
        subtotal.setText(appPreferences.getData("subtotal_value"));
        discountpercnt.setText(appPreferences.getData("discountpercent_value"));
        discountrate.setText(appPreferences.getData("discountrupee"));
        gst.setText(appPreferences.getData("taxes"));
        totalamount.setText(appPreferences.getData("totalamount_value"));

        makepdf.setOnClickListener(v -> {
            Log.d("size", " " + relativeLayout.getWidth() + "  " + relativeLayout.getWidth());
            bitmap = loadBitmapFromView(relativeLayout, relativeLayout.getWidth(), relativeLayout.getHeight());
            createPdf();
        });
    }

    private void initView() {
        relativeLayout = findViewById(R.id.relativeLayout);
        productname = findViewById(R.id.productname);
        quantity = findViewById(R.id.quantity);
        price = findViewById(R.id.price);
        subtotal = findViewById(R.id.subtotal);
        discountpercnt = findViewById(R.id.discountpercnt);
        discountrate = findViewById(R.id.discountrate);
        gst = findViewById(R.id.gst);
        totalamount = findViewById(R.id.totalamount);
        makepdf=findViewById(R.id.createpdf);
    }

    public static Bitmap loadBitmapFromView(View v, int width, int height) {
        Bitmap b = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(b);
        v.draw(c);

        return b;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void createPdf() {

        try {


            android.graphics.pdf.PdfDocument document = new android.graphics.pdf.PdfDocument();
            android.graphics.pdf.PdfDocument.PageInfo pageInfo = new android.graphics.pdf.PdfDocument.PageInfo.Builder(relativeLayout.getWidth(), relativeLayout.getHeight(),1).create();
            android.graphics.pdf.PdfDocument.Page page = document.startPage(pageInfo);

            Canvas canvas = page.getCanvas();
            Paint paint = new Paint();
            canvas.drawPaint(paint);
            relativeLayout.draw(canvas);
            document.finishPage(page);
            String targetPdf = "/sdcard/pdffromlayout.pdf";
            File filePath;
            filePath = new File(targetPdf);
            try {
                document.writeTo(new FileOutputStream(filePath));

            } catch (IOException e) {
                e.printStackTrace();
                Toast.makeText(this, "Something wrong: " + e.toString(), Toast.LENGTH_LONG).show();
            }

            // close the document
            document.close();
            Toast.makeText(this, "PDF is created!!!", Toast.LENGTH_SHORT).show();
            openGeneratedPDF();


        }catch (Exception e){

            Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_SHORT).show();
        }
    }


    private void openGeneratedPDF() {
//        File file = new File("/sdcard/pdffromlayout.pdf");
//        if (file.exists()) {
//            Intent intent = new Intent(Intent.ACTION_VIEW);
//            Uri uri = Uri.fromFile(file);
//            intent.setDataAndType(uri, "application/pdf");
//            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//
//            try {
//                startActivity(intent);
//            } catch (ActivityNotFoundException e) {
//                Toast.makeText(GenerateInv.this, "No Application available to view pdf", Toast.LENGTH_LONG).show();
//            }
//        }
    }
}
