package polinema.ac.id.rumusbangun.activities.RuangDatar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import polinema.ac.id.rumusbangun.R;
import polinema.ac.id.rumusbangun.activities.MenuActivity;
import polinema.ac.id.rumusbangun.fragments.HasilFragment;
import polinema.ac.id.rumusbangun.fragments.SegitigaSiku.KelilingSegitigaSiku;
import polinema.ac.id.rumusbangun.fragments.SegitigaSiku.LuasSegitigaSiku;

public class SegitigaSikuActivity extends AppCompatActivity implements KelilingSegitigaSiku.OnFragmentInteractionListener, LuasSegitigaSiku.OnFragmentInteractionListener, HasilFragment.OnFragmentInteractionListener {

    private HasilFragment hasilFragment;
    private LuasSegitigaSiku luasSegitigaSiku;
    private KelilingSegitigaSiku kelilingSegitigaSiku;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segitiga_siku);
        hasilFragment = new HasilFragment();
        luasSegitigaSiku = new LuasSegitigaSiku();
        kelilingSegitigaSiku = new KelilingSegitigaSiku();
    }

    @Override
    public void kembaliMenu(String menu) {
        startActivity(new Intent(SegitigaSikuActivity.this, MenuActivity.class));
        finish();
    }

    public void handlerClickLuasSegitigaSiku(View view) {
        getSupportFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).replace(R.id.frame_segitigaSiku, luasSegitigaSiku).commit();
    }

    public void handlerClickKelilingSegitigaSiku(View view) {
        getSupportFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).replace(R.id.frame_segitigaSiku, kelilingSegitigaSiku).commit();
    }

    @Override
    public void hitungLuasSegitigaSiku(float hasil) {
        hasilFragment.setInformation("Hasil Luas Segitiga Siku Siku");
        hasilFragment.setHasil(String.format("Hasil Perhitungan %.2f", hasil));
        hasilFragment.setRumus("Rumus = (alas x tinggi) / 2");
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_segitigaSiku, hasilFragment).commit();
    }

    @Override
    public void hitungKelilingSegitigaSiku(float hasil) {
        hasilFragment.setInformation("Hasil Keliling Segitiga Siku Siku");
        hasilFragment.setHasil(String.format("Hasil Perhitungan %.2f", hasil));
        hasilFragment.setRumus("Rumus = alas + tinggi + lebar ");
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_segitigaSiku, hasilFragment).commit();
    }
}
