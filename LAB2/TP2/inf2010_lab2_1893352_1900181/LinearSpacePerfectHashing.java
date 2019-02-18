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
	 //selon l'equation 2
     int pos = (a*(Integer) x + b) % p % n;
     //respect de l'intervalle
	 if(pos < 0) {
		  pos += n;
		  
	 } else if (pos > n) {
	 	 pos -= n;
	 }
	 return pos;
   }
   
   public boolean contains(AnyType x)
   {      
	  // s'il y a aucun element, renvoi faux
      if ( n == 0 ) return false;
      // trouver la position de l'element x
      int index = findPos(x);
      // utiliser la methode dans QuadraticSpacedPerfectHashing
      return (data[index].contains(x));
   }
      
   @SuppressWarnings("unchecked")
   private void allocateMemory(ArrayList<AnyType> array)
   {
      clear();
      
      if(array == null || array.size() == 0) return;
      //genere des valeurs, ajoute + 1 pour s'assurer de ne pas avoir 0 pour respecter l'intervalle
      a = generator.nextInt(p) + 1;
      b = generator.nextInt(p) + 1;
      n = array.size();
      data = new QuadraticSpacePerfectHashing[n];
      ArrayList<AnyType> arrayTemp[];
      arrayTemp = new ArrayList[n];
      
      // Placer un ArrayList<AnyType> a chaque position de arrayTemp
      for(int i = 0; i < n; i++) {
    	  arrayTemp[i] = new ArrayList<AnyType>();
      }
      
      // Si la taille de array est un sa memoire est simplement 2
      if(n == 1)
      {
         memorySize = 2;
         data[0].items[0] = array.get(0);
         return;
      }
      
      memorySize = 0;
      
      for(int j = 0; j < n; j++) {
    	  //Si il y a un item a la position j
    	  if(array.get(j) != null) {
    		  //rajouter l'item dans arrayTemp a la meme position
    		  arrayTemp[findPos(array.get(j))].add(array.get(j));
    	  }
      }
      
      for(int k = 0; k < n; k++) {
    	  //inserer un QuadraticSpacePerfectHashing<AnyType> base sur le arrayTemp
    	  // a chaque position de data
    	  data[k] = new QuadraticSpacePerfectHashing<AnyType>(arrayTemp[k]);
    	  // additioner la taille de la memoire occuper
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
