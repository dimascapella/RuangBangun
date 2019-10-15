package polinema.ac.id.rumusbangun.activities.RuangDatar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import polinema.ac.id.rumusbangun.R;
import polinema.ac.id.rumusbangun.activities.MenuActivity;
import polinema.ac.id.rumusbangun.fragments.HasilFragment;
import polinema.ac.id.rumusbangun.fragments.JajaranGenjang.KelilingJajaranGenjang;
import polinema.ac.id.rumusbangun.fragments.JajaranGenjang.LuasJajaranGenjang;

public class JajaranGenjangActivity extends AppCompatActivity implements LuasJajaranGenjang.OnFragmentInteractionListener, KelilingJajaranGenjang.OnFragmentInteractionListener, HasilFragment.OnFragmentInteractionListener {

    private HasilFragment hasilFragment;
    private LuasJajaranGenjang luasJajaranGenjang;
    private KelilingJajaranGenjang kelilingJajaranGenjang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jajaran_genjang);
        hasilFragment = new HasilFragment();
        luasJajaranGenjang = new LuasJajaranGenjang();
        kelilingJajaranGenjang = new KelilingJajaranGenjang();
    }

    @Override
    public void kembaliMenu(String menu) {
        startActivity(new Intent(JajaranGenjangActivity.this, MenuActivity.class));
        finish();
    }

    public void handlerClickLuasJajaranGenjang(View view) {
        getSupportFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).replace(R.id.frame_JajaranGenjang, luasJajaranGenjang).commit();
    }

    public void handlerClickKelilingJajaranGenjang(View view) {
        getSupportFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).replace(R.id.frame_JajaranGenjang, kelilingJajaranGenjang).commit();
    }

    @Override
    public void hitungKelilingJajaranGenjang(float hasil) {
        hasilFragment.setInformation("Hasil Keliling Jajaran Genjang");
        hasilFragment.setHasil(String.format("Hasil Perhitungan %.2f", hasil));
        hasilFragment.setRumus("Rumus = sisi1 + sisi2 + sisi3 + sisi4 ");
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_JajaranGenjang, hasilFragment).commit();
    }

    @Override
    public void hitungLuasJajaranGenjang(float hasil) {
        hasilFragment.setInformation("Hasil Luas Jajaran Genjang");
        hasilFragment.setHasil(String.format("Hasil Perhitungan %.2f", hasil));
        hasilFragment.setRumus("Rumus = alas * tinggi ");
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_JajaranGenjang, hasilFragment).commit();
    }
}
