/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author LENOVO
 */
public class Kostum extends Data {
    private final String idKostum;
    private String kategori;
    private int ukuran;
    private double hargaSewa;


    public Kostum(
            String idKostum,
            String nama,
            String kategori,
            int ukuran,
            double hargaSewa
    ) {

        super(nama);

        if (idKostum == null || idKostum.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "ID Kostum tidak boleh kosong"
            );
        }

        this.idKostum = idKostum;

        setKategori(kategori);
        setUkuran(ukuran);
        setHargaSewa(hargaSewa);
    }


    public String getIdKostum() {
        return idKostum;
    }


    public String getKategori() {
        return kategori;
    }


    public void setKategori(String kategori) {

        if (kategori == null || kategori.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Kategori tidak boleh kosong"
            );
        }

        this.kategori = kategori;
    }


    public int getUkuran() {
        return ukuran;
    }


    public void setUkuran(int ukuran) {

        if (ukuran < 20 || ukuran > 60) {

            throw new IllegalArgumentException(
                    "Ukuran kostum harus antara 20-60"
            );

        }

        this.ukuran = ukuran;
    }


    public double getHargaSewa() {
        return hargaSewa;
    }


    public void setHargaSewa(double hargaSewa) {

        if (hargaSewa <= 0) {

            throw new IllegalArgumentException(
                    "Harga sewa harus lebih dari 0"
            );

        }

        this.hargaSewa = hargaSewa;
    }

    @Override
    public void tampilData() {

        System.out.println("ID Kostum : " + idKostum);
        System.out.println("Nama Kostum : " + nama);
        System.out.println("Kategori : " + kategori);
        System.out.println("Ukuran : " + ukuran);
        System.out.println("Harga Sewa : " + hargaSewa);

    }

}
