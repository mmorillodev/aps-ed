
public class ListaEncadeada {
	//Variaveis de primeiro e ultimo valor
	private Node head, last;
	//Tamanho
	private int size;
	
	//Metodo de adi��o de n�mero
	public void add(int num) {
		//Se o head estiver null significa que a lista est� vazia,
		//portanto instanciar novo objeto n� e atribuir ao head e ao last
		if(head == null) 
			head = last = new Node(num);
		//Se n�o instanciar um novo objeto de N� e atribuir ao last (ultimo valor) e dizer q o o last.proximo
		//� o antigo last
		else 
			last.proximo = last = new Node(num);
		//Increnentar o tamanho
		size++;
	}
	
	public boolean removeMultiple(int n) {
		//Se estiver vazio ou n ultrapassa o tamanho da lista retorna false
		if(vazio() || n > size) 
			return false;
		
		Node atual = head;
		
		//Se n�o pegue o node n e torne-o o novo head (primeiro valor)
		for(int i = 0; i < n; i++) {
			atual = atual.proximo;
		}
		head = atual;
		return true;
	}
	
	public void troca(int m, int n) {
		//Verifica se as posi��es s�o v�lidas
		if(validPosition(m) && validPosition(n)) {
			//Vari�vel auxiliar
			int aux;
			//Pega os dois n�s que ser�o trocados
			Node node1 = getNode(m);
			Node node2 = getNode(n);
			//troque apenas seus valores
			aux = node1.dado;
			node1.dado = node2.dado;
			node2.dado = aux;
		}
	}
	
	//retorna o tamanho
	public int tamanho() {
		return size;
	}
	
	//retorna true se o size for 0 ou falso caso o contr�rio
	public boolean vazio() {
		return size == 0; 
	}
	
	//Verifica se algum index � v�lido.
	//para ser valido a posi��o deve estar entre 0 e o tamanho da lista
	private boolean validPosition(int i) {
		return i >= 0 || i < size;
	}
	
	//retorna o n� de determinada posi��o. private pois os que utilizar�o esta classe
	//n�o deve ter acesso direto ao n�
	private Node getNode(int index) {
		Node atual = head;
		for(int i = 0; i < index; i++) {
			atual = atual.proximo;
		}
		return atual;
	}
	
	//Metodo sobrescrito de Object que retorna uma string com todos os elementos da lista
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
	//O dado em s�
	public int dado;
	//Proximo valor
	public Node proximo;
	
	//construtor que recebe o dado
	public Node(int dado) {
		this.dado = dado;
	}
}
