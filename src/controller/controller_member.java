/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import view.dataMember;
import java.sql.SQLException;

/**
 *
 * @author agung
 */
public interface controller_member {
    public void Simpan(dataMember member) throws SQLException; 
    public void Hapus(dataMember member) throws SQLException; 
    public void Tampil(dataMember member) throws SQLException; 
    public void Update(dataMember member) throws SQLException;
    public void Baru(dataMember member); 
    public void KlikTabel(dataMember member) throws SQLException; 
    public void Show(dataMember member) throws SQLException;
}
