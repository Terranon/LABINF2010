import java.util.*; 


public class Main 
{
   /**
     * Fonction principale
     */
   public static void main(String[] args) 
   {
      // creer un monceau avec 22 elements et un tableau equivalent
      int numItems = 22;
      BinaryHeap<Integer> heap = new BinaryHeap<Integer>(true);
      
      Integer [ ] items = new Integer[ numItems ];

      int i;
      int j;

      // en inserant les elements un a un
      for( i = 11, j = 0; j != numItems; i = ( i + 37 ), j++ )
      {
	  heap.offer( i );
	  items[ j ] = i;

	  i %=  numItems; 
      }

      // en construisant le monceau depuis le depart
      System.out.println("Monceau min contruit element par element:");
      System.out.println( heap.printFancyTree() );

      heap = new BinaryHeap<Integer>(false);
      // en inserant les elements un a un
      for( Integer item : items)
	  heap.offer( item );

      // en construisant le monceau depuis le depart
      System.out.println("Monceau max contruit element par element:");
      System.out.println( heap.printFancyTree() );

      heap = new BinaryHeap<Integer>(items,false);
      System.out.println("Monceau max contruit a partir d'un tableau:");
      System.out.println( heap.printFancyTree() );

      heap = new BinaryHeap<Integer>(items,true);
      System.out.println("Monceau min contruit a partir d'un tableau:");
      System.out.println( heap.printFancyTree() );

      System.out.println();
      System.out.println("Affichage recursif:");
      System.out.println( heap.printFancyTree() );

      System.out.println("Affichage non recursif:");
      System.out.println( heap.nonRecursivePrintFancyTree() );

      System.out.println();
      System.out.println("Tableau d'origine:");
      System.out.println( printArray( items ) );
      
      BinaryHeap.heapSort( items );
      System.out.println("Tableau ordonne:");
      System.out.println( printArray( items ) );

      BinaryHeap.heapSortReverse( items );
      System.out.println("Tableau inversement ordonne:");
      System.out.println( printArray( items ) );


      /*
       * Ajouter appels pour repondre a la question
       **/
      testOfferMin(items);
      testOfferMax(items);
      testPollMin(items);
      testPollMax(items);
      //testOfferIteratorNext(items);
      //testIteratorOutOfBounds(items);
   }

   private static <AnyType> 
   String printArray(AnyType[] a)
   {
      String outputString = "";

      for(AnyType item : a)
      {
         outputString += item;
         outputString += ", ";
      }

      return outputString.substring(0,outputString.length()-2);
   }
   private static void testOfferMin(Integer[] items) {
	   System.out.print("Test pour : offer() quand min=true:\n");
	   int resultatVoulu = -100;
	   BinaryHeap<Integer> heap = new BinaryHeap<Integer>(items, true);
	   heap.offer(resultatVoulu);
	   if(resultatVoulu == heap.poll())
		   System.out.print("\tSucces!\n");
	   else
		   System.out.print("\tEchec :(\n");
   }
   private static void testOfferMax(Integer[] items) {
	   System.out.print("Test pour : offer() quand min=false:\n");
	   int resultatVoulu = 1000;
	   BinaryHeap<Integer> heap = new BinaryHeap<Integer>(items, false);
	   heap.offer(resultatVoulu);
	   if(resultatVoulu == heap.poll())
		   System.out.print("\tSucces!\n");
	   else
		   System.out.print("\tEchec :(\n");
   }
   private static void testPollMin(Integer[] items) {
	   System.out.print("Test pour : poll() quand min=true:\n");
	   int resultatVoulu = items[1];
	   BinaryHeap<Integer> heap = new BinaryHeap<Integer>(items, true);
	   if(resultatVoulu == heap.poll())
		   System.out.print("\tSucces!\n");
	   else
		   System.out.print("\tEchec :(\n");
   }
   private static void testPollMax(Integer[] items) {
	   System.out.print("Test pour : poll() quand min=false:\n");
	   int resultatVoulu = items[1];
	   boolean succes = true;
	   for(int valeur : items) {
		   if(valeur < items[1]) {
			   succes = false;
			   break;
		   }
	   }
	   if(succes)
		   System.out.print("\tSucces!\n");
	   else
		   System.out.print("\tEchec :(\n");
   }
   private static void testOfferIteratorNext(Integer[] items) {
	   System.out.print("Test pour : next() dans Iterator:\n");
	   BinaryHeap<Integer> heap = new BinaryHeap<Integer>(items, true);
	   Iterator<Integer> it = heap.iterator();
	   heap.offer(1);
	   it.next();
	   System.out.print("\tEchec :(\n");	   
   }
   private static void testIteratorOutOfBounds(Integer[] items) {
	   System.out.print("Test pour : OutofBound dans Iterator:\n");
	   BinaryHeap<Integer> heap = new BinaryHeap<Integer>(items, true);
	   Iterator<Integer> it = heap.iterator();
	   for(int i = 0; i <= items.length; i++) {
		   it.next();
	   }
	   System.out.print("\tEchec :(\n");
   }
}
