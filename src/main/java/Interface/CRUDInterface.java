/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

/**
 *
 * @author LENOVO
 */
public interface CRUDInterface<T> {
    void tambah(T data);

    void tampil();

    void update(String id);

    void hapus(String id);

}
