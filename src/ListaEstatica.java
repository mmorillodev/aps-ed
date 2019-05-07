
public class ListaEstatica {
	//O array que ser� utilizado para inserir os valores
	private int[] arr;
	//O tamanho real da lista
	private int realSize;
	
	public ListaEstatica(int size) {
		//Instancia o array passando o tamanho passado como par�metro
		arr = new int[size];
		//Setta o tamanho real inicialmente como 0
		realSize = 0;
	}
	
	public void add(int num) {
		//apenas adiciona se n�o est� cheio
		if(!isFull()) {
			//Insere o valor na �ltima posi��o
			arr[realSize] = num;
			//Incrementa o tamanho real
			realSize++;
		}
	}
	
	//Metodo que serve para pegar a ultima ocorrencia de determinado numero
	public int getLastOccourence(int num) {
		//Itera o array de tr�s para frente
		for(int i = realSize - 1; i >= 0; i--) {
			//Se o valor da posi��o i for igual ao par�metro retorne a posi��o
			if(arr[i] == num) return i;
		}
		//Se saiu do for significa que chegou ao fim do array e n�o achou ocorrencia
		//Retorne -1
		return -1;
	}
	
	public void reverse() {
		for(int i = 0; i < realSize/2; i++) {
			//Troca os valores da posi��o atual e da contr�ria
			trocaItens(i, realSize - (1+i));
		}
	}
	
	//Remove todas as ocorrencias de determinado numero
	public void removeAll(int num) {
		//Itera o array de frente para tr�s
		for(int i = 0; i < realSize; i++) {
			//Se o valor na posi��o i for igual ao numero remova-o e decremente i pois o tamanho se altera
			if(arr[i] == num) {
				remove(i);
				i--;
			}
		}
	}
	
	//Metodo que remove um elemento de determinada posi��o
	public void remove(int index) {
		//Cria um for para alem de retirar o valor empurrar os valores subsequentes uma posi��o para tr�s
		for(int i = index; i < realSize-1; i++) {
			arr[i] = arr[i+1];
		}
		//Decrementa o tamanho
		realSize--;
	}
	
	//Metodo que retorna true se estiver cheia ou false caso contr�rio
	public boolean isFull() {
		return realSize == arr.length;
	}
	
	//Metodo como intuito de trocar dois itens de posi��o
	private void trocaItens(int m, int n) {
		int aux = arr[m];
		arr[m] = arr[n];
		arr[n] = aux;
	}
	
	//Metodo sobrescrito de Object que retorna uma string com todos os elementos da lista
	@Override
	public String toString() {
		String str = "[";
		
		for(int i = 0; i < realSize; i++) {
			str += arr[i];
			if(i < realSize-1) {
				str += ", ";
			}
		}
		return str += "]";
	}
}
