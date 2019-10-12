package polinema.ac.id.rumusbangun.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import polinema.ac.id.rumusbangun.R;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void handlerClickRuangBangun(View view) {
        startActivity(new Intent(MenuActivity.this, RuangBangunActivity.class));
        overridePendingTransition(R.anim.slide_left, R.anim.slide_left);
    }

    public void handlerClickRuangDatar(View view) {
        startActivity(new Intent(MenuActivity.this, RuangDatarActivity.class));
        overridePendingTransition(R.anim.slide_left, R.anim.slide_left);
    }
}
