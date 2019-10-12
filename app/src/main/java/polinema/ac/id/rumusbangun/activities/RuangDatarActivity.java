package polinema.ac.id.rumusbangun.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import polinema.ac.id.rumusbangun.R;

public class RuangDatarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ruang_datar);
    }

    @Override
    public void onBackPressed(){
        this.finish();
    }
}
