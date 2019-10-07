/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emailapplication;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 *
 * @author Shaishav
 */
public class Email {

    private String employeefirstName;
    private String employeeLastName;
    private String employeePassword;
    private String employeeDepartment;
    private String employeealternateEmail;
    private String[] departmentTypes;// can also use arraylist
    private String departmentTypesString;
    private int mailboxSize;
    private int maxLengthPassword;
    private int minLengthPassword;

    public Email(String employeefirstName, String employeeLastName) {
        this.employeeLastName = employeeLastName;
        this.employeefirstName = employeefirstName;
        Random rand = new Random();
        int randomNumber = rand.nextInt(this.employeefirstName.length()) * 12;
        
        this.employeealternateEmail="Email Created " + this.employeeLastName.charAt(0) + this.employeefirstName + randomNumber;
        setTypesOfDepartments();
        setSelectDepartment();
        setMaxLengthPassword(16);
        setMinLengthPassword(8);
        //generateRandomPassword();
    }

    /**
     *
     * @return
     */
    private void setSelectDepartment() {
        System.out.println("Please select the choice" + departmentTypesString);
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt() - 1;
        if (choice >= 0 && choice <= this.departmentTypes.length - 1) {
            employeeDepartment = this.departmentTypes[choice];
            System.out.println("your department is : " + employeeDepartment);
        } else {
            System.out.print("Error in choice");
        }
    }

    /**
     * This method set the department types which holds number of department and
     * stores in a string
     *
     * @param departmentTypes
     */
    public void setTypesOfDepartments() {
        departmentTypesString = "";
        Scanner scan = null;
        int i = 0;
        try {
            /*getting departments from the files        */
            scan = new Scanner(new File("G:\\study material\\Netbeans Project data\\Neat beans\\Library\\EmailApplication\\src\\emailapplication\\department.txt"));
        } catch (FileNotFoundException ex) {
            System.out.println("Error in setTypesOfDepartments files");
        }

        StringTokenizer stoken = new StringTokenizer(scan.nextLine(), ",");

        this.departmentTypes = new String[stoken.countTokens()];
        while (stoken.hasMoreTokens()) {

            this.departmentTypes[i] = stoken.nextToken();
            departmentTypesString += (i + 1) + ") " + this.departmentTypes[i] + "\n";
            i++;
        }

        /*
            it takes every thing from the array
         */
    }

    /**
     * this method will help us to create a random password
     */
    public String generateRandomPassword() {
        Random randCharacter = new Random();
        employeePassword = "";
        int len;
        len = randCharacter.nextInt((maxLengthPassword - minLengthPassword) + 1) + minLengthPassword;
        String[] word = new String[len];
        for (int i = 0; i < word.length; i++) {
            employeePassword += generateRandomCharacter();
        }
        return employeePassword;
    }

    private char generateRandomCharacter() {
        Random randCharacter = new Random();
        int scn;
        char randomCharacter;
        do {
            scn = randCharacter.nextInt(122) + 32;
            randomCharacter = (char) (scn);
        } while (!((scn >= 47 && scn <= 90) || (scn >= 97 && scn <= 112) || (scn >= 33 && scn <= 38) || (scn == 42) || (scn == 43)));
        //this condition doesnot take any numner out of these number this condition helps to 
        //regerate the a number in random if the number is not in between the range
        //of (47 - 90 ) , (97 - 112) , ( 33 - 38 ) , ( 42 - 43 )
        // these numbers are the selected according to asscii value to select a character if please refer ascii to http://www.asciitable.com/
        return randomCharacter;
    }

    /**
     * this is to get the menu of departmentTypes
     *
     * @return
     */
    public String getDepartmentTypes() {
        return departmentTypesString;
    }

    /**
     * getting the password max
     */
    public int getMaxLengthPassword() {
        return maxLengthPassword;
    }

    /**
     * getting the password min
     */
    public int getMinLengthPassword() {
        return minLengthPassword;
    }
    /**
     * getting the password 
     */
    public String getPassword() {
        return this.employeePassword;
    }
    /**
     * getting the full name
     */
    public String getFullName() {
        return this.employeeLastName + this.employeefirstName;
    }
    /**
     * getting the last name
     */
    public String getLastName() {
        return this.employeeLastName ;
    }
    /**
     * getting the first name
     */
    public String getFirstName() {
        return this.employeefirstName ;
    }
    /**
     * getting the email of the employee
     */
    public String getEmail() {
        return this.employeealternateEmail ;
    }



    /**
     * setting the password max
     */
    public void setMaxLengthPassword(int maxLengthPassword) {
        this.maxLengthPassword = maxLengthPassword;
    }
    
    /**
     * setting the password min
     */
    public void setMinLengthPassword(int minLengthPassword) {
        this.minLengthPassword = minLengthPassword;
    }

    /**
     * setting the password
     */
    public void setPassword(String password) {

        if (contains(password)) {
            this.employeePassword = password;
        }

    }

    private boolean contains(String password) {
        int countLowerCase = 0;
        int countUpperCase = 0;
        int countNumeric = 0;
        int countSpecialCharachter = 0;
        char letter;
        int value;
        

           for (int i = 0; i < password.length(); i++) {
            letter=password.charAt(i);
            value=letter;
            
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
        if(countLowerCase>0&&countNumeric>0&& countSpecialCharachter>0 && countUpperCase>0){
            return true;
        }
        return false;
    }
}
