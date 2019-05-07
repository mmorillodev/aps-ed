
public class Main {

	public static void main(String[] args) {
		//Classe para testar os metodos
		ListaEncadeada list = new ListaEncadeada();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		
		list.troca(0, 5);
				
		System.out.println(list.toString());

	}

}
