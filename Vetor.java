public class Vetor {
	private Object[] objetos = new Object[5];
	private int totalDeObjetos = 0;
	
	
	void inserir (Object objeto) {
		//verifica se precisa de mais espaço
		this.getEspaco();
		
		//percorrer a lista até encontrar uma posição livre
		for (int i=0; i < this.objetos.length; i++) {
			//a posicao está livre?
			if (this.objetos[i]==null) {
				this.objetos[i] = objeto;
				this.totalDeObjetos++;
				break;
			}
		}
		
	}
	
	void inserir(Object objeto, int posicao) {

		//verifica se precisa de mais espaço
		this.getEspaco();

		if (!this.posicaoValida(posicao)){
			throw new IllegalArgumentException("Posição inválida");
		}

		//desloca os elementos para a direita
		for (int i = this.totalDeObjetos-1 ; i >= posicao; i--) {
			this.objetos[i+1] = this.objetos[i];
		}

		this.objetos[posicao] = objeto;
		this.totalDeObjetos++;
		
	}

	private boolean posicaoValida(int posicao){
		return posicao >=0 && posicao <= this.totalDeObjetos;
	}
	
	Object obtem(int posicao) {
	//acessar e devolver o objeto da posicao X (posicao que estou passando por parametro)
		if(!this.posicaoOcupada(posicao)){
			throw new IllegalArgumentException("Posição inválida");
		}
		return this.objetos[posicao];
	}

	private boolean posicaoOcupada(int posicao){
		return posicao >=0 && posicao < this.totalDeObjetos;
	}

	void remover(int posicao) {
		if ( !(posicao < this.objetos.length && posicao >=0) ) {
			throw new IllegalArgumentException("Posição inválida");
		}

		for (int i = posicao; i < this.totalDeObjetos-1 ; i++) {
			this.objetos[i] = this.objetos[i+1];
		}

		this.totalDeObjetos--;
	}
	
	boolean contem(Object objeto){
		for (int i = 0; i < objetos.length; i++) {
			if (this.objetos[i].equals(objeto)) {
				return true;
			}
		}
		return false;
	}
	
	int tamanho() {
		return this.totalDeObjetos;
	}
	
	public String toString() {
		if (this.totalDeObjetos == 0) {
			return "[]";
		}
		
		StringBuilder saida = new StringBuilder();
		
		saida.append("[");
		
		for (int p=0; p<this.totalDeObjetos-1; p++) {
			saida.append(this.objetos[p]);
			saida.append(", ");
		}
		
		saida.append(this.objetos[this.totalDeObjetos-1]);
		saida.append("]");
			
		return saida.toString();
	}

	//Aula de 26/03
	private void getEspaco(){
		//verifica se o total de objetos é igual ao tamanho do vetor
		if (this.totalDeObjetos == this.objetos.length){
			//criamos um novo array para guardar novas inserções
			Object[] novoArray = new Object[this.objetos.length + 2];

			//percorremos o array atual e transferimos os valores do array atual para o novo
			for (int i = 0; i < this.objetos.length; i++) {
				novoArray[i] = this.objetos[i];
			}
			//o array atual perde o lugar para o novo array
			this.objetos = novoArray;
		}
	}

	public void remove(Object objeto) {
		for (int i = 0; i < this.objetos.length; i++) {
			if (objeto.equals(this.objetos[i])) {
				this.remover(i);
			}
		}
	}

	public void clear() {
		this.objetos = null;
		this.totalDeObjetos = 0;
		objetos = new Object[5];
	}

	public int indexOf(Object objeto) {
		int index = -1;
		for (int i = 0; i < this.objetos.length; i++) {
			if (objeto.equals(this.objetos[i])) {
				index = i;
				break;
			}
		}	
		return index;
	}

	public int lastIndexOf(Object objeto) {
		int index = -1;
		for (int i = 0; i < this.objetos.length; i++) {
			if (objeto.equals(this.objetos[i])) {
				index = i;
			}
		}	
		return index;
	}
}
















