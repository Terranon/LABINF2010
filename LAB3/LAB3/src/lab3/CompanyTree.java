package lab3;
public class CompanyTree {

    private CompanyNode root;

    public CompanyTree() { }

    // TODO: initialisation
    public CompanyTree(CompanyNode item) {
    	root = item;
    }

    // TODO: une compagnie m�re achete une autre compagnie
    // O(n)
    public void buy(CompanyNode item) {
    	root.buy(item);
    }

    // TODO: on retourne le montant en banque de la compagnie m�re
    // O(1)
    public Integer getMoney() {
        return root.getMoney();
    }

    // TODO: si on avait a laisser tomber un enfant, �a serait lui
    // Ceci est le pire de tous les enfants et les sous-enfants
    // O(1)
    public Integer getWorstChildMoney() {
        return root.worstChild.getMoney();
    }

    // TODO: on retourne en string un presentation en ordre inverse
    // de la compagnie m�re et de ses enfants
    // O(1)
    public String getTreeInOrder() {
    	StringBuilder sB = new StringBuilder();
    	root.fillStringBuilderInOrder(sB, "> ");
    	return sB.toString();
    }
}
