/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import java.util.ArrayList;
import Model.Pelanggan;
/**
 *
 * @author LENOVO
 */
public class PelangganRepository {
    private ArrayList<Pelanggan> daftarPelanggan;

    public PelangganRepository(){

        daftarPelanggan = new ArrayList<>();

        isiDataAwal();

    }



    private void isiDataAwal(){

        Pelanggan pelanggan1 = new Pelanggan(
                "P001",
                "Andi",
                "08123456789",
                "Jakarta"
        );


        daftarPelanggan.add(pelanggan1);

    }


    public void tambahPelanggan(Pelanggan pelanggan){

    if(pelanggan == null){

        throw new IllegalArgumentException(
                "Data pelanggan tidak boleh kosong"
        );

    }


    if(cariPelanggan(pelanggan.getIdPelanggan()) != null){

        throw new IllegalArgumentException(
                "ID Pelanggan sudah digunakan"
        );

    }


    daftarPelanggan.add(pelanggan);

}


    public ArrayList<Pelanggan> getSemuaPelanggan(){

        return daftarPelanggan;

    }


    public Pelanggan cariPelanggan(String idPelanggan){


        if(idPelanggan == null || idPelanggan.trim().isEmpty()){

            throw new IllegalArgumentException(
                    "ID Pelanggan tidak boleh kosong"
            );

        }



        for(Pelanggan p : daftarPelanggan){


            if(p.getIdPelanggan().equals(idPelanggan)){

                return p;

            }

        }


        return null;

    }


    public void updatePelanggan(
            String idPelanggan,
            String nomorTelepon,
            String alamat
    ){


        Pelanggan pelanggan = cariPelanggan(idPelanggan);



        if(pelanggan == null){

            throw new IllegalArgumentException(
                    "Data pelanggan tidak ditemukan"
            );

        }



        pelanggan.setNomorTelepon(nomorTelepon);
        pelanggan.setAlamat(alamat);


    }


    public void hapusPelanggan(String idPelanggan){


        Pelanggan pelanggan = cariPelanggan(idPelanggan);



        if(pelanggan == null){

            throw new IllegalArgumentException(
                    "Data pelanggan tidak ditemukan"
            );

        }

        daftarPelanggan.remove(pelanggan);

    }


}