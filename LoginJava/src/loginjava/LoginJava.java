/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginjava;

/**
 *
 * @author user
 */
public class LoginJava {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(padLeftZeros("10",4));
        String kalimat = "aku cakep banget deh";
        String[] listt = kalimat.split(" ");
        for(int x = 0; x<listt.length-1;x++){
            System.out.println(listt[x]);
        }
        System.out.println(listt.length); 
        for (String coba : listt) {
            System.out.println(coba);
            if(coba.contains("aku")){
                System.out.println("ada");
            }else System.out.println("no");
        }
    }
    public static String padLeftZeros(String inputString, int length) {
        if (inputString.length() >= length) {
            return inputString;
        }
        StringBuilder sb = new StringBuilder();
        while (sb.length() < length - inputString.length()) {
            sb.append('0');
        }
        sb.append(inputString);

        return sb.toString();
    }
}
