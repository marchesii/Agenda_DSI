/*package model;

public class ArrayConjunto implements IConjunto {
	private ICoisa ArrayC[];
	private final int Tamanho_Maximo_Default = 2;
	private int tamanho_coisas = 0;
	private int tamanho = 0;

	public ArrayConjunto() {
		ArrayC = new ICoisa[Tamanho_Maximo_Default];
		this.tamanho = Tamanho_Maximo_Default;
	}
	
	public ArrayConjunto(int initialSize){
		if(initialSize > 0) {
			ArrayC = new ICoisa[initialSize];
			this.tamanho = initialSize;
		}else {
			ArrayC = new ICoisa[Tamanho_Maximo_Default];
			this.tamanho = Tamanho_Maximo_Default;
		}
	}
	
	public Contato obter(int posicao) {
		Contato cont;
		
		cont = (Contato) ArrayC[posicao];
		
		return cont;
	}
	
	private void garanteEspaco() {
		if(this.tamanho_coisas == this.tamanho){
			ICoisa[] auxiliar = new ICoisa[this.tamanho * 2];
			System.arraycopy(ArrayC, 0, auxiliar, 0, ArrayC.length);
			this.tamanho = this.tamanho * 2;
			this.ArrayC = auxiliar;
		}
	}	

	@Override
	public boolean add(ICoisa coisa) {
		boolean result = false;
		
		if(isFull()) {
			garanteEspaco();
			ArrayC[tamanho_coisas] = coisa;
			result = true;
		}else {
			ArrayC[tamanho_coisas] = coisa;
			result = true;
		}
			
		if(result == true) {
			tamanho_coisas ++;
		}
		return result;
	}
	
	public boolean isFull() {
		boolean cheio = true;
		for(int i = 0; i < this.tamanho && cheio == true; i++) {
			if(ArrayC[i] == null) {
				cheio = false;
			}
		}
		return cheio;
	}

	@Override
	public void clear() {
		if(this.tamanho > 0) {
			for(int coisas = this.tamanho;coisas > 0; coisas-- ){
				remove(coisas);
			}
		}
	}

	@Override
	public boolean contains(ICoisa coisa) {
		boolean result = false;
		int coisas = this.tamanho-1;
		
		if(this.tamanho > 0) {
			while(coisas > -1 && result == false)
			{
				if(get(coisas) == coisa) {
					result = true;
				}
				coisas --;
			}
		}
		return result;
	}

	@Override
	public ICoisa get(int posicao) {
		ICoisa result;
		
		if(posicao < this.tamanho || posicao > -1){
			result = ArrayC[posicao];
		}else {
			result = null;
		}
		return result;
	}

	@Override
	public boolean isEmpty() {
		boolean result = true;
		int coisas = this.tamanho;
		
		while((coisas > 0) || result == false){
			if(ArrayC[coisas] != null) {
				result = false;
			}
			coisas --;
		}
		
		return result;
	}

	@Override
	public ICoisa remove(int posicao) {
		ICoisa result = null;
		if((posicao < this.tamanho) && (posicao > 0)) {
			result = ArrayC[posicao];
		}else {
			result = null;
		}
		
		return result;
	}

	public void reorganizar(int coisas) {
		
		while(coisas < this.tamanho) {
				if(coisas == this.tamanho-1) {
					ArrayC[coisas] = null;
				}else {
					ArrayC[coisas] = ArrayC[coisas+1];
				}
				coisas++;
		}
	}
	@Override
	public boolean remove(ICoisa coisa) {
		boolean result = false;
		int coisas = 0;
		while((coisas < this.tamanho) && (result == false)){
			if(ArrayC[coisas] == coisa) {
				remove(coisas);
				reorganizar(coisas);
				result = true;
			}
			coisas++;
		}
		return result;
	}

	@Override
	public int size() {
		int result = 0;
		int tamanho = this.tamanho;
		
		while(result < tamanho) {
			result++;
		}
		
		return result;
	}
	@Override
	public String toString() {
		String result= null;
		StringBuilder sb = new StringBuilder();
		
		for(int i =0; i<ArrayC.length && ArrayC[i] != null; i++) {
			sb.append(ArrayC[i]);
		}
		result =  sb.toString() ;
		
		return result;
	}

}
*/