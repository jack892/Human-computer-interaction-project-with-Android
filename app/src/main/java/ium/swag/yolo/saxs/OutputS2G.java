package ium.swag.yolo.saxs;


import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;


public class OutputS2G extends AppCompatActivity implements TextFragment.OnFragmentInteractionListener, GestureFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output_s2g);

        Intent intent = getIntent();
        String value = intent.getStringExtra("testo");

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        if (intent.getStringExtra("tipo").equals("testo")) {
            ft.add(R.id.fooFragment,new TextFragment().newInstance(value,value));
            ft.addToBackStack(null);
            ft.commit();
        } else {
            ft.add(R.id.fooFragment, new GestureFragment().newInstance(value,value));
            ft.addToBackStack(null);
            ft.commit();
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_home:
                // User chose the "Settings" item, show the app settings UI...
                Toast.makeText(this,"FUNZIONA",Toast.LENGTH_LONG).show();
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
