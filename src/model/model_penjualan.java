/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.controller_penjualan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import koneksi.koneksi;
import view.penjualan;

/**
 *
 * @author dhenie
 */
public class model_penjualan implements controller_penjualan {

    @Override
    public void Baru(penjualan pj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Simpan(penjualan pj) throws SQLException {
try {
            Connection con = koneksi.getKoneksi(); 
            String sql = "insert transaksi values(?,?,?,?,?)"; 
            PreparedStatement prepare= con.prepareStatement(sql); 
            prepare.setString(1, pj.faktur.getText()); 
            prepare.setString(2, pj.tgl.getText()); 
            prepare.setString(3, (String) pj.m_cobox.getSelectedItem()); 
            prepare.setString(4, (String) pj.b_cobox.getSelectedItem()); 
            prepare.setString(5, pj.qty.getText());
            prepare.executeUpdate(); 
            JOptionPane.showMessageDialog(null, "Data Berhasil di Simpan"); 
            prepare.close(); 
        } catch (Exception e) {
            System.out.println(e); 
        } 
        finally{ 
             
        }
    }

    @Override
    public void Hapus(penjualan pj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void m_cmb(penjualan pj) throws SQLException {
try
{
Connection con = koneksi.getKoneksi();    
Statement stats = con.createStatement();
String sql="SELECT * from member";
ResultSet isi = stats.executeQuery(sql);
while(isi.next()){
           pj.m_cobox.addItem(isi.getString(1));
           }
   }catch (Exception e){
        JOptionPane.showMessageDialog(null,"error :"+e.getMessage());
        }
    }
    public void m_cmb_d(penjualan pj) throws SQLException {
try
{
Connection con = koneksi.getKoneksi();   
Statement stats = con.createStatement();
String sql2="SELECT * from member where kd_member='"+pj.m_cobox.getSelectedItem()+"'";
ResultSet data = stats.executeQuery(sql2);
while(data.next()){
            pj.n_member.setText(data.getString(2));
            pj.alamat.setText(data.getString(3));
            pj.tlp.setText(data.getString(4));
           }
   }catch (Exception e){
        JOptionPane.showMessageDialog(null,"error :"+e.getMessage());
        } 
    }


    @Override
    public void b_cmb(penjualan pj) throws SQLException {
try
{
Connection con = koneksi.getKoneksi();    
Statement stats = con.createStatement();
String sql="SELECT * from barang";
ResultSet isi = stats.executeQuery(sql);
while(isi.next()){
           pj.b_cobox.addItem(isi.getString(1));
           }
   }catch (Exception e){
        JOptionPane.showMessageDialog(null,"error :"+e.getMessage());
        }
    }
    public void b_cmb_d(penjualan pj) throws SQLException {  
try
{
Connection con = koneksi.getKoneksi();   
Statement stats = con.createStatement();
String sql2="SELECT * from barang where id_barang='"+pj.b_cobox.getSelectedItem()+"'";
ResultSet data = stats.executeQuery(sql2);
while(data.next()){
            pj.n_barang.setText(data.getString(2));
            pj.hrg.setText(data.getString(4));
           }
   }catch (Exception e){
        JOptionPane.showMessageDialog(null,"error :"+e.getMessage());
        }
    }  
}
