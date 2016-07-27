/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package playfair_cipher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


/**
 *
 * @author 104013
 */
public class Playfair_cipher {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    

      public static int decrypt_text(char []sub1,char [][]array,String str3,int r1,int c1,int r2,int c2)
      {
           char x,y;
           int k,count1=0;
          for(int i=0;i<str3.length();i+=2)
         {
            x=str3.charAt(i);
            y=str3.charAt(i+1);
         
            for(int j=0;j<5;j++)
              for( k=0;k<5;k++)  
              {
               if(array[j][k]==x)
               {
                 r1=j;
                 c1=k;
               }
               if(array[j][k]==y)
               {
                 r2=j;
                 c2=k;
               }
              }
            
               if(r1==r2)
               {
                 if(c1==0)
                 c1=5;
                 
                 if(c2==0)
                  c2=5;
                 sub1[count1++]=array[r1][c1-1];
                 sub1[count1++]=array[r2][c2-1];
               }
               
               else if(c1==c2)
               {
                 if(r1==0)
                     r1=5;
                 
                 if(r2==0)
                     r2=5;
                 
                 sub1[count1++]=array[r1-1][c1];
                 sub1[count1++]=array[r2-1][c2];                 
                 
               }
               
               else
               {
                sub1[count1++]=array[r1][c2];
                sub1[count1++]=array[r2][c1];
               } 
         }
          return count1;
      }   
      
      public static void encrypt_text(char []sub,char [][]array,String str3,int r1,int c1,int r2,int c2,int count)
      {        
         count=0;
         char x,y;
         int k;
       
         for(int i=0;i<str3.length();i+=2)
         {
            x=str3.charAt(i);
            y=str3.charAt(i+1);
            
            for(int j=0;j<5;j++)
              for( k=0;k<5;k++)  
              {
               if(array[j][k]==x)
               {
                 r1=j;
                 c1=k;
                 
               }
               if(array[j][k]==y)
               {
                 r2=j;
                 c2=k;
               }
              }
            
               if(r1==r2)
               {
                 if(c1==4)
                 c1=-1;
                 
                 if(c2==4)
                  c2=-1;
                 sub[count++]=array[r1][c1+1];
                 sub[count++]=array[r2][c2+1];
               }
               
               else if(c1==c2)
               {
                 if(r1==4)
                     r1=-1;
                 
                 if(r2==4)
                     r2=-1;
                 
                 sub[count++]=array[r1+1][c1];
                 sub[count++]=array[r2+1][c2];                 
                 
               }
               
               else
               {
                sub[count++]=array[r1][c2];
                sub[count++]=array[r2][c1];
               } 
         } 
      }  
       
    public static void polybius_square(char[][]array,String str1)
      {
               
         int t=65,count=0,k=0;
         for(int i=0;i<5;i++)
         {
           for(int j=0;j<5;j++)
           {
               count=0;
              if(k<str1.length())
              {
              array[i][j]=str1.charAt(k);
              k++;                  
              }  
              
              else
              {
                String m="";
                m=m+(char)t;
                
                while(count==0)
                {
                  if(str1.contains(m)==false)
                   {
                     array[i][j]=(char)t;
                     count++;
                   }    
                      t++;
                      if(t==74)
                      t++;    
                      m="";
                      m=m+(char)t;
                      if(t>90)
                          t=65;
                } 
                      
                }
              
           }
         }
      }  
  
      public static String rem_dupl(String str1,String str)
        {  
            int count=0;
            for(int j=0;j<str.length();j++)
           {
             count=0;
             for(int k=0;k<str1.length();k++)
           {
              if(str1.charAt(k)==str.charAt(j))
              count++;    
           }
            if(count==0)
            str1=str1+str.charAt(j);

                
         }
            return str1;            
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
    
    
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
                int dn=0;
  do
   {    
        char [][] array=new char[5][5];
        
        int r1=0,c1=0,r2=0,c2=0,count=0,k;
        String str3="",str="",str1="",input="",input1="";       
       
        System.out.println("\n\t Playfair Cipher");
        
        System.out.println("\t1.Encryption");
        System.out.println("\t2.Decryption");
        System.out.print("\nEnter your choice:");
        Scanner r5=new Scanner(System.in);   
        
        int ch=r5.nextInt();
    
     if(ch==1)
     {  
         char []sub=new char[100];
        System.out.println("\n\nEnter the text to be encrypted:");
        Scanner reader1=new Scanner(System.in);
        
        
        input1 = reader1.nextLine();        
        
        
         str3=rem_spac(input1,str3);                         //input string after removing the spaces
        
        System.out.println("\n\nEnter the Key:");
        Scanner reader=new Scanner(System.in);
        
        
        input = reader.nextLine();
        
            str=rem_spac(input,str);                       //key string after removing the spaces
        
            str1=rem_dupl(str1,str);                      //string after removing the duplicates
   
            polybius_square(array,str1);                  //generation of the 5x5 key matrix
        
        
        System.out.println("\n\nThe generated polybius square is:");
         for(int i=0;i<5;i++)
         {
             System.out.println();
             for(int j=0;j<5;j++)
               System.out.print(array[i][j]+" ");
         }
             

         int flag=0,q,f=str3.length(),kn=0;
         String b="";
         
         if(f%2==1)
         {
             str3=str3+"Z";
             f=str3.length();
             for( q=0;q<f-1;q++)
             {   
                  if(str3.charAt(q)==str3.charAt(q+1))
                  break;
                  else
                  b=b+str3.charAt(q);
             }     
             if(q!=f-1)
             { 
                 kn=q+1;
                 b=b+str3.charAt(q)+"X";
                for(q=q+1;q<f-1;q++)
                 b=b+str3.charAt(q);
                str3=b;
             }    
             flag=1;
         }    
         
                   encrypt_text(sub,array,str3,r1,c1,r2,c2,count);
                   System.out.println("\n\nThe encrypted text is:");
                   System.out.println(sub);
     }
     
     else if(ch==2)
            {
                char [] sub1=new char[100];
                System.out.println("\n\nEnter the ciphertext:");
                Scanner reader1=new Scanner(System.in);
        
        
                input1 = reader1.nextLine();        
        
               
                str3=rem_spac(input1,str3);                         //input string after removing the spaces
        
                System.out.println("\n\nEnter the Key:");
                Scanner reader=new Scanner(System.in);                
                
                 input = reader.nextLine();
        
                 str=rem_spac(input,str);                       //key string after removing the spaces
         
                 str1=rem_dupl(str1,str);                      //string after removing the duplicates
   
                 polybius_square(array,str1);                  //generation of the 5x5 key matrix                

        System.out.println("\n\nThe generated polybius square is:");                 
                         for(int i=0;i<5;i++)
                            {
                                 System.out.println();
                                    for(int j=0;j<5;j++)
                                       System.out.print(array[i][j]+" ");
                             }
                         
                             r1=r2=c1=c2=0;
         
                            count=decrypt_text(sub1,array,str3,r1,c1,r2,c2);
                 
         
                            System.out.print("\n\nThe decrypted text is:");
                              System.out.println(sub1);
            }
         
                    System.out.print("\n\ndo you want to continue(1/0):");
                     r5=new Scanner(System.in);
                    dn=r5.nextInt();
                 } while(dn==1);        
    }
    
}
