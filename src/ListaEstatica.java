
public class ListaEstatica {
	private int[] arr;
	private int realSize;
	
	public ListaEstatica(int size) {
		arr = new int[size];
		realSize = 0;
	}
	
	public void add(int num) {
		if(!isFull()) {
			arr[realSize] = num;
			realSize++;
		}
	}
	
	public int getLastOccourence(int num) {
		for(int i = realSize - 1; i >= 0; i--) {
			if(arr[i] == num) return i;
		}
		return -1;
	}
	
	public void reverse() {
		for(int i = 0; i < realSize/2; i++) {
			trocaItens(i, realSize - (1+i));
		}
	}
	
	public void removeAll(int num) {
		for(int i = 0; i < realSize; i++) {
			if(arr[i] == num) {
				remove(i);
				i--;
			}
		}
	}
	
	public void remove(int index) {
		for(int i = index; i < realSize-1; i++) {
			arr[i] = arr[i+1];
		}
		realSize--;
	}
	
	public boolean isFull() {
		return realSize == arr.length;
	}
	
	private void trocaItens(int m, int n) {
		int aux = arr[m];
		arr[m] = arr[n];
		arr[n] = aux;
	}
	
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
