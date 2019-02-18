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
   
   /* nom: findPos();
    * description: Retourne la position de l'element en memoire selon la formule
    * 			   de l'equation 1.
    */
   
   private int findPos(AnyType x){
	  //selon l'equation 1
	  int pos = (a*(Integer) x + b) % p % m;
	  //respect de l'intervalle
	  if(pos < 0) {
		  pos += m;
		  
	  } else if (pos > m) {
		  pos -= m;
	  }
	  return pos;
   }

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
    	 //allocation d'un espace
         items = (AnyType[]) new Object[m];
         items[0]	= array.get(0);
         return;
      }
      
      while( unsuccessfulMemoryAllocation( array ) );
   }

   @SuppressWarnings("unchecked")
   private boolean unsuccessfulMemoryAllocation(ArrayList<AnyType> array)
   {
      //genere des valeurs, ajoute + 1 pour s'assurer de ne pas avoir 0 pour respecter l'interalle
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
