package polinema.ac.id.rumusbangun.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import polinema.ac.id.rumusbangun.R;
import polinema.ac.id.rumusbangun.fragments.HasilFragment;
import polinema.ac.id.rumusbangun.fragments.kubus.LuasPermukaanKubus;
import polinema.ac.id.rumusbangun.fragments.kubus.VolumeKubus;

public class KubusActivity extends AppCompatActivity implements VolumeKubus.OnFragmentInteractionListener,LuasPermukaanKubus.OnFragmentInteractionListener, HasilFragment.OnFragmentInteractionListener {

    private LuasPermukaanKubus luasPermukaanKubus;
    private HasilFragment hasilFragment;
    private VolumeKubus volumeKubus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kubus);
        luasPermukaanKubus = new LuasPermukaanKubus();
        volumeKubus = new VolumeKubus();
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
        finish();
    }

    public void handlerClickLPKubus(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_kubus, luasPermukaanKubus).commit();
    }

    public void handlerClickVKubus(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_kubus, volumeKubus).commit();
    }

    @Override
    public void hitungVolumeKubus(float hasil) {
        hasilFragment.setInformation("Hasil Volume Kubus");
        hasilFragment.setHasil(String.format("Hasil Perhitungan %.2f", hasil));
        hasilFragment.setRumus("Rumus = sisi x sisi x sisi");
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_kubus, hasilFragment).commit();
    }
}
