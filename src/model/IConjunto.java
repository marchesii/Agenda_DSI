package model;


/**
 * 
 * @author Andr� Marchesi
 */
public interface IConjunto {
	
	
	/**
	 * Adiciona a Coisa passada como argumento no Conjunto. Caso o array criado nao possua mais espa�o
	 * deve-se dobrar o tamanho do array para armazenar mais coisas.
	 *  
	 * @param 
	 * 		coisa - Coisa que será inserida no final (última posição) do Conjunto
	 * 
	 * @return
	 * 		true - se inseriu a coisa
	 * 		false - se não inseriu a coisa
	 */
	public abstract boolean add(ICoisa coisa);
	
	
	/**
	 * Remove todos os elementos do Conjunto, ou seja, o conjunto para a estar vazio.
	 */
	public abstract void clear();
	
	
	/**
	 * Verifica se uma Coisa está ou não no Conjunto.
	 * 
	 * @param coisa
	 * 		coisa - elemento que será procurado no Conjunto
	 * 
	 * @return
	 * 		true se o argumento <code>coisa</code> está no conjunto
	 * 		false caso não esteja no conjunto.
	 */
	public abstract boolean contains(ICoisa coisa);
	
	
	/**
	 * Retorna a Coisa de uma posição específica
	 * 
	 * @param posicao - posição do array cuja Coisa é desejada
	 *  
	 * @return Coisa que está na posição passada como argumentos ou <code>null</code> caso não exista a posição
	 */
	public abstract ICoisa get(int posicao);
	
	
	/**
	 * Informa se o Conjunto está vazio (não possui Coisas) ou não (possui Coisas)
	 * 
	 * @return 
	 * 		true se não existem Coisas no Conjunto
	 * 		false se exsite alguma Coisa no Conjunto
	 */
	public abstract boolean isEmpty();
	
	
	/**
	 * Remove a Coisa que está na posição indicada do Conjunto.
	 * 
	 * @param posicao - posição desejada
	 * 
	 * @return
	 * 		Coisa removida ou <code>null</code> caso não seja possível remover a posição indicada
	 */
	public abstract ICoisa remove (int posicao);
	
	
	/**
	 * Remove a primeira ocorrência da Coisa do Conjunto. Os elementos posteriores são reorganizados para
	 * que o array não fique com valores nulos no meio dos dados.
	 *  
	 * @param 
	 * 		coisa - Coisa que será procurada no array e retornada.
	 * 
	 * @return
	 * 		A Coisa que foi removida do Conjunto ou <code>null</code> caso não seja possível remover a Coisa
	 */
	public abstract boolean remove(ICoisa coisa);
	
	
	/**
	 * Retorna a quantidade de Coisas armazenadas no Conjunto.
	 * 
	 * @return o número de Coisas do Conjunto
	 */
	public abstract int size();
	

}
