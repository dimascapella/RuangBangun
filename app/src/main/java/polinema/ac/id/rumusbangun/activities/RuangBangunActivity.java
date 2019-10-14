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
        overridePendingTransition(R.anim.slide_left,R.anim.slide_right);
        finish();
    }

    public void handlerBalokActivity(View view) {
        startActivity(new Intent(RuangBangunActivity.this, BalokActivity.class));
        overridePendingTransition(R.anim.slide_left,R.anim.slide_right);
        finish();
    }

    public void handlerClickPrismaActivity(View view) {
        startActivity(new Intent(RuangBangunActivity.this, PrismaActivity.class));
        overridePendingTransition(R.anim.slide_left,R.anim.slide_right);
        finish();
    }

    public void handlerClickLimasActivity(View view) {
        startActivity(new Intent(RuangBangunActivity.this, LimasActivity.class));
        overridePendingTransition(R.anim.slide_left,R.anim.slide_right);
        finish();
    }

    public void handlerClickTabungActivity(View view) {
        startActivity(new Intent(RuangBangunActivity.this, TabungActivity.class));
        overridePendingTransition(R.anim.slide_left,R.anim.slide_right);
        finish();
    }

    public void handlerClickKerucutActivity(View view) {
        startActivity(new Intent(RuangBangunActivity.this, KerucutActivity.class));
        overridePendingTransition(R.anim.slide_left,R.anim.slide_right);
        finish();
    }

    public void handlerClickBolaActivity(View view) {
        startActivity(new Intent(RuangBangunActivity.this, BolaActivity.class));
        overridePendingTransition(R.anim.slide_left,R.anim.slide_right);
        finish();
    }
}
