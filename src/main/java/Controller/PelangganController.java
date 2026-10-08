/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.util.ArrayList;
import Model.Pelanggan;
import Repository.PelangganRepository;
import Interface.CRUDInterface;
import Repository.Database;
/**
 *
 * @author LENOVO
 */
public class PelangganController implements CRUDInterface<Pelanggan> {
    private PelangganRepository repository;



    public PelangganController(){

    repository = Database.pelangganRepository;

}


    public void tambahPelanggan(Pelanggan pelanggan){


        if(pelanggan == null){

            throw new IllegalArgumentException(
                    "Data pelanggan tidak boleh kosong"
            );

        }


        repository.tambahPelanggan(pelanggan);

    }

    public ArrayList<Pelanggan> tampilSemuaPelanggan(){

        return repository.getSemuaPelanggan();

    }

    public Pelanggan cariPelanggan(String idPelanggan){

        return repository.cariPelanggan(idPelanggan);

    }

    public void updatePelanggan(
            String idPelanggan,
            String nomorTelepon,
            String alamat
    ){


        repository.updatePelanggan(
                idPelanggan,
                nomorTelepon,
                alamat
        );

    }

    public void hapusPelanggan(String idPelanggan){


        repository.hapusPelanggan(idPelanggan);

    }

@Override
public void tambah(Pelanggan pelanggan){

    tambahPelanggan(pelanggan);

}


@Override
public void tampil(){

    for(Pelanggan p : tampilSemuaPelanggan()){

        p.tampilData();

        System.out.println();

    }

}


@Override
public void update(String id){

    System.out.println(
            "Update menggunakan updatePelanggan()"
    );

}


@Override
public void hapus(String id){

    hapusPelanggan(id);

}}