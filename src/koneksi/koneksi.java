/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koneksi;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;

/**
 *
 * @author agung
 */
public class koneksi {
private static Connection koneksi; 
public static Connection getKoneksi() { 
if(koneksi== null) { try { 
String url="jdbc:mysql://localhost/penjualan"; 
String username= "root";
String password= "";
DriverManager.registerDriver(new com.mysql.jdbc.Driver()); 
koneksi =(Connection) DriverManager.getConnection(url, username, password); 
} 
catch (Exception e) { 
System.out.println(e); 
} 
} 
return koneksi; 
} 
}
