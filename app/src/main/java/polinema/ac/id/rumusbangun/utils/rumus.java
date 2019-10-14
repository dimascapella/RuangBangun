package polinema.ac.id.rumusbangun.utils;

public class rumus {

    private float  hasil;
    private double phi = 3.14;

    public rumus() {
    }

    public float getHasil() {
        return hasil;
    }

    public float luasPersegi(float sisi){
        return hasil = (float) (Math.pow(sisi, 2));
    }

    public float kelilingPersegi(float sisi){
        return hasil = sisi * 4;
    }

    public float luasPersegiPanjang(float panjang, float lebar){
        return hasil = panjang * lebar;
    }

    public float kelilingPersegiPanjang(float panjang, float lebar){
        return hasil = 2*(panjang + lebar);
    }

    public float luasSegitigaSiku(float alas, float tinggi){
        return hasil = (float) 0.5 * alas * tinggi;
    }

    public float kelilingSegitigaSiku(float alas, float tinggi, float lebar){
        return hasil = alas + tinggi + lebar;
    }

    public float luasSegitigaKakiSisi(float alas, float tinggi, float lebar){
        float s = (float) 0.5*(alas + tinggi + lebar);
        return hasil = (float) (Math.sqrt(s * (s - alas) * (s - tinggi) * (s - lebar)));
    }

    public float kelilingSegitigakakiSisi(float alas, float tinggi, float lebar){
        return hasil = alas + tinggi + lebar;
    }

    public float luasJajaranGenjang(float alas, float tinggi){
        return hasil = alas * tinggi;
    }

    public float kelilingJajaranGenjang(float a, float b, float c, float d){
        return hasil = a + b + c + d;
    }

    public float luasTrapesium(float atas, float bawah, float tinggi){
        return hasil = ((atas + bawah)/2) * tinggi;
    }

    public float kelilingTrapesium(float a, float b, float c, float d){
        return hasil = a + b + c + d;
    }

    public float luasLayangKetupat(float d1, float d2){
        return hasil = (float) 0.5 * d1 * d2;
    }

    public float kelilingLayangKetupat(float a, float b, float c, float d){
        return hasil = a + b + c + d;
    }

    public float luasLingkaran(float r){
        return hasil = (float) phi * r * r;
    }

    public float kelilingLingkaran(float r){
        return hasil = (float) phi * 2 * r;
    }

    public float lpKubus(float sisi){
        return hasil = (float) (Math.pow(sisi,2)) * 6;
    }

    public float vKubus(float sisi){
        return hasil = (float) (Math.pow(sisi, 3));
    }

    public float kelilingBalok(float panjang, float lebar, float tinggi){
        return hasil = 4*(panjang + tinggi + lebar);
    }

    public float diagonalBalok(float panjang, float lebar, float tinggi){
        return hasil = (float) Math.sqrt((Math.pow(panjang,2) +(Math.pow(lebar,2)) + (Math.pow(tinggi,2)))) ;
    }

    public float lpBalok(float panjang, float lebar, float tinggi){
        return hasil = 2 * ((panjang * lebar) + (panjang * tinggi) + (lebar * tinggi));
    }

    public  float vBalok(float panjang, float lebar, float tinggi){
        return hasil = panjang * lebar * tinggi;
    }

    public float vLimas(float luas_alas, float tinggi){
        return hasil = (luas_alas * tinggi) / 3;
    }

    public float lAlasLimas(float alas, float tinggi){
        return hasil = (alas * tinggi) / 2;
    }

    public float sisiLimas(float alas, float tinggi){
        return hasil = (alas * tinggi) / 2;
    }

    public float lpLimas(float luas_alas, float sisi1, float sisi2, float sisi3){
        return hasil = luas_alas + sisi1 + sisi2 + sisi3;
    }

    public float vBola(float r){
        return hasil = (float) (4 * phi * (Math.pow(r,3))) / 3;
    }

    public float lpBola(float r){
        return hasil = (float) (4 * phi * (Math.pow(r,2)));
    }

    public float vKerucut(float r, float tinggi){
        return hasil = (float) (phi * r * r * tinggi) / 3;
    }

    public float lpKerucut(float luas_alas, float luas_selimut){
        return hasil = luas_alas + luas_selimut;
    }

    public float lSelimutKerucut(float r, float s){
        return hasil = (float) phi * r * s;
    }

    public float lAlasKerucut(float r){
        return hasil = (float) phi * r * r;
    }

    public float laTabung(float r){
        return hasil = (float) (phi * (Math.pow(r,2)));
    }

    public float vTabung(float r, float tinggi){
        return hasil = (float) (phi * (Math.pow(r,2)) * tinggi);
    }

    public float kAlasTabung(float r){
        return hasil = (float) (2 * phi * r);
    }

    public float lSelimutTabung(float r, float tinggi){
        return hasil = (float) (2 * phi * r * tinggi);
    }

    public float lpTabung(float luas_alas, float luas_selimut){
        return hasil = 2 * luas_alas * luas_selimut;
    }

    public float lpPrisma(float luas_alas, float alas, float tinggi){
        return hasil = (2 * luas_alas) + (alas * tinggi);
    }

    public float lSelimutPrisma(float panjang, float lebar){
        return hasil = panjang * lebar;
    }

    public float kelilingPrisma(float sisi){
        return hasil = (float) (Math.pow(sisi, 3));
    }

    public float lAlasPrisma(float vPrisma, float tinggi){
        return hasil = vPrisma / tinggi;
    }

    public float vPrisma(float alas_segitiga, float tinggi_segitiga, float tinggi){
        return hasil = ((alas_segitiga * tinggi_segitiga)/2) * tinggi;
    }
}
