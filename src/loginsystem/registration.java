/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loginsystem;

/**
 *
 * @author Lev Shkolnikov
 */
public class registration {
     public static void main(String[] args) {
        LoginSystem loginsystem = new LoginSystem();

        
        LoginFrame loginFrame = new LoginFrame(loginsystem);
        RegisterFrame RegisterFrame = new RegisterFrame(loginsystem);
    }
    
}
