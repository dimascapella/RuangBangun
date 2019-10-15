package polinema.ac.id.rumusbangun.activities.RuangDatar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import polinema.ac.id.rumusbangun.R;
import polinema.ac.id.rumusbangun.activities.MenuActivity;
import polinema.ac.id.rumusbangun.fragments.HasilFragment;
import polinema.ac.id.rumusbangun.fragments.Trapesium.KelilingTrapesium;
import polinema.ac.id.rumusbangun.fragments.Trapesium.LuasTrapesium;

public class TrapesiumActivity extends AppCompatActivity implements LuasTrapesium.OnFragmentInteractionListener, KelilingTrapesium.OnFragmentInteractionListener, HasilFragment.OnFragmentInteractionListener {

    private HasilFragment hasilFragment;
    private LuasTrapesium luasTrapesium;
    private KelilingTrapesium kelilingTrapesium;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trapesium);
        hasilFragment = new HasilFragment();
        luasTrapesium = new LuasTrapesium();
        kelilingTrapesium = new KelilingTrapesium();
    }

    public void handlerClickLuasTrapesium(View view) {
        getSupportFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).replace(R.id.frame_trapesium, luasTrapesium).commit();
    }

    public void handlerClickKelilingTrapesium(View view) {
        getSupportFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).replace(R.id.frame_trapesium, kelilingTrapesium).commit();
    }

    @Override
    public void kembaliMenu(String menu) {
        startActivity(new Intent(TrapesiumActivity.this, MenuActivity.class));
        finish();
    }

    @Override
    public void hitungKelilingTrapesium(float hasil) {
        hasilFragment.setInformation("Hasil Keliling Trapesium");
        hasilFragment.setHasil(String.format("Hasil Perhitungan %.2f", hasil));
        hasilFragment.setRumus("Rumus = sisi1 + sisi2 + sisi3 + sisi4");
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_trapesium, hasilFragment).commit();
    }

    @Override
    public void hitungLuasTrapesium(float hasil) {
        hasilFragment.setInformation("Hasil Luas Trapesium");
        hasilFragment.setHasil(String.format("Hasil Perhitungan %.2f", hasil));
        hasilFragment.setRumus("Rumus = ((sisi atas + sisi bawah) / 2 ) x tinggi ");
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_trapesium, hasilFragment).commit();
    }
}
