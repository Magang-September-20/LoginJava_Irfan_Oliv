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
    private String namaDepan="";
    private String namaBelakang;
    private String userName="";
    private String password;

    public void setIdKaryawan(String idKaryawan) {
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

    
    public String getIdKaryawan() {
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
    
    String generateId(){
        int no = count.incrementAndGet(); 
        String strNo = no+"";
        StringBuilder sb = new StringBuilder();
        while (sb.length() < 5 - strNo.length()) {
            sb.append('0');
        }
        sb.append(strNo);
        return sb.toString();
    }
    
    String generateNamaDepan(String nama){
        String[] namaLeng = nama.split(" ");
        if(namaLeng.length>1){
            for(int x = 0; x<namaLeng.length-1;x++){
                namaDepan += namaLeng[x] + " ";
            }
        }
        else{
            namaDepan += nama;
        }
        return namaDepan;
    }
    Boolean cekUserName(String username, List<Employees> listPekerja){
        for (Employees list : listPekerja) {
            if(list.userName.equals(username)){
                return true;
            }
        }
        return false;
    }
    String generateUserName(String namaDepan, String namaBelakang, List<Employees> listPekerja){
        String[] arrNamadepan = namaDepan.split(" ");
        userName = arrNamadepan[0]+namaBelakang.substring(0, 2);
        if(cekUserName(userName, listPekerja)){
            for(int i=arrNamadepan.length-1;i>=0;i--){
                userName = arrNamadepan[0]+arrNamadepan[i].substring(0, 2);
                if(!cekUserName(userName, listPekerja)){
                    break;
                }
            }
        }
        return userName;
    }
    
    public void inputData(String nama, String password, List<Employees> listPekerja) {
        this.idKaryawan = generateId();
        String[] namaLeng = nama.split(" ");
        namaDepan = generateNamaDepan(nama);
        namaBelakang = namaLeng[namaLeng.length-1];
        userName = generateUserName(namaDepan,namaBelakang,listPekerja);
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
    public void login (String userName, String Password,List<Employees> listPekerja){
        for (Employees list : listPekerja) {
            if(list.userName.equals(userName)== true && (BCrypt.checkpw(Password,list.password) )== true){
                System.out.println("Login Berhasil");
            }else {
                System.out.println("Login Gagal");
            }
        }
    }
//    public  void loginUser(String userName, String Password){
//        if(userName.equals("admin") && password.equals("admin")){
//         this
//            
}
    
    


