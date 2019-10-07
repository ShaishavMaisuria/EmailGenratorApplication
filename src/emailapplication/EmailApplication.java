/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emailapplication;

import java.util.*;

/**
 *
 * @author Shaishav
 */
public class EmailApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scan= new Scanner(System.in);
         System.out.println("last Name" );
        String lastName=scan.nextLine();
        System.out.println("first Name" );
        String firstName=scan.nextLine();
        Email email = new Email(firstName,lastName);
        
        System.out.println("password " +email.generateRandomPassword());
        email.setPassword("shaishaV1$");
        System.out.println("Change password " +email.getPassword());
        
        System.out.println("Full name of the person "+email.getFullName());
        System.out.println(email.getEmail());
        
        
    }
}
