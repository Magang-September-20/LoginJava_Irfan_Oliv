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
    private String idKaryawan;
    private String namaDepan="";
    private String namaBelakang;
    private String userName="";
    private String password;
    
    String generateId(int no){
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
        System.out.println(namaLeng.length);
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
            for(int i=0;i<arrNamadepan.length;i++){
                userName = arrNamadepan[0]+arrNamadepan[arrNamadepan.length-i];
            }
        }
        return userName;
    }
    
    public void inputData(int no, String nama, String password) {
        this.idKaryawan = generateId(no);
        String[] namaLeng = nama.split(" ");
        namaDepan = generateNamaDepan(nama);
        namaBelakang = namaLeng[namaLeng.length-1];
        userName = namaLeng[0] + namaBelakang.substring(0,2);
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
    
    


