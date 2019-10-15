package polinema.ac.id.rumusbangun.activities.RuangBangun;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import polinema.ac.id.rumusbangun.R;
import polinema.ac.id.rumusbangun.activities.MenuActivity;
import polinema.ac.id.rumusbangun.fragments.balok.DiagonalBalok;
import polinema.ac.id.rumusbangun.fragments.HasilFragment;
import polinema.ac.id.rumusbangun.fragments.balok.KelilingBalok;
import polinema.ac.id.rumusbangun.fragments.balok.LuasPermukaanBalok;
import polinema.ac.id.rumusbangun.fragments.balok.VolumeBalok;

public class BalokActivity extends AppCompatActivity implements KelilingBalok.OnFragmentInteractionListener,DiagonalBalok.OnFragmentInteractionListener,LuasPermukaanBalok.OnFragmentInteractionListener, VolumeBalok.OnFragmentInteractionListener, HasilFragment.OnFragmentInteractionListener {

    private VolumeBalok volumeBalok;
    private HasilFragment hasilFragment;
    private LuasPermukaanBalok luasPermukaanBalok;
    private DiagonalBalok diagonalBalok;
    private KelilingBalok kelilingBalok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balok);
        volumeBalok = new VolumeBalok();
        hasilFragment = new HasilFragment();
        luasPermukaanBalok = new LuasPermukaanBalok();
        diagonalBalok = new DiagonalBalok();
        kelilingBalok = new KelilingBalok();
    }

    public void handlerClickLPBalok(View view) {
        getSupportFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).replace(R.id.frame_balok, luasPermukaanBalok).commit();
    }

    public void handlerClickVBalok(View view) {
        getSupportFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).replace(R.id.frame_balok, volumeBalok).commit();
    }

    public void handlerClickDgBalok(View view) {
        getSupportFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).replace(R.id.frame_balok, diagonalBalok).commit();
    }

    public void handlerClickKlBalok(View view) {
        getSupportFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).replace(R.id.frame_balok, kelilingBalok).commit();
    }

    @Override
    public void hitungVolumeBalok(float hasil) {
        hasilFragment.setInformation("Hasil Volume Balok");
        hasilFragment.setHasil(String.format("Hasil Perhitungan %.2f", hasil));
        hasilFragment.setRumus("Rumus = panjang x lebar x tinggi");
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_balok, hasilFragment).commit();
    }

    @Override
    public void kembaliMenu(String menu) {
        startActivity(new Intent(BalokActivity.this, MenuActivity.class));
        finish();
    }

    @Override
    public void hitungLuasPermukaanBalok(float hasil) {
        hasilFragment.setInformation("Hasil Luas Permukaan Balok");
        hasilFragment.setHasil(String.format("Hasil Perhitungan %.2f", hasil));
        hasilFragment.setRumus("Rumus = 2 x ((panjang x lebar) + (panjang x tinggi) + (lebar x tinggi))");
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_balok, hasilFragment).commit();
    }

    @Override
    public void hitungDiagonalBalok(float hasil) {
        hasilFragment.setInformation("Hasil Diagonal Balok");
        hasilFragment.setHasil(String.format("Hasil Perhitungan %.2f", hasil));
        hasilFragment.setRumus("Rumus = akar((panjang x panjang) + (lebar x lebar) + (tinggi x tinggi))");
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_balok, hasilFragment).commit();
    }

    @Override
    public void hitungKelilingBalok(float hasil) {
        hasilFragment.setInformation("Hasil Keliling Balok");
        hasilFragment.setHasil(String.format("Hasil Perhitungan %.2f", hasil));
        hasilFragment.setRumus("Rumus = 4 x ( panjang + lebar + tinggi )");
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_balok, hasilFragment).commit();
    }

    @Override
    public void onBackPressed(){
        this.finish();
    }
}
