package pack1;
public class Currency1
{
    public double dol_rup(double d)
    {
        return d*80;

    }
    public double rup_dol(double r)
    {
        return r/80;
    }
               
}

package pack2;
public class Currency2
{
    public double euro_rup(double e)
    {
       return e*88.33;
    }
    public double rup_euro(double r)
    {
       return r/88.33;
    }
   
}

package pack3;
public class Currency3
{
   public double yen_rup(double y)
   {
      return y*0.56;
   }
   public double rup_yen(double r)
   {
       return r/0.56;
   }
}
   





package javaapplication25;

import java.util.Scanner;
import pack1.Currency1;
import pack2.Currency2;
import pack3.Currency3;
public class CurrencyCalculation
{
    public static void main(String[] args)
    {
     
      Scanner obj=new Scanner(System.in);
      Currency1 obj1=new Currency1();
      Currency2 obj2=new Currency2();
      Currency3 obj3=new Currency3();
      System.out.println("Currency Conversion Menu:");
      System.out.println("1. Dollar to Indian Rupees");
      System.out.println("2. Indian Rupees to Dollar");
      System.out.println("3. Euro to Indian Rupees");
      System.out.println("4. Indian Rupees to Euro");
      System.out.println("5.  Yen to Indian Rupees");
      System.out.println("6. Indian Rupees to Yen");
      System.out.print("Enter your choice: ");
      while(true){
      int choice = obj.nextInt();
      switch(choice)
      {
          case 1:
              System.out.println("Enter the Dollar:");
              double k=obj.nextDouble();
              System.out.println("INDIAN RUPEES:"+obj1.dol_rup(k));
              break;
         
          case 2:
              System.out.println("Enter the Indian rupees:");
              double x=obj.nextDouble();
              System.out.println("DOLLARS:"+obj1.rup_dol(x));
              break;
             
          case 3:
              System.out.println("Enter the Euro :");
              double d=obj.nextDouble();
              System.out.println("INDIAN RUPEES:"+obj2.euro_rup(d));
              break;
          case 4:
              System.out.println("Enter the Indian rupees:");
              double o=obj.nextDouble();
              System.out.println("EURO:"+obj2.rup_euro(o));
              break;
         
          case 5:
              System.out.println("Enter the Yen :");
              double z=obj.nextDouble();
              System.out.println("INDIAN RUPEES:"+obj3.yen_rup(z));
              break;
             
          case 6:
              System.out.println("Enter the Indian rupees :");
              double p=obj.nextDouble();
              System.out.println("YEN:"+obj3.rup_yen(p));
              break;
             
          default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
             
        }
     
       }
    }
}
