package net.azurewebsites.s1mple.easybill;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.content.Intent;
import java.sql.*;
import android.os.StrictMode;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        enableStrictMode();
        Button b1=(Button)findViewById(R.id.loginbtn);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText mid = (EditText)findViewById(R.id.mid);
                EditText mpass = (EditText)findViewById(R.id.mpass);
                try{
                    Class.forName("net.sourceforge.jtds.jdbc.Driver");
                    Connection con=DriverManager.getConnection(
                            "CONNECTION-STRING");
                    Statement stmt=con.createStatement();
                    ResultSet rs=stmt.executeQuery("SELECT * FROM merchantTable;");
                    while(rs.next())
                    {
                        if(mid.getText().toString().equals(rs.getString(3)) && mpass.getText().toString().equals(rs.getString(4)))
                        {
                            Intent switchAct = new Intent(MainActivity.this,ListActivity.class);
                            switchAct.putExtra("merchant_id",Integer.parseInt(rs.getString(1)));
                            switchAct.putExtra("merchant_name",rs.getString(2));
                            switchAct.putExtra("merchant_userid",rs.getString(3));
                            switchAct.putExtra("merchant_pass",rs.getString(4));
                            switchAct.putExtra("merchant_products",rs.getString(5));
                            switchAct.putExtra("merchant_sgst",rs.getString(6));
                            switchAct.putExtra("merchant_cgst",rs.getString(7));
                            switchAct.putExtra("merchant_price",rs.getString(8));
                            startActivity(switchAct);
                        }
                    }
                    con.close();
                }
                catch(Exception e){ e.printStackTrace();}
            }
        });
    }
    public void enableStrictMode()
    {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }
}
