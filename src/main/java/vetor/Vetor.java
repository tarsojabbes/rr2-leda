package vetor;

import java.util.Comparator;

/**
 * Implementação de um vetor de objetos simples para exercitar os conceitos de
 * Generics.
 * 
 * @author Adalberto
 *
 */
public class Vetor<E extends Comparable<E>> {

	// O array interno onde os objetos manipulados são guardados
	private E[] arrayInterno;

	// O tamanho que o array interno terá
	private int tamanho;

	// Indice que guarda a proxima posição vazia do array interno
	private int indice;

	// O Comparators a serem utilizados
	private Comparator<E> comparadorMaximo;
	private Comparator<E> comparadorMinimo;

	public Vetor(int tamanho) {
		super();
		this.tamanho = tamanho;
		this.indice = -1;
		this.arrayInterno = (E[]) new Comparable[tamanho];
	}

	public void setComparadorMaximo(Comparator<E> comparadorMaximo) {
		this.comparadorMaximo = comparadorMaximo;
	}

	public void setComparadorMinimo(Comparator<E> comparadorMinimo) {
		this.comparadorMinimo = comparadorMinimo;
	}

	// Insere um objeto no vetor
	public void inserir(E o) {
		if (!isCheio()) {
			this.arrayInterno[indice + 1] = o;
			indice++;
		}
	}

	// Remove um objeto do vetor
	public E remover(E o) {
		int indiceObjeto = procuraIndice(o);

		if (indiceObjeto != -1) {
			this.arrayInterno[indiceObjeto] = null;
			return o;
		}

		return null;
	}

	// Procura um elemento no vetor
	public E procurar(E o) {
		for (E e : this.arrayInterno) {
			if (e.equals(o)) {
				return e;
			}
		}
		return null;
	}

	// Diz se o vetor está vazio
	public boolean isVazio() {
		return this.indice == -1;
	}

	// Diz se o vetor está cheio
	public boolean isCheio() {
		return this.indice >= this.tamanho;
	}

	public E maximo() {
		setComparadorMaximo(comparadorMaximo);
		if (isVazio()) {
			return null;
		}

		E eMaximo = this.arrayInterno[0];
		for (int i = 0; i < indice; i++){
			if (this.comparadorMaximo.compare(eMaximo, this.arrayInterno[i]) < 0) {
				eMaximo = this.arrayInterno[i];
			}
		}
		return eMaximo;
	};
	public E minimo() {
		setComparadorMinimo(comparadorMinimo);
		if (isVazio()) {
			return null;
		}

		E eMinimo = this.arrayInterno[0];
		for (int i = 0; i < indice; i++){
			if (this.comparadorMinimo.compare(eMinimo, this.arrayInterno[i]) < 0) {
				eMinimo = this.arrayInterno[i];
			}
		}
		return eMinimo;
	};

	private void moveItensParaEsquerda(int indiceInicio) {
		for (int i = indiceInicio; i < this.arrayInterno.length; i++) {
			this.arrayInterno[i] = this.arrayInterno[i + 1];
		}
	}

	private int procuraIndice(E o) {
		for (int i = 0; i < this.arrayInterno.length; i++) {
			if (arrayInterno[i].equals(o)) {
				return i;
			}
		}
		return -1;
	}

}
