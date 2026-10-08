/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.Peminjaman;
import Model.Pelanggan;
import Model.Kostum;
import java.util.ArrayList;
import Repository.PeminjamanRepository;
import Repository.PelangganRepository;
import Repository.KostumRepository;
import Interface.CRUDInterface;
import Repository.Database;
/**
 *
 * @author LENOVO
 */
public class PeminjamanController implements CRUDInterface<Peminjaman> {
    private PeminjamanRepository peminjamanRepository;
    private PelangganRepository pelangganRepository;
    private KostumRepository kostumRepository;

    public PeminjamanController(){

    peminjamanRepository =
            Database.peminjamanRepository;

    pelangganRepository =
            Database.pelangganRepository;

    kostumRepository =
            Database.kostumRepository;

}

    public void tambahPeminjaman(
            String idPeminjaman,
            String idPelanggan,
            String idKostum,
            String tanggalPinjam,
            String tanggalPengembalian
    ){
        
        Pelanggan pelanggan =
                pelangganRepository
                .cariPelanggan(idPelanggan);

        if(pelanggan == null){

            throw new IllegalArgumentException(
                    "Pelanggan tidak ditemukan"
            );

        }
        
        Kostum kostum =
                kostumRepository
                .cariKostum(idKostum);

        if(kostum == null){

            throw new IllegalArgumentException(
                    "Kostum tidak ditemukan"
            );

        }

        if(
            peminjamanRepository
            .cekKostumDipinjam(idKostum)
        ){

            throw new IllegalArgumentException(
                    "Kostum sedang dipinjam"
            );

        }

        Peminjaman peminjaman =
                new Peminjaman(
                        idPeminjaman,
                        pelanggan,
                        kostum,
                        tanggalPinjam,
                        tanggalPengembalian
                );

        peminjamanRepository
                .tambahPeminjaman(peminjaman);

    }


    public ArrayList<Peminjaman>
            tampilSemuaPeminjaman(){


        return peminjamanRepository
                .getSemuaPeminjaman();

    }


    public Peminjaman cariPeminjaman(
            String idPeminjaman
    ){

        return peminjamanRepository
                .cariPeminjaman(idPeminjaman);

    }


    public void kembalikanKostum(
            String idPeminjaman
    ){

        peminjamanRepository
                .updateStatusPengembalian(
                        idPeminjaman
                );

    }


    public void hapusPeminjaman(
            String idPeminjaman
    ){

        peminjamanRepository
                .hapusPeminjaman(
                        idPeminjaman
                );

    }
@Override
public void tambah(Peminjaman peminjaman){

    if(peminjaman == null){

        throw new IllegalArgumentException(
                "Data peminjaman tidak boleh kosong"
        );

    }

    peminjamanRepository
            .tambahPeminjaman(peminjaman);

}


@Override
public void tampil(){

    for(Peminjaman p : tampilSemuaPeminjaman()){

        p.tampilData();

        System.out.println();

    }

}


@Override
public void update(String id){

    kembalikanKostum(id);

}


@Override
public void hapus(String id){

    hapusPeminjaman(id);

}


}
