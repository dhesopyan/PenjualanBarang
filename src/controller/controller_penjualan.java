/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import view.penjualan;
import java.sql.SQLException;

/**
 *
 * @author agung
 */
public interface controller_penjualan {
    public void Baru(penjualan pj);
    public void Simpan(penjualan pj) throws SQLException; 
    public void Hapus(penjualan pj) throws SQLException;
    public void m_cmb(penjualan pj) throws SQLException;
    public void m_cmb_d(penjualan pj) throws SQLException;
    public void b_cmb(penjualan pj) throws SQLException;
    public void b_cmb_d(penjualan pj) throws SQLException;
}
