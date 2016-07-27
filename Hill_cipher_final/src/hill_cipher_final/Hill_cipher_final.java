/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hill_cipher_final;

import java.util.Scanner;

/**
 *
 * @author Tech
 */
public class Hill_cipher_final {

    /**
     * @param args the command line arguments
     */
     static int pos;
    
    
     public static void inverse_final(int [][]array,int t,int n)
     {
         System.out.println("\n The final adjt matrix of the key is:\n");
         
            for(int i=0;i<n;i++)   
            {   System.out.println();
                for(int j=0;j<n;j++)
                {
                    if(array[i][j]<0)
                    {
                       for( int k=-1;;k--)
                           if(26*k<array[i][j])
                           {
                               array[i][j]-=(26*k);break;
                           }        
                    }
                    else
                        array[i][j]%=26;
                    array[i][j]=(array[i][j]*t)%26;         
                    System.out.print(array[i][j]+"\t");
                }       
            }
     }    
     
     
    public static int inverse_d(int d)
    {
         if(d<0)
          {
            for(int j=-1;;j--)
              if(26*j<d)
              {   d=d-(26*j);
                  break;
              }
               
          }
          else
              d%=26;
         return d;
    }
     
     public static int mult(int d)
     {    
          int i,t=0;
          for( i=1;i<=25;i++)
                  if((i*d)%26==1)
                  {
                      t=i;
                      break;
                  } 
          if(i==26)
          return 0;     
          return t;
      }
     
     
     public static int find(int [][]array,int j,int i,int n)
     {
       int []f=new int[4];
       int r1=0;
       for(int r=0;r<n;r++)
           for(int c=0;c<n;c++)
           {
             if(r!=j&&c!=i)  
             f[r1++]=array[r][c];
           }
       return f[0]*f[3]-f[1]*f[2];
     }
    
    public static void inverse(int [][] array,int n)
    {   
        int d,t;
       if(n==2) 
       {
          d=(array[0][0]*array[1][1])-(array[0][1]*array[1][0]);         
          d=inverse_d(d);
           t= array[0][0];
          array[0][0]=array[1][1];
          array[1][1]=t;
          array[0][1]=-1*array[0][1];
          array[1][0]=-1*array[1][0];

          
          if(d==0)
          pos=0;
          else
          pos=1;
          
          if(pos==1)
          {
                   t=mult(d);
                   if(t==0)
                   System.out.println("Use a different cipher key");System.exit(0);    
                   inverse_final(array,t,n);
          }   
          }
       
          else
            {
                
              int [][]temp=new int[3][3];
              for(int i=0;i<n;i++)
                  for(int j=0;j<n;j++)
                      temp[i][j]=array[i][j];
              
              d=(array[0][0]*(array[1][1]*array[2][2]-array[2][1]*array[1][2]))-(array[0][1]*(array[1][0]*array[2][2]-array[2][0]*array[1][2]))+(array[0][2]*(array[1][0]*array[2][1]-array[1][1]*array[2][0]));
              d=inverse_d(d);

              double ct=0.0;
              for(int i=0;i<n;i++)
                for(int j=0;j<n;j++,ct++)
                {
                  double val=find(temp,j,i,n)*Math.pow(-1.0, ct);
                  array[i][j]=(int)val;
                }    
          if(d==0)
          pos=0;
          else
          pos=1;
          
          if(pos==1)
          {
                   t=mult(d);
                   if(t==0)
                   {
                       System.out.println("Use a different cipher key");
                   System.exit(0);    }
                   inverse_final(array,t,n);
          }                 
             }
       }
    
    
    
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
    

    
  public static void key_matrix(String g1,int[][]array,int n,int []array3,char[]array4)
  {   
           int r=0,c=0,x=0;
           
           for(int p=0;p<g1.length();p++)
           {
               x=-1;
             for(int k=0;k<26;k++)
             {
                if(g1.charAt(p)==array4[k]) 
                {
                    x=array3[k];
                    break;
                       
                }   
             }
               if(r<n)
               {    
                 if(c<n)
                 array[r][c++]=x;
                 else
                 {
                   r++;
                   c=0;
                   array[r][c++]=x;                   
                 }
               }  
           }
           
             x=0;
               if(r!=n-1||c!=n-1)         
               {
                 for(;r<n;r++,c=0)    
                  for(;c<n;c++)
                  {
                    array[r][c]=array3[x++];   
                  }  
               }    
    
  } 
   

  public static int columnar_matrix(String g,int[][]array1,int n,int []array3,char[]array4)
  {
           
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
        return c;
  }
  
  
    public static void main(String[] args) {
        // TODO code application logic here
        
     
          
     int [] array3={0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};
           
     char [] array4={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
         
      int n,l,dn;  
      
     do
     {    
        System.out.println("\n\t Hill Cipher");
        
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
        
        String g=nstring(input1);
         
        String f="";
        
        System.out.println("Enter the size of the key matrix(2 or 3): ");
        Scanner reader=new Scanner(System.in);
        
        
        f = reader.nextLine();           
        n=Integer.parseInt(f);
        
        int [][] array=new int[10][10];
        int [][] array1=new int[n][10];
        
        System.out.println("\n Enter the cipher text:");
        reader=new Scanner(System.in);
        
        
        f = reader.nextLine();                   

        String g1=nstring(f);

         key_matrix(g1,array,n,array3,array4);
         
         int r,c,x;
               
         System.out.println("The key matrix is:");
           for(r=0;r<n;r++)
              {
                  
                  System.out.print("\n");
                  for( c=0;c<n;c++)
                     System.out.print(array[r][c]+"\t");
              }
               
               c=columnar_matrix(g,array1,n,array3,array4);
               
           System.out.println("\nThe columnar matrix is:");
              for(int i=0;i<n;i++)
              {
                  
                  System.out.print("\n");
                  for(int j=0;j<=c;j++)
                  {
                    System.out.print(array1[i][j]+"\t");
                  }
                 
            }
        
            int [][]array5=new int[n][c+1];  
              
            l=0;
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
            
             
            System.out.println("\n The final matrix cipher is:");
              for(int i=0;i<n;i++)
              {
                  
                  System.out.print("\n");
                  for(int j=0;j<=c;j++)
                  {
                    System.out.print(array5[i][j]+"\t");
                  }
                 
            }            
              
              System.out.print("\nThe encrypted text is:");
              String encry="";
              for(int i=0;i<=c;i++)
                  for(int j=0;j<n;j++)
                   for(int k=0;k<26;k++)
                   {
                     if(array5[j][i]==array3[k])
                     {
                         System.out.print(array4[k]);
                         encry=encry+array4[k];
                     }
                   }
         } 
      
      else if(ch==2)
      {
        String input1="";
        
        System.out.println("Enter the text to be decrypted:");
        Scanner reader1=new Scanner(System.in);
        
        
        input1 = reader1.nextLine();           
        
        String g=nstring(input1);
         
        String f="";
        
        System.out.println("Enter the size of the key matrix(2 or 3): ");
        Scanner reader=new Scanner(System.in);
        
        
        f = reader.nextLine();           
        n=Integer.parseInt(f);
        
        int [][] array=new int[10][10];
        int [][] array1=new int[n][10];
        
        System.out.println("\n Enter the cipher text:");
        reader=new Scanner(System.in);
        
        
        f = reader.nextLine();                   

        String g1=nstring(f);

         key_matrix(g1,array,n,array3,array4);

          
        int c=columnar_matrix(g,array1,n,array3,array4); 
            
        
              inverse(array,n);
              if(pos==0)
                  System.out.println("\nthe given text cant be deciphered using the key");
              else
              {
                  l=0;
                  int [][] array0=new int [10][10];
                     while(l<=c)
                            {
                                 for(int j=0;j<n;j++)
                                    {
                                        array0[j][l]=0;
                                            for(int k=0;k<n;k++)  
                                            array0[j][l]+=(array[j][k]*array1[k][l]);  
                  
                                             if(array0[j][l]<0)
                                                {
                                                    for( int q=-1;;q--)
                                                      if(26*q<array0[j][l])
                                                       {
                                                             array0[j][l]-=(26*q);
                                                             break;
                                                       }
                                                     }    
                                                            else
                                                            array0[j][l]%=26;
                                        }
                
            
                                                               l++;
                                }
            
             
            System.out.println("\n The matrix  is:");
              for(int i=0;i<n;i++)
              {
                  
                  System.out.print("\n");
                  for(int j=0;j<=c;j++)
                  {
                    System.out.print(array0[i][j]+"\t");
                  }
                 
              }
                System.out.print("\n\n The decrypted text is:");
                 for(int i=0;i<=c;i++)
                 {
                  for(int j=0;j<n;j++)
                  {
                   for(int k=0;k<26;k++)
                   {
                     if(array0[j][i]==array3[k])
                         System.out.print(array4[k]);
                     }
                   }
                  }              
              }
      }
      
                    System.out.print("\n\ndo you want to continue(1/0):");
                    Scanner r2=new Scanner(System.in);
                    dn=r2.nextInt();
            } while(dn==1);
    }
}   
    
