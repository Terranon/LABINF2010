package TP2;

import java.util.ArrayList;
import java.util.Random;

public class QuadraticSpacePerfectHashing<AnyType> 
{
   static int p = 46337;

   int a, b, m, n;
   AnyType[] items;
   Random generator;

   QuadraticSpacePerfectHashing()
   {
      clear();
   }

   QuadraticSpacePerfectHashing(ArrayList<AnyType> array)
   {
      allocateMemory(array);
   }

   public void setArray(ArrayList<AnyType> array)
   {
      allocateMemory(array);
   }

   public int size()
   {
      return n;
   }

   public void clear()
   {
      generator = new Random( System.nanoTime() );
      a = b = m = n = 0; 
      items = null;
   }

   private int findPos(AnyType x){
	  
	  int pos = (a*(Integer) x + b) % p % m;
	  if(0 <= pos) {
		  if(pos < m) {
			  return pos;
		  }
		  else {
			  System.out.println( "position out of bounds: greater than m");
			  return -1;
		  }
	  }
	  else {
		  System.out.println( "position out of bounds: less than zero");
	      return -1;
	  }
   }
	/*
	 * private static boolean isPrime(int n) { if(n == 2 || n == 3) { return true; }
	 * if(n == 1 || n % 2 == 0) { return false; } for(int i = 3 ; i * i <= n; i +=2)
	 * { if (n% i == 0) { return false; } } return true; }
	 */

   public boolean contains(AnyType x )
   {
      if( n == 0 ) return false; 

      int index = findPos(x);

      return ( ( items[index] != null ) && ( items[index].equals(x) ) );
   }

   @SuppressWarnings("unchecked")
   private void allocateMemory(ArrayList<AnyType> array)
   {
      clear();

      if(array == null || array.size() == 0) return;

      n = array.size();
      m = n*n;

      if(n == 1)
      {
         items = (AnyType[]) new Object[m];
         items[0]	= array.get(0);
         return;
      }

      while( unsuccessfulMemoryAllocation( array ) );
   }

   @SuppressWarnings("unchecked")
   private boolean unsuccessfulMemoryAllocation(ArrayList<AnyType> array)
   {
      a = generator.nextInt(p) + 1;
      b = generator.nextInt(p) + 1;
      items = (AnyType[]) new Object[m];
      for(int i = 0; i < array.size(); i++) {
    	  int pos = findPos(array.get(i));
    	  if (items[pos] != null) {
    		  return true;
    	  } else {
    		  items[pos] = array.get(i);
    	  }
      }
      return false;
   }
   
   public int memorySize() 
   {
      return m;
   }
   
   public String toString(){
      if(n == 0) 
         return "";
      
      StringBuilder sb = new StringBuilder();
      
      for(AnyType item : items) 
         if( item != null ) 
            sb.append(item + ", ");
      
      return sb.toString();
   }
}
