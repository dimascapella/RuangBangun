package polinema.ac.id.rumusbangun.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import polinema.ac.id.rumusbangun.R;
import polinema.ac.id.rumusbangun.fragments.HasilFragment;
import polinema.ac.id.rumusbangun.fragments.Tabung.KelilingAlasTabung;
import polinema.ac.id.rumusbangun.fragments.Tabung.LuasAlasTabung;
import polinema.ac.id.rumusbangun.fragments.Tabung.LuasPermukaanTabung;
import polinema.ac.id.rumusbangun.fragments.Tabung.LuasSelimutTabung;
import polinema.ac.id.rumusbangun.fragments.Tabung.VolumeTabung;

public class TabungActivity extends AppCompatActivity implements LuasSelimutTabung.OnFragmentInteractionListener, KelilingAlasTabung.OnFragmentInteractionListener, LuasAlasTabung.OnFragmentInteractionListener, VolumeTabung.OnFragmentInteractionListener, LuasPermukaanTabung.OnFragmentInteractionListener, HasilFragment.OnFragmentInteractionListener {

    private HasilFragment hasilFragment;
    private LuasPermukaanTabung luasPermukaanTabung;
    private VolumeTabung volumeTabung;
    private LuasAlasTabung luasAlasTabung;
    private KelilingAlasTabung kelilingAlasTabung;
    private LuasSelimutTabung luasSelimutTabung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabung);
        hasilFragment = new HasilFragment();
        luasPermukaanTabung = new LuasPermukaanTabung();
        volumeTabung = new VolumeTabung();
        luasAlasTabung = new LuasAlasTabung();
        kelilingAlasTabung = new KelilingAlasTabung();
        luasSelimutTabung = new LuasSelimutTabung();
    }

    public void handlerClickLPTabung(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_tabung, luasPermukaanTabung).commit();
    }

    public void handlerClickVTabung(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_tabung, volumeTabung).commit();
    }

    public void handlerClickSelimutTabung(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_tabung, luasSelimutTabung).commit();

    }

    public void handlerClickKATabung(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_tabung, kelilingAlasTabung).commit();
    }

    public void handlerClickLATabung(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_tabung, luasAlasTabung).commit();
    }

    @Override
    public void kembaliMenu(String menu) {
        startActivity(new Intent(TabungActivity.this, MenuActivity.class));
        finish();
    }

    @Override
    public void hitungLuasPermukaanTabung(float hasil) {
        hasilFragment.setInformation("Hasil Luas Permukaan Tabung");
        hasilFragment.setHasil(String.format("Hasil Perhitungan %.2f", hasil));
        hasilFragment.setRumus("Rumus = 2 x luas alas x luas selimut");
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_tabung, hasilFragment).commit();
    }

    @Override
    public void hitungVolumeTabung(float hasil) {
        hasilFragment.setInformation("Hasil Volume Tabung");
        hasilFragment.setHasil(String.format("Hasil Perhitungan %.2f", hasil));
        hasilFragment.setRumus("Rumus = phi x ( jari x jari ) x tinggi ");
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_tabung, hasilFragment).commit();
    }

    @Override
    public void hitungLuasAlasTabung(float hasil) {
        hasilFragment.setInformation("Hasil Luas Alas Tabung");
        hasilFragment.setHasil(String.format("Hasil Perhitungan %.2f", hasil));
        hasilFragment.setRumus("Rumus = phi x jari x jari");
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_tabung, hasilFragment).commit();
    }

    @Override
    public void hitungKelilingAlasTabung(float hasil) {
        hasilFragment.setInformation("Hasil Keliling Alas Tabung");
        hasilFragment.setHasil(String.format("Hasil Perhitungan %.2f", hasil));
        hasilFragment.setRumus("Rumus = 2 x phi x jari");
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_tabung, hasilFragment).commit();
    }

    @Override
    public void hitungLuasSelimutTabung(float hasil) {
        hasilFragment.setInformation("Hasil Luas Selimut Tabung");
        hasilFragment.setHasil(String.format("Hasil Perhitungan %.2f", hasil));
        hasilFragment.setRumus("Rumus = 2 x phi x jari x tinggi");
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_tabung, hasilFragment).commit();
    }

    @Override
    public void onBackPressed(){
        this.finish();
    }
}
