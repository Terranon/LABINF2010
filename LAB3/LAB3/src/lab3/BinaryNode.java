package lab3;
import java.util.List;

public class BinaryNode<T extends Comparable<? super T> > {
    private T data;
    private BinaryNode<T> right;
    private BinaryNode<T> left;

    // TODO: initialisation
    // O(1)
    public BinaryNode(T data) {
    	this.data = data;
    	right = null;
    	left = null;
    }

    // TODO: on retourne la donnee voulue
    // O(1)
    public T getData() {
        return this.data;
    }

    // TODO: on ajoute une nouvelle donnee au bon endroit
    // O(log(n))
    public void insert(T item) {
    	int compareResult = item.compareTo(this.data);
    	// Insérer si position courante est une feuille
    	if( right == null && left == null) {
    		BinaryNode<T> nouvelleNode = new BinaryNode<T>(item);
    		if(compareResult <= 0) {
    			left = nouvelleNode;
    		}
    		else {
    			right = nouvelleNode;
    		}
    	}
    	// Sinon
    	else {
    		if(compareResult <= 0 )
    	    	this.left.insert(item);
    		else
    			this.right.insert(item);
    	}
    }

    private int compareTo(T data2) {
		int dataDeThis = (int) this.data;
		int dataEnParametre = (int) data2;
		int resultat = (dataDeThis - dataEnParametre);
		return resultat;
	}

	// TODO: est-ce que l'item fais partie du noeuds courant
    // O(log(n))
    public boolean contains(T item) {
    	int compareResult = item.compareTo(this.data);
        if(compareResult == 0) {
        	return true;
        }
        else if(right != null && left != null) {
        	if(compareResult < 0){
            	return left.contains(item);
            }
        	else {
        		return right.contains(item);
        	}
        }
        else {
        	return false;
        }
    }

    // TODO: on retourne la maximale de l'arbre
    // O(n)
    public int getHeight() {
    	int height = 0;
    	if(left == null && right == null) {
    		return height - 1;
    	}
    	int lefth = left.getHeight();
    	int righth = right.getHeight();
    	if( lefth > righth) {
    		return lefth + 1;
    	}
    	else {
    		return righth + 1;
    	}
    }

    // TODO: l'ordre d'insertion dans la liste est l'ordre logique
    // de manière que le plus petit item sera le premier inseré
    // O(n)
    public void fillListInOrder(List<BinaryNode<T>> result) {
    	BinaryNode<T> plusPetit = new BinaryNode<T>(result.get(0).getData());
    	int compareResult = 0;
    	for(int i = 0; i < result.size(); i++) {
    		compareResult = result.get(i).getData().compareTo(plusPetit.getData());
    		if(compareResult < 0) {
    			plusPetit = result.get(i);
    		}
    	}
    	this.insert(plusPetit.getData());
    	// TODO: remove de la list "plusPetit"
    	result.remove(plusPetit);
    	fillListInOrder(result);
    }
}
