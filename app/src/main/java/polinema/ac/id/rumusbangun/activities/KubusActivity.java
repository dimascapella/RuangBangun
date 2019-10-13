package polinema.ac.id.rumusbangun.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import polinema.ac.id.rumusbangun.R;
import polinema.ac.id.rumusbangun.fragments.HasilFragment;
import polinema.ac.id.rumusbangun.fragments.LuasPermukaanKubus;

public class KubusActivity extends AppCompatActivity implements LuasPermukaanKubus.OnFragmentInteractionListener, HasilFragment.OnFragmentInteractionListener {

    private LuasPermukaanKubus luasPermukaanKubus;
    private HasilFragment hasilFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kubus);
        luasPermukaanKubus = new LuasPermukaanKubus();
        hasilFragment = new HasilFragment();
    }

    @Override
    public void hitungLuasPermukaanKubus(float hasil) {
        hasilFragment.setInformation("Hasil Luas Permukaan Kubus");
        hasilFragment.setHasil(String.format("Hasil Perhitungan %.2f", hasil));
        hasilFragment.setRumus("Rumus = (sisi x sisi) x 6");
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_kubus, hasilFragment).commit();
    }

    @Override
    public void kembaliMenu(String menu) {
        startActivity(new Intent(KubusActivity.this, MenuActivity.class));
    }

    public void handlerClickLPKubus(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_kubus, luasPermukaanKubus).commit();
    }

}
