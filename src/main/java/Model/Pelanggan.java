/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author LENOVO
 */
public class Pelanggan extends Data {
    private final String idPelanggan;
    private String nomorTelepon;
    private String alamat;


    public Pelanggan(
            String idPelanggan,
            String nama,
            String nomorTelepon,
            String alamat
    ) {

        super(nama);

        if (idPelanggan == null || idPelanggan.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "ID Pelanggan tidak boleh kosong"
            );
        }

        this.idPelanggan = idPelanggan;

        setNomorTelepon(nomorTelepon);
        setAlamat(alamat);

    }


    public String getIdPelanggan() {
        return idPelanggan;
    }


    public String getNomorTelepon() {
        return nomorTelepon;
    }


    public void setNomorTelepon(String nomorTelepon) {

        if (nomorTelepon == null || nomorTelepon.trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "Nomor telepon tidak boleh kosong"
            );

        }


        if (!nomorTelepon.matches("\\d+")) {

            throw new IllegalArgumentException(
                    "Nomor telepon hanya boleh berisi angka"
            );

        }


        this.nomorTelepon = nomorTelepon;

    }


    public String getAlamat() {
        return alamat;
    }


    public void setAlamat(String alamat) {

        if (alamat == null || alamat.trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "Alamat tidak boleh kosong"
            );

        }

        this.alamat = alamat;

    }


    @Override
    public void tampilData() {

        System.out.println("ID Pelanggan : " + idPelanggan);
        System.out.println("Nama Pelanggan : " + nama);
        System.out.println("Nomor Telepon : " + nomorTelepon);
        System.out.println("Alamat : " + alamat);

    }

}
