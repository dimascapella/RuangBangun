package polinema.ac.id.rumusbangun.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import polinema.ac.id.rumusbangun.R;
import polinema.ac.id.rumusbangun.fragments.HasilFragment;
import polinema.ac.id.rumusbangun.fragments.Limas.LuasAlasLimas;
import polinema.ac.id.rumusbangun.fragments.Limas.LuasPermukaanLimas;
import polinema.ac.id.rumusbangun.fragments.Limas.SisiLimas;
import polinema.ac.id.rumusbangun.fragments.Limas.VolumeLimas;

public class LimasActivity extends AppCompatActivity implements SisiLimas.OnFragmentInteractionListener, LuasAlasLimas.OnFragmentInteractionListener, VolumeLimas.OnFragmentInteractionListener, HasilFragment.OnFragmentInteractionListener, LuasPermukaanLimas.OnFragmentInteractionListener {

    private HasilFragment hasilFragment;
    private LuasPermukaanLimas luasPermukaanLimas;
    private VolumeLimas volumeLimas;
    private LuasAlasLimas luasAlasLimas;
    private SisiLimas sisiLimas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_limas);
        hasilFragment = new HasilFragment();
        luasPermukaanLimas = new LuasPermukaanLimas();
        volumeLimas = new VolumeLimas();
        luasAlasLimas = new LuasAlasLimas();
        sisiLimas = new SisiLimas();
    }

    public void handlerClickLPLimas(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_limas, luasPermukaanLimas).commit();
    }

    public void handlerClickVLimas(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_limas, volumeLimas).commit();
    }

    public void handlerClickLALimas(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_limas, luasAlasLimas).commit();
    }

    public void handlerClickSisiLimas(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_limas, sisiLimas).commit();
    }

    @Override
    public void kembaliMenu(String menu) {
        startActivity(new Intent(LimasActivity.this, MenuActivity.class));
        finish();
    }

    @Override
    public void hitungLuasPermukaanLimas(float hasil) {
        hasilFragment.setInformation("Hasil Luas Permukaan Limas");
        hasilFragment.setHasil(String.format("Hasil Perhitungan %.2f", hasil));
        hasilFragment.setRumus("Rumus = Luas alas + sisi 1 + sisi 2 + sisi 3");
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_limas, hasilFragment).commit();
    }

    @Override
    public void hitungVolumeLimas(float hasil) {
        hasilFragment.setInformation("Hasil Volume Limas");
        hasilFragment.setHasil(String.format("Hasil Perhitungan %.2f", hasil));
        hasilFragment.setRumus("Rumus = (Luas Alas x tinggi) / 3 ");
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_limas, hasilFragment).commit();
    }

    @Override
    public void hitungLuasAlasLimas(float hasil) {
        hasilFragment.setInformation("Hasil Luas Alas Limas");
        hasilFragment.setHasil(String.format("Hasil Perhitungan %.2f", hasil));
        hasilFragment.setRumus("Rumus = ( alas x tinggi ) / 2");
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_limas, hasilFragment).commit();
    }

    @Override
    public void hitungSisiLimas(float hasil) {
        hasilFragment.setInformation("Hasil Sisi Limas");
        hasilFragment.setHasil(String.format("Hasil Perhitungan %.2f", hasil));
        hasilFragment.setRumus("Rumus = ( alas x tinggi ) / 2");
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_limas, hasilFragment).commit();
    }

    @Override
    public void onBackPressed(){
        this.finish();
    }
}
