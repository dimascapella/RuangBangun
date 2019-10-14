package polinema.ac.id.rumusbangun.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import polinema.ac.id.rumusbangun.R;
import polinema.ac.id.rumusbangun.fragments.HasilFragment;
import polinema.ac.id.rumusbangun.fragments.LuasPermukaanPrisma;
import polinema.ac.id.rumusbangun.fragments.VolumePrisma;

public class PrismaActivity extends AppCompatActivity implements LuasPermukaanPrisma.OnFragmentInteractionListener,HasilFragment.OnFragmentInteractionListener, VolumePrisma.OnFragmentInteractionListener {

    private HasilFragment hasilFragment;
    private VolumePrisma volumePrisma;
    private LuasPermukaanPrisma luasPermukaanPrisma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prisma);
        hasilFragment = new HasilFragment();
        volumePrisma = new VolumePrisma();
        luasPermukaanPrisma = new LuasPermukaanPrisma();
    }

    @Override
    public void kembaliMenu(String menu) {
        startActivity(new Intent(PrismaActivity.this, MenuActivity.class));
        finish();
    }

    public void handlerClickLPPrisma(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_prisma, luasPermukaanPrisma).commit();
    }

    public void handlerClickVPrisma(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_prisma, volumePrisma).commit();
    }

    public void handlerClickSelimutPrisma(View view) {
    }

    public void handlerClickKlPrisma(View view) {
    }

    public void handlerClickLAPrisma(View view) {
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
}
