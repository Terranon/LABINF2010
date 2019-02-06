package POO;

public class Article {	
	private final String NumProduit; 
	private String nom;
	private double Prix_net;


    public Article(String NumProduit, String nom){
        this.NumProduit = NumProduit;
        this.nom = nom;
	}
	
	public Article(String np, String nom, double prix){		
		this.NumProduit = np;
		this.nom = nom;
		this.Prix_net = prix;
	}

	public String getNumProduit() {
		return this.NumProduit;
	}	
	public String getNom() {
		return this.nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public double getPrixNet() {
		return this.Prix_net;
	}
	public void setPrixNet(double prix_net) {
		this.Prix_net = prix_net;
	}
	public double getVAT(){
		return this.Prix_net;
	}
	public double getPrix(int count){
		return this.Prix_net;
	}
	public String getArticleType(){
		return "Article sans type";
	}
	public String toString() {
		String prixEnString = Double.toString(this.Prix_net);
		return (this.NumProduit + this.nom + prixEnString);
	}
}
