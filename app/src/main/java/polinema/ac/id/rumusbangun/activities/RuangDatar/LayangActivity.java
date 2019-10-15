package polinema.ac.id.rumusbangun.activities.RuangDatar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import polinema.ac.id.rumusbangun.R;
import polinema.ac.id.rumusbangun.activities.MenuActivity;
import polinema.ac.id.rumusbangun.fragments.HasilFragment;
import polinema.ac.id.rumusbangun.fragments.Layang.KelilingLayang;
import polinema.ac.id.rumusbangun.fragments.Layang.LuasLayang;

public class LayangActivity extends AppCompatActivity implements KelilingLayang.OnFragmentInteractionListener, LuasLayang.OnFragmentInteractionListener, HasilFragment.OnFragmentInteractionListener {

    private HasilFragment hasilFragment;
    private LuasLayang luasLayang;
    private KelilingLayang kelilingLayang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layang);
        hasilFragment = new HasilFragment();
        luasLayang = new LuasLayang();
        kelilingLayang = new KelilingLayang();
    }

    @Override
    public void kembaliMenu(String menu) {
        startActivity(new Intent(LayangActivity.this, MenuActivity.class));
        finish();
    }

    public void handlerClickLuasLayang(View view) {
        getSupportFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).replace(R.id.frame_layang, luasLayang).commit();
    }

    public void handlerClickKelilingLayang(View view) {
        getSupportFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).replace(R.id.frame_layang, kelilingLayang).commit();
    }

    @Override
    public void hitungKelilingLayang(float hasil) {
        hasilFragment.setInformation("Hasil Keliling Layang Layang");
        hasilFragment.setHasil(String.format("Hasil Perhitungan %.2f", hasil));
        hasilFragment.setRumus("Rumus = sisi1 + sisi2 + sisi3 + sisi4");
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layang, hasilFragment).commit();
    }

    @Override
    public void hitungLuasLayang(float hasil) {
        hasilFragment.setInformation("Hasil Luas Layang Layang");
        hasilFragment.setHasil(String.format("Hasil Perhitungan %.2f", hasil));
        hasilFragment.setRumus("Rumus = (diagonal 1 * diagonal 2) / 2 ");
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layang, hasilFragment).commit();
    }
}
