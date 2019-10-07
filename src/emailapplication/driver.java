/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emailapplication;

/**
 *
 * @author Shaishav
 */
public class driver {
    public static void main(String[] args){
         String password="sHaishav1$";
        int countLowerCase = 0;
        int countUpperCase = 0;
        int countNumeric = 0;
        int countSpecialCharachter = 0;

        for (int i = 0; i < password.length(); i++) {
            char letter=password.charAt(i);
            int value=letter;
            
            if (value >= 65 && value <= 90) {
                countUpperCase++;
            } else if( value >= 97 && value <= 122) {
                countLowerCase++;
            } else if (value >= 48 && value <= 57) {
                countNumeric++;
            } else if ((value >= 33 && value <= 38) || value == 42 || value == 43 || value == 47) {
                countSpecialCharachter++;
            }
        }
        if(countLowerCase>0 && countNumeric>0 && countSpecialCharachter>0 && countUpperCase>0){
            System.out.println("countLowerCase" +countLowerCase +"countUpperCase" +countUpperCase +"countSpeacialCharachter" +countSpecialCharachter +"countNumber" +countNumeric);
        }else{
        System.out.println("Error");
        }
    }
}
