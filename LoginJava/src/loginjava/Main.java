/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginjava;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
//import com.metrodataacademy.tools.BCrypt;


/**
 *
 * @author user
 */
public class Main {
    public static void main(String[] args){
        List<Employees> listPekerja = new ArrayList<>();
        Employees siX = new Employees();
        for(int a=0; ;a++){
            System.out.println(" ==============================\n 1. Add \n 2. View \n 3. Login \n ==============================");
            System.out.print("Pilihan(1-3) : " );
            try {
                int pilih = new Scanner(System.in).nextInt();
                switch (pilih) {
                    case 1:
                        {
                            Scanner input = new Scanner(System.in);
                            System.out.print("Nama Lengkap : ");
                            String namaLengkap = input.nextLine();
                            System.out.print("Password : ");
                            String password = input.nextLine();   
                            listPekerja.add(new Employees(namaLengkap, password, listPekerja));
                            System.out.println("Penambahan Data Berhasil");
                            break;
                        }
                    case 2:
                        {
                            siX.displayData(listPekerja);
                            break;
                        }
                    case 3:
                        {
                            Scanner input = new Scanner(System.in);
                            System.out.print("User Name : ");
                            String userLogin = input.nextLine();
                            System.out.print("Password : ");
                            String passLogin = input.nextLine();
                            siX.login(userLogin, passLogin, listPekerja);
                            break;
                        }
                    default:
                        System.out.println("Eror");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Inputan harus angka");
            }     
        }
    }   
}

            
