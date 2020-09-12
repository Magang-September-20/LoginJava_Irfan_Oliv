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
    private int idKaryawan;
    private String namaDepan;
    private String namaBelakang;
    private String userName;
    private String password;

    public void setIdKaryawan(int idKaryawan) {
        this.idKaryawan = idKaryawan;
    }

    public void setNamaDepan(String namaDepan) {
        this.namaDepan = namaDepan;
    }

    public void setNamaBelakang(String namaBelakang) {
        this.namaBelakang = namaBelakang;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdKaryawan() {
        return idKaryawan;
    }

    public String getNamaDepan() {
        return namaDepan;
    }

    public String getNamaBelakang() {
        return namaBelakang;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
    
    public void inputData(String nama, String password) {
        this.idKaryawan = count.incrementAndGet();
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
//    public  void loginUser(String userName, String Password){
//        if(userName.equals("admin") && password.equals("admin")){
//         this
//            
        }
    
    


