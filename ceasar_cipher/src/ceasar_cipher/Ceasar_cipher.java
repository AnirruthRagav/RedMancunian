/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ceasar_cipher;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ceasar_cipher {

    

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
            String input="";
            Integer a=0;
        System.out.println("Enter the text:");
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        
        try {
             input=reader.readLine();
        } catch (IOException ex) {
            Logger.getLogger(Ceasar_cipher.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         
         System.out.println("Enter the key value:");
         BufferedReader number=new BufferedReader(new InputStreamReader(System.in));

          try {
                 a =Integer.parseInt(number.readLine());
        } catch (IOException ex) {
            Logger.getLogger(Ceasar_cipher.class.getName()).log(Level.SEVERE, null, ex);
        } 
                  
         for(int i=0;i<input.length();i++)
         {
           
             int t=input.codePointAt(i);
             
             t=t+a;
             
             if(t>90)
             {
              t=64+(t-90);   
             }    
             
             char [] chars=input.toCharArray();
             
             chars[i]=(char)t;
             
             input=String.valueOf(chars);
             
           
             
         }
         
         System.out.println("Encrypted text:" +input);
         
         for(int i=0;i<input.length();i++)
         {
             int t=input.codePointAt(i);
             
             t=t-a;
             
             if(t<65)
             {
              t=91-(65-t);   
             }    

             char [] chars=input.toCharArray();
             
             chars[i]=(char)t;
             
             input=String.valueOf(chars);         
         }
           System.out.println("Decrypted text:" +input);
    }
    
}
