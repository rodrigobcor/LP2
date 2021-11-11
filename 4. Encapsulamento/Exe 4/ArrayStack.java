import java.util.ArrayList;

class ArrayStack implements IStackable {
	ArrayList<Integer> pilha = new ArrayList<Integer>();
	
	public int  size () {
		return pilha.size();
	}
	public void push (int v) {
    	pilha.add(v);
    }
	public int  pop () {
    	return pilha.remove(pilha.size()-1);
    }
}
