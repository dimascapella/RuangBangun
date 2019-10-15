package polinema.ac.id.rumusbangun.activities.RuangDatar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import polinema.ac.id.rumusbangun.R;
import polinema.ac.id.rumusbangun.activities.MenuActivity;
import polinema.ac.id.rumusbangun.fragments.HasilFragment;
import polinema.ac.id.rumusbangun.fragments.Persegi.KelilingPersegi;
import polinema.ac.id.rumusbangun.fragments.Persegi.LuasPersegi;

public class PersegiActivity extends AppCompatActivity implements KelilingPersegi.OnFragmentInteractionListener, LuasPersegi.OnFragmentInteractionListener, HasilFragment.OnFragmentInteractionListener {

    private LuasPersegi luasPersegi;
    private HasilFragment hasilFragment;
    private KelilingPersegi kelilingPersegi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persegi);
        luasPersegi = new LuasPersegi();
        hasilFragment = new HasilFragment();
        kelilingPersegi = new KelilingPersegi();
    }

    public void handlerClickLuasPersegi(View view) {
        getSupportFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).replace(R.id.frame_persegi, luasPersegi).commit();
    }

    public void handlerClickKelilingPersegi(View view) {
        getSupportFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).replace(R.id.frame_persegi, kelilingPersegi).commit();
    }

    @Override
    public void kembaliMenu(String menu) {
        startActivity(new Intent(PersegiActivity.this, MenuActivity.class));
        finish();
    }

    @Override
    public void hitungLuasPersegi(float hasil) {
        hasilFragment.setInformation("Hasil Luas Persegi");
        hasilFragment.setHasil(String.format("Hasil Perhitungan %.2f", hasil));
        hasilFragment.setRumus("Rumus = sisi x sisi");
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_persegi, hasilFragment).commit();
    }

    @Override
    public void hitungKelilingPersegi(float hasil) {
        hasilFragment.setInformation("Hasil Keliling Persegi");
        hasilFragment.setHasil(String.format("Hasil Perhitungan %.2f", hasil));
        hasilFragment.setRumus("Rumus = sisi x 4");
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_persegi, hasilFragment).commit();
    }
}
