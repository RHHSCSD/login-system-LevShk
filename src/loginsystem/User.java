/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loginsystem;

/**
 *
 * @author Lev Shkolnikov
 */
public class User {
    
    
    private String userName;
    private String password;
    private String firstName;
    private String email;
    private String phoneNumber;
    
    
    public User(String userName, String password, String firstName, String email, String phoneNumber){
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
    
        public String getuserName(){
            return userName;
        }
        public String getPassword(){
            return password;
        }
        public String getfirstName(){
            return firstName;
        }
        public String getemail(){
            return email;
        }
        public String getphoneNumber(){
            return phoneNumber;
        }
}
