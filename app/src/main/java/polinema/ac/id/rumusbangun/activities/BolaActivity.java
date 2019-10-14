package polinema.ac.id.rumusbangun.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import polinema.ac.id.rumusbangun.R;
import polinema.ac.id.rumusbangun.fragments.HasilFragment;
import polinema.ac.id.rumusbangun.fragments.Bola.LuasPermukaanBola;
import polinema.ac.id.rumusbangun.fragments.Bola.VolumeBola;

public class BolaActivity extends AppCompatActivity implements LuasPermukaanBola.OnFragmentInteractionListener, VolumeBola.OnFragmentInteractionListener, HasilFragment.OnFragmentInteractionListener {
    private HasilFragment hasilFragment;
    private VolumeBola volumeBola;
    private LuasPermukaanBola luasPermukaanBola;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bola);
        hasilFragment = new HasilFragment();
        volumeBola = new VolumeBola();
        luasPermukaanBola = new LuasPermukaanBola();
    }

    public void handlerClickLPBola(View view) {
        getSupportFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).replace(R.id.frame_bola, luasPermukaanBola).commit();
    }

    public void handlerClickVBola(View view) {
        getSupportFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).replace(R.id.frame_bola, volumeBola).commit();
    }

    @Override
    public void kembaliMenu(String menu) {
        startActivity(new Intent(BolaActivity.this, MenuActivity.class));
        finish();
    }

    @Override
    public void hitungVolumeBola(float hasil) {
        hasilFragment.setInformation("Hasil Volume Bola");
        hasilFragment.setHasil(String.format("Hasil Perhitungan %.2f", hasil));
        hasilFragment.setRumus("Rumus = (4 x phi x r^3) / 3");
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_bola, hasilFragment).commit();
    }

    @Override
    public void hitungLuasPermukaanBola(float hasil) {
        hasilFragment.setInformation("Hasil Luas Permukaan Bola");
        hasilFragment.setHasil(String.format("Hasil Perhitungan %.2f", hasil));
        hasilFragment.setRumus("Rumus = (4 x phi x r^2)");
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_bola, hasilFragment).commit();
    }

    @Override
    public void onBackPressed(){
        this.finish();
    }
}
