package POO;

public class Main {
	public static void main(String[] args) {		
		Etudiant e = new Etudiant("1897453","John",3);
		
			
		e.AjouterNote("INF2010", "Structures de donn�es et algorithmes", 4);		
		e.AjouterNote("LOG2810", "Structures discr�tes", 5);
		e.AjouterNote("INF2610", "Noyau d'un syst�me d'exploitation", 3);
		System.out.println(e.NoteMoyenne());
 
                



	}
}