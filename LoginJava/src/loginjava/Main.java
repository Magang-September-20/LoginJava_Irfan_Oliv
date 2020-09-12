/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginjava;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//import com.metrodataacademy.tools.BCrypt;


/**
 *
 * @author user
 */
public class Main {
    public static void main(String[] args) {
        List<Employees> listPekerja = new ArrayList<>();
        for(int a=0; ;a++){
        System.out.println(" 1. Add \n 2. View \n 3. Login \n ==============================");
        System.out.print("Pilihan(1-3) : " );
        int pilih = new Scanner(System.in).nextInt();
        if (pilih == 1){
            Employees siX = new Employees();
            System.out.print("Nama Lengkap : ");
            String namaLengkap = new Scanner(System.in).nextLine();
            System.out.print("password : ");
            String password = new Scanner(System.in).nextLine();
            siX.inputData(a+1, namaLengkap, password);
            listPekerja.add(a,siX);
            System.out.println("Penambahan Data berhasil");
        }
        else if(pilih == 2) {
            Employees siX = new Employees();
            siX.displayData(listPekerja);
        } else if (pilih ==3 ){
            Employees siX = new Employees();
            Scanner loginUser = new Scanner(System.in);
            Scanner loginPass = new Scanner(System.in);
            String userLogin;
            String passLogin;
            System.out.print("User Name : ");
            userLogin = loginUser.nextLine();
            System.out.print("Password : ");
            passLogin = loginPass.nextLine();
            //siX.loginUser(userLogin, passLogin, listPekerja);
            if(listPekerja.contains(userLogin)== true &&(BCrypt.checkpw(passLogin, BCrypt.hashpw(passLogin, BCrypt.gensalt()))== true)){
                System.out.println("Login berhasil");
            } else {
                System.out.println("Login Gagal");
            }
    } else System.out.println("Eror");
            
     
}
    }
}
//        System.out.println(S);
//      //  System.out.println(listPekerja.get(1).getIdKaryawan());
            
