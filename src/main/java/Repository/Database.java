/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

/**
 *
 * @author LENOVO
 */
public class Database {
    public static KostumRepository kostumRepository;
    public static PelangganRepository pelangganRepository;
    public static PeminjamanRepository peminjamanRepository;

    static{
        kostumRepository = new KostumRepository();
        pelangganRepository = new PelangganRepository();
        peminjamanRepository = new PeminjamanRepository();
    }
}

