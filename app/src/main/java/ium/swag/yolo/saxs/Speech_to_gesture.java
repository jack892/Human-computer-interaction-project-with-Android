package ium.swag.yolo.saxs;

import android.content.DialogInterface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import java.util.ArrayList;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.v7.widget.ContentFrameLayout;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Speech_to_gesture extends AppCompatActivity {

    protected static final int RESULT_SPEECH = 1;

    private ImageButton btnSpeak;
    private TextView txtText;
    private View myView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speech_to_gesture);
        myView = getWindow().getDecorView();

        txtText = (TextView) findViewById(R.id.txt_output);

        btnSpeak = (ImageButton) findViewById(R.id.btn_mic);

        btnSpeak.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(
                        RecognizerIntent.ACTION_RECOGNIZE_SPEECH);

                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, "it-IT");

                try {
                    startActivityForResult(intent, RESULT_SPEECH);
                    //txtText.setText("");
                } catch (ActivityNotFoundException a) {
                    Toast t = Toast.makeText(getApplicationContext(),
                            "Ops! Your device doesn't support Speech to Text",
                            Toast.LENGTH_SHORT);
                    t.show();
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case RESULT_SPEECH: {
                if (resultCode == RESULT_OK && null != data) {

                    ArrayList<String> text = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);

                    final String parole = text.get(0);

                    new AlertDialog.Builder(Speech_to_gesture.this)
                            .setTitle("Attenzione")
                            .setMessage("Scegli come visualizzare il messaggio")
                            .setCancelable(false)
                            .setPositiveButton("Gesture", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent myIntent = new Intent(Speech_to_gesture.this, OutputS2G.class);
                                    myIntent.putExtra("testo", parole);
                                    myIntent.putExtra("tipo","gesture");
                                    //Optional parameters
                                    Speech_to_gesture.this.startActivity(myIntent);
                                }
                            })
                            .setNegativeButton("Testo", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent myIntent = new Intent(Speech_to_gesture.this, OutputS2G.class);
                                    myIntent.putExtra("testo", parole);
                                    myIntent.putExtra("tipo","testo");
                                    //Optional parameters
                                    Speech_to_gesture.this.startActivity(myIntent);
                                }
                            })
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .show();

                }
                break;
            }

        }
    }
}
