package polinema.ac.id.rumusbangun.activities.RuangDatar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import polinema.ac.id.rumusbangun.R;
import polinema.ac.id.rumusbangun.activities.MenuActivity;
import polinema.ac.id.rumusbangun.fragments.HasilFragment;
import polinema.ac.id.rumusbangun.fragments.Lingkaran.KelilingLingkaran;
import polinema.ac.id.rumusbangun.fragments.Lingkaran.LuasLingkaran;

public class LingkaranActivity extends AppCompatActivity implements LuasLingkaran.OnFragmentInteractionListener, KelilingLingkaran.OnFragmentInteractionListener, HasilFragment.OnFragmentInteractionListener {

    private HasilFragment hasilFragment;
    private LuasLingkaran luasLingkaran;
    private KelilingLingkaran kelilingLingkaran;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lingkaran);
        hasilFragment = new HasilFragment();
        luasLingkaran = new LuasLingkaran();
        kelilingLingkaran = new KelilingLingkaran();
    }

    public void handlerClickLuasLingkaran(View view) {
        getSupportFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).replace(R.id.frame_lingkaran, luasLingkaran).commit();
    }

    public void handlerClickKelilingLingkaran(View view) {
        getSupportFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).replace(R.id.frame_lingkaran, kelilingLingkaran).commit();
    }

    @Override
    public void kembaliMenu(String menu) {
        startActivity(new Intent(LingkaranActivity.this, MenuActivity.class));
        finish();
    }

    @Override
    public void hitungKelilingLingkaran(float hasil) {
        hasilFragment.setInformation("Hasil Keliling Lingkaran");
        hasilFragment.setHasil(String.format("Hasil Perhitungan %.2f", hasil));
        hasilFragment.setRumus("Rumus = 2 x phi x jari");
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_lingkaran, hasilFragment).commit();

    }

    @Override
    public void hitungLuasLingkaran(float hasil) {
        hasilFragment.setInformation("Hasil Luas Lingkaran");
        hasilFragment.setHasil(String.format("Hasil Perhitungan %.2f", hasil));
        hasilFragment.setRumus("Rumus = phi x jari x jari");
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_lingkaran, hasilFragment).commit();

    }
}
