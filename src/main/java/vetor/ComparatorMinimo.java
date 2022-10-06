package vetor;

import java.util.Comparator;

public class ComparatorMinimo implements Comparator<Aluno> {


    @Override
    public int compare(Aluno aluno1, Aluno aluno2) {
        return (int) (aluno2.getMedia() - aluno1.getMedia());
    }
}
