/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vignere_cipher;

import java.util.Scanner;

/**
 *
 * @author Tech
 */



public class Vignere_cipher {

    /**
     * @param args the command line arguments
*/
    public static void fill_val(char [][]array)
    {
        int t=65;
        
        System.out.println("The Tabula Recta is:\n");
        for(int i=1;i<27;i++)
        {
             array[0][i]=array[i][0]=(char)t;
             t++;
        }
       
        for(int i=1;i<27;i++)
        {
           t=(int)array[0][i];
          for(int j=1;j<27;j++)  
          {
             array[i][j]=(char)t;
             t++;
             if(t>90)
             t=65;      
          }   
        }
        
         for(int i=0;i<27;i++)
         {
            System.out.println();
             for(int j=0;j<27;j++)
              System.out.print(array[i][j]+" ");
         } 
    }
    
       public static String rem_spac(String input1,String str3)
      {        
    
        for(int i=0;i<input1.length();i++) 
        {
          if(input1.charAt(i)==' ')
          continue;
          
          str3=str3+input1.charAt(i);   
        }
        return str3;
      }   

       public static String key_stream(String str,String str3)
         {
             String temp="";
             int t=str.length(),s=str3.length(),i,k;
             k=t;
               while(true)
                {
                  for(i=0;i<k;i++)
                  {    
                    temp=temp+str.charAt(i);
                    t++;
                    if(t==s)
                     break;
                  } 
                  if(t==s)
                  break;                     
                }
             str=str+temp; 
             return str;
         }       
       
       
       public static String encrypt_text(char [][]array,String str,String str3)
       {
           
           int r1=0,r2=0,c1=0,c2=0;
           int t=str3.length();
           String temp="";
           for(int i=0;i<t;i++)
           {   
              for(int j=1;j<27;j++)
                if(array[0][j]==str.charAt(i))
                {    
                    c1=j; 
                    break;
                }
              
              for(int j=1;j<27;j++)
                 if(array[j][0]==str3.charAt(i))
                 {
                     r1=j;
                     break;
                 }    
                 temp=temp+array[r1][c1];
           }   
          return temp;
       }

       
       public static String decrypt_text(char [][]array,String str,String str3)
       {
           
           int r1=0,r2=0,c1=0,c2=0,j;
           int t=str3.length();
           String temp="";
           for(int i=0;i<t;i++)
           {   
              for(j=1;j<27;j++)
                if(array[0][j]==str.charAt(i))
                {    
                    c1=j; 
                    break;
                }
              
              for(j=1;j<27;j++)
                 if(array[j][c1]==str3.charAt(i))
                     break;
                 
                 temp=temp+array[j][0];
           }   
          return temp;
       }       
       
    public static void main(String[] args) {
        // TODO code application logic here
                int dn=0;
                char [][] array=new char[27][27];
                fill_val(array);
  do
   {    

        
        int r1=0,c1=0,r2=0,c2=0,count=0,k;
        String str3="",str="",input="",input1="";       
       
        System.out.println("\n\t Vigenere Cipher");
        
        System.out.println("\t1.Encryption");
        System.out.println("\t2.Decryption");
        System.out.print("\nEnter your choice:");
        Scanner r5=new Scanner(System.in);   
        
        int ch=r5.nextInt();
    
     if(ch==1)
     {  
                  String sub="";
                 System.out.println("\n\nEnter the text to be encrypted:");
                 Scanner reader1=new Scanner(System.in);
        
        
                 input1 = reader1.nextLine();        
        
        
                 str3=rem_spac(input1,str3);                         //input string after removing the spaces
        
                 System.out.println("\n\nEnter the Key:");
                 Scanner reader=new Scanner(System.in);
        
        
                input = reader.nextLine();
        
                str=rem_spac(input,str);                       //key string after removing the spaces
         
                if(str.length()<str3.length())
                str=key_stream(str,str3);
                
                sub=encrypt_text(array,str,str3);
                System.out.println("\n\nThe encrypted text is:");
                System.out.println(sub);
     }
     
     else if(ch==2)
            {
                String sub1="";
                System.out.println("\n\nEnter the ciphertext:");
                Scanner reader1=new Scanner(System.in);
        
        
                input1 = reader1.nextLine();        
        
               
                str3=rem_spac(input1,str3);                         //input string after removing the spaces
        
                System.out.println("\n\nEnter the Key:");
                Scanner reader=new Scanner(System.in);                
                
                 input = reader.nextLine();
        
                 str=rem_spac(input,str);                         //key string after removing the spaces
                 
                if(str.length()<str3.length())
                str=key_stream(str,str3);                 
                
                 
                sub1=decrypt_text(array,str,str3);
                System.out.println("\n\nThe encrypted text is:");
                System.out.println(sub1);                          
            }
         
                    System.out.print("\n\ndo you want to continue(1/0):");
                     r5=new Scanner(System.in);
                    dn=r5.nextInt();
                 } while(dn==1);            
  
    }
    
}
