package ium.swag.yolo.saxs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Istruzioni extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_istruzioni);

        Button s2gButton = (Button)findViewById(R.id.istruzioniS2GButton);
        s2gButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Istruzioni.this, IstruzioniWeb.class);
                myIntent.putExtra("url","file:///android_asset/istruzionis2g.html");
                Istruzioni.this.startActivity(myIntent);
            }
        });

        Button g2sButton = (Button)findViewById(R.id.istruzioniG2SButton);
        g2sButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Istruzioni.this, IstruzioniWeb.class);
                myIntent.putExtra("url","file:///android_asset/istruzionig2s.html");
                Istruzioni.this.startActivity(myIntent);
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
