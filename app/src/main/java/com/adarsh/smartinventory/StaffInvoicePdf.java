package com.adarsh.smartinventory;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Context;
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

import com.adarsh.smartinventory.Model.ViewInvoiceByStaffModel;
import com.adarsh.smartinventory.Retro.Api;
import com.adarsh.smartinventory.Retro.Api_client;
import com.harishpadmanabh.apppreferences.AppPreferences;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StaffInvoicePdf extends AppCompatActivity {
    private Button btn;
    private RelativeLayout relativeLayout;
    private Bitmap bitmap;
    TextView productname,quantity,price,subtotal,discountpercnt,discountrate,gst,totalamount;
    Float rate_value,subtotal_value;
    String pro_name;
    int quantitynum,emp_id;
    String discountpercentage,discountrupee,taxes,totalamountvalue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_invoice_pdf);

//        final SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("staffpref",MODE_PRIVATE);
//        emp_id=sharedPreferences.getInt("staffid",0);
      //  appPreferences = AppPreferences.getInstance(getApplicationContext(), getResources().getString(R.string.app_name));

        btn = findViewById(R.id.isavepdf);
        relativeLayout=findViewById(R.id.irelativelayout);
        productname=findViewById(R.id.iinvoiceproduct);
        quantity=findViewById(R.id.iquantity);
        price=findViewById(R.id.iprice);
        subtotal=findViewById(R.id.isubtotal);
        discountpercnt=findViewById(R.id.idiscountpcntg);
        discountrate=findViewById(R.id.idiscountrate);
        gst=findViewById(R.id.igst);
        totalamount=findViewById(R.id.itotamount);
        SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("invoice", Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor=sharedPreferences.edit();
//        sharedPreferences.getInt("invoiceid",0);
//        sharedPreferences.getInt("employeeid",0);
//        sharedPreferences.getString("name",null);
//        sharedPreferences.getString("cust_code",null);


        productname.setText(sharedPreferences.getString("pro_name",null));
        quantity.setText(String.valueOf(sharedPreferences.getInt("quantity",0)));
        price.setText(sharedPreferences.getString("amount",null));
        subtotal.setText(sharedPreferences.getString("subtotal",null));
        discountpercnt.setText(sharedPreferences.getString("discountpercentage",null));
        discountrate.setText(sharedPreferences.getString("discountrupees",null));
        gst.setText(sharedPreferences.getString("tax",null));
        totalamount.setText(sharedPreferences.getString("total_amount",null));
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
                Toast.makeText(StaffInvoicePdf.this, "No Application available to view pdf", Toast.LENGTH_LONG).show();
            }
        }
    }
}