/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hill_cipher;

import java.util.Scanner;

import java.io.*;

/**
 *
 * @author Tech
 */
public class Hill_cipher {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        String input1="";
        
        System.out.println("Enter the text to be encrypted:");
        Scanner reader1=new Scanner(System.in);
        
        
        input1 = reader1.nextLine();           
        
        String g="";
        for(int i=0;i<input1.length();i++)
        {
            if(input1.charAt(i)==' ')
            continue;
            else
              g=g+input1.charAt(i);
            }
        
        System.out.println(g);
        
        int n;
        String f="";
        
        System.out.println("Enter the size of the key matrix(2 or 3): ");
        Scanner reader=new Scanner(System.in);
        
        
        f = reader.nextLine();           
        n=Integer.parseInt(f);
        
        int [][] array=new int[10][10];
        
        System.out.println("\n\n Enter the elements of the matrix:");
        
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
            {
              reader=new Scanner(System.in);
              f="";
              f=reader.next();
              array[i][j]=Integer.parseInt(f);
            }
        
        for(int i=0;i<n;i++)
        {  
            System.out.println("\n");
            for(int j=0;j<n;j++)
                System.out.print(" "+array[i][j]);
        }    
       
        
          int [][]array1=new int[n][10];
          
           int [] array3={0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};
           
           char [] array4={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
          
 
           
           int x=-1;
           int r=0,c=0;
           for(int i=0;i<g.length();i++)
           {
               x=-1;
             for(int k=0;k<26;k++)
             {
                if(g.charAt(i)==array4[k]) 
                {
                    x=array3[k];
                    break;
                       
                }   
             }
             
             
                 if(r<n)
                 array1[r++][c]=x;
                 else
                 {
                   r=0;
                   c++;
                   array1[r++][c]=x;                   
                 }
                  
           }
           
             int val=array1[r-1][c];
             if(val==25)
             val=-1;    
             
              if(g.length()%n!=0)
              {
                 for(;r<n;r++)
                   array1[r][c]=val+1;   
              } 
           
           
        
           
              for(int i=0;i<n;i++)
              {
                  
                  System.out.print("\n");
                  for(int j=0;j<=c;j++)
                  {
                    System.out.print(" "+array1[i][j]);
                  }
                 
            }
        
              
            int [][]array5=new int[n][c+1];  
              
            int l=0;
            while(l<=c)
            {
              for(int j=0;j<n;j++)
              {
                 array5[j][l]=0;
                  for(int k=0;k<n;k++)  
                  array5[j][l]+=(array[j][k]*array1[k][l]);  
                  
                  array5[j][l]%=26;
              }
                
            
            l++;
            }
            
             
            
              for(int i=0;i<n;i++)
              {
                  
                  System.out.print("\n");
                  for(int j=0;j<=c;j++)
                  {
                    System.out.print(" "+array5[i][j]);
                  }
                 
            }            
              
              for(int i=0;i<=c;i++)
              {
                  
                  System.out.print("\n");
                  for(int j=0;j<n;j++)
                  {
                   for(int k=0;k<26;k++)
                   {
                     if(array5[j][i]==array3[k])
                     System.out.println("\n\n"+array4[k]+" ");
                   }
                  }
                 
            }               
              
    }
        
    }
    
