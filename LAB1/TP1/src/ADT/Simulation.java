package ADT;

import java.util.Random;

public class Simulation {
	 private static Random random;  

	 //Retourne un nombre réel aléatoire uniformément dans [0,1[
	    public static double uniform() {
	    	return random.nextDouble();
	    }

	 
	 
	 //Retourne un nombre entier aléatoire uniformément dans [0,n[
	    public static int uniform(int n) {
	    	return random.nextInt((n - 0) + 1);
	    }

	//Retourne un entier long aléatoire uniformément dans [0, n[.
        // Vous pouviez trouver le code https://docs.oracle.com/javase/8/docs/api/java/util/Random.html#longs-long-long-long-
    public static long uniform(long n) {
        if (n <= 0L) throw new IllegalArgumentException("Argument doit etre positive: " + n);


        long r = random.nextLong();
        long m = n - 1;

        
        if ((n & m) == 0L) {
            return r & m;
        }

      
        long u = r >>> 1;
        while (u + m - (r = u % n) < 0L) {
            u = random.nextLong() >>> 1;
        }
        return r;
    }
    
    //Retourne avec succès un booléen true si p suit d'une distribution de Bernoulli
    public static boolean bernoulli(double p) {
       return true;
    }
    
    public static Compteur max(Compteur x, Compteur y) {
    	if(x.compareTo(y) <= 0) {
    		return x;
    	} else {
    		return y;
    	}
    }
	
	 public static void main(String[] args) {
	    int n = 10;
	    Compteur pile = new Compteur("pile");
	    Compteur face = new Compteur("face");
	       
              //Les instructions du simulation
	    int nbrDeFaces = 1;
        for(int i = 0; i < n; i++) {
        	if(uniform(nbrDeFaces) == 0) {
        		pile.increment();
        	} else {
        		face.increment();
        	}
        }
              //afficher la différence entre les score des compteur
        int difference = (pile.score() - face.score());
        if(difference < 0) {
        	difference = difference * -1;
        }
        System.out.println("En " + n + " flips nous avons eu une difference de " 
              + difference + " entre les piles et faces.");
        
        
	    Compteur pile_c = new Compteur("pile");
		Compteur face_c = new Compteur("face");
		        
	          //Les instructions du simulation
        for(int i = 0; i < n; i++) {
        	if(uniform(nbrDeFaces) == 0) {
        		pile_c.increment();
        	} else {
        		face_c.increment();
        	}
        }
                   //afficher le maximum entre les score des compteur
        if(pile_c.score() < face_c.score()) {
        	System.out.println("Il y a eu plus de faces que de piles, avec " + face_c.score()
        		+ " faces");
        } else if (pile_c.score() == face_c.score()) {
        	System.out.println("Il y a eu aucune difference entre les faces et piles.");
        } else {
        	System.out.println("Il y a eu plus de piles que de faces, avec " + pile_c.score()  
        		+ " piles");
        }

	        }
	  }



