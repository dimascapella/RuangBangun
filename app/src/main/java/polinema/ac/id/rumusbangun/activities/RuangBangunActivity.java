package polinema.ac.id.rumusbangun.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import polinema.ac.id.rumusbangun.R;

public class RuangBangunActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ruang_bangun);
    }



    @Override
    public void onBackPressed(){
        this.finish();
    }

    public void handlerKubusActivity(View view) {
        startActivity(new Intent(RuangBangunActivity.this, KubusActivity.class));
    }
}
