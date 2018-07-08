/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.controller_barang;
import koneksi.koneksi;
import view.dataBarang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author agung
 */
public class model_barang implements controller_barang {
    @Override
    public void Simpan(dataBarang dtbarang) throws SQLException {
        try {
            Connection con = koneksi.getKoneksi(); 
            String sql = "insert barang values(?,?,?,?)"; 
            PreparedStatement prepare= con.prepareStatement(sql); 
            prepare.setString(1, dtbarang.kdbarang.getText()); 
            prepare.setString(2, dtbarang.nmbarang.getText()); 
            prepare.setString(3, dtbarang.stok.getText()); 
            prepare.setString(4, dtbarang.harga.getText()); 
            prepare.executeUpdate(); 
            JOptionPane.showMessageDialog(null, "Data Berhasil di Simpan"); 
            prepare.close(); 
        } catch (Exception e) {
            System.out.println(e); 
        } 
        finally{ 
            Tampil(dtbarang); 
        }
    }
    
    @Override
    public void Hapus(dataBarang dtbarang) throws SQLException {
        try {
            Connection con = koneksi.getKoneksi(); 
            String sql = "delete from barang where id_barang= ?"; 
            PreparedStatement prepare= con.prepareStatement(sql); 
            prepare.setString(1, dtbarang.kdbarang.getText()); 
            prepare.executeUpdate(); 
            JOptionPane.showMessageDialog(null, "Data Berhasil di Hapus"); 
            prepare.close();
        } 
        catch (Exception e) { 
            System.out.println(e);
        }
    }
    
    @Override
    public void Tampil(dataBarang dtbarang) throws SQLException {
        try {
            Connection con = koneksi.getKoneksi(); 
            String sql = "select * from barang where id_barang= '"+dtbarang.kdbarang.getText()+"'"; 
            PreparedStatement prepare= con.prepareStatement(sql);        
            ResultSet isi = prepare.executeQuery(sql);
            while(isi.next()){
                dtbarang.kdbarang.setText(isi.getString(1));
                dtbarang.nmbarang.setText(isi.getString(2));
                dtbarang.stok.setText(isi.getString(3));
                dtbarang.harga.setText(isi.getString(4));
            }       
        } 
        catch (Exception e) {
            System.out.println(e);
        }
    }
    
    @Override
    public void Update(dataBarang dtbarang) throws SQLException {
        try { 
            Connection con = koneksi.getKoneksi(); 
            String sql = "update barang set nama_barang= ?, stok= ?, harga= ? where id_barang= ?";
            PreparedStatement prepare= con.prepareStatement(sql); 
            prepare.setString(4, dtbarang.kdbarang.getText()); 
            prepare.setString(1, dtbarang.nmbarang.getText()); 
            prepare.setString(2, dtbarang.stok.getText()); 
            prepare.setString(3, dtbarang.harga.getText()); 
            prepare.executeUpdate(); 
            JOptionPane.showMessageDialog(null, "Data Berhasil di Ubah"); 
            prepare.close(); 
        } 
        catch (Exception e) {
            System.out.println(e); 
        }
    }

    @Override
    public void Baru(dataBarang dtbarang) {
        dtbarang.kdbarang.setText("");
        dtbarang.nmbarang.setText("");
        dtbarang.stok.setText("");
        dtbarang.harga.setText("");
   }
    
    @Override
    public void KlikTabel(dataBarang dtbarang) throws SQLException {
        try { 
            int pilih = dtbarang.tblmodel.getSelectedRow(); 
            if (pilih == -1 ){
                return; 
            } 
            dtbarang.kdbarang.setText(dtbarang.tblmodel.getValueAt(pilih, 0).toString());
            dtbarang.nmbarang.setText(dtbarang.tblmodel.getValueAt(pilih, 1).toString());
            dtbarang.stok.setText(dtbarang.tblmodel.getValueAt(pilih, 2).toString()); 
            dtbarang.harga.setText(dtbarang.tblmodel.getValueAt(pilih, 3).toString());  
        } catch (Exception e) { }
    }
    
    @Override
    public void Show(dataBarang dtbarang) throws SQLException {
        dtbarang.tabel.getDataVector().removeAllElements(); 
        dtbarang.tabel.fireTableDataChanged(); 
        try {
            Connection con = koneksi.getKoneksi(); 
            Statement stt = con.createStatement(); 
            String sql = "select * from barang order by id_barang asc"; 
            ResultSet res = stt.executeQuery(sql); 
            while(res.next()) { Object[] ob= new Object[8]; 
            ob[0] = res.getString(1); ob[1] = res.getString(2); 
            ob[2] = res.getString(3); ob[3] = res.getString(4); 
            dtbarang.tabel.addRow(ob);
            }
        } catch (Exception e) { 
            System.out.println(e); 
        }
    }
    
}