package lab3;
import java.util.ArrayList;
import java.util.List;

public class CompanyNode implements Comparable<CompanyNode> {
    private Integer money;
    private BinarySearchTree<CompanyNode> childs;
    public CompanyNode worstChild;

    // TODO: initialisation
    // O(1)
    public CompanyNode(Integer data) {
    	this.money = data;
    	childs = null;
    	worstChild = null;
    }

    // TODO: la compagnie courante achete une autre compagnie
    // O(log(n))
    public void buy(CompanyNode item) {
    	money += item.getMoney();
    	if(childs == null) {
    		childs = new BinarySearchTree<CompanyNode>(item);
    	}
    	else {
    		childs.insert(item);
    	}
    	if(worstChild == null) {
    		worstChild = item.getWorstChild();
    	}
    	else {
    		if(worstChild.getMoney() > item.getWorstChild().getMoney()) {
    			worstChild = item.getWorstChild();
    		}
    	}
    }

    // TODO: on retourne le montant en banque de la compagnie
    // O(1)
    public Integer getMoney() {
    	if(childs == null) {
    		return money;
    	}
    	else {
    		List<BinaryNode<CompanyNode>> liste = new ArrayList<>();
    		liste = childs.getItemsInOrder();
    		int nouvelleValeurDeMoney = 0;
    		for(int i = 0; i < liste.size(); i++) {
    			nouvelleValeurDeMoney += liste.get(i).getData().money;
    		}
    		return nouvelleValeurDeMoney;
    	}
    }

    // TODO: on rempli le builder de la compagnie et de ses enfants avec le format
    //A
    // > A1
    // > A2
    // >  > A21...
    // les enfants sont afficher du plus grand au plus petit (voir TestCompany.testPrint)
    // O(n)
    public void fillStringBuilderInOrder(StringBuilder builder, String prefix) {
    	builder.append(money);
    	builder.append("\n");
    	if(childs != null) {
    		List<BinaryNode<CompanyNode>> liste = childs.getItemsInOrder();
    		for(int i = 0; i < liste.size(); i++) {
    			int nbrDePrefix = liste.get(i).getHeight();
    			for(int j= 0; j < nbrDePrefix; j++) {
    				builder.append(prefix);
    			}
    			builder.append(money);
    			builder.append("\n");
    		}
    	}
    }

    // TODO: on override le comparateur pour defenir l'ordre
    @Override
    public int compareTo(CompanyNode item) {

        return 0;
    }
}
