/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package row_column_cipher;

import java.util.Scanner;

/**
 *
 * @author Tech
 */





public class Row_column_cipher {


    
    public static void sort(int[] array1,String f,int n,char[] array2)
    {
        
       int [] array3={0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};
           
       char [] array4={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

        for(int i=0;i<n;i++)
           for(int k=0;k<26;k++)
             if(f.charAt(i)==array4[k])
                 array1[i]=array3[k];
        
        for(int i=0;i<n-1;i++)
            for(int j=0;j<n-1-i;j++)
            {
               if(array1[j]>array1[j+1])
               {
                   int t=array1[j];
                   array1[j]=array1[j+1];
                   array1[j+1]=t;
               }
               
            }
              for(int j=0;j<n;j++)
                  for(int k=0;k<26;k++)
                      if(array1[j]==array3[k])
                          array2[j]=array4[k];
           
    }
        
       
    
    
     public static String nstring1(String f)
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
        
      int n,l,dn; 

  do
   {       
        
        System.out.println("\n\t Row and Column Cipher");
        
        System.out.println("\t1.Encryption");
        System.out.println("\t2.Decryption");
        System.out.print("\nEnter your choice:");
        Scanner r1=new Scanner(System.in);   
        
        int ch=r1.nextInt();
    
     if(ch==1)
     {
        String input1="";
        
        System.out.println("Enter the text to be encrypted:");
        Scanner reader1=new Scanner(System.in);
        
        
        input1 = reader1.nextLine();           
        
        String g=nstring1(input1);
         
        String f="";
        
        System.out.println("Enter the keyword: ");
        Scanner reader=new Scanner(System.in);
        
        
        f = reader.nextLine();           
        f=nstring1(f);
        
        n=f.length();

        int []array1=new int[n];
        char[]array2=new char[n];
        
        char [][]array=new char[30][n];
        char [][]temp=new char[30][n];

        
         int r=0,i=0;
        

                          for(int j=0;j<n;j++)  
                            {
                              array[r][j]=f.charAt(j);  
                            }
                 r=1;
                 while(r>=0)
                    {
                        for(int j=0;j<n;j++)  
                            {
                              array[r][j]=g.charAt(i++); 
                              if(i==g.length())
                              break;                                                     
                            }
                        r++;
                        if(i==g.length())
                        break;   
                    }
                 sort(array1,f,n,array2);
                 
              System.out.println("\n\n The encrypted text is:");
              int j;
                                for(i=0,j=0;i<n;i++)
                                    for(int k=0;k<n;k++)
                                        if(array[j][k]==array2[i])
                                            {
                                             for(l=j+1;l<r;l++)       
                                             temp[l][i]=array[l][k];
                                             break;
                                            }
                                  for(i=1;i<r;i++)
                                      for(j=0;j<n;j++)
                                       System.out.print(temp[i][j]+" ");
                                    
     }
     
         else
            {
                
                            String input1="";
        
                           System.out.println("Enter the text to be decrypted:");
                           Scanner reader1=new Scanner(System.in);
        
                           
                            input1 = reader1.nextLine();           
        
                            String g=nstring1(input1);
         
                           String f="";
        
                           System.out.println("Enter the keyword: ");
                           Scanner reader=new Scanner(System.in);
        
        
                          f = reader.nextLine();           
                          f=nstring1(f);
        
                          n=f.length();

                          int []array1=new int[n];
                          char[]array2=new char[n];
                          
                          
                          sort(array1,f,n,array2);              
                
        
                         char [][]array=new char[30][n];
                         char [][]temp=new char[30][n];

        
                        int r=0,i=0;
        

                          for(int j=0;j<n;j++)  
                              array[r][j]=array2[j];  
                            
                 r=1;
                 while(r>=0)
                    {
                        for(int j=0;j<n;j++)  
                            {
                              array[r][j]=g.charAt(i++); 
                              if(i==g.length())
                              break;                               
                            }
                        r++;
                        if(i==g.length())
                        break;   
                    }                
                
              System.out.println("\n\n The decrypted text is:");
              int j;
                                for(i=0,j=0;i<n;i++)
                                    for(int k=0;k<n;k++)
                                        if(array[j][k]==f.charAt(i))
                                            {
                                             for(l=j+1;l<r;l++)       
                                             temp[l][i]=array[l][k];
                                             break;
                                            }
                                  for(i=1;i<r;i++)
                                      for(j=0;j<n;j++)
                                       System.out.print(temp[i][j]+" ");                
            }
                
                    System.out.print("\n\ndo you want to continue(1/0):");
                    Scanner r2=new Scanner(System.in);
                    dn=r2.nextInt();
                 } while(dn==1);                

     }
               
}
     
     

