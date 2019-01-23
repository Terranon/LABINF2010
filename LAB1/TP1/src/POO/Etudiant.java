package POO;

import java.util.Comparator;

public class Etudiant {
	final int N = 10;
	private String Matr;
	private String nom;
	private String prenom;	
	private String email; 
	private int section; 
	
    private int n_des_notes;
	private NoteCours [] notes;
	
	
	
	public Etudiant(String Matr,String nom, int section) {
		this.Matr = Matr;
		this.nom = nom;
		this.section = section;
	}
        
         
	
	public void AjouterNote(String sigle, String titre, int note){ 
		NoteCours nouvelleNote = new NoteCours();
		nouvelleNote.sigle = sigle;
		nouvelleNote.titre = titre;
		nouvelleNote.note = note;
		this.notes[n_des_notes] = nouvelleNote;
		n_des_notes++;
	}
	
	public double NoteMoyenne() {
		double moyenne = 0;
		for(int i = 0; i < n_des_notes; i++) {
			moyenne += this.notes[i].note;
		}
		return moyenne/n_des_notes;
	}

	public String getMatr() {
		return this.Matr;
	}

	public void setMatr(String matr) {
		this.Matr = matr;
	}

    public String getEmail() {
        return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNom() {
		return this.nom;
	}
    
	
	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public int getSection() {
		return section;
	}
	
    public String toString() {
        return (this.Matr + this.nom + this.section);
    }
    
    public boolean equals(Object etudiant_x) {
    	boolean estEgale = false;
    	if(etudiant_x instanceof Etudiant) {
    		if (this.Matr == ((Etudiant)etudiant_x).Matr && this.nom == ((Etudiant)etudiant_x).nom &&
        			this.prenom == ((Etudiant)etudiant_x).prenom && this.email == ((Etudiant)etudiant_x).email &&
        			this.section == ((Etudiant)etudiant_x).section) {
        		estEgale = true;
        	} 
    	} else {
    		estEgale = false;
    	}
    	
    	return estEgale;
    }
}
