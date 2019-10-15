package polinema.ac.id.rumusbangun.activities.RuangDatar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import polinema.ac.id.rumusbangun.R;
import polinema.ac.id.rumusbangun.activities.MenuActivity;
import polinema.ac.id.rumusbangun.fragments.HasilFragment;
import polinema.ac.id.rumusbangun.fragments.PersegiPanjang.KelilingPersegiPanjang;
import polinema.ac.id.rumusbangun.fragments.PersegiPanjang.LuasPersegiPanjang;

public class PersegiPanjangActivity extends AppCompatActivity implements KelilingPersegiPanjang.OnFragmentInteractionListener, LuasPersegiPanjang.OnFragmentInteractionListener, HasilFragment.OnFragmentInteractionListener {

    private HasilFragment hasilFragment;
    private LuasPersegiPanjang luasPersegiPanjang;
    private KelilingPersegiPanjang kelilingPersegiPanjang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persegi_panjang);
        hasilFragment = new HasilFragment();
        luasPersegiPanjang = new LuasPersegiPanjang();
        kelilingPersegiPanjang = new KelilingPersegiPanjang();
    }

    public void handlerClickLuasPersegiPanjang(View view) {
        getSupportFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).replace(R.id.frame_persegiPanjang, luasPersegiPanjang).commit();
    }

    public void handlerClickKelilingPersegiPanjang(View view) {
        getSupportFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).replace(R.id.frame_persegiPanjang, kelilingPersegiPanjang).commit();
    }

    @Override
    public void kembaliMenu(String menu) {
        startActivity(new Intent(PersegiPanjangActivity.this, MenuActivity.class));
        finish();
    }

    @Override
    public void hitungLuaspersegiPanjang(float hasil) {
        hasilFragment.setInformation("Hasil Luas Persegi Panjang");
        hasilFragment.setHasil(String.format("Hasil Perhitungan %.2f", hasil));
        hasilFragment.setRumus("Rumus = panjang x lebar ");
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_persegiPanjang, hasilFragment).commit();
    }

    @Override
    public void hitungKelilingpersegiPanjang(float hasil) {
        hasilFragment.setInformation("Hasil Keliling Persegi Panjang");
        hasilFragment.setHasil(String.format("Hasil Perhitungan %.2f", hasil));
        hasilFragment.setRumus("Rumus = 2 x ( panjang + lebar )");
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_persegiPanjang, hasilFragment).commit();
    }
}
