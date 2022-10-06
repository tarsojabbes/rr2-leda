package vetor;

import java.util.Comparator;

public class TestarVetor {

	public static void main(String[] args) {
		// preencha esse metodo com codigo para testar a classe vetor.
		// À medida que voce evoluir no exercício o conteúdo deste mpetodo
		// também será modificado.
		Vetor<Aluno> vetor = new Vetor<Aluno>(3);
		Aluno a1 = new Aluno("tarso", 8);
		Aluno a3 = new Aluno("victor", 9);
		Aluno a4 = new Aluno("raniel", 8.5);
		vetor.inserir(a1);
		vetor.inserir(a3);
		vetor.inserir(a4);

		Comparator<Aluno> comparatorMaximo = new ComparatorMaximo();
		Comparator<Aluno> comparatorMinimo = new ComparatorMinimo();

		vetor.setComparadorMinimo(comparatorMinimo);
		vetor.setComparadorMaximo(comparatorMaximo);

		System.out.println(vetor.maximo().getNome());
		System.out.println(vetor.minimo().getNome());

	}
}
