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
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class GenerateInvoiceActivity extends AppCompatActivity {
   private Button btn;
    private RelativeLayout relativeLayout;
    private Bitmap bitmap;
   TextView productname,quantity,price,subtotal,discountpercnt,discountrate,gst,totalamount;
    Float rate_value,subtotal_value;
    String pro_name;
    int quantitynum;
    String discountpercentage,discountrupee,taxes,totalamountvalue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_invoice);

        btn = findViewById(R.id.savepdf);
        relativeLayout=findViewById(R.id.relativelayout);
        productname=findViewById(R.id.invoiceproduct);
        quantity=findViewById(R.id.quantity);
        price=findViewById(R.id.price);
        subtotal=findViewById(R.id.subtotal);
        discountpercnt=findViewById(R.id.discountpcntg);
        discountrate=findViewById(R.id.discountrate);
        gst=findViewById(R.id.gst);
        totalamount=findViewById(R.id.totamount);


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

        productname.setText(pro_name);
        quantity.setText(String.valueOf(quantitynum));
        price.setText(String.valueOf(rate_value));
        subtotal.setText(String.valueOf(subtotal_value));
        discountpercnt.setText(discountpercentage);
        discountrate.setText(String.valueOf(discountrate));
        gst.setText(taxes);
        totalamount.setText(totalamountvalue);
        btn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                Log.d("size", " " + relativeLayout.getWidth() + "  " + relativeLayout.getWidth());
                bitmap = loadBitmapFromView(relativeLayout, relativeLayout.getWidth(), relativeLayout.getHeight());
                createPdf();
            }
        });

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

            // Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_SHORT).show();
        }
    }


    private void openGeneratedPDF() {
        File file = new File("/sdcard/pdffromlayout.pdf");
        if (file.exists()) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            Uri uri = Uri.fromFile(file);
            intent.setDataAndType(uri, "application/pdf");
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            try {
                startActivity(intent);
            } catch (ActivityNotFoundException e) {
                Toast.makeText(GenerateInvoiceActivity.this, "No Application available to view pdf", Toast.LENGTH_LONG).show();
            }
        }
    }
}