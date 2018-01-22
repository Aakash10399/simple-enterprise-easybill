package net.azurewebsites.s1mple.easybill;

import android.content.pm.PackageManager;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.telephony.SmsManager;
import android.support.v4.app.ActivityCompat;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import android.Manifest;
import java.lang.System;

public class Main2Activity extends AppCompatActivity {
    static public String message_send;
    static public String mob_send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        enableStrictMode();
        Intent in = getIntent();
        int id = 0;
        Bill bill = new Bill("<GSTIN_PLUGIN>",in.getStringExtra("products"),in.getStringExtra("price"),in.getStringExtra("quantity"),in.getStringExtra("cgst"),in.getStringExtra("sgst"),in.getStringExtra("mobile"));
        try{
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "CONNECTION-STRING");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT * FROM billTable;");
            while(rs.next())
            {
                id++;
            }
            con.close();
        }
        catch(Exception e){ e.printStackTrace();}
        try{
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "CONNECTION-STRING");
            Statement stmt=con.createStatement();
            String sql = "Insert Into billTable(GSTIN,products,sgst,cgst,price,quantity,mobile) Values('"+bill.getGSTIN()+"','"+bill.getProducts()+"','"+bill.getSgst()+"','"+bill.getCgst()+"','"+bill.getPrice()+"','"+bill.getQuantity()+"','"+bill.getMobile()+"')";
            ResultSet rs=stmt.executeQuery(sql);
            con.close();
        }
        catch(Exception e){ e.printStackTrace();}
        ((Button)findViewById(R.id.restart)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = getBaseContext().getPackageManager()
                        .getLaunchIntentForPackage( getBaseContext().getPackageName() );
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        });
        message_send = "Your Bill for recent purchase : "+"\n"+" https://ebbiller.azurewebsites.net/?id="+(id+1)+"&mobile="+bill.getMobile();
        mob_send = bill.getMobile();
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.SEND_SMS},123);
    }
    public void sendSMS(String phoneNo, String msg) {
        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNo, null, msg, null, null);
            Toast.makeText(getApplicationContext(), "Message Sent",
                    Toast.LENGTH_LONG).show();
            ((TextView)findViewById(R.id.done)).setText("DONE!");
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(),ex.getMessage().toString(),
                    Toast.LENGTH_LONG).show();
            ex.printStackTrace();
        }
    }
    public void enableStrictMode()
    {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 123: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                    sendSMS(mob_send,message_send);

                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request.
        }
    }
}
