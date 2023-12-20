

/**
 * Assignment Name : Final Project (CS160)
 * Author : Seerat Sandha 
 * Date : 05/03/2023
 * e-mail : sand4927@bears.unco.edu
 */
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.*;

public class SpaceExplorer
{
    public static double Gravity_Finder(String userInput, double force , String[] names, double [] mass , double[] distance) {
   {
     //acess from nasa.gov
     final double GRAVITATIONAL_CONSTANT= 6.67e-11; // Gravitational  Constant
     final double MASS_SUN = 2e30;   // mass of the sun in Kg 
  int w;
  for(w=0; w<9;w++)
  {
    if(userInput.equals(names[w]))
    {
        // applying the newtons law of gravitation to find the garavitational ofrce between to objects using their mass
      // and square of the distance between them . 
      double upper = GRAVITATIONAL_CONSTANT*MASS_SUN*mass[w]*1e24; 
      // dividing the formula into two sections upper part and lower part. upper part multiply the gravitational constant
      // with the masses of two objects 
      double below = distance[w]*distance[w];
      // lower part calculates the square of the distance between them 
      force = upper/below;  // finally divide the upper part by lower part and find the gravitational constatnt . 
    }
}
return force;
}
}
public static double Age_Finder(int currAge , double[] days , String[] names , String userInput)
{
    double finalAge=0;
    for(int z =0; z<9 ; z++)
    {
        // to find the age of the user on other planets . 
      if(userInput.equals(names[z]))
     {
       double ageEarth= currAge*365;  // just multiplying the age of the user with the number of days per year on earth.
       finalAge = ageEarth/days[z];// now ageEarth is dividing by the number of days per year on other planet
    }
  }
  return Math.ceil(finalAge);
}
public static double Weight_Finder(double currWeight , String userInput, String[] names , double [] planetOwnGravity)
{
    
    double finalWeight =0; 
    for(int w =0; w<9; w++)
    // to find the weight of the person on other planets .
    {
        if(userInput.equals(names[w]))
        {
            finalWeight= currWeight * planetOwnGravity[w]; 
            // simply divide the weight of the person on earth with the planet's own gravitational force . 
        }
    }
    return finalWeight;
    
    
    
}

public static void main(String[]args) throws IOException
{

try
{
    
   Scanner scnr1 = null;
   Scanner scnr2 = null;
   Scanner scnr3 = null;
   
    // FileInputStream to open and read the data from file 
    // all files must be in same directory 
    
    FileInputStream fileName = new FileInputStream("C:\\Users\\sand4927\\mass & distance.txt");
    FileInputStream fileName1 = new FileInputStream("C:\\Users\\sand4927\\names.txt");
    FileInputStream fileName2 = new FileInputStream("C:\\Users\\sand4927\\define planet.txt");
    scnr1 = new Scanner(fileName);
    scnr2 = new Scanner(fileName1);
    scnr3 = new Scanner(fileName2);
    // declare multiple arrays to store the contents of file . 
    FileOutputStream  outputFile = new FileOutputStream ("Output Record(sand).txt");
    PrintWriter outfs = new PrintWriter(outputFile);
    
    double [] mass = new double[9];
    double [] distance= new double[9];
    double [] days = new double[9];
    double [] planetOwnGravity= new double[9];
    String [] names = new String [9];
    String [] lines =new String[9];
    String [] gravity = new String[13];
    
    /*String space = "\t\t\t\t";
    System.out.println("Enter the planet name you want to know about:" );
    Scanner scnr = new Scanner(System.in);   // prompt user for planet name 
    String userInput = scnr.next();*/
    int i =0; 
     while(scnr1.hasNextDouble() && i <9)   // To read only mass of planets (first 9 lines) 
     {
        for(i=0; i <9 ; i++)
        {
          mass[i] = scnr1.nextDouble();
        }
    }
    int j =0;
    while(scnr1.hasNextDouble()&& j <9)   // To read the distance of planets from sun( 9 to 18 lines)
    { 
        for(j =0 ; j <9; j++)
        {
          distance[j] = scnr1.nextDouble();
        }
    }
    int m =0;
    while(scnr1.hasNextDouble()&& m <9)   // To read the of no. of days per year on each planets (18 to 27 lines)
    {
        for(m =0 ; m <9; m++)
        {
          days[m] = scnr1.nextDouble();
        }
    }
    int d =0;
    while(scnr1.hasNextDouble()&&d<9)  // To read the Gravity of each planet (27 to 36 lines)
    
    {
        for(d=0; d<9;d++)
        {
            planetOwnGravity[d] = scnr1.nextDouble();
        }
    }
    
    int s=0;
   
    while(scnr2.hasNext() && s<9)   // In other file read the names of the planets 
   {
    for(s=0;s<9; s++)
    {
      names[s] = scnr2.next();
      System.out.print(names[s] +" , "); // printing the names of all planets 
    
    
    }
  }
  int l =0;
  
  while(scnr3.hasNextLine() && l<9)  // to read the description of all planets 
  {
    for(l =0; l<9 ;l++)
    {
        lines[l] = scnr3.nextLine();
    }
  }
String space = "\t\t\t\t";
System.out.println("\n\nEnter the planet name from above that you want to know about:\n" );
Scanner scnr = new Scanner(System.in);   // prompt user for planet name 
String userInput = scnr.next();
 System.out.printf("\nThe Gravitational Force on "+userInput+" by sun is: "+"%3.4e",Gravity_Finder(userInput, 0.0 , names, mass,distance));
 System.out.print(" Newtons(N)");
 outfs.printf("\nThe Gravitational Force on "+ userInput+" by sun is : "+"%3.4e", Gravity_Finder(userInput, 0.0 , names, mass,distance));
 outfs.print( "Newtons(N)");
 
   for(int lee=0; lee<9; lee++)
  {
   if(userInput.equals(names[lee])) // to print the description of the entered planet nam
   {
       System.out.println("\n\n"+space+"***** Small Description to " +names[lee]+" ******"+"\n");
       for(d=0; d<lines[lee].length();d++)
      {
         System.out.print("-"); 
      }
       System.out.println("\n"+lines[lee]);
       for(d=0; d<lines[lee].length();d++)
      {
         System.out.print("-"); 
       }
    System.out.println("\n\nIf you want to know more about the Gravitational force then type *yes* Otherwise type *no*");
    String decision = scnr.next();
    int q=0;
    boolean flag = true;
      while(scnr3.hasNextLine() && q<12 && flag==true)  // to print the ways to use gravity
    {
       for( q =0; q<12; q++)
     {
       gravity[q] = scnr3.nextLine();
       if(decision.equals("yes"))
      {
         System.out.println(gravity[q]);
      }
      else
      {
        System.out.println("\t\t\t\t\t Alright!! Now move to the next step !!! \t\t\t\t\t");
        flag=false;
        break;
    
       
       }
     }
    }
   }

 }
System.out.println("\n"+space +"Are you wonder what your *AGE* will be on different planets"+"\n");
System.out.println(space+"\t\t<<<<< Lets find out>>>>>\n");
System.out.println("Please enter your current age.....");
int currAge = scnr.nextInt();
// method call to Age_Finder to find age on enterd planet);
System.out.println("\nYour current age on  "+userInput+" will be "+Age_Finder(currAge , days ,names ,userInput)+" years old");
outfs.println("\nYour current age on  "+userInput+" will be "+Age_Finder(currAge , days ,names ,userInput)+" years old");


System.out.println("\n"+space+"Are you wonder what your *WEIGHT* will be on different planets"+"\n");
System.out.println(space+"\t\t<<<<< Lets find out>>>>>\n");
System.out.println("Please enter your current weight ....");
int currWeight= scnr.nextInt();
// method call to Weight_Finder to find the weight of person on entered planet
System.out.printf("Your current weight on "+userInput+" will be "+"%.3f",Weight_Finder(currWeight,userInput,names,planetOwnGravity));
System.out.print(" Kg");
outfs.printf("Your current weight on "+userInput + " will be "+"%.3f",Weight_Finder(currWeight,userInput,names,planetOwnGravity));
outfs.print( "Kg");

System.out.println("\n\n"+ space+"Your data has been sucessfully saved to a file."+"\n\n " +space+"\t\t\tThank You  :)");

fileName.close();
fileName1.close();
fileName2.close();
outfs.close();
}
catch(FileNotFoundException f )  // for IOExceptions .
 {
    System.out.println("File not found in the directory.");
 }
catch(IOException eof)
 {
    System.out.println("Error!! openning a file.");
 }
}
}

