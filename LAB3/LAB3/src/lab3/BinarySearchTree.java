package lab3;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class BinarySearchTree<T extends Comparable<? super T> > {

    private BinaryNode<T> root;

    public BinarySearchTree() { }

    // TODO: initialisation
    public BinarySearchTree(T item) {
    	root = new BinaryNode<T>(item);
    }

    // TODO: on insere un nouvel item a partir de la racine
    // O(log(n))
    public void insert(T item) {
    	root.insert(item);
    }

    // TODO: est-ce qu'un item fais partie de l'arbre
    // O(log(n))
    public boolean contains(T item) {
        return root.contains(item);
    }

    // TODO: trouver la hauteur de l'arbre
    // O(n)
    public int getHeight() {
        return root.getHeight();
    }

    // TODO: placer dans une liste les items de l'arbre en ordre
    // O(n)
    public List<BinaryNode<T>> getItemsInOrder() {
    	List<BinaryNode<T>> listeEnOrdre = new ArrayList<BinaryNode<T>>();
    	root.fillListInOrder(listeEnOrdre);
    	return listeEnOrdre;
    }

    // TODO: retourner la liste d'item en String selon le bon format
    // O(n)
    public String toStringInOrder() {
        List<BinaryNode<T>> treeEnListe = new ArrayList<BinaryNode<T>>();
        treeEnListe = getItemsInOrder();
        String stringToBeReturned = "[";
        for(int i = 0; i < treeEnListe.size(); i++) {
        	stringToBeReturned += treeEnListe.get(i).getData();
        	if(i != (treeEnListe.size() -1)) {
        		stringToBeReturned += ", ";
        	}
        }
        stringToBeReturned += "]";
        return stringToBeReturned;
    }
}
