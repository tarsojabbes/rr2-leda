package produto;

public interface RepositorioProdutos<E> {

    public boolean existe(int codigo);

    public void inserir(E e);

    public void atualizar(E produto);

    public void remover(int codigo);

    public E procurar(int codigo);

}