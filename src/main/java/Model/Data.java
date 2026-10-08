/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author LENOVO
 */
public abstract class Data {
    protected String nama;


    public Data(String nama){

        setNama(nama);

    }


    public String getNama(){

        return nama;

    }


    public void setNama(String nama){

        if(nama == null || nama.trim().isEmpty()){

            throw new IllegalArgumentException(
                    "Nama tidak boleh kosong"
            );

        }


        this.nama = nama;

    }


    public abstract void tampilData();


    public void tampilData(String judul){

        System.out.println(
                "=== " + judul + " ==="
        );

        tampilData();

    }

}