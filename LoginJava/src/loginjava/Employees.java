/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginjava;

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
    private String username="";
    private String password;

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
            if(list.username.equals(username)){
                return true;
            }
        }
        return false;
    }
    String generateUserName(String namaDepan, String namaBelakang, List<Employees> listPekerja){
        String[] arrNamadepan = namaDepan.split(" ");
        try {
            username = arrNamadepan[0]+namaBelakang.substring(0, 2);
            if(cekUserName(username, listPekerja)){
                for(int i=arrNamadepan.length-1;i>=0;i--){
                    username = arrNamadepan[0]+arrNamadepan[i].substring(0, 2);
                    if(!cekUserName(username, listPekerja)){
                        break;
                    }
                }
            }
        } catch (StringIndexOutOfBoundsException e) {
            username+=arrNamadepan[0]+idKaryawan;
        }
        
        if(cekUserName(username, listPekerja)){
            username+=idKaryawan;
        }
        return username;
    }
    public Employees(){
        
    }
    public Employees(String nama, String password, List<Employees> listPekerja) {
        this.idKaryawan = generateId();
        String[] namaLeng = nama.split(" ");
        namaDepan = generateNamaDepan(nama);
        namaBelakang = namaLeng[namaLeng.length-1];
        username = generateUserName(namaDepan,namaBelakang,listPekerja);
        this.password = BCrypt.hashpw(password, BCrypt.gensalt());
  
    }
    public void displayData(List<Employees> listPekerja){
        for (Employees employees : listPekerja) {
            System.out.println("Id Karyawan     : " + employees.idKaryawan);
            System.out.println("Nama Depan      : " + employees.namaDepan);
            System.out.println("Nama Belakang   : " + employees.namaBelakang);
            System.out.println("Username        : " + employees.username);
            System.out.println("Password        : " + employees.password);
            System.out.println("=============================");   
        }
    }
    public void login (String userName, String password,List<Employees> listPekerja){
        boolean cek = false;
        for (Employees list : listPekerja) {
            if(list.username.equals(userName) && (BCrypt.checkpw(password,list.password))){
                cek = true;
                break;
            }else {
                cek = false;
            }
        }
        if(cek){
            System.out.println("LOGIN BERHASIL");
        }else System.out.println("LOGIN GAGAL");
    }      
}
    
    


