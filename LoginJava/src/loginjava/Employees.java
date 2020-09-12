/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginjava;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author user
 */
public class Employees {
    private static final AtomicInteger count = new AtomicInteger(0);
    private String idKaryawan;
    private String namaDepan;
    private String namaBelakang;
    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    public void inputData(int no, String nama, String password) {
        this.idKaryawan = " " +no;
        String[] namaLeng = nama.split(" ");
        if (namaLeng.length>2){
          this.namaDepan = namaLeng[0]+namaLeng[1];
          this.namaBelakang = namaLeng[2]+namaLeng[3];
        } else {
            this.namaDepan = namaLeng[0];
            this.namaBelakang = namaLeng[1];
        }
        this.userName = namaDepan + namaBelakang.substring(0,2);
        this.password = BCrypt.hashpw(password, BCrypt.gensalt());
  
    }
    public void displayData(List<Employees> listPekerja){
        for (Employees employees : listPekerja) {
            System.out.println("Id Karyawan     : " + employees.idKaryawan);
            System.out.println("Nama Depan      : " + employees.namaDepan);
            System.out.println("Nama Belakang   : " + employees.namaBelakang);
            System.out.println("Username        : " + employees.userName);
            System.out.println("Password        : " + employees.password);
            System.out.println("=============================");   
        }
    }
//    public  void loginUser(String userName, String Password, List<Employees> listPekerja){
//       for (Employees employees : listPekerja ) {
//           if ((listPekerja.getUserName().constaint(userName) == true) && (BCrypt.checkpw(Password, BCrypt.hashpw(password, BCrypt.gensalt()))== true)) {
//               System.out.println("Login Berhasil");
//           } else {
//               System.out.println("Login Gagal");
//           }
//            
//       }
//        }
}
    


