/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import java.util.ArrayList;
import Model.Peminjaman;
import Model.Pelanggan;
import Model.Kostum;
/**
 *
 * @author LENOVO
 */
public class PeminjamanRepository {
    private ArrayList<Peminjaman> daftarPeminjaman;

    public PeminjamanRepository(){

        daftarPeminjaman = new ArrayList<>();

        isiDataAwal();

    }


    private void isiDataAwal(){

        Pelanggan pelanggan1 = new Pelanggan(
                "P001",
                "Andi",
                "08123456789",
                "Jakarta"
        );

        Kostum kostum1 = new Kostum(
                "K001",
                "Iron Man",
                "Superhero",
                40,
                150000
        );

        Peminjaman peminjaman1 = new Peminjaman(
                "PM001",
                pelanggan1,
                kostum1,
                "20-09-2026",
                "22-09-2026"
        );

        daftarPeminjaman.add(peminjaman1);

    }


    public void tambahPeminjaman(
        Peminjaman peminjaman
){

    if(peminjaman == null){

        throw new IllegalArgumentException(
                "Data peminjaman tidak boleh kosong"
        );

    }


    if(cariPeminjaman(peminjaman.getIdPeminjaman()) != null){

        throw new IllegalArgumentException(
                "ID Peminjaman sudah digunakan"
        );

    }


    daftarPeminjaman.add(peminjaman);

}


    public ArrayList<Peminjaman>
            getSemuaPeminjaman(){

        return daftarPeminjaman;
    }


    public Peminjaman cariPeminjaman(
            String idPeminjaman
    ){

        if(idPeminjaman == null ||
           idPeminjaman.trim().isEmpty()){

            throw new IllegalArgumentException(
                    "ID Peminjaman tidak boleh kosong"
            );

        }

        for(Peminjaman p : daftarPeminjaman){

            if(p.getIdPeminjaman()
                    .equals(idPeminjaman)){

                return p;
            }
        }
        return null;
    }


    public void updateStatusPengembalian(
        String idPeminjaman
){

    if(idPeminjaman == null ||
       idPeminjaman.trim().isEmpty()){

        throw new IllegalArgumentException(
                "ID Peminjaman tidak boleh kosong"
        );

    }

    Peminjaman peminjaman =
            cariPeminjaman(idPeminjaman);

    if(peminjaman == null){

        throw new IllegalArgumentException(
                "Data peminjaman tidak ditemukan"
        );

    }

    peminjaman.kembalikanKostum();

}

    
    public void hapusPeminjaman(
            String idPeminjaman
    ){
        Peminjaman peminjaman =
                cariPeminjaman(idPeminjaman);

        if(peminjaman == null){

            throw new IllegalArgumentException(
                    "Data peminjaman tidak ditemukan"
            );
        }
        daftarPeminjaman.remove(peminjaman);
    }


    public boolean cekKostumDipinjam(
            String idKostum
    ){

        if(idKostum == null ||
           idKostum.trim().isEmpty()){


            throw new IllegalArgumentException(
                    "ID Kostum tidak boleh kosong"
            );

        }

        for(Peminjaman p : daftarPeminjaman){

            if(
                p.getKostum()
                 .getIdKostum()
                 .equals(idKostum)

                &&

                p.getStatusPeminjaman()
                 .equals("Dipinjam")
            ){
                return true;
            }
        }
        return false;
    }

}