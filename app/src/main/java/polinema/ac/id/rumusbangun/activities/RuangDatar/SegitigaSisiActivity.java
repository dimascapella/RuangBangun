package polinema.ac.id.rumusbangun.activities.RuangDatar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import polinema.ac.id.rumusbangun.R;
import polinema.ac.id.rumusbangun.activities.MenuActivity;
import polinema.ac.id.rumusbangun.fragments.HasilFragment;
import polinema.ac.id.rumusbangun.fragments.SegitigaSisi.KelilingSegitigaSisi;
import polinema.ac.id.rumusbangun.fragments.SegitigaSisi.LuasSegitigaSisi;

public class SegitigaSisiActivity extends AppCompatActivity implements KelilingSegitigaSisi.OnFragmentInteractionListener, LuasSegitigaSisi.OnFragmentInteractionListener, HasilFragment.OnFragmentInteractionListener {

    private HasilFragment hasilFragment;
    private LuasSegitigaSisi luasSegitigaSisi;
    private KelilingSegitigaSisi kelilingSegitigaSisi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segitiga_sisi);
        hasilFragment = new HasilFragment();
        luasSegitigaSisi = new LuasSegitigaSisi();
        kelilingSegitigaSisi = new KelilingSegitigaSisi();
    }

    @Override
    public void kembaliMenu(String menu) {
        startActivity(new Intent(SegitigaSisiActivity.this, MenuActivity.class));
        finish();
    }

    public void handlerClickLuasSegitigaSisi(View view) {
        getSupportFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).replace(R.id.frame_segitigaSisi, luasSegitigaSisi).commit();
    }

    public void handlerClickKelilingSegitigaSisi(View view) {
        getSupportFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).replace(R.id.frame_segitigaSisi, kelilingSegitigaSisi).commit();
    }

    @Override
    public void hitungKelilingSegitigaSisi(float hasil) {
        hasilFragment.setInformation("Hasil Keliling Segitiga Sama Sisi");
        hasilFragment.setHasil(String.format("Hasil Perhitungan %.2f", hasil));
        hasilFragment.setRumus("Rumus = alas + tinggi + lebar ");
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_segitigaSisi, hasilFragment).commit();
    }

    @Override
    public void hitungLuasSegitigaSisi(float hasil) {
        hasilFragment.setInformation("Hasil Luas Segitiga Sama Sisi");
        hasilFragment.setHasil(String.format("Hasil Perhitungan %.2f", hasil));
        hasilFragment.setRumus("Rumus = (alas x tinggi) / 2");
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_segitigaSisi, hasilFragment).commit();
    }
}
