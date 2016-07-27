/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rail_cipher;

import java.util.Scanner;
import java.io.*;

/**
 *
 * @author Tech
 */
public class Rail_cipher {

    /**
     * @param args the command line arguments
     */
    
    public static String nstring(String f)
    {             
                String g1="";
               for(int i=0;i<f.length();i++)
                {
                    if(f.charAt(i)==' ')
                    continue;
                        else
                        g1=g1+f.charAt(i);
        }  
               return g1;
    }
        
    
    
    public static void main(String[] args) {
        // TODO code application logic here

        int dn=0;
      do
      {   
        System.out.println("\n\t Rail Cipher");
        
        System.out.println("\t1.Encryption");
        System.out.println("\t2.Decryption");
        System.out.print("\nEnter your choice:");
        Scanner r1=new Scanner(System.in);   
        
        int ch=r1.nextInt();
     
      if(ch==1)
      {           
        String input1="";
        int n;
        
        System.out.println("Enter the text to be encrypted:");
        Scanner reader1=new Scanner(System.in);
        
        
        input1 = reader1.nextLine();           
        
        String g=nstring(input1);
         
        
        System.out.println("Enter the no of rows of the key matrix: ");
        Scanner reader=new Scanner(System.in);
        
        n=reader.nextInt();
        
        char array[][]=new char[n][100];
        int r=-1,c=0,d=0,flag=0;
        
                for(int i=0;i<n;i++)
                  for(int j=0;j<100;j++)
                      array[i][j]='/';
                
                
                        for(int i=0;i<g.length();i++)
                            {
                                   if(flag==0&&r<n-1)          
                                       array[++r][c++]=g.charAt(i);
                                     
                                   else
                                         {   
                                            flag=1;
                                            array[--r][c++]=g.charAt(i);
                                            if(r<=0)
                                              flag=0;
                                            
                                         }
                               }  
                                   
                System.out.println();         
                System.out.print("\nThe encrypted text is:");        
                for(int i=0;i<n;i++)
                    {     
                         for( int j=0;j<c;j++)
                          if(array[i][j]!='/')   
                          System.out.print(array[i][j]);
                    }           
      }
      
      else if(ch==2)
      {
                       String input1="";
                       int n;
        
                       System.out.println("Enter the text to be decrypted:");
                       Scanner reader1=new Scanner(System.in);
        
        
                       input1 = reader1.nextLine();           
        
                       String g=nstring(input1);
         
        
                       System.out.println("Enter the no of rows of the key matrix: ");
                       Scanner reader=new Scanner(System.in);
   
                       n=reader.nextInt();

        char array[][]=new char[n][100];
        int r=-1,c=-1,d=0,flag=0;
        
                for(int i=0;i<n;i++)
                  for(int j=0;j<g.length();j++)
                      array[i][j]='/';
                
                int kc1=0,kr1=0,i=0;
                       
                                while(c<g.length())
                                {    
                                    
                                  if(flag==0&&r<n-1)          
                                   {
                                     r++;
                                     c++;
                                     if(r==kr1)
                                     array[r][c]=g.charAt(i++);
                                   }
                                     
                                   else
                                         {   
                                            flag=1;
                                            r--;
                                            c++;
                                            if(r==kr1&&c<g.length())
                                            array[r][c]=g.charAt(i++);

                                              if(r<=0)
                                              flag=0;
                                         }
                                  
                                  if(c==g.length())
                                  {  kr1++;
                                     kc1++; 
                                     c=r=-1;
                                     flag=0;
                                  }    
                                  if(i==g.length())
                                      break;
                               }                         
       
         r=-1;
         c=d=flag=0;
                                 System.out.print("\n\n The decrypted text is:");
                                 for(i=0;i<g.length();i++)
                                  {
                                   if(flag==0&&r<n-1)          
                                     System.out.print(array[++r][c++]+" ");
                                     
                                   else
                                         {   
                                            flag=1;
                                           System.out.print(array[--r][c++]+" ");
                                            if(r<=0)
                                              flag=0;
                                            
                                         }
                               }  
                                                                  
                                
                                
      }
                                               
                    System.out.print("\n\ndo you want to continue(1/0):");
                    Scanner r2=new Scanner(System.in);
                    dn=r2.nextInt();
            } while(dn==1);                                   
       }
        
} 
    

