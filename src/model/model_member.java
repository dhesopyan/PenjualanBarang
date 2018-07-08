/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.controller_member;
import koneksi.koneksi;
import view.dataMember;
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
public class model_member implements controller_member {
    @Override
    public void Simpan(dataMember dtmember) throws SQLException {
        try {
            Connection con = koneksi.getKoneksi(); 
            String sql = "insert member values(?,?,?,?)"; 
            PreparedStatement prepare= con.prepareStatement(sql); 
            prepare.setString(1, dtmember.kdmember.getText()); 
            prepare.setString(2, dtmember.nmmember.getText()); 
            prepare.setString(3, dtmember.alamat.getText()); 
            prepare.setString(4, dtmember.notlp.getText()); 
            prepare.executeUpdate(); 
            JOptionPane.showMessageDialog(null, "Data Berhasil di Simpan"); 
            prepare.close(); 
        } catch (Exception e) {
            System.out.println(e); 
        } 
        finally{ 
            Tampil(dtmember); 
        }
    }
    
    @Override
    public void Hapus(dataMember dtmember) throws SQLException {
        try {
            Connection con = koneksi.getKoneksi(); 
            String sql = "delete from member where kd_member= ?"; 
            PreparedStatement prepare= con.prepareStatement(sql); 
            prepare.setString(1, dtmember.kdmember.getText()); 
            prepare.executeUpdate(); 
            JOptionPane.showMessageDialog(null, "Data Berhasil di Hapus"); 
            prepare.close();
        } 
        catch (Exception e) { 
            System.out.println(e);
        }
    }
    
    @Override
    public void Tampil(dataMember dtmember) throws SQLException {
        try {
            Connection con = koneksi.getKoneksi(); 
            String sql = "select * from member where kd_member= '"+dtmember.kdmember.getText()+"'"; 
            PreparedStatement prepare= con.prepareStatement(sql);        
            ResultSet isi = prepare.executeQuery(sql);
            while(isi.next()){
                dtmember.kdmember.setText(isi.getString(1));
                dtmember.nmmember.setText(isi.getString(2));
                dtmember.alamat.setText(isi.getString(3));
                dtmember.notlp.setText(isi.getString(4));
            }       
        } 
        catch (Exception e) {
            System.out.println(e);
        }
    }
    
    @Override
    public void Update(dataMember dtmember) throws SQLException {
        try { 
            Connection con = koneksi.getKoneksi(); 
            String sql = "update member set nama_member= ?, alamat= ?, tlp= ? where kd_member= ?";
            PreparedStatement prepare= con.prepareStatement(sql); 
            prepare.setString(4, dtmember.kdmember.getText()); 
            prepare.setString(1, dtmember.nmmember.getText()); 
            prepare.setString(2, dtmember.alamat.getText()); 
            prepare.setString(3, dtmember.notlp.getText()); 
            prepare.executeUpdate(); 
            JOptionPane.showMessageDialog(null, "Data Berhasil di Ubah"); 
            prepare.close(); 
        } 
        catch (Exception e) {
            System.out.println(e); 
        }
    }
    
    @Override
    public void Baru(dataMember dtmember) {
        dtmember.kdmember.setText("");
        dtmember.nmmember.setText("");
        dtmember.alamat.setText("");
        dtmember.notlp.setText("");
   }
    
    @Override
    public void KlikTabel(dataMember dtmember) throws SQLException {
        try { 
            int pilih = dtmember.tblmodel.getSelectedRow(); 
            if (pilih == -1 ){
                return; 
            } 
            dtmember.kdmember.setText(dtmember.tblmodel.getValueAt(pilih, 0).toString());
            dtmember.nmmember.setText(dtmember.tblmodel.getValueAt(pilih, 1).toString());
            dtmember.alamat.setText(dtmember.tblmodel.getValueAt(pilih, 2).toString()); 
            dtmember.notlp.setText(dtmember.tblmodel.getValueAt(pilih, 3).toString());  
        } catch (Exception e) { }
    }
    
    @Override
    public void Show(dataMember dtmember) throws SQLException {
        dtmember.tabel.getDataVector().removeAllElements(); 
        dtmember.tabel.fireTableDataChanged(); 
        try {
            Connection con = koneksi.getKoneksi(); 
            Statement stt = con.createStatement(); 
            String sql = "select * from member order by kd_member asc"; 
            ResultSet res = stt.executeQuery(sql); 
            while(res.next()) { Object[] ob= new Object[8]; 
            ob[0] = res.getString(1); ob[1] = res.getString(2); 
            ob[2] = res.getString(3); ob[3] = res.getString(4); 
            dtmember.tabel.addRow(ob);
            }
        } catch (Exception e) { 
            System.out.println(e); 
        }
    }
    
}
