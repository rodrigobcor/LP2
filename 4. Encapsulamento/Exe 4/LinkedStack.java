import java.util.LinkedList;

public class LinkedStack implements IStackable {
	LinkedList<Integer> pilha = new LinkedList<Integer>();
	
	public int  size () {
		return pilha.size();
	}
	public void push (int v) {
    	pilha.addFirst(v);
    }
	public int  pop () {
    	return pilha.removeFirst();
    }
}
