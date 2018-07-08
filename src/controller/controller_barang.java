/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import view.dataBarang;
import java.sql.SQLException;

/**
 *
 * @author agung
 */
public interface controller_barang {
    public void Simpan(dataBarang barang) throws SQLException; 
    public void Hapus(dataBarang barang) throws SQLException; 
    public void Tampil(dataBarang barang) throws SQLException; 
    public void Update(dataBarang barang) throws SQLException;
    public void Baru(dataBarang barang); 
    public void KlikTabel(dataBarang barang) throws SQLException; 
    public void Show(dataBarang barang) throws SQLException;
}
