package polinema.ac.id.rumusbangun.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import polinema.ac.id.rumusbangun.R;
import polinema.ac.id.rumusbangun.activities.RuangDatar.JajaranGenjangActivity;
import polinema.ac.id.rumusbangun.activities.RuangDatar.LayangActivity;
import polinema.ac.id.rumusbangun.activities.RuangDatar.LingkaranActivity;
import polinema.ac.id.rumusbangun.activities.RuangDatar.PersegiActivity;
import polinema.ac.id.rumusbangun.activities.RuangDatar.PersegiPanjangActivity;
import polinema.ac.id.rumusbangun.activities.RuangDatar.SegitigaSikuActivity;
import polinema.ac.id.rumusbangun.activities.RuangDatar.SegitigaSisiActivity;
import polinema.ac.id.rumusbangun.activities.RuangDatar.TrapesiumActivity;

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

    public void handlerClickPersegiActivity(View view) {
        startActivity(new Intent(RuangDatarActivity.this, PersegiActivity.class));
        overridePendingTransition(R.anim.slide_left,R.anim.slide_right);
        finish();
    }

    public void handlerClickPersegiPanjangActivity(View view) {
        startActivity(new Intent(RuangDatarActivity.this, PersegiPanjangActivity.class));
        overridePendingTransition(R.anim.slide_left,R.anim.slide_right);
        finish();
    }

    public void handlerClickSegitigaSikuActivity(View view) {
        startActivity(new Intent(RuangDatarActivity.this, SegitigaSikuActivity.class));
        overridePendingTransition(R.anim.slide_left,R.anim.slide_right);
        finish();
    }

    public void handlerClickSegitigaKakiSisiActivity(View view) {
        startActivity(new Intent(RuangDatarActivity.this, SegitigaSisiActivity.class));
        overridePendingTransition(R.anim.slide_left,R.anim.slide_right);
        finish();
    }

    public void handlerClickJajarGenjangActivity(View view) {
        startActivity(new Intent(RuangDatarActivity.this, JajaranGenjangActivity.class));
        overridePendingTransition(R.anim.slide_left,R.anim.slide_right);
        finish();
    }

    public void handlerClickTrapesiumActivity(View view) {
        startActivity(new Intent(RuangDatarActivity.this, TrapesiumActivity.class));
        overridePendingTransition(R.anim.slide_left,R.anim.slide_right);
        finish();
    }

    public void handlerClickLayangKetupatActivity(View view) {
        startActivity(new Intent(RuangDatarActivity.this, LayangActivity.class));
        overridePendingTransition(R.anim.slide_left,R.anim.slide_right);
        finish();
    }

    public void handlerClickLingkaranActivity(View view) {
        startActivity(new Intent(RuangDatarActivity.this, LingkaranActivity.class));
        overridePendingTransition(R.anim.slide_left,R.anim.slide_right);
        finish();
    }
}
