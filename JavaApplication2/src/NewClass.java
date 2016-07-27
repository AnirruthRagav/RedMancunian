/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Tech
 */
public class NewClass {    
        public static void main(String[] args){
        try{
            Class.forName("java.sql.Driver");
            new NewJFrame().setVisible(true);
            
        }
        catch(Exception e){
       javax.swing.JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }

}


