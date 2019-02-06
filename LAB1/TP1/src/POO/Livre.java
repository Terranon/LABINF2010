package POO;

public class Livre extends Article {
	private String format;   // pdf, epub  ou paper
	public Livre(String NumProduit, String nom, String format) {
		super(NumProduit, nom);
		this.format = format;
	}
	
	public Livre(String NumProduit, String nom, double prix, String format){
		super(NumProduit, nom, prix);
	    this.format = format;
	}
	
	
	public String getArticleType() {
	    return "Livre";
	}

	public String getFormat() {
		return this.format;
	}

	public void setFormat(String format) {
	    this.format = format;
	}
	
}