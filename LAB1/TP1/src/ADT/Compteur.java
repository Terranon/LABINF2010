package ADT;

import java.util.Random;

public class Compteur implements Comparable<Compteur> {

    private final String nom;        // nom du compteur
    private int compteur = 0;        // initialisation la valeur courant est 0

    
    public Compteur(String id) {
         this.nom = id;
    } 

   
    public void increment() {
         this.compteur++;
    } 

   
    public int score() {
         return this.compteur;
    } 

   
    public String toString() {
         return (this.nom + Integer.toString(this.compteur));
    } 

  
    public int compareTo(Compteur x) {
        if(this.compteur < x.compteur) {
        	return -1;
        } else if (this.compteur == x.compteur) {
        	return 0;
        } else {
        	return 1;
        }
    }
    
	
      
    private static Random random = new Random(10000);
    
      //Retourne un nombre entier aléatoire uniformément dans [0,n[
    
	public static int uniform(int n) {
		return random.nextInt((n - 0) + 1);
	}


   
    public static void main(String[] args) { 
       int n = 6;
       int essais = 60000;

       // Creation n compteurs
       int [] compteurs = new int[n];
 
       // incrémente les compteurs d'essais au hasard
       for(int i = 0; i < essais; i++) {
    	   int quelCompteur = uniform(n);
    	   compteurs[quelCompteur]++;
       }

       // Affichage des resultat
       System.out.println("Les " + n + " compteurs ont ete incremente: ");
       for(int j = 0; j < n; j++) {
    	   System.out.println("Compteur " + j + compteurs[j]);
       }
    }
} 
