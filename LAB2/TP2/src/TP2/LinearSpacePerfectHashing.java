package TP2;

import java.util.Random;
import java.util.ArrayList;

public class LinearSpacePerfectHashing<AnyType>
{
   static int p = 46337;
   
   int a, b, n, memorySize;
   QuadraticSpacePerfectHashing<AnyType>[] data;
   Random generator;
   
   LinearSpacePerfectHashing()
   {
      clear();
   }
   
   LinearSpacePerfectHashing(ArrayList<AnyType> array)
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
      a = b = n = memorySize = 0; 
      data = null;
   }

   private int findPos(AnyType x)
   {
     int pos = (a*(Integer) x + b) % p % n;
	 
	  if(pos < n) {
		  return pos;
	  }
	  else {
		  System.out.println( "position out of bounds: greater than n");
		  return -1;
	  }
   }
   
   public boolean contains(AnyType x)
   {      
      if ( n == 0 ) return false;

      int index = findPos(x);

      return (data[index].contains(x));
   }
      
   @SuppressWarnings("unchecked")
   private void allocateMemory(ArrayList<AnyType> array)
   {
      clear();
      
      if(array == null || array.size() == 0) return;
      a = generator.nextInt(p) + 1;
      b = generator.nextInt(p) + 1;
      n    = array.size();
      data = new QuadraticSpacePerfectHashing[n];
      ArrayList<AnyType> arrayTemp[];
      arrayTemp = new ArrayList[n];
      
      for(int i = 0; i < n; i++) {
    	  arrayTemp[i] = new ArrayList<AnyType>();
      }
      
      if(n == 1)
      {
         memorySize = 2;
         data[0].items[0] = array.get(0);
         return;
      }
      int pos;
      AnyType vector;
      memorySize = 0;
      
      for(int j = 0; j < n; j++) {
    	  if(array.get(j) != null) {
    		  vector = array.get(j);
    		  pos = findPos(vector);
    		  arrayTemp[pos].add(vector);
    	  }
      }
      for(int k = 0; k < n; k++) {
    	  data[k] = new QuadraticSpacePerfectHashing<AnyType>(arrayTemp[k]);
    	  memorySize += data[k].memorySize();
      }
   }
   
   public int memorySize() 
   {
      return memorySize;
   }
   
   public String toString(){
      StringBuilder sb = new StringBuilder();
      
      for(int i = 0; i < data.length; i++) {
    	  sb.append("- ");
    	  sb.append(i);
    	  sb.append(" ->");
    	  for(int j = 0; j < data[i].memorySize(); j++) {
    		  sb.append(data[i].items[j]);
    		  sb.append(",");
    	  }
    	  sb.append("\n");
      }
      
      return sb.toString();
   }
}
