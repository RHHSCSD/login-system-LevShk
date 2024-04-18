/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package loginsystem;

/**
 *
 * @author Lev Shkolnikov
 */

import java.io.*;
import java.util.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;


public class LoginSystem {
    
    /**
     * Registers a new user to the file with their username, password, email, first name, and phone number
     * 
     * @param user the user to be registered
     * @throws IOException 
     */
    public void register(User user)throws IOException{
        
        try{
        File f = new File("users.txt");
        PrintWriter pw = new PrintWriter(new FileWriter(f, true));
        String delimeter = ";";
        
        pw.print(user.getuserName()+delimeter+user.getPassword()+delimeter+user.getemail()+delimeter+user.getfirstName()+delimeter+user.getphoneNumber()+delimeter);
        
        pw.close();  
        } catch(IOException e){
            System.out.println("chould not register user");
        }
    }
    
    /**
     * This method loads all the current users into an array list
     */
    public User[] loadusers(){
        User users[] = new User[0];
        
        try{
            File f = new File("users.txt");
            Scanner s = new Scanner(f);
            //splitting the user file for each line and at the delimeter
            while(s.hasNextLine()){
                String line = s.nextLine();
                String[] parts = line.split(";");
                
                //create new variables to make a user out of
                if(parts.length==5){
                    String username = parts[0];
                    String password = parts[1];
                    String email = parts[2];
                    String firstname = parts[3];
                    String phone = parts[4];
                    //add the user to the arraylist
                users.add(new User(username, password, firstname, email, phone));
                }
            }
            
        } catch(FileNotFoundException e){
            System.out.println("No File Found");
        }
        return users;
    }
    /**
     * This method takes in the username and checks all existing users to see if the username is unique
     * 
     * @param username
     * @return true or false 
     */
    public boolean isUnique(String username){
        User users[] = loadusers();
        //loop through users to check the username
        for (User user : users) {
            if (user.getuserName().equals(username)) {
                return false; 
            }
        }
        return true;
    }
    /**
     * This method uses several parameters to check if a password is strong or weak
     * 
     * @param password
     */
    public boolean strongPassword(String password){
        
        char[] charArray = password.toCharArray();
        
        //checking for length
        boolean length = charArray.length > 8 && charArray.length < 32;
        //checking for special characters
        boolean special = false;
        for(char c : charArray){
            if(!Character.isLetterOrDigit(c)){
                special = true;
                break;
            }
        }
        //checking for capitals
        boolean capital = false;
        for(char c : charArray){
            if(!Character.isUpperCase(c)){
                capital = true;
                break;
            }
        }
        //looking through the list of bad passwords
        boolean list = true;
        try{
            String line;
            File f = new File("dictbadpass.txt");
            Scanner s = new Scanner(f);
            //loops through the file and checks for the password
            while(s.hasNextLine()){
                line = s.nextLine();
                if(line.equals(password)){
                    list = false;
                    break;
                }
            }
        } catch(FileNotFoundException e){
            System.out.println("No file to be checked");
        }
        
        if(length == true && special == true && capital == true && list == true){
            return true;
        } else{
            return false;
        }
        
    }
    /**
     * This method encrypts passwords
     * 
     * @param password
     */
    
    public String encrypt(String password){
         try {
            // To be implemented
            // Java helper class to perform encryption
            MessageDigest md = MessageDigest.getInstance("MD5");
            // Give the helper function the password
            md.update(password.getBytes());
            // Perform the encryption
            byte byteData[] = md.digest();
            // To express the byte data as a hexadecimal number (the normal way)
            String encryptedPassword = "";
            for (int i = 0; i < byteData.length; ++i) {
                encryptedPassword += (Integer.toHexString((byteData[i] & 0xFF) | 0x100).substring(1,3));
            }
            return encryptedPassword;
            
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(LoginSystem.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
