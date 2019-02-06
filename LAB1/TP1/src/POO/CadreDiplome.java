package POO;

public class CadreDiplome extends Article {
	private String categorie;
	private String couleur;
	public CadreDiplome(String NumProduit, String nom, double prix, String couleur,String categorie){
		super(NumProduit, nom, prix);
		this.categorie = categorie;
		this.couleur = couleur;
	}
	
	public CadreDiplome(String NumProduit, String nom, double prix,String categorie){
		super(NumProduit, nom, prix);
		this.categorie = categorie;
	}
	
	@Override
	public String getArticleType() {
		return "CadreDiplome";
	}

	public String getCategorie() {
		return this.categorie;
	}

	public void setCategorie(String categorie) {
        this.categorie = categorie;
	}
	
	public String getCouleur() {
		return this.couleur;
	}
	
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	
}
