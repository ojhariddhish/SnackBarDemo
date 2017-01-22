package com.dnsoftindia.snackbardemo;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnNormal, btnNormalWithAction, btnCustom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNormal = (Button) findViewById(R.id.btnNormal);
        btnNormal.setOnClickListener(this);
        btnNormalWithAction = (Button) findViewById(R.id.btnNormalWithAction);
        btnNormalWithAction.setOnClickListener(this);
        btnCustom = (Button) findViewById(R.id.btnCustom);
        btnCustom.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        final Snackbar snackbar;
        switch (v.getId()) {
            case R.id.btnNormal:
                snackbar = Snackbar.make(v, "This is Normal", Snackbar.LENGTH_SHORT);
                snackbar.show();
                break;
            case R.id.btnNormalWithAction:
                snackbar = Snackbar.make(v, "But Normals need Action", Snackbar.LENGTH_INDEFINITE);
                snackbar.setAction("OK", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "Understood", Toast.LENGTH_LONG).show();
                        snackbar.dismiss();
                    }
                });
                snackbar.show();
                break;
            case R.id.btnCustom:
                snackbar = Snackbar.make(v, "Customized Snacking...", Snackbar.LENGTH_LONG);
                snackbar.setAction("OK", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "Nice", Toast.LENGTH_LONG).show();
                        snackbar.dismiss();
                    }
                });
                View view = snackbar.getView();
                view.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.colorPrimary));
                TextView tv = (TextView) view.findViewById(android.support.design.R.id.snackbar_text);
                if (tv != null) {
                    if (Build.VERSION.SDK_INT > Build.VERSION_CODES.JELLY_BEAN) {
                        tv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                    }
                    tv.setGravity(Gravity.CENTER_HORIZONTAL);
                    tv.setTextColor(Color.WHITE);
                }
                snackbar.setActionTextColor(ContextCompat.getColor(MainActivity.this, R.color.colorAccent));
                snackbar.show();
                break;
        }
    }
}
