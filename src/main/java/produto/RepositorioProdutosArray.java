package produto;

public class RepositorioProdutosArray <T extends Produto> implements RepositorioProdutos<T> {
    private T[] produtos;

    private int index = -1;

    public RepositorioProdutosArray(int size) {
        this.produtos = (T[]) new Object[size];
    }

    private int procurarIndice(int codigo) {
        for (int i = 0; i < this.produtos.length; i++) {
            if (this.produtos[i] == null) {
                return -1;
            }
            if (this.produtos[i].getCodigo() == codigo) {
                return i;
            }
        }
        return -1;
    }

    public boolean existe(int codigo) {
        if (procurarIndice(codigo) == -1) {
            return false;
        }
        return true;
    }


    public void inserir(T produto) {
        if (index + 1 == this.produtos.length) {
            return;
        }
        this.produtos[index] = produto;
        index++;
    }

    public void atualizar(T produto) {
        int indice = procurarIndice(produto.getCodigo());
        if (indice == -1) {
            throw new RuntimeException();
        }
        this.produtos[indice] = produto;
    }

    public void remover(int codigo) {
        int indice = procurarIndice(codigo);
        if (indice == -1) {
            throw new RuntimeException();
        }
        this.produtos[indice] = null;
        moveProdutosParaEsquerda(indice);
        index--;
    }

    public T procurar(int codigo) {
        int indice = procurarIndice(codigo);
        if (indice == -1) {
            throw new RuntimeException();
        }
        return this.produtos[indice];

    }

    private void moveProdutosParaEsquerda(int indiceInicio) {
        for (int i = indiceInicio; i < this.produtos.length; i++) {
            this.produtos[i] = this.produtos[i + 1];
        }
    }
}