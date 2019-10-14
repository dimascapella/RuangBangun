package polinema.ac.id.rumusbangun.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import polinema.ac.id.rumusbangun.R;
import polinema.ac.id.rumusbangun.fragments.HasilFragment;
import polinema.ac.id.rumusbangun.fragments.Prisma.KelilingPrisma;
import polinema.ac.id.rumusbangun.fragments.Prisma.LuasAlasPrisma;
import polinema.ac.id.rumusbangun.fragments.Prisma.LuasPermukaanPrisma;
import polinema.ac.id.rumusbangun.fragments.Prisma.LuasSelimutPrisma;
import polinema.ac.id.rumusbangun.fragments.Prisma.VolumePrisma;

public class PrismaActivity extends AppCompatActivity implements LuasAlasPrisma.OnFragmentInteractionListener,KelilingPrisma.OnFragmentInteractionListener,LuasSelimutPrisma.OnFragmentInteractionListener, LuasPermukaanPrisma.OnFragmentInteractionListener,HasilFragment.OnFragmentInteractionListener, VolumePrisma.OnFragmentInteractionListener {

    private HasilFragment hasilFragment;
    private VolumePrisma volumePrisma;
    private LuasPermukaanPrisma luasPermukaanPrisma;
    private LuasSelimutPrisma luasSelimutPrisma;
    private KelilingPrisma kelilingPrisma;
    private LuasAlasPrisma luasAlasPrisma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prisma);
        hasilFragment = new HasilFragment();
        volumePrisma = new VolumePrisma();
        luasPermukaanPrisma = new LuasPermukaanPrisma();
        luasSelimutPrisma = new LuasSelimutPrisma();
        kelilingPrisma = new KelilingPrisma();
        luasAlasPrisma = new LuasAlasPrisma();
    }

    @Override
    public void kembaliMenu(String menu) {
        startActivity(new Intent(PrismaActivity.this, MenuActivity.class));
        finish();
    }

    public void handlerClickLPPrisma(View view) {
        getSupportFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).replace(R.id.frame_prisma, luasPermukaanPrisma).commit();
    }

    public void handlerClickVPrisma(View view) {
        getSupportFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).replace(R.id.frame_prisma, volumePrisma).commit();
    }

    public void handlerClickSelimutPrisma(View view) {
        getSupportFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).replace(R.id.frame_prisma, luasSelimutPrisma).commit();
    }

    public void handlerClickKlPrisma(View view) {
        getSupportFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).replace(R.id.frame_prisma, kelilingPrisma).commit();
    }

    public void handlerClickLAPrisma(View view) {
        getSupportFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).replace(R.id.frame_prisma, luasAlasPrisma).commit();
    }

    @Override
    public void hitungVolumePrisma(float hasil) {
        hasilFragment.setInformation("Hasil Volume Prisma");
        hasilFragment.setHasil(String.format("Hasil Perhitungan %.2f", hasil));
        hasilFragment.setRumus("Rumus = ((alas prisma x garis tengah)/2) x tinggi");
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_prisma, hasilFragment).commit();
    }

    @Override
    public void hitungLuasPermukaanPrisma(float hasil) {
        hasilFragment.setInformation("Hasil Luas Permukaan Prisma");
        hasilFragment.setHasil(String.format("Hasil Perhitungan %.2f", hasil));
        hasilFragment.setRumus("Rumus = (2 x luas alas) + (keliling alas x tinggi)");
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_prisma, hasilFragment).commit();
    }

    @Override
    public void hitungLuasSelimutPrisma(float hasil) {
        hasilFragment.setInformation("Hasil Luas Selimut Prisma");
        hasilFragment.setHasil(String.format("Hasil Perhitungan %.2f", hasil));
        hasilFragment.setRumus("Rumus = panjang x lebar");
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_prisma, hasilFragment).commit();
    }

    @Override
    public void hitungKelilingPrisma(float hasil) {
        hasilFragment.setInformation("Hasil Keliling Alas Prisma");
        hasilFragment.setHasil(String.format("Hasil Perhitungan %.2f", hasil));
        hasilFragment.setRumus("Rumus = sisi x sisi x sisi");
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_prisma, hasilFragment).commit();
    }

    @Override
    public void hitungLuasAlasPrisma(float hasil) {
        hasilFragment.setInformation("Hasil Luas Alas Prisma");
        hasilFragment.setHasil(String.format("Hasil Perhitungan %.2f", hasil));
        hasilFragment.setRumus("Rumus = volume / tinggi");
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_prisma, hasilFragment).commit();
    }

    @Override
    public void onBackPressed(){
        this.finish();
    }
}
