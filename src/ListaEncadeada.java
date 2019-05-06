
public class ListaEncadeada {
	private Node head, last;
	private int size;
	
	public void add(int num) {
		if(head == null) {
			head = new Node(num);
			last = head;
		}
		else {
			last.proximo = new Node(num);
			last = last.proximo;
		}
		size++;
	}
	
	public boolean removeMultiple(int n) {
		if(vazio() || n > size) 
			return false;
		
		Node atual = head;
		
		for(int i = 0; i < n; i++) {
			atual = atual.proximo;
		}
		head = atual;
		return true;
	}
	
	public void troca(int m, int n) {
		if(validPosition(m) && validPosition(n)) {
			int aux;
			Node node1 = getNode(m);
			Node node2 = getNode(n);
			aux = node1.dado;
			node1.dado = node2.dado;
			node2.dado = aux;
		}
	}
	
	public int tamanho() {
		return size;
	}
	
	public boolean vazio() {
		return size == 0; 
	}
	
	private boolean validPosition(int i) {
		return i >= 0 || i < size;
	}
	
	private Node getNode(int index) {
		Node atual = head;
		for(int i = 0; i < index; i++) {
			atual = atual.proximo;
		}
		return atual;
	}
	
	@Override
	public String toString() {
		String str = "[";
		Node atual = head;
		
		while(atual != null) {
			str += atual.dado;
			if(atual.proximo != null)
				str += ", ";
			atual = atual.proximo;
		}
		
		return str += "]";
	}
}

class Node {
	public int dado;
	public Node proximo;
	
	public Node(int dado) {
		this.dado = dado;
	}
}
