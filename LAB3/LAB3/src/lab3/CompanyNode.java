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
    		if(item.worstChild != null) {
    			worstChild = item.worstChild;
    		}
    		else {
    			worstChild = item;
    		}
    	}
    	else {
    		if(item.worstChild != null) {
    			if(worstChild.compareTo(item.worstChild) == 1) {
        			worstChild = item.worstChild;
        		}
    		}
    	}
    }

//    private CompanyNode getWorstChild() {
//    	List<BinaryNode<CompanyNode>> liste = new ArrayList<>();
//		liste = childs.getItemsInOrder();
//		return liste.get(0).getData();
//	}

	// TODO: on retourne le montant en banque de la compagnie
    // O(1)
    public Integer getMoney() {
    	return money;
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
    		for(int i = liste.size() - 1 ; i >= 0; i--) {
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
    	int dataEnParametre = item.getMoney();
    	if(money > dataEnParametre) {
    		return 1;
    	} 
    	else if(money < dataEnParametre) {
    		return -1;
    	}
    	else {
    		return 0;
    	}
    }
}
