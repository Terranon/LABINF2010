package ADT;

import java.util.*;

public class Sac<T>{
	T field;
	LinkedList<T> linkedlist = new LinkedList<T>();
	
	public void addItem(T item) {
		linkedlist.add(item);
	}
	
}
