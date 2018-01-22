package net.azurewebsites.s1mple.easybill;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Button;
import android.util.Log;
import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Intent in = getIntent();
        final Merchant merchant_data = new Merchant(in.getIntExtra("merchant_id",0),in.getStringExtra("merchant_name"),in.getStringExtra("merchant_userid"),in.getStringExtra("merchant_pass"),in.getStringExtra("merchant_products"),in.getStringExtra("merchant_sgst"),in.getStringExtra("merchant_cgst"),in.getStringExtra("merchant_price"));
        String products[] = merchant_data.getProducts().split(";");
        TextView tt = (TextView)findViewById(R.id.p1);
        tt.setText(products[0]);
        tt = (TextView)findViewById(R.id.p2);
        tt.setText(products[1]);
        tt = (TextView)findViewById(R.id.p3);
        tt.setText(products[2]);
        tt = (TextView)findViewById(R.id.p4);
        tt.setText(products[3]);
        tt = (TextView)findViewById(R.id.p5);
        tt.setText(products[4]);
        Button bb = (Button)findViewById(R.id.addp1);
        bb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView t2 = (TextView)findViewById(R.id.p1q);
                t2.setText(" ( "+(Integer.parseInt(t2.getText().toString().charAt(3)+"")+1)+" ) ");
            }
        });
        bb = (Button)findViewById(R.id.subp1);
        bb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView t2 = (TextView)findViewById(R.id.p1q);
                if((Integer.parseInt(t2.getText().toString().charAt(3)+""))!=0)
                t2.setText(" ( "+(Integer.parseInt(t2.getText().toString().charAt(3)+"")-1)+" ) ");
            }
        });
        bb = (Button)findViewById(R.id.addp2);
        bb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView t2 = (TextView)findViewById(R.id.p2q);
                t2.setText(" ( "+(Integer.parseInt(t2.getText().toString().charAt(3)+"")+1)+" ) ");
            }
        });
        bb = (Button)findViewById(R.id.subp2);
        bb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView t2 = (TextView)findViewById(R.id.p2q);
                if((Integer.parseInt(t2.getText().toString().charAt(3)+""))!=0)
                t2.setText(" ( "+(Integer.parseInt(t2.getText().toString().charAt(3)+"")-1)+" ) ");
            }
        });
        bb = (Button)findViewById(R.id.addp3);
        bb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView t2 = (TextView)findViewById(R.id.p3q);
                t2.setText(" ( "+(Integer.parseInt(t2.getText().toString().charAt(3)+"")+1)+" ) ");
            }
        });
        bb = (Button)findViewById(R.id.subp3);
        bb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView t2 = (TextView)findViewById(R.id.p3q);
                if((Integer.parseInt(t2.getText().toString().charAt(3)+""))!=0)
                    t2.setText(" ( "+(Integer.parseInt(t2.getText().toString().charAt(3)+"")-1)+" ) ");
            }
        });
        bb = (Button)findViewById(R.id.addp4);
        bb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView t2 = (TextView)findViewById(R.id.p4q);
                t2.setText(" ( "+(Integer.parseInt(t2.getText().toString().charAt(3)+"")+1)+" ) ");
            }
        });
        bb = (Button)findViewById(R.id.subp4);
        bb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView t2 = (TextView)findViewById(R.id.p4q);
                if((Integer.parseInt(t2.getText().toString().charAt(3)+""))!=0)
                     t2.setText(" ( "+(Integer.parseInt(t2.getText().toString().charAt(3)+"")-1)+" ) ");
            }
        });
        bb = (Button)findViewById(R.id.addp5);
        bb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView t2 = (TextView)findViewById(R.id.p5q);
                t2.setText(" ( "+(Integer.parseInt(t2.getText().toString().charAt(3)+"")+1)+" ) ");
            }
        });
        bb = (Button)findViewById(R.id.subp5);
        bb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView t2 = (TextView)findViewById(R.id.p5q);
                if((Integer.parseInt(t2.getText().toString().charAt(3)+""))!=0)
                    t2.setText(" ( "+(Integer.parseInt(t2.getText().toString().charAt(3)+"")-1)+" ) ");
            }
        });
        bb = (Button)findViewById(R.id.submitbt);
        bb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in2 = new Intent(ListActivity.this,Main2Activity.class);
                TextView t1 = (TextView)findViewById(R.id.p1q);
                TextView t2 = (TextView)findViewById(R.id.p2q);
                TextView t3 = (TextView)findViewById(R.id.p3q);
                TextView t4 = (TextView)findViewById(R.id.p4q);
                TextView t5 = (TextView)findViewById(R.id.p5q);
                EditText e1 = (EditText)findViewById(R.id.mobile);
                String quantity = (Integer.parseInt(t1.getText().toString().charAt(3)+""))+";"+(Integer.parseInt(t2.getText().toString().charAt(3)+""))+";"+(Integer.parseInt(t3.getText().toString().charAt(3)+""))+";"+(Integer.parseInt(t4.getText().toString().charAt(3)+""))+";"+(Integer.parseInt(t5.getText().toString().charAt(3)+""));
                in2.putExtra("products",merchant_data.getProducts());
                in2.putExtra("price",merchant_data.getPrice());
                in2.putExtra("sgst",merchant_data.getSgst());
                in2.putExtra("cgst",merchant_data.getCgst());
                in2.putExtra("quantity",quantity);
                in2.putExtra("mobile",e1.getText().toString());
                startActivity(in2);
            }
        });
    }
}
