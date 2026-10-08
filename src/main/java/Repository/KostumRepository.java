/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;
import java.util.ArrayList;
import Model.Kostum;

/**
 *
 * @author LENOVO
 */
public class KostumRepository {
    private ArrayList<Kostum> daftarKostum;

    public KostumRepository(){

        daftarKostum = new ArrayList<>();

        isiDataAwal();

    }

    private void isiDataAwal(){

        Kostum kostum1 = new Kostum(
                "K001",
                "Iron Man",
                "Superhero",
                40,
                150000
        );


        daftarKostum.add(kostum1);

    }


    public void tambahKostum(Kostum kostum){

    if(kostum == null){

        throw new IllegalArgumentException(
                "Data kostum tidak boleh kosong"
        );

    }


    if(cariKostum(kostum.getIdKostum()) != null){

        throw new IllegalArgumentException(
                "ID Kostum sudah digunakan"
        );

    }


    daftarKostum.add(kostum);

}


    public ArrayList<Kostum> getSemuaKostum(){

        return daftarKostum;

    }


    public Kostum cariKostum(String idKostum){

        if(idKostum == null || idKostum.trim().isEmpty()){

            throw new IllegalArgumentException(
                    "ID Kostum tidak boleh kosong"
            );

        }


        for(Kostum k : daftarKostum){

            if(k.getIdKostum().equals(idKostum)){

                return k;

            }

        }


        return null;

    }


    public void updateKostum(
        String idKostum,
        String nama,
        String kategori,
        int ukuran,
        double hargaSewa
){


        Kostum kostum = cariKostum(idKostum);


        if(kostum == null){

            throw new IllegalArgumentException(
                    "Data kostum tidak ditemukan"
            );

        }


        kostum.setNama(nama);
        kostum.setKategori(kategori);
        kostum.setUkuran(ukuran);
        kostum.setHargaSewa(hargaSewa);


    }


    public void hapusKostum(String idKostum){


        Kostum kostum = cariKostum(idKostum);


        if(kostum == null){

            throw new IllegalArgumentException(
                    "Data kostum tidak ditemukan"
            );

        }


        daftarKostum.remove(kostum);

    }


}