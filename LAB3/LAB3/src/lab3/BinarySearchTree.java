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
    	BinaryNode<T> parentDUneNode = this.root;
        BinaryNode<T> uneNode = this.root;
        while(uneNode != null) {
        	// la node completement a gauche dois etre la plus petite node
        	while(uneNode.getLeft() != null) {
        		parentDUneNode = uneNode;
            	uneNode = uneNode.getLeft();
            }
            listeEnOrdre.add(uneNode);
            listeEnOrdre.add(parentDUneNode);
            if(parentDUneNode.getRight() != null) {
            	parentDUneNode = parentDUneNode.getRight();
            	
            }
        }
    }

    // TODO: retourner la liste d'item en String selon le bon format
    // O(n)
    public String toStringInOrder() {
        return "[1, 2, 3]";
    }
}
