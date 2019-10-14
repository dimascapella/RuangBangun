package polinema.ac.id.rumusbangun.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import polinema.ac.id.rumusbangun.R;
import polinema.ac.id.rumusbangun.fragments.HasilFragment;
import polinema.ac.id.rumusbangun.fragments.Kerucut.LuasAlasKerucut;
import polinema.ac.id.rumusbangun.fragments.Kerucut.LuasPermukaanKerucut;
import polinema.ac.id.rumusbangun.fragments.Kerucut.LuasSelimutKerucut;
import polinema.ac.id.rumusbangun.fragments.Kerucut.VolumeKerucut;

public class KerucutActivity extends AppCompatActivity implements LuasAlasKerucut.OnFragmentInteractionListener, LuasSelimutKerucut.OnFragmentInteractionListener, VolumeKerucut.OnFragmentInteractionListener, LuasPermukaanKerucut.OnFragmentInteractionListener, HasilFragment.OnFragmentInteractionListener {

    private HasilFragment hasilFragment;
    private LuasPermukaanKerucut luasPermukaanKerucut;
    private VolumeKerucut volumeKerucut;
    private LuasSelimutKerucut luasSelimutKerucut;
    private LuasAlasKerucut luasAlasKerucut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kerucut);
        hasilFragment = new HasilFragment();
        luasPermukaanKerucut = new LuasPermukaanKerucut();
        volumeKerucut = new VolumeKerucut();
        luasSelimutKerucut = new LuasSelimutKerucut();
        luasAlasKerucut = new LuasAlasKerucut();
    }

    public void handlerClickLPKerucut(View view) {
        getSupportFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).replace(R.id.frame_kerucut, luasPermukaanKerucut).commit();
    }

    public void handlerClickVKerucut(View view) {
        getSupportFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).replace(R.id.frame_kerucut, volumeKerucut).commit();
    }

    public void handlerClickLAKerucut(View view) {
        getSupportFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).replace(R.id.frame_kerucut, luasAlasKerucut).commit();
    }

    public void handlerClickLSKerucut(View view) {
        getSupportFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).replace(R.id.frame_kerucut, luasSelimutKerucut).commit();
    }

    @Override
    public void kembaliMenu(String menu) {
        startActivity(new Intent(KerucutActivity.this, MenuActivity.class));
        finish();
    }

    @Override
    public void hitungLuasPermukaanKerucut(float hasil) {
        hasilFragment.setInformation("Hasil Luas Permukaan Kerucut");
        hasilFragment.setHasil(String.format("Hasil Perhitungan %.2f", hasil));
        hasilFragment.setRumus("Rumus = luas alas + luas selimut");
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_kerucut, hasilFragment).commit();
    }

    @Override
    public void hitungVolumeKerucut(float hasil) {
        hasilFragment.setInformation("Hasil Volume Kerucut");
        hasilFragment.setHasil(String.format("Hasil Perhitungan %.2f", hasil));
        hasilFragment.setRumus("Rumus = (phi x jari x jari x tinggi) / 3");
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_kerucut, hasilFragment).commit();
    }

    @Override
    public void hitungLuasSelimutKerucut(float hasil) {
        hasilFragment.setInformation("Hasil Luas Selimut Kerucut");
        hasilFragment.setHasil(String.format("Hasil Perhitungan %.2f", hasil));
        hasilFragment.setRumus("Rumus = phi x jari x garis pelukis");
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_kerucut, hasilFragment).commit();
    }

    @Override
    public void hitungLuasAlasKerucut(float hasil) {
        hasilFragment.setInformation("Hasil Luas Alas Kerucut");
        hasilFragment.setHasil(String.format("Hasil Perhitungan %.2f", hasil));
        hasilFragment.setRumus("Rumus = phi x jari x jari");
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_kerucut, hasilFragment).commit();
    }

    @Override
    public void onBackPressed(){
        this.finish();
    }
}
